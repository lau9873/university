# Lab 2 - Testing for security

We started by inspecting the code of the examples provided in the SARD test suite, analyzing the vulnerabilities and the
corresponding fixes.

We focused on examples taking input from the user, allowing us to fuzz that input and find vulnerabilities.

Afterward, we picked a few examples to analyze in more detail using the tools explained in the lab.

## [Example 129 - Improper Null Termination ](https://github.com/hpacheco/ses/blob/main/c/SARD-testsuite-100/000/149/129/improper_null_term_basic_%40alias-sensitive_information.c)

The vulnerable code is the following:

```c
char str1[1][MAX_SIZE];

if (fread(*str1,sizeof(char),MAX_SIZE,stdin) == MAX_SIZE)
{
    printf("%s\nlength = %zu\n", *str1, strlen(*str1));			/* FLAW */
}
```

The issue is related to how strings are handled in C - arrays of characters, and the last character of the array is the
null character `\0`.
Since this is the standard, the library functions that work with strings, such as `printf`, expect the string to be
null-terminated.

If the string is not null-terminated, the function will read past the end of the array, and the program may crash or
display adjacent memory contents.

In this particular case, the string is not null-terminated because the `fread` function does not automatically add the
terminating null character.
Moreover, it reads `MAX_SIZE` characters, which is the size of the array, leaving no space
for the null character.

In order for the program to be
safe ([example 130](https://github.com/hpacheco/ses/blob/main/c/SARD-testsuite-101/000/149/130/improper_null_term_basic_%40alias-good.c)),
the null character must be added manually, and the `fread` function must not read `MAX_SIZE` characters:

```c
if (fread(*str1,sizeof(char),MAX_SIZE-1,stdin) == MAX_SIZE-1)
{
    str1[0][MAX_SIZE-1] = '\0';						/* FIX */
    printf("\n%s\nlength = %zu\n", *str1, strlen(*str1));
}
```

### Compiling and running the program

We started by adapting the program to easily show possible buffer overflows by adding stack memory above the buffer:

```c
char str1[1][MAX_SIZE];
const char *test_str = "sensitive_information";

if (fread(*str1,sizeof(char),MAX_SIZE-1,stdin) == MAX_SIZE-1)
{
    str1[0][MAX_SIZE-1] = '\0';						/* FIX */
    printf("\n%s\nlength = %zu\n", *str1, strlen(*str1));
}

```

Then, we compiled the program using the following command:

```bash
gcc -o improper_null_term_basic improper_null_term_basic.c
```

And ran the program and entered the following input:

```bash
./improper_null_term_basic <<< "AAAAAAAA"
```

The program output was:

```
AAAAAAAAsensitive_information
length = 29
```

The program did not crash, likely because no important memory was overwritten.

However, as we entered a string of length `MAX_SIZE` and the program did not add the null character, the output included
the contents of the stack memory above the buffer.

### Fuzzing the program

This kind of vulnerability should be easy to find using fuzzing, since the program will provide a different output for
some inputs.

#### Radamsa

We started by using radamsa to fuzz the program:

Our input file was:

```bash
cat input.txt
# t3s7
```

We ran radamsa with the following command:

```bash
radamsa input.txt -n 10 -s 564 >output.txt
cat output.txt
#t3s8
#t3s26\r!!%s!!+inf\x170141183460469231731687303715884105727%pNaN$'%p\r\x0d$+%d%n%s\x0a$PATHt255s135
#t4294967294s7
#t-1s-0
#t2s-127
#แt3⁠2769s3276󠁪8
#t3s9223372036854775808
#t3+/v+s7
#t͏94345953538932s2147483648
#t3s0
```

Then, we ran the program for each generated input.

If the output was different from the expected output, we considered the input to be a valid test case.
When the program output was not empty or the same as the input, we considered the input to be a valid test case:

```bash
while read line; do
  output=$(./improper_null_term_basic <<<"$line" | tail -n 2 | head -n 1)
  if [ -n "$output" ] && [ "$output" != "$line" ]; then
    echo "ERROR: EXPECTED '$line' GOT: '$output'"
  fi
done <output.txt
```

The script output was:

```
ERROR: EXPECTED 't3s26r!!%s!!+infx170141183460469231731687303715884105727%pNaN$'%prx0d$+%d%n%sx0a$PATHt255s135' GOT: 't3s26r!!sensitive_information'
ERROR: EXPECTED 't4294967294s7' GOT: 't4294967sensitive_information'
ERROR: EXPECTED 't2s-127' GOT: 'sensitive_information'
ERROR: EXPECTED 'แt3⁠2769s3276󠁪8' GOT: 'แt3⁠sensitive_information'
ERROR: EXPECTED 't3s9223372036854775808' GOT: 't3s92233sensitive_information'
ERROR: EXPECTED 't3+/v+s7' GOT: 't3+/v+s7sensitive_information'
ERROR: EXPECTED 't͏94345953538932s2147483648' GOT: 't͏94345sensitive_information'
```

This shows that the program is vulnerable to buffer overflows, and that fuzzing can be used to find them.

#### Blab && AFL

We also tried to find the vulnerability using AFL and Blab.
However, we were not able to find any crashes or error reports.
This may be because we could not generate the correct pattern of inputs to trigger the vulnerability.

### Symbolic execution

Our next step was attempting to find the vulnerability using symbolic execution.

#### KLEE

We started by using KLEE to find the vulnerability.
For that, we adapted the program to use `klee_make_symbolic` to generate symbolic inputs, and created placeholder
functions for `printf` and `fread`:

```c
int sym_fread(char*buf, int size, int n, FILE *stream)
{
    int r = 0;
    char *ptr = buf;
    while(1) {
        r = klee_range(0, 255, "input");
        *ptr = r;
        ptr++;
        if (r == 0 || ptr == buf + size * n) {
            break;
        }
    }

    return r;
}

int sym_puts(const char *s) {
    while (*s != '\0') {
        s++;
    }
    return 0;
}
```

Then, we compiled the program using the following command:

```bash
clang -I /usr/local/include/klee -emit-llvm -c -g improper_null_term_basic.c
```

And ran KLEE with the following command:

```bash
klee -libc=uclibc -posix-runtime improper_null_term_basic.bc
```

KLEE output was:

```
KLEE: ERROR: libc/string/strlen.c:22: memory error: out of bound pointer
KLEE: NOTE: now ignoring this error at this location

KLEE: done: total instructions = 14250
KLEE: done: completed paths = 1
KLEE: done: generated tests = 1
```

This shows that the program is vulnerable to buffer overflows, and that symbolic execution can be used to find them.

### Other tools
#### Driller

To use both fuzzing and symbolic execution, we used Driller to try to find the vulnerability.

For that, we adapted the program to crash when the buffer overflow occurs.
Then, we compiled and ran the program.

As expected, the program crashed when we entered a string of length `MAX_SIZE`.

## Summary

This lab allowed us to better understand how to find and refine our test cases using fuzzing and symbolic execution.

We understood that the two techniques work differently, and that they can be used together to find more vulnerabilities.

While fuzzing requires manually specifying the input format, it can be used in easier ways by feeding the output to the
program.
In contrast, symbolic execution requires intercepting library functions, but is more versatile because it can generate
inputs and learn from its own execution.