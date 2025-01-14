# dada sequencia de n inteiros, conta o numero de ocorrencias do maximo

n  = int(input())
maximo =  int(input())
ocorre = 1
for i in range(1,n):
    valor  = int(input())
    if valor > maximo:
        maximo = valor     # um novo maximo encontrado
        ocorre = 1
    elif valor == maximo:
        ocorre = ocorre + 1   # encontra mais uma vez o maximo atual
print("Maximo: ", maximo, " No. ocorrencias: ", ocorre)
