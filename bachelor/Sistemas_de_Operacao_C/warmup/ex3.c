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
        int parentsecret = random()% atoi(argv[1]);
        int childguess;
        do {
            int parentguess=random()% atoi(argv[1]);
            read(fd[1], &childguess, sizeof(int));
            write(fd[1], &parentguess, sizeof(int));
        } while (childguess != parentsecret);
        printf("child wins!\n");
        close(fd[1]);
        wait(NULL);
        exit(EXIT_SUCCESS);
        
        }
     
    else {
        /* child */
        close(fd[1]);
        srandom(getpid());
        int childsecret = random()% atoi(argv[1]);
        int parentguess;
        do{
            int childguess=random()% atoi(argv[1]);
            write(fd[0], &childguess, sizeof(int));
            read(fd[0], &parentguess, sizeof(int));
        }while(parentguess != childsecret);
        printf("parent wins!\n");
        close(fd[0]);
        wait(NULL);
        exit(EXIT_SUCCESS);
        }
      }





