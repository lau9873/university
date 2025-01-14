"""
CC1015 - Definição da função mergeSort, dada na aula teórica de 20.04.2020
"""

# função auxiliar para mergeSort
def merge(L,M):
    res = []
    i = 0
    j = 0
    while i < len(L) and j < len(M):
        if L[i] <= M[j]:
            res.append(L[i])
            i = i+1
        else:
            res.append(M[j])
            j = j+1
    # resta verificar se L ou M ainda não acabaram (apenas um dos dois, pode não estar no fim)
    while i < len(L):  
        res.append(L[i])
        i = i+1
    while j < len(M):
        res.append(M[j])
        j = j+1
    return res

def mergeSort(L):
    """ Ordenação por merge sort. 
     A função retorna a lista ordenada, mas não modifica L """
    n = len(L)
    if n <= 1:
        return L
    meio = n // 2
    L1 = mergeSort(L[0:meio])
    L2 = mergeSort(L[meio:])
    return merge(L1,L2)


