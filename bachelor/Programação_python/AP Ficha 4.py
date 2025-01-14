# =============================================================================
# EX1
# =============================================================================
def mdcalgoeuclides(a,b):
    if a>=b:
        q=a
        r=b
    else:
        q=b
        r=a
    while r!=0:
        aux=q%r
        q=r
        r=aux
    return q
    
def mdc_rec(a,b):
    if b==0:
        return a 
    return mdc_rec(b,a%b)

def mmcae(a,b):
    return (a*b/mdcalgoeuclides(a,b))

def mmcrec(a,b):
    return (a*b/mdc_rec(a,b))
    
# =============================================================================
# EX2
# =============================================================================
def crivo(n):
    lista=[i for i in range(2,n+1)]
    i=0 
    while i<len(lista):
        p=lista[i]
        j=i+1
        while j<len(lista):
            if lista[j]%p==0:
                del lista[j]
            j=j+1
        i=i+1
    return lista

def crivofast(n):
    lista=[i for i in range(2,n+1)]
    i=0 
    while i<len(lista):
        if lista[i]!=0:
            p=lista[i]
            j=i+p
            while j<len(lista):
                lista[j]=0
                j=j+p
        i=i+1
    return [x for x in lista if x!=0]

def crivofastfast(n):
    lista=list(range(n+1))
    lista[0]=lista[1]=0
    i=0
    while i*i <=n:
        if lista[i]!=0:
            p=lista[i]
            j=i+p
            while j<=n:
                lista[j]=0
                j+=+p
        i+=+1
    return [x for x in lista if x!=0 ]
    
# =============================================================================
# EX3
# =============================================================================
#a)
def decomposicao(n):
    resultado=[]
    crivo=crivofastfast(n)
    while n>1:
        for x in crivo:
            while n%x==0:
                n=n//x
                resultado.append(x)
    return resultado
#b)
def check_primo(x:int(),primos:list())->bool:
    for i in primos:
        if x%i==0:
            return False
    return True
#c)
def decompSucinta(n):
    if n<=1:
        return []
    primos=[]
    resultado=[]
    candidatos=[2]+[3+2*j for j in range((n-3)//2+1)]
    i=0
    while n>1 and i <len(candidatos):
        p=candidatos[i]
        if n%p==0 and check_primo(p,primos):
            primos.append(p)
            resultado.append(p)
            n=n//p
            while n%p==0:
                resultado.append(p)
                n=n//p
        i=i+1
    lista=[]
    for x in primos:
        k=0
        for i in resultado:
            if i==x:
                k=k+1
        lista.append([x,k])         
    return lista
#d)
def questao(r):
    res=1
    for x in r:
        res=res*x[0]**x[1]
    return res
# questao(decompSucinta(104))=104
    
# =============================================================================
# EX4
# =============================================================================
#a)
def merge_rec(r,s):
    if r==[]:
        return s
    if s==[]:
        return r
    if r[0]<=s[0]:    
        b=r[0]
        r.remove(r[0])
        return [b]+merge(r,s)
    if r[0]>s[0]: 
        b=s[0]
        s.remove(s[0])
        return [b]+merge(r,s)
#b)      
def merge_iter(r,s):
    resultado=[]
    i=0
    j=0
    while (i <len(r) and j<len(s)):
        if r[i]<=s[j]:
            resultado.append(r[i])
            i+=+1
        else:
            resultado.append(s[j])
            j+=+1
    while i<len(r):
        resultado.append(r[i])
        i=i+1
    while j<len(s):
        resultado.append(s[j])
        j=j+1
    return resultado
#c)    
def merge(r,s):
    lista=r+s
    lista.sort()
    return lista
 
# =============================================================================
# EX5
# =============================================================================
def mmc_fac(fa,fb):
    na=len(fa)
    nb=len(fb)
    i=0
    j=0
    mmc=[]
    while i< na and j< nb:
        xa=fa[i]
        xb=fb[j]
        if xa[0]==xb[0]:
            mmc.append([xa[0],max(xa[1],xb[1])])
            i+=+1
            j+=+1
        elif xa[0]<xb[0]:
            mmc.append(xa)
            i=i+1
        else:
            mmc.append(xb)
            j+=+1
    if i <na:
        mmc+=+fa[i:]
    elif j<nb:
        mmc+=+fb[j:]
    return mmc

def mdc_fac(fa,fb):
    na=len(fa)
    nb=len(fb)
    i=0
    j=0
    mdc=[]
    while i<na and j<nb:
        xa=fa[i]
        xb=fb[j]
        if xa[0]==xb[0]:
            mdc.append(xa[0],min(xa[1],xb[1]))
            i+=+1
            j+=+1
        elif xa[0]<xb[0]:
            i=i+1
        else:
            j+=+1
    return mdc

# =============================================================================
# EX6
# =============================================================================
#a)
def strb2int(x,b):
    resposta=0
    i=0
    while i<len(x)-1:
        if x[i] in '0123456789':
            resposta=(resposta+int(x[i]))*b           
        else:
            resposta=(resposta+ord(x[i])-55)*b
        i+=+1
    if x[i] in '0123456789':
        resposta=resposta+int(x[i])          
    else:
        resposta=resposta+ord(x[i])-55
    return resposta
#b)
def int2strb(x,b):
    lista=[0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F']
    n=0
    resposta=[]
    if x//b==0:
        resposta.insert(0,str(lista[x%b]))
    while x//b!=0:
        while x%b==0:      
            resposta.insert(0,str(0))
            x=(x)/b
        while x%b!=0:
            r=int(x%b)
            resposta.insert(0,str(lista[r]))
            n=n+1
            x=(x-r)/b
        
    return "".join(resposta)

# =============================================================================
# EX7
# =============================================================================
#a)
#def divisivel_pot10(x,p):
#    if x%(10**p)==0:
#        return True
#    else:
#        return False
def divisivel_pot10(x:str,p:int):
    if x=='0':
        return True    
    if len(x)<=p:
        return False
    for i in range(len(x)-p,len(x)):
        if x[i]!=0:
            return False
    return True
#b)
def par(x):
    n=x[len(x)-1]
    return(n=='0' or n=='2' or n=='4' or n=='6' or n=='8')
#c)
def divisivel_9(x):
    resposta=0
    for i in x:
        resposta+=int(i)
    if resposta%9==0:
        return True
    return False
#d)
def divisivel_11(x):     
    par=0
    impar=0
    for i in range(1,len(x),2):
        par+=int(x[i])
    for i in range(0,len(x),2):
        impar+=int(x[i])
    if par==impar:
        return True
    return False
# =============================================================================
# EX8
# =============================================================================
#def soma(x,y,b):
#    carry=0
#    soma=[]
#    
#    if len(x)>=len(y):
#        n=len(y)
#        h=len(x)
#    if len(x)<len(y):
#        n=len(x) 
#        h=len(y)
#    for i in range(n):
#        if int(x[i])+int(y[i])+carry>b-1:
#            soma.insert(0,int(x[i])+int(y[i])+carry-b)
#        if int(x[i])+int(y[i])+carry<=b-1:
#            soma.insert(0,int(x[i])+int(y[i])+carry)
#            carry=0
#    for i in range(n,h):
#        if len(x)>=len(y):    
#            soma.insert(0,x[i])
#        if len(x)<len(y):
#            soma.insert(0,y[i])
#
#    return soma
#     ?????       
#
def soma(x,y,b):
    return int2strb((strb2int(x,b)+strb2int(y,b)),b)
        


















