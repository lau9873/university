#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
int main(int argc, char* argv[]) {
  pid_t pid = fork();
  if (pid == -1) {
    perror("fork");
    exit(EXIT_FAILURE);
  }
  if (pid == 0) {
    /* child */
    execvp(argv[1],&argv[1]);
    /* next two lines executed only if execlp() fails */
    perror("execvp");
    exit(EXIT_FAILURE);
}
else {
    /* parent */
    int retv = waitpid(pid, NULL, 0);
    if (retv == -1) {
      perror("waitpid");
      exit(EXIT_FAILURE);
    }
}
  exit(EXIT_SUCCESS);
}
