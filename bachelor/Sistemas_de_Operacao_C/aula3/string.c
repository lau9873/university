#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#define MAX_SIZE  64
int main(int argc, char* argv[]) {
  char* p1 = (char*)malloc(MAX_SIZE * sizeof(char));
  char* p2 = (char*)malloc(MAX_SIZE * sizeof(char));
  
p1 = argv[1];
int length = strlen(p1);
for (int i = 0; i < length; i++) {
    p1[i] = tolower(p1[i]);
}
printf("String em minúsculas: %s\n", p1);
  p2 = argv[2];
   if (strstr(p2, p1) != NULL) {
        printf("%s ocorre em %s\n", p1, p2);
    } else {
        printf("%s não ocorre em %s\n", p1, p2);
    }
int count = 0;
char *ptr = p2;
while ((ptr = strstr(ptr, p1)) != NULL) {
    printf("%s\n",ptr);
    count++;
    ptr++;
    
}
printf("A string '%s' ocorre %d vezes em '%s'\n", p1, count, p2);
exit(EXIT_SUCCESS);
}
