def cadeiras():
    ntipos=int(input())
    lista=[]
    for a in range (ntipos):
        tipo=int(input())
        quantidade=int(input())
        lista.append([tipo,quantidade])
    nhabitantes=int(input())
    depe=nhabitantes
    for b in range (nhabitantes):
        npreferencias=int(input())
        pe='empe'
        for c in range (npreferencias):
            preferencias=int(input())
            if pe=='empe' :
                for d in range(len(lista)):
                    if preferencias==lista[d][0]:
                        if lista[d][1]==0:
                            pe='empe'
                        if lista[d][1]>0:
                            lista[d][1]=lista[d][1]-1
                            pe='sentado'
                            depe=depe-1
    cadeiras=0
    for f in range (len(lista)):
        cadeiras=cadeiras+lista[f][1]
    print(depe)
    print(cadeiras)
cadeiras()