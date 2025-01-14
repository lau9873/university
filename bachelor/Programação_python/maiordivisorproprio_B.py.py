def maiordivisorproprio(n):
    "calcula o maior divisor proprio de n"
    d = n-1
    while d >= 2:
        if n%d == 0:
            return d
        d = d-1
    return 1

