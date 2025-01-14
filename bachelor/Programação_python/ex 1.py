def media_arit(x):
    n=len(x)
    if n==0:
        return 0
    soma=0
    for a in x:
        soma=soma+a
    return soma/n

def media_geom(x):
    n=len(x)
    if n==0:
        return 0
    mult=1
    for a in x:
        mult=mult*a
    return mult**(1/n)

def desvio_padrao(x):
    n=len(x)
    if n>1:
        media=media_arit(x)
        soma=0
        for a in x:
            soma=(a-media)**2+soma
        desvio=(1/(n-1)*(soma))**(1/2)
        return desvio
    
def prod_interno(x,y):
    prod=0
    for a in range (0,len(x)):
        prod=x[a]*y[a]+prod
    return prod

def posicao(x,v):
    for a in range (0,len(v)):
        p=0
        if v[a]==x:
            p=a+1
            return p
        if v[a]!=x:
            p=-1
    return p

def posMin(v):
    minimo=0
    if len(v)==0:
        return -1
    for i in range(1,len(v)):
        if v[i]<v[minimo]:
            minimo=i
    return minimo+1     
       
def intervalo(x,a,b):
    contador=0
    for i in range (len(x)):
        if x[i]>=a and x[i]<=b:
            contador=contador+1
            i=i+1
        else:
            contador=contador
    return contador
            
def capicua(x):
    n=len(x)
    for i in range(n//2):
        if x[i]!=x[n-1-i]:
            return 'false'
        return 'true'

def equimedia(x):
    n=len(x)
    for i in range(0,n//2):
        x[i]=(x[i]+x[n-1-i])/2
    for i in range(0,n//2):
        x.remove(x[n-1-i])
    return x

def rotacao(x):
    n=len(x)
    if n>=1:
        x=x
    x.insert(0,x[n-1])
    x.pop(n)
    return x