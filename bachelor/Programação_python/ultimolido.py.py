# ultimo inteiro dado antes de 0, sendo dado algum

print("Indicar sequencia de inteiros (0 se quiser terminar)")
ultimo  = int(input())
proximo = int(input())
while proximo != 0:
    ultimo = proximo
    proximo = int(input())
print("Ultimo: "+str(ultimo))

