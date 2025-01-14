#========================================
#    Folha 4: exercicio 4
#========================================

def mmc_fac(fa,fb):
    na = len(fa)
    nb = len(fb)
    i = 0
    j = 0
    mmc = []
    while i < na and j < nb:
        xa = fa[i]
        xb = fb[j]
        if xa[0] == xb[0]: 
            mmc.append([xa[0],max(xa[1],xb[1])])
            i = i+1
            j = j+1
        elif xa[0] < xb[0]:
            mmc.append(xa)
            i = i+1
        else:
            mmc.append(xb)
            j = j+1
   
    if i < na:
        mmc = mmc + fa[i:]   # junta o resto da lista fa
    elif j < nb:
        mmc = mmc + fb[j:]  #junta o resto da lista fb
    return mmc

def mdc_fac(fa,fb):
    na = len(fa)
    nb = len(fb)
    i = 0
    j = 0
    mdc = []
    while i < na and j < nb:
        xa = fa[i]
        xb = fb[j]
        if xa[0] == xb[0]: 
            mdc.append([xa[0],min(xa[1],xb[1])])
            i = i+1
            j = j+1
        elif xa[0] < xb[0]:
            i = i+1
        else:
            j = j+1
    return mdc


#========================================
#    Folha 4: exercicio 7
#========================================

#=========
#   7a)
#==============

def divisivel_pot10(x:str,p:int) -> bool:
    # admitir que não começa por zero se não for 0
    if x == "0":
        return True

    n = len(x)
    if n <= p:    # um número divisivel por 10^p tem de ter pelo menos p+1 digitos
        return False

    for i in range(n-p,n):     #n-p, n-p+1, ..., n-1
        if x[i] != "0":
            return False
    
    return True

#=========
#   7b)
#==============

def par(x:str) -> bool:
    # admitir que não começa por zero se não for 0 e não é ""

    ultimo = x[len(x)-1]

    return (ultimo == "0" or ultimo == "2" or ultimo == "4" or ultimo == "6" or ultimo == "8")


#=========
#   7c)
#==============

def divisivel_9(x:str) -> bool:
    soma = 0
    for c in x:
        soma = soma + ord(c)-ord("0")     # ord(c)-ord("0")  é o valor do número
    
    if soma % 9 == 0:
        return True
    return False


"""
    Em vez de:

    if soma % 9 == 0:
        return True
    return False

    bastaria escrever

    return  soma % 9 == 0

"""
