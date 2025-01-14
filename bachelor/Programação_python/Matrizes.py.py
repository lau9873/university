"""
CC1015 - Aula Teórica 2 Abril 2020
    Exemplos de funções sobre matrizes
    As matrizes são definidas por listas de listas
"""

def matriz_nula(m,n):
    return [ [0 for _ in range(n)]  for _ in range(m) ]


def prod_por_escalar(Mat,k):
    "multiplica os elementos de Mat por escalar k"
    for i in range(len(Mat)):
        for j in range(len(Mat[0])):
            Mat[i][j] = k*Mat[i][j]


def produto(A,B):
    "calcula o produto de A por B  (A: ma x na e B: mb x nb)"
    ma = len(A)       # numero de linhas de A
    na  = len(A[0])   # numero de colunas de A
    mb = len(B)
    nb  = len(B[0])
    if  na != mb:
        return []    # forma de assinalar erro (dimensoes incompativeis)
    #  caso na == mb
    C = [ [0 for _ in range(nb) ]  for _ in range(ma)]
    for i in range(ma):
        for j in range(nb):
            for k in range(na):
                C[i][j] = C[i][j] + A[i][k]*B[k][j]
    return C

def troca(A,i0,i1):
    "troca a linha i0 com a linha i1"
    aux = A[i0]
    A[i0] = A[i1]
    A[i1] = aux

def somar(A,B):
    "soma a matriz B a A (admite que têm dimensões iguais)"
    m = len(A)
    n = len(A[0])
    for i in range(m):
        for j in range(n):
            A[i][j] = A[i][j]+B[i][j]


def diagonal(A):
    "verificar se A é uma matriz diagonal (assume que é quadrada  n x n)"
    n = len(A)
    for i in range(n):
        for j in range(n):
            if i != j and A[i][j] != 0:
                 return False
    return True

def transf(A,v):
    "determinar a imagem de v pela transformação definida pela matriz A (assume A: m x n e vetor v de dimensao n)"
    res = []
    for i in range(len(A)):
        c = 0
        for j in range(len(v)):
            c += A[i][j] * v[j]
        res.append(c)
    return res

              
    
