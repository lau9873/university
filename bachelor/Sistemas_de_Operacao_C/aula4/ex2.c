#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pwd.h>

int main(int argc, char* argv[]) {
  struct stat info;
  if (argc < 2) {
    fprintf(stderr, "usage: %s file\n", argv[0]);
    exit(EXIT_FAILURE);
  }
  for (int i=1; i<argc;i++){
    int retv = stat(argv[i], &info);
    if (retv == -1) {
        fprintf(stderr, "fsize: Can’t stat %s\n", argv[1]);
        exit(EXIT_FAILURE);
    }
    printf("%s size: %d bytes, disk_blocks: %d, last modificarion: %s, own user: %s\n",
            argv[1], (int)info.st_size, (int)info.st_blocks, ctime(&info.st_mtime), getpwuid(info.st_uid)->pw_name);
  }
  
  exit(EXIT_SUCCESS);
}