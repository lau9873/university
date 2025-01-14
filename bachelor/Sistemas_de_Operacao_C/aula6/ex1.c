
#include <sys/wait.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>

#define LINESIZE  256

int main(int argc, char* argv[]) {
  int   fd[2];
  pid_t pid;
  if (pipe(fd) == -1) { perror("pipe"); exit(EXIT_FAILURE); }
  if ((pid = fork()) == -1) { perror("fork"); exit(EXIT_FAILURE); }
  if (pid > 0) { /* parent */
    close(fd[0]);
    int file_fd = open(argv[1], O_RDONLY);
        if (file_fd == -1) { 
            perror("open"); 
            exit(EXIT_FAILURE); 
        }
  
    char buffer[LINESIZE];
    ssize_t bytes_read;
    while ((bytes_read = read(file_fd, buffer, LINESIZE)) > 0) {
        write(fd[1], buffer, bytes_read);
    }
    
    close(fd[1]);
    close(file_fd);
    if ( wait(NULL) == -1) { perror("wait"); exit(EXIT_FAILURE); }
    exit(EXIT_SUCCESS);
  } else { /* child */
    close(fd[1]);
    char line[LINESIZE];
    int nbytes;
    while ((nbytes = read(fd[0], line, LINESIZE)) > 0) {
        write(STDOUT_FILENO, line, nbytes);
    }
    close(fd[0]);
    exit(EXIT_SUCCESS);
} 
}