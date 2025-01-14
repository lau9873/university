#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>


int main(int argc, char* argv[]) {
    char *strings[10]; 
    for(int i = 1 ; i < argc ; i++) {
        pid_t pid = fork();
        if(pid == 0) {
            size_t len = strlen(argv[i]);
            strings[i] = malloc(len - 3);
            char new_str[len - 3]; 
            strncpy(new_str, argv[1], len - 4); 
            new_str[len - 4] = '\0'; 
            strcat(new_str, ".epub");
            strncpy(strings[i], new_str, strlen(new_str)); 
            printf("[pid: %i] compiling %s ...\n",getpid(),argv[i]);
            char *args[] = {"pandoc",argv[i],"-o",new_str, NULL};
            execvp(args[0], args);
            perror("execvp");
            exit(EXIT_FAILURE);
        }
        
    }
    for(int i = 1 ; i < argc ; i++)
       wait(NULL);
    pid_t pid = fork();
    if(pid == 0) {
        char *a1[]={"zip","ebooks.zip"};
        char *concatenated[argc+1];
        for (int i = 0; i < 2; i++) {
            concatenated[i] = strdup(a1[i]);
        }
        for (int i = 0; i < argc-3; i++) {
            concatenated[i+2] = strdup(strings[i]);
        }
        concatenated[argc]=NULL;
        execvp(concatenated[0], concatenated);
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
