# =============================================================================
# EX1
# =============================================================================
#a)
def reflexiva(M):
    for i in range (len(M)):
        if M[i][i]==False:
            return False
    return True
#b) 
def simetrica(M):
    for i in range(1,len(M)):
        for j in range(i):
            if M[i][j]!=M[j][i]:
                return False
        return True
#c)
def antissimetrica(M):
    for i in range(1,len(M)):  
        for j in range(i): 
            if M[i][j] and M[j][i]:
                return False
    return True
#d)
def transitiva(M):
    for i in range(len(M)):
        for j in range(len(M)):
            for k in range(len(M)):
                if M[i][k] and M[k][j] and not(M[i][j]):
                   return False
    return True
#e)
def equivalencia(M):
    if reflexiva(M) and simetrica(M) and transitiva(M):
        return True
    return False
#f)
def ordemParcial(M):
    return reflexiva(M) and antissimetrica(M) and transitiva(M)
# =============================================================================
# EX2
# =============================================================================
def composta(r,s):
    t=[[False for j in range(len(s[0]))]for i in range(len(r))]
    if len(r[0])!=len(s):
        return[]
    for i in range(len(r)):
        for j in range(len(s[0])):
            for k in range(len(r)):
                t[i][j]=t[i][j] or (r[i][k] and s[k][j])
    return t        
# =============================================================================
# EX3    
# =============================================================================
def transposta(r):
    return [[r[i][j] for i in range(len(r))]for j in range(len(r[0]))]
# =============================================================================
# EX4
# =============================================================================
#a)
import copy
def fechoSimetrico(r):
    fecho=copy.deepcopy(r)
    for i in range(1,len(fecho)):
        for j in range (i):
            aux=fecho[i][j] or fecho[j][i]
            fecho[i][j]=aux
            fecho[j][i]=aux
    return fecho
#b)
def fechoReflexivo(r):
    fecho=copy.deepcopy(r)
    for i in range(len(r)):
        fecho[i][i] = True
    return fecho
#c)
def fechoTransitivo(r):
    fecho=copy.deepcopy(r)
    novosPares = True
    while novosPares:
        novosPares = False
        for i in range(len(r)):
            for j in range(len(r)):
                for k in range(len(r)):
                    if fecho[i][k] and fecho[k][j] and not(fecho[i][j]):
                        fecho[i][j]=True
                        novosPares=True
    return fecho
# =============================================================================
# EX5
# =============================================================================
def arestasHasse(r):
    fecho=copy.deepcopy(r)
    novosPares = True
    while novosPares:
        novosPares = False
        for i in range(len(r)):
            fecho[i][i]=False
            for j in range(len(r)):
                for k in range(len(r)):
                    if fecho[i][k] and fecho[k][j]:
                        fecho[i][j]=False
                        novosPares=True
    return fecho
# =============================================================================
# EX6
# =============================================================================
def classesEquivalencia(r):
    Visitado = [False for i in range(len(r))]
    Classes = []
    for i in range(len(r)):
        if Visitado[i] == False:
            Visitado[i] = True
            aux = [i+1]
            for j in range(i+1,len(r)): 
                if r[i][j]:
                    Visitado[j] = True
                    aux.append(j+1)
            Classes.append(aux)
    return Classes









    
    
    
    
    
    
    
    
    
    
    
    
    