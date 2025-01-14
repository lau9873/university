def ali():
    a=0
    b=0
    seguidas=0
    lista=[]
    while a!=-1 or b!=-1:
        a,b=map(int,input().split())
        seguidas=seguidas+1
        if b==0:
            seguidas=0
            c=0
            while c==0:
                c=int(input())
        lista.append(seguidas)
    del lista[-1]
    maximo=max(lista)
    print(maximo) 
ali()       