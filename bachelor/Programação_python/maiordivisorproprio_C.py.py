def maiordivisorproprio(n):
    "calcula o maior divisor proprio de n"
    d = 2
    while d*d <= n:
        if n%d == 0:
            return n//d
        d = d+1
    return 1

# Divisores proprios de n são todos os divisores exceto n

# Nesta implementacao, usamos o facto de os divisores poderem ser agrupados
# aos pares, pois, se d é divisor então n/d é divisor.
# Para n=28 temos   (1,28), (2,14), (4,7)
# Assim quando estamos a procurar divisores, podemos pensar em pares
# (d, n//d), com d <= n//d, ou seja,  d*d <= n.  Mas, no par (d, n//d),
# o maior divisor é n//d



