def somaprogarit(u1,r,n):
    "Soma dos n primeiros termos de progressao aritmetica"
    soma = 0
    for i in range(n):     # 0,1,2,...,n-1
        soma = soma + u1   # adiciona o termo de ordem i+1
        u1 = u1 + r        # termo seguinte
    return soma            # no fim do ciclo, retorna o valor da soma
