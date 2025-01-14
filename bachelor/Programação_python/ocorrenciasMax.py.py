# dada sequencia de n inteiros, conta o numero de ocorrencias do maximo

n  = int(input())
maximo =  int(input())
ocorre = 1
while n > 1:
    valor  = int(input())
    if valor > maximo:
        maximo = valor     # um novo maximo encontrado
        ocorre = 1
    elif valor == maximo:
        ocorre = ocorre + 1   # encontra mais uma vez o maximo atual
    n = n-1                 # falta ver menos 1
print("Maximo: ", maximo, " No. ocorrencias: ", ocorre)
