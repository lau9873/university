# dois ultimos lidos dado antes de 0, sendo dados pelo menos dois antes de 0

#print("Indicar sequencia de inteiros (0 se quiser terminar)")
penultimo = int(input())
ultimo  = int(input())
proximo = int(input())
while proximo != 0:
    penultimo = ultimo
    ultimo = proximo
    proximo = int(input())
print(penultimo, ultimo)
#print("Resultado: "+str(penultimo)+" "+str(ultimo))

