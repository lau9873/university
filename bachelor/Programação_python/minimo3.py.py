def minimo(a,b,c):
    "Calcula o minimo de tres valores dados"
    if a < b:
        min = a
    else:
        min = b
    if c < min:
        min = c
    return min

# Para experimentar, escrever na consola (shell de Python versoes 3)
#    exec(open('minimo3.py').read())
#    minimo(5,7,8)
#    minimo(7,5,8)
#    minimo(7,8,5)
#    help(minimo)
# Para sair do help, usar q

# Para versoes 2, substituir exec por:
#    execfile('minimo3.py')
