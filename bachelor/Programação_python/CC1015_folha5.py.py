

"""
Uma resolução dos exercícios da Folha 5
"""

import copy


# 1a)

def reflexiva(M):
    """ Verifica se é reflexiva. Não é reflexiva sse existir um i tal que M[i][i] == False """

    for i in range(len(M)):
       if M[i][i] == False:
          return False
    return True


def reflexiva_explica(M):
    """ Verifica se a relação é reflexiva. Não é reflexiva sse existir um i tal que M[i,i] == False """

    for i in range(len(M)):
        if M[i][i] == False:
            print('Não é reflexiva. Por ex., (%d,%d) não pertence à relação.' % (i,i))
            return
    print('É reflexiva.')

# 1b)
def simetrica(M):
    """ Verifica se a relação é simetrica. Não é simétrica sse existir 
    um par (i,j) tal que M[i,j] != M[j,i] """
    for i in range(1,len(M)):  # i= 1,2,3,....,n-1
        for j in range(i):   # j= 0,1,2,3,...,i-1
            if M[i][j] != M[j][i]:
                return False
    return True

def simetrica_explica(M):
    """ Verifica se a relação é simetrica. Não é simétrica sse existir um par (i,j) tal que M[i,j] != M[j,i] """
    for i in range(1,len(M)):  # i= 1,2,3,....,n-1
        for j in range(i):   # j= 0,1,2,3,...,i-1
            if M[i][j] != M[j][i]:
                msg = 'Não é simétrica. Por ex., (%d,%d)' % (i,j)
                if M[i][j]:
                    msg = msg + ' pertence à relação e (%d,%d) não pertence.' % (j,i)
                else:
                    msg = msg + ' não pertence à relação e (%d,%d) pertence.' % (j,i)
                print(msg)
                return
    print('É simétrica.')

# 1c)
def antissimetrica(M):
    """ Verifica se a relação é antissimetrica. Não é antissimetrica sse existir um par (i,j) tal que M[i,j]== True e M[j,i]== True e i != j """
    for i in range(1,len(M)):  # i= 1,2,3,....,n-1
        for j in range(i):   # j= 0,1,2,3,...,i-1
            if M[i][j] and M[j][i]:
                return False
    return True


def antissimetrica_explica(M):
    """ Verifica se a relação é antissimetrica. Não é antissimetrica sse existir um par (i,j) tal que M[i,j]== True e M[j,i]== True e i != j """
    for i in range(1,len(M)):  # i= 1,2,3,....,n-1
        for j in range(i):   # j= 0,1,2,3,...,i-1
            if M[i][j] and M[j][i]:
                print('Não antissimétrica. Por ex., (%d,%d) e (%d,%d) estão ambos na relação.' %(i,j,j,i))
                return
    print('É antissimétrica.')

# 1d)
def transitiva(M):
    """ Verifica se a relação é transitiva. Não é transitiva sse existirem i, j e k com M[i,k]== True e M[k,j]== True e  M[i,j] == False"""

    for i in range(len(M)):
        for j in range(len(M)):
            for k in range(len(M)):
                if M[i][k] and M[k][j] and not(M[i][j]):
                   return False
    return True


def transitiva_explica(M):
    """ Verifica se a relação é transitiva. Não é transitiva sse existirem i, j e k com M[i,k]== True e M[k,j]== True e  M[i,j] == False"""

    for i in range(len(M)):
        for j in range(len(M)):
            for k in range(len(M)):
                if M[i][k] and M[k][j] and not(M[i][j]):
                   print('Não é transitiva. Por exemplo, (%d,%d) e (%d,%d) pertencem à relação mas (%d,%d) não pertence.' % (i,k,k,j,i,j))
                   return
    print('É transitiva.')


# 1e)
def equivalencia(M):
    return reflexiva(M) and simetrica(M) and transitiva(M)

# 1f)
def ordemParcial(M):
    return reflexiva(M) and antissimetrica(M) and transitiva(M)


# 2

def composta(r,s):
   if len(r[0]) != len(s):
       return []     # nao pode calcular o produto        
   t = [[False for j in range(len(s[0]))] for i in range(len(r))]
   for i in range(len(r)):   # linhas da r
      for j in range(len(s[0])):   # colunas da s
         for k in range(len(r[0])):   #colunas da r
            t[i][j] = t[i][j]  or (r[i][k] and s[k][j])
   return t

#3 --------------------

def transposta(r):
    # usar listas em compreensao
    return [ [ r[i][j]  for i in range(r) ]   for j in range(range(r[0])) ]

#4  -----------------------------
def fechoReflexivo(r):
    """calcula em r o fecho reflexivo de r"""
    for i in range(len(r)):
        r[i][i] = True


def fechoReflex(r):
    """retorna o fecho reflexivo de r mas não altera r"""
    fecho = copy.deepcopy(r)
    for i in range(len(fecho)):
        fecho[i][i] = True
    return fecho

def fechoSimetrico(r):
    """calcula em r o fecho simetrico de r"""
    for i in range(1,len(r)):  # i= 1,2,3,....,n-1
        for j in range(i):   # j= 0,1,2,3,...,i-1
            aux = r[i][j] or r[j][i]
            r[i][j] = aux
            r[j][i] = aux

def fechoSim(r):
    """retorna o fecho simetrico de r mas não altera r"""
    fecho = copy.deepcopy(r)
    for i in range(1,len(fecho)):  # i= 1,2,3,....,n-1
        for j in range(i):   # j= 0,1,2,3,...,i-1
            aux = fecho[i][j] or fecho[j][i]
            fecho[i][j] = aux
            fecho[j][i] = aux
    return fecho


def fechoTransitivo(r):
    """ retorna o fecho transitivo de r e não altera r.
    Usa o facto de o fecho transitivo ser a menor relação transitiva que contém r.
    Vai testando se a relação em fecho já é transitiva e, se não for, acrescenta 
    pares que pares (i,j) que faltem e repete enquanto houver alteração.
    """
    fecho = copy.deepcopy(r)
    novosPares = True   # inicialmente não sabemos se é transitiva ou não
    while novosPares:
        novosPares = False   # para assinalar se adicionou mais pares
        for i in range(len(r)):
            for j in range(len(r)):
                for k in range(len(r)):
                    if fecho[i][k] and fecho[k][j] and not(fecho[i][j]):
                        fecho[i][j] = True
                        novosPares = True
    return fecho


# 5 ------------------------

def arestasHasse(r):
    # resolver
    return
        
#6 --------------------

def classesEquivalencia(r):
    """ determina as classes de equivalencia de relação r
    que é de equivalência"""

    Visitado = [False for _ in range(len(r))]
    Classes = []
    for i in range(len(r)):
        if Visitado[i] == False:
            Visitado[i] = True
            aux = [i+1]
            for j in range(i+1,len(r)): 
                if r[i][j]:
                    Visitado[j] = True
                    aux.append(j+1)
#           Classes.append(copy.copy(aux))
            Classes.append(aux)
    return Classes
