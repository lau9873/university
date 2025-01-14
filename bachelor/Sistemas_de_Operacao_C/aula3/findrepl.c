#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFFER_SIZE 1024

char* replace(char* p, char** mat, int argc){
    char* nova_palavra = p;
    for (int i=0;i<(argc-1);i++){
        char* text=strdup(mat[i]);
        char* findword = strsep(&text, "-");
        char* replword = strsep(&text, "-");
        // printf("%s - %s\n", p,findword);
        if (strcmp(p,findword)==0){
            nova_palavra=replword;
            break;
        }
    }
    return nova_palavra;
}

int main(int argc, char *argv[]) {


    char** matriz_strings = (char **) malloc((argc-1) * sizeof(char *));
    for (int i = 1; i < argc; i++) {
        matriz_strings[i-1] = argv[i];
    }

    char* buffer;
    size_t buffer_size = BUFFER_SIZE;
    char* palavra;
    while (getline(&buffer, &buffer_size, stdin) != -1) {
        while ((palavra=strsep(&buffer," \t\n")) != NULL) {
            char ultimo=palavra[strlen(palavra) - 1];
            if (ultimo == ',' || ultimo == '.') {
                palavra[strlen(palavra) - 1] = '\0';
                char* nova_palavra = replace(palavra, matriz_strings, argc);
                printf("%s%c ", nova_palavra, ultimo);
            }else{
                char* nova_palavra = replace(palavra, matriz_strings, argc);
                printf("%s ", nova_palavra);
            }
            
            
        }
        printf("\n");
    }

    free(matriz_strings);

    return EXIT_SUCCESS;
}



