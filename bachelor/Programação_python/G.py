def troco():
    a,b,c,d,e,f=map(int,input().split())
    moedas=[200,100,50,20,10,5]
    dinheiro=[a,b,c,d,e,f]
    
    retido=0
    retidas=0
    transacoes=0
    g,h=map(int,input().split())
    while g!=0 or h!=0:      
        g=g*100
        apagar=g+h
        pagou=0
        i=1
        
        while i !=0:
            i=int(input())
            if i==2 or i==1:
                i=i*100
            for k in range(len(moedas)):
                if i==moedas[k]:
                    dinheiro[k]=dinheiro[k]+1
            pagou=pagou+i
        troco=pagou-apagar
        for j in range (len(moedas)):
            adar=troco//moedas[j]
            if dinheiro[j]>0:
                if adar>=dinheiro[j]:
                    troco=troco-dinheiro[j]*moedas[j]
                    dinheiro[j]=0
                if adar<dinheiro[j]:
                    dinheiro[j]=dinheiro[j]-adar
                    troco=troco-moedas[j]*adar
        retido=retido+troco
        if troco!=0:
            retidas=retidas+1
        g,h=map(int,input().split())
        transacoes=transacoes+1
    retidoeuro=retido//100
    retidocent=retido%100
    print(str(retidoeuro)+' '+str(retidocent))
    print(str(retidas)+'/'+str(transacoes))
troco()