def maiordivisorproprio(n):
    "calcula o maior divisor proprio de n"
    maxdiv = 1
    for d in range(2,n):
        if n%d == 0:
            maxdiv = d
    return maxdiv
