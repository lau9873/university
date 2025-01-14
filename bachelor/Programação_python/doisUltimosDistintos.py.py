# dada sequencia de inteiros que termina em 0, indicar os dois ultimos elementos
# distintos ou escrever todos iguais a x, com x substituído consistentemente
#
# será dado pelo menos um número além de zero

penultimo = 0
ultimo = int(input())
proximo = int(input())
while proximo == ultimo:
    proximo = int(input())

while proximo != 0:
    penultimo = ultimo
    ultimo = proximo
    while proximo == ultimo:
        proximo = int(input())    

if penultimo != 0:
    print("Resultado: "+str(penultimo)+" "+str(ultimo))
else:
    print("Todos iguais a "+str(ultimo))




