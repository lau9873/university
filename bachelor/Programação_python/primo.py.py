def primo(n):
    "verifica se n é primo"
    if n == 1 or (n % 2 == 0 and n != 2):
        return False
    if n == 2:
        return True
    d = 3            # primeiro impar maior do que 2
    while d*d <= n:
        if n%d == 0:
            return False
        d = d+2      # proximo impar
    return True


#  Explicação: 
#    Assumimos que n >= 1 e inteiro. 
#    n é primo se n não é 1 e tem exatamente dois divisores positivos (1 e n)

#    Nenhum numero par diferente de 2 é primo. 
#    Os primos distintos de 2 são ímpares (logo, não são divisiveis por 2)

#    Assim, podemos restringir a pesquisa aos ímpares e usar também o facto de
#    os divisores poderem ser emparelhados: procuramos d ímpar cujo quadrado 
#    não seja superior a n e tal que n%d seja 0



