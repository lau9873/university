#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>


int main(int argc, char* argv[]) {
    for(int i = 3 ; i < argc ; i++) {
        pid_t pid = fork();
        if(pid == 0) {
            printf("[pid: %i] compiling %s ...\n",getpid(),argv[i]);
            char *args[] = {"gcc","-Wall","-c",argv[i], NULL};
            execvp(args[0], args);
            perror("execvp");
            exit(EXIT_FAILURE);
        }
        
    }
    for(int i = 1 ; i < argc ; i++)
       wait(NULL);
    pid_t pid = fork();
    if(pid == 0) {
        char *args[] = {"gcc","prog1.o","prog2.o","prog3.o","-o","prog", NULL};
        execvp(args[0], args);
        perror("execvp");
        exit(EXIT_FAILURE);
    }
    int retv = waitpid(pid, NULL, 0);
    if (retv == -1) {
        perror("waitpid");
        exit(EXIT_FAILURE);
    }
    exit(EXIT_SUCCESS);

}
