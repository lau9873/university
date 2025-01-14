from typing import *


#=======================================  Máximo divisor comum
def mdc(a:int,b:int) -> int:
    "Determina o máximo divisor comum de a e b. Assume a e b não negativos"
    # abordagem iterativa
    if a >= b:
        q = a
        r = b
    else:
        q = b
        r = a
    while r != 0:
        aux = q%r
        q = r
        r = aux
    return q


def mdc_rec(a:int,b:int) -> int:
    "Determina o máximo divisor comum de a e b. Assume a e b não negativos"
    # abordagem recursiva
    if b == 0:    
        return a
    return mdc_rec(b,a%b)

#=======================================  Sucessão de Fibonacci

def fib(n:int) -> int:
    "Calcula o termo de ordem n da sucessão de Fibonacci"
    # versão recursiva

    if n < 2:
        return 1
    return fib(n-1)+fib(n-2)

def fib_iterativa(n:int) -> int:
    "Calcula o termo de ordem n da sucessão de Fibonacci"
    # versão iterativa

    if n < 2:
        return 1

    anterior = ultimo  = 1

    for i in range(2,n-1):
        proximo = anterior + ultimo
        anterior = ultimo
        ultimo = proximo

    return ultimo

#================================ compactar uma lista para remover os elementos iguais a x

def compactar(lista: List[int], x: int):
    "Remover todas as ocorrencias de x da lista"
    nfinal = 0  # marca a primeira posição livre

    for i in range(len(lista)):
        if lista[i] != x:
            lista[nfinal] = lista[i]    # copia lista[i] para a primeira livre
            nfinal = nfinal+1   # a primeira livre passará a ser a seguinte
    del lista[nfinal::]    # remove todos a partir de lista[nfinal]


def compactar_alt(lista: List[int], x: int):
    "Remover todas as ocorrencias de x da lista"
    lista = [y for y in lista if y != x]     #usando diferença de listas



#===========================  Crivo de Erastotenes

def crivo(n: int) -> List[int]:
    "determina a lista de primos até n usando o crivo de Erastotenes"
    
    lista = [i for i in range(2,n+1)]    # definir lista em compreensão
    # ou usar     lista = list(range(2,n+1))  

    i = 0
    while i<len(lista):
        if lista[i] != 0:
            p = lista[i] # p é primo
            j = i+p # vamos remover múltiplos de p maiores do que p
            while j<len(lista):
                lista[j] = 0    # não remove mas assinala que não é primo
                j = j+p
        i = i+1

    return [x for x in lista if x != 0]   # a lista dos x's de lista que não são nulos
    # em alternativa chamar  compactar(lista,0)  para remover 0's e depois return lista


def crivo2(n: int) -> List[int]:
    "determina a lista de primos até n usando o crivo de Erastotenes"
    # outra versão (muito mais lento)

    lista = list(range(2,n+1))

    i = 0
    while i<len(lista):
        p = lista[i] # p é primo
        j = i+1 # vamos remover múltiplos
        while j<len(lista):
            if lista[j]%p == 0:
                del lista[j]
            else:
                j = j+1
        i = i+1 # próximo número

    return lista



import time
def comparaTempos(n:int,times:int):
    # para comparar as duas funções repetindo execução times vezes

    start = time.process_time()
    for i in range(times):
        crivo(n)
    end = time.process_time()

    start2 = time.process_time()
    for i in range(times):
        crivo2(n)
    end2 = time.process_time()

    print("crivo para n = ",n,":",(end-start)/times)
    print("crivo2 para n = ",n,":",(end2-start2)/times)
