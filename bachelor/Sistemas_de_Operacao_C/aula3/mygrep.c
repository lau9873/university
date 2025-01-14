#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFFER_SIZE 1024


int main(int argc, char *argv[]) {

    char *string = argv[1];
    char *nome_arquivo = argv[2];
    FILE *file = fopen(nome_arquivo, "r");
    if (file == NULL) {
        printf("Erro: Não foi possível abrir o arquivo %s.\n", nome_arquivo);
        return EXIT_FAILURE;
    }
    char buffer[BUFFER_SIZE];
    int nu_li = 1;
    int pos;
    while (fgets(buffer, sizeof(buffer), file) != NULL) {
        char *ptr = buffer;
        pos = 0;
        while ((ptr = strstr(ptr, string)) != NULL){
            printf("%d:%d, ", nu_li, pos);
            pos=(int) (ptr-buffer)+1; // são apontadores...
            ptr++;
        }
        nu_li++;
    }
    printf("]\n");
    fclose(file);
    return EXIT_SUCCESS;
}



