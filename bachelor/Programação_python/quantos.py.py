
# indicar sequencia de inteiros que termina em 0 e contar quantos inteiros
# foram dados

#print("Indicar sequencia de inteiros (0 se quiser terminar)")
contador = 0
valor  = int(input())
while valor != 0:
    contador = contador + 1
    valor = int(input())
#print("Indicou "+str(contador)+" numeros")
print(contador)

