"""
CC1015 - Resolução do problema "Não lhes dês troco", usando um dicionário para suportar a caixa.

Dado na aula teórica de 20.04.2020
"""





def insereQuantia(caixa):
    """ inserir na caixa as moedas que o utilizador deu numa transação """
    total = 0
    moeda = int(input())
    while moeda !=0:
        if moeda <= 2:
            moeda = moeda*100
        total += moeda
        caixa[moeda] += 1
        moeda =int(input())
    return total


def darTroco(troco,caixa,moeda):
    """ formar um troco, usando sempre a moeda de valor mais alto que puder"""
    j = 0
    while troco != 0 and j < 6:
        k=min(troco//moeda[j],caixa[moeda[j]])  
        # k define quantas vezes pode usar a moeda j
        troco = troco - k*moeda[j]
        caixa[moeda[j]]  -= k
        j = j+1    # passa à próxima moeda
    return troco



def naolhesdestroco():
    moeda = [200,100,50,20,10,5]
    aux=list(map(int,input().split()))
    # criar a caixa como um dicionário 
    caixa = {}    
    for i in range(6):
        caixa[moeda[i]] = aux[i]
    # inicializar as variaveis que permitem dar a resposta final
    montanteRetido =0
    retencoes = 0
    transacoes = 0
    # processar transações
    E,C=map(int,input().split())
    while E!=0 or C!=0:
        transacoes += 1
        quantia = insereQuantia(caixa)
        troco = darTroco(quantia-E*100-C,caixa,moeda)
        if troco!=0:
            montanteRetido += troco
            retencoes += 1
        E,C=map(int,input().split())
    # depois de processar todas as transacoes, escrever o resultado
    cent = montanteRetido % 100
    euro = montanteRetido // 100
    msgOutput = '%d %d\n%d/%d' % (euro,cent,retencoes,transacoes)
    print(msgOutput)

naolhesdestroco()



