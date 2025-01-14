def abs(x):  
    if x<0:
        return -x
    else:
        return x
import math    
def grau_rad(x):
    return x*(math.pi)/180
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

def perfeito(n):
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
    if s==n:
        return "true"
    if s!=n:
        return "false"