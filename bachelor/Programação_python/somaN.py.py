faltam = int(input("Quantos inteiros quer somar? "))
soma = 0
while faltam != 0:
    num = int(input("Indique inteiro: "))
    faltam = faltam-1
    soma = soma + num
print("Resultado: "+str(soma))

