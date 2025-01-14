#include <stdio.h>
#include <stdlib.h>

#define BUFFER_SIZE 1024

void print_file_content(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        printf("mycat: cannot open file '%s'\n", filename);
        exit(EXIT_FAILURE);
    }

    char buffer[BUFFER_SIZE];
    int nchars;

    while ((nchars = fread(buffer, sizeof(char), BUFFER_SIZE, file)) > 0) {
        fwrite(buffer, sizeof(char), nchars, stdout);
    }

    fclose(file);
}

int main(int argc, char *argv[]) {
    if (argc == 1) {
        printf("Usage: %s <file1> [<file2> ...]\n", argv[0]);
        return EXIT_FAILURE;
    }

    for (int i = 1; i < argc; i++) {
        print_file_content(argv[i]);
    }

    return EXIT_SUCCESS;
}
