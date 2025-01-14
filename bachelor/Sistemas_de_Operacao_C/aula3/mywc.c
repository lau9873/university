#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define BUFFER_SIZE 1024



// Função para contar o número de caracteres
int count_characters(FILE *file) {
    int count = 0;
    int ch;
    while ((ch = fgetc(file)) != EOF) {
        printf("%d\n",ch);
        count++;
    }
    return count;
}

// Função para contar o número de palavras
int count_words(FILE *file) {
    int count = 0;
    int in_word = 0;
    int ch;
    while ((ch = fgetc(file)) != EOF) {
        if (ch == ' ' || ch == '\n' || ch == '\t') {
            if (in_word) {
                count++;
                in_word = 0;
            }
        } else {
            in_word = 1;
        }
    }
    if (in_word) {
        count++; // Conta a última palavra se o arquivo terminar sem espaço em branco
    }
    return count;
}

// Função para contar o número de linhas
int count_lines(FILE *file) {
    int count = 0;
    int ch;
    while ((ch = fgetc(file)) != EOF) {
        if (ch == '\n') {
            count++;
        }
    }
    if (ftell(file) != 0) {
        // Incrementa o contador se o arquivo não estiver vazio e não terminar com uma nova linha
        count++;
    }
    return count;
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Uso: %s <-c | -w | -l> <arquivo>\n", argv[0]);
        return EXIT_FAILURE;
    }

    char *opcao = argv[1];
    char *nome_arquivo = argv[2];

    FILE *file = fopen(nome_arquivo, "r");
    if (file == NULL) {
        printf("Erro: Não foi possível abrir o arquivo %s.\n", nome_arquivo);
        return EXIT_FAILURE;
    }

    int resultado = 0;
    if (strcmp(opcao, "-c") == 0) {
        resultado = count_characters(file);
        printf("Número de caracteres: %d\n", resultado);
    } else if (strcmp(opcao, "-w") == 0) {
        resultado = count_words(file);
        printf("Número de palavras: %d\n", resultado);
    } else if (strcmp(opcao, "-l") == 0) {
        resultado = count_lines(file);
        printf("Número de linhas: %d\n", resultado);
    } else {
        printf("Opção inválida.\n");
        fclose(file);
        return EXIT_FAILURE;
    }

    fclose(file);
    return EXIT_SUCCESS;
}



