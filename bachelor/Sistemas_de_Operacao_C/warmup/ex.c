


#include <sys/wait.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
int main(int argc, char* argv[]) {
  int   fd[2];
  pid_t pid;
  if (socketpair(AF_UNIX, SOCK_STREAM, 0, fd) == -1) {
    perror("socketpair");
    exit(EXIT_FAILURE);
  }
  if ((pid = fork()) == -1) {
    perror("fork");
    exit(EXIT_FAILURE);
}
if (pid > 0) {
    /* parent */
    close(fd[0]);
    srandom(getpid());
    int parentsecret = random() % atoi(argv[1]);
    while(1){
        int status;
        pid_t child_pid = waitpid(pid, &status, WNOHANG);
        if (child_pid == pid)
            break;
        int guesschild;
        read(fd[1], &guesschild, sizeof(int));
            if(guesschild==parentsecret){
                printf("child wins!\n");
                break;
            }
        int guessparent = random() % atoi(argv[1]);
        write(fd[1], &guessparent, sizeof(int));
        
    };
    close(fd[1]);
    if ( wait(NULL) == -1) {
       perror("wait");
       exit(EXIT_FAILURE);
}
    exit(EXIT_SUCCESS);
  }
  else {
    /* child */
    close(fd[1]);
    srandom(getpid());
    int childsecret = random() % atoi(argv[1]);
    
    while(1){
        int guesschild = random() % atoi(argv[1]);
        write(fd[0], &guesschild, sizeof(int));
        int guessparent;
        read(fd[0], &guessparent, sizeof(int));
            if(guessparent==childsecret){
                printf("parent wins!\n");
                break;
            }
    };
    
    close(fd[0]);
    exit(EXIT_SUCCESS);
} }
