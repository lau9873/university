#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
int main(int argc, char* argv[]) {
  /* fork a child process */
  pid_t pid = fork();
  if (pid == -1) {
    perror("fork");
    exit(EXIT_FAILURE);
  }
  if (pid == 0) {
    /* child process */
    execlp(argv[1],argv[1],NULL);
    /* next two lines executed only if execlp() fails */
    perror("execlp");
    exit(EXIT_FAILURE);
}
else {
    /* parent process */
    int retv = waitpid(pid, NULL, 0);
    if (retv == -1) {
      perror("waitpid");
      exit(EXIT_FAILURE);
    }
    printf("Processo pai - PID: %d\n",getpid());
}
  exit(EXIT_SUCCESS);
}
