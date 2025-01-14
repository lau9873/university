Para experimentar, por exemplo a função definida em minimo3.py,
escrever na consola (shell de Python versoes 3)
     exec(open('minimo3.py').read())
     minimo(5,7,8)
     minimo(7,5,8)
     minimo(7,8,5)
     help(minimo)
Para sair do help, usar q

Para versoes 2, substituir exec por:
     execfile('minimo3.py')
