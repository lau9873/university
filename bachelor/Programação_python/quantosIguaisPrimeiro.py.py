# dada sequencia de inteiros terminada em 0, determina quantos são iguais ao primeiro

primeiro  = int(input())
contador = 0
valor  = int(input())
while valor != 0:
    if valor == primeiro:
        contador = contador + 1
    valor = int(input())
print(contador)

#if contador == 1:
#    print("Deu "+str(contador)+" vez o valor "+str(x))
#else:
#    print("Deu "+str(contador)+" vezes o valor "+str(x))
