#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/time.h>

int main(int argc, char* argv[]) {
    /* check if file exists */
    struct stat info;
    if (access(argv[1], F_OK) == 0) {
        stat(argv[1], &info);
        printf("Ficheiro existia, last access:%s",ctime(&info.st_atime));
       /* file exists */
        utimes(argv[1], NULL);
       /* change last access date */
        stat(argv[1], &info);
        printf("new access:%s",ctime(&info.st_atime));
    } else {
        /* file does not exist - create it */
        mode_t perms = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;
        /* fill perms using the permission bits */
        /* defined in the "chmod" system call */
        int fd = open(argv[1], O_CREAT | O_WRONLY, perms);
        stat(argv[1], &info);
        printf("criado em:%s",ctime(&info.st_atime));
        close(fd);
}
    exit(EXIT_SUCCESS);
}
