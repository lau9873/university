#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
    pid_t pid;

    pid = fork();
    printf("Processo filho 1 - PID: %d\n", getpid());
    pid = fork();
    printf("Processo filho 2 - PID: %d\n", getpid());
    pid = fork();
    printf("Processo filho 3 - PID: %d\n", getpid());
    printf("Processo pai - PID: %d\n", getpid());
    exit(EXIT_SUCCESS);
}
