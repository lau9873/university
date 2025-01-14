# =============================================================================
#  Conversao de temperatura
# =============================================================================
def celsius(F):
    return ((5/9)*(F-32))
# =============================================================================
#  Distancia entre dois pontos
# =============================================================================
import math
def dist(x1,y1,x2,y2):
    return (math.sqrt((x2-x1)**2 + (y2-y1)**2))
# =============================================================================
#  Conversao para radianos
# =============================================================================
import math
def radianos(graus: int, mins: int, segs: int) -> float:
    x=graus+mins/60+segs/(60*60)
    resp=(x*2*math.pi)/360
    return(resp)  
# =============================================================================
#  Desenhar um poli­gono
# =============================================================================
import turtle
def poligono(n: int, lado: float):
   '''Desenhar um poli­gono regular com n lados.'''
   grau=(360/n)
   while n>0:
       turtle.forward(lado)
       turtle.left(grau)
       n=n-1
# =============================================================================
#  Desenhar um friso  
# =============================================================================
import turtle
def friso(n:int, lado: int):
    while n>0:
        turtle.forward(lado)
        turtle.left(90)
        turtle.forward(lado)
        turtle.right(90)
        turtle.forward(lado)
        turtle.right(90)
        turtle.forward(lado)
        turtle.left(90)
        n=n-1
# =============================================================================
#  Classificar triângulos        
# =============================================================================
def triangulo(a: int, b: int, c: int) -> str:
   # completar esta definição
   if a==b and a==c:
       return ('equilátero')
   elif a==b or a==c or b==c:
       return ('isósceles')
   else:
       return ('escaleno')
# =============================================================================
#  Classificar uma pontuação   
# =============================================================================
def classifica(p: int) -> str:
   # complete esta definição 
   if 0<=p and p<50:
       return ('insuficiente')
   if 50<=p and p<70:
       return ('suficiente')
   if 70<=p and p<80:
       return ('bom')
   if 80<=p and p<90:
       return ('muito bom')
   if 90<=p and p<=100:
       return ('excelente')
   else:
       return ('inválido')   
# =============================================================================
#  Contar algarismos    
# =============================================================================
def algarismos(n: int) -> int:
   # complete esta definição
   k=0
   i=n
   while i!=0:
       k=k+1
       i=n//10**k
   return k
# =============================================================================
#  Números triangulares   
# =============================================================================
def triangular(n: int) -> bool:
    # completar esta definição
    k=0
    l=0
    while l<n:
        k=k+1
        l=l+k
    return (l==n)
# =============================================================================
#  Calcular raizes aproximadamente
# =============================================================================
def raiz(q: float, epsilon: float) -> float:
    # completar esta definição
    x=q/2.0
    a=0.0
    while abs(x-a)>=epsilon:
        a=x
        x=1/2*(x+q/x)
    return x    
# =============================================================================
#  Testar palíndromos   
# =============================================================================
def palindromo(txt: str) -> bool:
   # completar esta definição
   lista=[]
   lista2=[]
   for i in txt:
       if i>='a' and i<='z':
           lista.append(i)
       if i>='A' and i <='Z':
           lista.append(chr(ord(i)+32))
   for l in range(len(lista)):
       lista2.append(lista[-l-1])
   return (lista==lista2)
# =============================================================================
#  Palavra-passe forte           
# =============================================================================
def forte(palavra: str) -> bool:
    # completar esta definição
    m=0
    M=0
    n=0
    for i in palavra: 
        if (i>='a' and i<='z'):
            m=1
    for i in palavra: 
        if (i>='A' and i<='Z'):
            M=1
    for i in palavra: 
        if (i>='0' and i<='9'):
            n=1  
    return((len(palavra)>=8) and m==1 and M==1 and n==1)
# =============================================================================
#  Testar repetidos
# =============================================================================
from typing import *
def repetidos(xs: List[Any]) -> bool:
    # completar esta definição
    for i in range(len(xs)):
        for j in range(len(xs)):
            if i!=j:
                if xs[i]==xs[j]:
                    return True
    return False
# =============================================================================
#  Triângulo de Pascal
# =============================================================================
from typing import *
def comb(n,k):
    if k==0 or k==n:
        return 1
    elif n>0 and k>0 and k<n:
        return (comb(n-1,k-1)+comb(n-1,k))
def pascal(n: int) -> List[int]:
    # completar esta definição
    lista=[]
    for i in range(0,n+1):
        lista.append(comb(n,i))
    return lista
# ================================ Ou =========================================
from typing import *
def fact(n):
    r=1
    count=1
    while count <= n:
        r *= count
        count += 1
    return r
def comb(n,k):
    return int(fact(n)/(fact(k)*fact(n-k)))
def pascal(n: int) -> List[int]:
    # completar esta definição
    lista=[]
    for i in range(0,n+1):
        lista.append(comb(n,i))
    return lista
# =============================================================================
#  Desvio padrão
# =============================================================================
from typing import *
def media(x):
    r=0
    for i in range (len(x)):
        r=r+x[i]
    return (r/len(x))
    
def desvio_padrao(lista: List[float]) -> float:
    # completar esta definição
    r=0
    for n in range(len(lista)):
        r=r+(lista[n]-media(lista))**2
    return ((1/(len(lista)-1))*r)**(1/2)
# =============================================================================
#  Quadrados mágicos
# =============================================================================
from typing import *
def magico(A: List[List[int]]) -> bool:
    # completar esta definição
    somas=[]
    d=0
    l=0
    c=0
    d2=0
    for i in range(len(A)):
        d=d+A[i][i]
        d2=d2+A[i][len(A)-1-i]
        for j in range(len(A)):
            l=l+A[i][j]
            c=c+A[j][i]
        somas.append(l)
        l=0
        somas.append(c)
        c=0
    somas.append(d)
    somas.append(d2)
    for p in range(len(somas)):
        if somas[1]!=somas[p]:
            return False
    return True
# =============================================================================
#  Formatar tempo        
# =============================================================================
def tempo(t: int) -> str:
    # completar esta definição
    horas=t//3600
    minutos=(t%3600)//60
    segundos=(t%3600)%60
    if horas<=9 and minutos<=9 and segundos<=9:
        return( '0'+str(horas)+':'+'0'+str(minutos)+':'+'0'+str(segundos))
    if horas<=9 and minutos<=9:
        return( '0'+str(horas)+':'+'0'+str(minutos)+':'+str(segundos))
    if horas<=9 and segundos<=9 :
        return( '0'+str(horas)+':'+str(minutos)+':'+'0'+str(segundos))
    if segundos<=9 and minutos<=9 :
        return( str(horas)+':'+'0'+str(minutos)+':'+'0'+str(segundos))
    if horas<=9 :
        return( '0'+str(horas)+':'+str(minutos)+':'+str(segundos))
    if minutos<=9 :
        return( str(horas)+':'+'0'+str(minutos)+':'+str(segundos))
    if segundos<=9:
        return( str(horas)+':'+str(minutos)+':'+'0'+str(segundos))
    return( str(horas)+':'+str(minutos)+':'+str(segundos))
# ================================ Ou =========================================
def tempo(t:int):
    h = t//3600
    r = t % 3600
    m = r // 60
    r = r % 60
    if h < 10:
        h ='0%d' % (h)
    if m < 10:
        m = '0%d' % (m)
    if r < 10:
        r = '0%d' % (r)
    return (("%s:%s:%s") % (h,m,r))
# =============================================================================
#  Sequência de Collatz
# =============================================================================
from typing import *

def collatz(n: int) -> List[int]:
    # completar esta definição
    lista=[n]
    while n!=1:
        if n%2==0:
            n=n//2
            lista.append(n)
        else:
            n=n*3+1
            lista.append(n)
    return lista
# =============================================================================
#  Média aritmética
# =============================================================================
def media(valores):
    # completar esta definição
    r=0
    if valores==[]:
        raise ValueError
    if not list(valores):
        raise TypeError
    for i in valores:
        r=r+i
    return r/len(valores)
# =============================================================================
#  Testar anagramas
# =============================================================================
def anagramas(txt1: str, txt2: str) -> bool:
    # completar
   lista=[]
   lista2=[]
   lista3=[]
   for i in txt1:
       if i>='a' and i<='z':
           lista.append(i)
       if i>='A' and i <='Z':
           lista.append(chr(ord(i)+32))
   for l in range(len(lista)):
       lista3.append(lista[-l-1])
   for i in txt2:
       if i>='a' and i<='z':
           lista2.append(i)
       if i>='A' and i <='Z':
           lista2.append(chr(ord(i)+32))
   lista2.sort()
   lista3.sort()
   return (lista2==lista3)
# =============================================================================
#  Lista de co-primos
# =============================================================================
from typing import *

def mdc(a: int, b: int) -> int:
    # completar esta definição
    if b==0:
        return a
    if a==0:
        return b
    else:
        return mdc(b,a%b)
        
def coprimos(n: int) -> List[int]:
    # completar esta definição
    lista=[]
    for l in range(n):
        p=mdc(l,n)
        if p==1:
            lista.append(l)
    return lista
# =============================================================================
#  Testar palíndromos recursivamente       
# =============================================================================
def palindromo(txt: str) -> bool:
    # completar esta definição
    if len(txt)<=1:
        return True
    if txt[0]==txt[-1]:
        return palindromo(txt[1:-1])
    return False
# =============================================================================
#  Calcular a mediana
# =============================================================================
def mediana(a: int, b: int, c: int) -> int:
    # completar esta definição
    lista=[a,b,c]
    lista.sort()
    return lista[1]
# =============================================================================
#  Acertos do Totoloto
# =============================================================================
from typing import *
def repetidos(xs: List[Any]) -> bool:
    # completar esta definição
    for i in range(len(xs)):
        for j in range(len(xs)):
            if i!=j:
                if xs[i]==xs[j]:
                    return True
    return False
def acertos(chave: List[int], aposta: List[int]) -> int:
    # completar esta definição
    n=0
    assert not(repetidos(chave))
    assert not(repetidos(aposta))
    for i in chave:
        for j in aposta:
            if i==j:
                n=n+1
    return n
# =============================================================================
#  Determinar o quadrante
# =============================================================================
def quadrante(x: int, y: int) -> str:
    # completar esta definição
    if x>0:
        if y<0:
            return('IV')
        if y>0:
            return('I')
        else:
            return('EIXOS')
    if x<0:
        if y<0:
            return('III')
        if y>0:
            return('II')
        else:
            return('EIXOS')
    else:
        return('EIXOS')
# =============================================================================
#  Ângulo entre dois vetores
# =============================================================================
import math
def mod(a,b):
    return ((a**2)+(b**2))**(1/2)
def angulo(x1: float, y1: float, x2: float, y2: float) -> float:
    # completar esta definição 
    p=x1*x2+y1*y2
    r=mod(x1,y1)*mod(x2,y2)
    return math.acos(p/r)
# =============================================================================
#  Próximo primo
# =============================================================================
def primo(n):
    for i in range(2,int(n**(1/2))+1):
        if n%i==0:
            return False
    return True
def proximo_primo(n: int) -> int:
    # completar esta definição
    for i in range(1,n):
        if primo(n+i):
            return n+i
    return 2
# =============================================================================
#  Tamanho de camisas (3 valores)
# =============================================================================
def tamanho_camisa(peso,altura):
    if altura < 175 and peso <65:
        return 'S'
    elif altura <180 and peso <75:
        return 'M'
    elif altura <185 and peso <85:
        return 'L'
    else:
        return 'XL'
# =============================================================================
#  Torre de Hanoi (3 valores)       
# =============================================================================
def hanoi(n):
    if n==1:
        return 1
    else:
        return (2*hanoi(n-1)+1)
# =============================================================================
#  Dois inteiros consecutivos (3 valores)
# =============================================================================
def consecutivos(l):
    for i in range (len(l)):
        if (l[i-1]+1)==l[i]:
            return True
    return False
# =============================================================================
#  Parte texto (3 valores)
# =============================================================================
def parte_texto(txt):
    letras=[]
    num=[]
    outros=[]
    for i in txt:
        if (i>='a' and i<='z') or (i>='A' and i<='Z'):
            letras.append(i)
        elif i>='0' and i<='9':
            num.append(i)
        else:
            outros.append(i)
    a=''.join(letras)
    b=''.join(num)
    c=''.join(outros)
    return [a,b,c]
# =============================================================================
#  Colunas sem repetidos (5 valores)
# =============================================================================
def colunas_sem_repetidos(A):
    for p in range(len(A)):
        for i in range(len(A)):
            for j in range(len(A)):
                if i!=j:
                    if A[i][p]==A[j][p]:
                        return False
    return True        
# =============================================================================
#  Soma dos múltiplos de 3 ou de 5 (3 valores)
# =============================================================================
def soma_multiplos(n):
    s=0
    for i in range (n+1):
        if i%3==0 or i%5==0:
            s=s+i
    return s
# =============================================================================
#  Maiúsculas e minúsculas (3 valores)
# =============================================================================
def  maiusc_minusc(txt):
    m=0
    M=0
    for i in txt:
        if i >='a' and i <='z':
            m=m+1
        if i >='A' and i <='Z':
            M=M+1
    if m>M:
        return -1
    elif M>m:
        return 1
    else:
        return 0
# =============================================================================
#  Contar hashtags (5 valores)
# =============================================================================
def conta_hashtags(txt):
    lista=[]
    lista2=[]
    for i in txt[1:]:
        if i=='#':
            lista.append(lista2)
            lista2=[]
        if i!='#':
            lista2.append(i)
    lista.append(lista2)
    for q in range( len(lista)):
        for p in range(len(lista)):
            if q!=p:
                if lista[p]==lista[q]:
                    lista.remove(lista[p])
                    lista.insert(p,[])
                    
    r=0
    for i in lista:
        if i!=[]:
            r=r+1
    return r
# =============================================================================
#  Colunas com repetidos (5 valores)
# =============================================================================
def colunas_com_repetidos(A):
    for p in range(len(A)):
        for i in range(len(A)):
            for j in range(len(A)):
                if i!=j:
                    if A[i][p]==A[j][p]:
                        return True
    return False
# =============================================================================
#  Soma dos múltiplos de 3 e não de 5 (3 valores)
# =============================================================================
def soma_multiplos(n):
    s=0
    for i in range (n+1):
        if i%3==0 and i%5!=0:
            s=s+i
    return s
# =============================================================================
#  Top da playlist (6 valores)
# =============================================================================
def top_playlist(pl):
    dic={}
    for i in pl:
        (a,b)=i
        if b in dic:
            dic[b]+=1
        else:
            dic[b]=1
    (x,y)=pl[0]
    maximo=dic[y]
    for k in list(dic.keys()):
        if dic[k]>maximo:
            maximo=dic[k]
            y=k
    return y
# =============================================================================
#  Letras e dígitos (3 valores)
# =============================================================================
def letras_digitos(txt):
    m=0
    M=0
    for i in txt:
        if (i >='a' and i <='z') or (i >='A' and i <='Z'):
            m=m+1
        if i>='0' and i<='9':
            M=M+1
    if m>M:
        return 1
    elif M>m:
        return -1
    else:
        return 0
# =============================================================================
#  Permutação de dígitos (5 valores)
# =============================================================================
def posmin(l,k):
    imin=k
    for i in range (k,len(l)):
        if l[i]<l[imin]:
            imin=i
    return imin
def selectionsort(l):
    for k in range (len(l)-1):
        ipos=posmin(l,k)
        if ipos!=k:
            aux=l[ipos]
            l[ipos]=l[k]
            l[k]=aux
    return l
def permutacao(a,b):
    listaa=[]
    listab=[]
    p=str(a)
    q=str(b)
    for i in p:
        listaa.append(i)
    for i in q:
        listab.append(i)
    c=selectionsort(listaa)
    d=selectionsort(listab)
    return (c==d)
# =============================================================================
#  Quadrado latino (6 valores)
# =============================================================================
def quadrado_latino(A):
    orig=[]
    for i in range(1,len(A)+1):
        orig.append(i)
    comp=[]
    for i in range(len(A)):
        for j in range(len(A)):
            comp.append(A[j][i])
        comp.sort()
        if comp!=orig:
            return False
        comp=[]
    for i in range(len(A)):
        for j in range(len(A)):
            comp.append(A[i][j])
        comp.sort()
        if comp!=orig:
            return False
        comp=[]
    return True