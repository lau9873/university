continuar = 1
while (continuar == 1): 
    x = int(input("x? "))
    y = int(input("y? "))
    z = int(input("Qual o valor de "+str(x)+"+"+str(y)+"? "))
    if (z == x+y):
        print("Correto!")
    else:
        print("Errado!")
    continuar = int(input("Quer continuar? (1-sim  / 0 - nao) "))

