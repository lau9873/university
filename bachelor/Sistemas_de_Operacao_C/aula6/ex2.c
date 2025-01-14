#include <sys/types.h>
#include <sys/wait.h>
#include <sys/socket.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <ctype.h>

#define LINESIZE  256
void stringToUpper(char *str) {
    while (*str) {
        *str = toupper((unsigned char)*str);
        str++;
    }
}

int main(int argc, char* argv[]) {
  int   sockets[2], retv;
  retv = socketpair(AF_UNIX, SOCK_STREAM, 0, sockets);
  if (retv == -1) { perror("socketpair"); exit(EXIT_FAILURE); }
  retv = fork();
  if (retv == -1) { perror("fork"); exit(EXIT_FAILURE); }
  if (retv > 0) { /* parent */
    close(sockets[1]);
    int file_fd = open(argv[1], O_RDONLY);
        if (file_fd == -1) { 
            perror("open"); 
            exit(EXIT_FAILURE); 
        }
    char buffer[LINESIZE];
    ssize_t bytes_read;
    while ((bytes_read = read(file_fd, buffer, LINESIZE)) > 0) {
        write(sockets[0], buffer, bytes_read);
    }
    char line[LINESIZE];
    int nbytes;
    do{
        nbytes = read(sockets[0], line, LINESIZE);
        write(STDOUT_FILENO, line, nbytes);
        int status;
    } while (nbytes > 0);
    close(sockets[0]);
    close(file_fd);
    retv = wait(NULL);
    if (retv == -1) { perror("wait"); exit(EXIT_FAILURE); }
  } else { /* child */
    close(sockets[0]);
    char line[LINESIZE];
    ssize_t nbytes;
    do{
        nbytes = read(sockets[1], line, LINESIZE);
        stringToUpper(line);
        write(sockets[1], line, nbytes);
    } while (nbytes  > 0);
    close(sockets[1]);
    exit(EXIT_SUCCESS);
  }
  return 0;
}