def et():
    l=input()
    lista=[l]
    while l != '#':
        l=input()
        lista.append(l)
    resposta=lista[:]
    for i in range(len(lista)):
        if lista[i] != lista[i-1]:
            if lista[i-1]=='a' and lista[i]=='c':
                resposta[i]='t'
            if lista[i-1]=='a' and lista[i]=='t':
                resposta[i]='c'
            if lista[i-1]=='c' and lista[i]=='a':
                resposta[i]='t' 
            if lista[i-1]=='c' and lista[i]=='t':
                resposta[i]='a'
            if lista[i-1]=='t' and lista[i]=='c':
                resposta[i]='a'
            if lista[i-1]=='t' and lista[i]=='a':
                resposta[i]='c'
    for i in range(len(resposta)-1):
        print(resposta[i])
et()      