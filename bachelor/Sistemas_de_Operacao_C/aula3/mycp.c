#include <stdio.h>
#include <stdlib.h>
#define BUFFER_SIZE 1024
int main(int argc, char* argv[]) {
  FILE*   file1 = fopen(argv[1], "r");
  FILE*   file2 = fopen(argv[2], "w");
  if ( file1 == NULL ) {
     printf("error: could not open %s\n", argv[1]);
     exit(EXIT_FAILURE);
  }

  char buffer[BUFFER_SIZE];
  int  nchars = fread(buffer, sizeof(char), BUFFER_SIZE, file1);
  while (nchars > 0) {
     fwrite(buffer, sizeof(char), nchars, file2);
     nchars = fread(buffer, sizeof(char), BUFFER_SIZE, file1);
  }
  fclose(file1);
  fclose(file2);
  exit(EXIT_SUCCESS);
}
