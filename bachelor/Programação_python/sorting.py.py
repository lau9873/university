"""
CC1015 - Aula Teórica 16.04.2020

Definição de funções de ordenação (selection sort, insertion sort e quicksort)

Para experimentar, no IDE ou interpretador de Python, usar:
>>> exec(open('sorting.py').read())
>>> L = [5,7,8,9,-1,1,3,7,2]
>>> selectionSort(L)
>>> L

"""

# função auxiliar para selectionSort
def posMin(L,k):
    "indice da 1ª ocorrencia do minimo de L[k], L[k+1], L[k+2], ..."
    imin = k
    for i in range(k,len(L)):
        if L[i] < L[imin]:
            imin = i
    return imin


def selectionSort(L):
    "ordenacao da lista L pelo método de seleção"
    n = len(L)
    for k in range(len(L)-1):
        ipos = posMin(L,k)
        if ipos != k:
            aux = L[ipos]
            L[ipos] = L[k]
            L[k] = aux
        # para ver o conteúdo em cada iteraçao
        # print(L)        

def insertionSort(L):
    "ordenacao da lista L pelo método de inserção"
    for k in range(1,len(L)):
        """ na iteração k, tem-se 
            L[0] <= L[1] <= L[2] <= .... <= L[k-1]
            e coloca-se L[k] na posição correta face a esse segmento
        """
        v = L[k]
        j = k-1
        while j >= 0 and L[j] > v:
            L[j+1] = L[j]
            j = j-1
        L[j+1] = v
        # para ver o conteúdo em cada iteraçao
        # print(L)        

def quickSort(L):
    "ordenacao de L pelo metodo quicksort, usando memoria auxiliar"
    if len(L) <= 1:
        return L
    pivot = L[0]
    LMenores,LMaiorIg = separar(L[1:],pivot)
    quickSort(LMenores)
    quickSort(LMaiorIg)
    aux = LMenores + [pivot] + LMaiorIg
    # necessario fazer a copia para L
    for i in range(len(L)):
        L[i] = aux[i]

#função auxiliar para quickSort    
def separar(L,x):
    Menores = []
    MaioresIguais = []
    for y in L:
        if y < x:
            Menores.append(y)
        else:
            MaioresIguais.append(y)
    return [Menores,MaioresIguais]            

# a função factorial para ilustrar funções recursivas
def fact(n):
    if n <= 1:
        return 1
    return fact(n-1)*n

