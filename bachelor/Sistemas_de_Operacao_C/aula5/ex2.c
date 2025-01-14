
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
int main(int argc, char* argv[]) {
  int p=0;
  int f=0;
  pid_t pid;
  for (int i = 0; i < 4; i++){
    pid=fork();
    printf("Processo filho 1 - PID: %d\n",getpid());
    f++;
  }
  printf("Processo pai - PID: %d\n",getpid());
  p++;
  //printf("p:%d,f:%d",p,f);
exit(EXIT_SUCCESS);
}
