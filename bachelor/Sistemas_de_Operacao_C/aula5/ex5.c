#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>



#define HISTORY_FILE "shell_history.txt"

void save_command_to_history(const char *command) {
    FILE *history_file = fopen(HISTORY_FILE, "a");
    if (history_file == NULL) {
        perror("Error opening history file");
        return;
    }
    if (fprintf(history_file, "%s\n", command) < 0) {
        perror("Error writing to history file");
        fclose(history_file);
        return;
    }
    fclose(history_file);
}


int main(int argc, char* argv[]) {
  int h=0;
  char *commands[100];
  for( ; ; ) {
    /* give prompt, read command and null terminate it */
    fprintf(stdout, "$ ");
    /* command = NULL tells getline to do the memory allocation */
    char*  command = NULL;
    size_t nchars;
    nchars = getline(&command, &nchars, stdin);
    /* check for getline error */
    if(nchars == -1)
      exit(EXIT_FAILURE);
    /* properly end the command string */
    command[nchars-1] = '\0';
    /* call fork and check return value */
    commands[h++]=command;
    pid_t pid = fork();
    if(pid == -1) {
      perror("fork");
      exit(EXIT_FAILURE);
    }
    
    if (strcmp(command, "exit") == 0) {       
            break;  // Exit the shell loop
        }
    
    char *com2 = strdup(command);
    char *args[100]; // Assuming maximum of 10 arguments
    char *token, *rest = command;
    int i=0;
    while ((token = strsep(&rest, " "))) {
        args[i++] = token;
    } 
    args[i]=NULL;
    
    if(pid == 0) {
        if (strcmp(args[0], "myhistory") == 0) {  
            char *concatenated = (char *)malloc(2);
            strcat(concatenated, "-");
            strcat(concatenated, args[1]);
            char *args2[] = {"tail", concatenated,"shell_history.txt", NULL};
            execvp(args2[0], args2);     
            perror("execvp");
            exit(EXIT_FAILURE);
            }
        save_command_to_history(com2);
        execvp(args[0], args);
        perror("execvp");
        exit(EXIT_FAILURE);
    }
    /* shell waits for command to finish before giving prompt again */
    int retv = waitpid(pid, NULL, 0);
    if (retv == -1) {
      perror("waitpid");
      exit(EXIT_FAILURE);
    }
}
  exit(EXIT_SUCCESS);
}