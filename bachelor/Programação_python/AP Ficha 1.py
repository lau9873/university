def ex1():
   x=int(input())
   if x<0:
       x=-x
   print(x)
   
def ex2a():
    x,y,z=map(int,input("x,y,z?").split())
    if x>0 and y>0 and z>0:
        if x<(y+z) and y<(x+z) and z<(y+x):
            print("("+str(x)+","+str(y)+","+str(z)+")"+"define um triangulo")
    else:
         print("("+str(x)+","+str(y)+","+str(z)+")"+"nao define um triangulo")

def ex2b():       
    x,y,z=map(int,input().split())
    msg="("+str(x)+","+str(y)+","+str(z)+")"
    if x>0 and y>0 and z>0:
        if x<(y+z) and y<(x+z) and z<(x+y):
             if x==y and y==z and x==z:
                 return( msg +"define um triangulo equilatero")
             if x==y or y==z or x==z:
                 return( msg +"define um triangulo isosceles")    
             if x!=y and y!=z and x!=z    :
                 return( msg +"define um triangulo escaleno") 
    else:
        return(msg +"nao define um triangulo")

def ex3a():
    x,y=map(int,input().split())
    r=int(input())
    a,b=map(int,input().split())
    d=(a-x)**2+(b-y)**2
    msg='('+str(a)+','+str(b)+'): '
    if d==r**2:
        print(msg+'na fronteira')
    if d<r**2:
        print(msg+'no interior')
    if d>r**2:
        print(msg+'no exterior')

def ex3b():
    x,y=map(int,input().split())
    r=int(input())
    n=int(input())
    while n!=0:
        a,b=map(int,input().split())
        d=(a-x)**2+(b-y)**2
        msg='('+str(a)+','+str(b)+'): '
        if d==r**2:
            print(msg+'na fronteira')
        if d<r**2:
            print(msg+'no interior')
        if d>r**2:
            print(msg+'no exterior')
        n=n-1

def ex4():
    conta=0
    n=int(input("Quantos numeros?"))
    for i in range(n):
        x=int(input("valor?"))
        if x%2==0:
            if x%3!=0:
                conta=conta+1     
        if x%3==0:
            if x%2!=0:
                conta=conta+1        
    print("Numero de multiplos ou de 2 ou de 3 = "+str(conta))           
    
def ex5():
    n=int(input())
    a=n
    b=n
    while n!=0:   
        if n>a:
            a=n
        if n<b:
            b=n
        n=int(input())
    if a==b:
        print('Maior=Menor='+str(a))
    if a!=b:
        print('Maior = '+str(a)+' e Menor = '+str(b))
    
def ex6():
    n=int(input())  
    anterior=int(input())
    atual=int(input())
    if atual==anterior:
        print('Nao estritamente crescente nem estritamente decrescente')
    else:
        n=n-2
        if atual>anterior:
            sinal=1
        else:
            sinal=-1
        while n!=0 and sinal!=0:
            anterior =atual
            atual=int (input())
            n=n-1
            if (atual-anterior)*sinal<=0:
                sinal=0
        if sinal==0:
            print('Nao estritamente crescente nem estritamente decrescente')
        elif sinal==-1:
            print('Estritamente decrescente')
        elif sinal==1:
            print('Estritamente crescente')

def ex7():
    k=int(input())
    n=1
    s=0
    while n!=0:
        n=int(input())
        if n>0 and n%k==0:
            s=s+n
    print(s)

def ex8():
    a,b,c=map(int,input().split())
    x=b**2-4*a*c
    if a==0:
        print('Nao define uma equacao quadratica') 
    elif x<0:
        print('Sem raizes reais')
    elif x==0:
        print('Com uma raiz real dupla')
    elif x>0:
        print('Com raizes reais distintas')

def ex9():
    a,b,s=map(int(),input().split())
    if a!=0:
        if a<0:
            a=-a
            b=-b
            s=-s
        if s==0:
            if b%a !=0:
                print('impossivel')
            else:
                print('x= ' + str(-b//a))
        else:
            if s==1:
                operador='>='
            else:
                operador='<='
            if b%a!=0 and s==1:
                v=-b//a+1
            else:
                v=-b//a
            print('x'+operador+' '+str(v))
    elif b*s<0 or (s==0 and b!=0):
        print('impossivel')
    else:
        print('universal')
                
    
    
    
    
    
    
    
    
    
    
    