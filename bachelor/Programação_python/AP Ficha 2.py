# =============================================================================
# EX1
# =============================================================================
def abs(x):  
    if x<0:
        return -x
    else:
        return x

# =============================================================================
# EX2
# =============================================================================        
import math    
def grau_rad(x):
    return x*(math.pi)/180

# =============================================================================
# EX3
# =============================================================================
def posicao(a,b,c,d):
    s="Q em relacao a P esta"
    if (a,b)==(c,d):
        s=s+" coicidente"
    if c>a:
        s=s+" a direita"
        if d>b:
            s=s+" e acima"
        if b>d:
            s=s+" e a baixo"
    if a==c:
        if d>b:
            s=s+" acima"
        if b>d:
            s=s+" a baixo"   
    if a>c:
        s=s+" a esquerda"   
        if d>b:
            s=s+" e acima"
        if b>d:
            s=s+" e a baixo"
    return s   

# =============================================================================
# EX4 
# =============================================================================
# a)   
def somadivprops(n):
    if n <= 1:
        return 0
    s=1
    d=2
    while d*d < n:
        if n%d==0:
            s=s+(n//d)+d
            
        d=d+1
        
    if d*d==n:
        s=s+d
    return s
# b)    
def perfeito(n):
    if somadivprops(n)==n:
        return "true"
    if somadivprops(n)!=n:
        return "false"

# c)
def imprimeperfeitos(a,b):
    d=b-a+1
    for i in range(d):
        if perfeito(b-i)=='true':
            print (b-i)

# =============================================================================
# EX5
# =============================================================================
def leibniz(k):
    s=0
    n=0
    while n<=k:
        s=((-1)**n)/(2*n +1)*4+s
        n=n+1
    return s

# =============================================================================
# EX6
# =============================================================================
def sin(x,k):
    s=0
    n=0
    while n<=k:
        s=(((-1)**n)/math.factorial(2*n+1))*x**(2*n +1) +s
        n=n+1       
    return s












        