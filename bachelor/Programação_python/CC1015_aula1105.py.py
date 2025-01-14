"""
   Aula Prática 11/05
   Exercicios 6.8  e 6.7  de:
    https://www.dcc.fc.up.pt/~pbv/aulas/programacaoI/pratica-06.pdf
"""



#=====================================================================
#   Exercicio 6.8     linha n do Triangulo de Pascal com n >= 0
#=====================================================================

"""
Ideia:
    Começar com k = 0  e Linha = [1]

    Enquanto k < n
        acrescentar  1  no fim da lista  Linha
        Substituir os elementos de Linha
            somando a cada um o elemento anterior
            começamos pelo penultimo e vamos até ao elemento na posição 1

"""

def pascal(n):
    if type(n) != int or n < 0:
        raise ValueError("argumento não é inteiro não negativo")
    Linha = [1]
    for k in range(1,n+1):
#        print(Linha)
        Linha.append(1)
        for i in range(k-1,0,-1):
            Linha[i] = Linha[i] + Linha[i-1]
    return Linha

# versao recursiva
def recpascal(n):
    if type(n) != int or n < 0:
        raise ValueError

    if n == 0:
        return [1]

    Linha = recpascal(n-1)    # calcular a linha n-1
    Linha.append(1)           # modificar para obter a linha n
    for i in range(n-1,0,-1):
        Linha[i] = Linha[i] + Linha[i-1]
    return Linha




#=================================================================
#   Ex 6.7:  ler inteiro positivo < 1000000 em portugues
#==================================================================

centenas = ["", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos","seiscentos", "setecentos", "oitocentos", "novecentos"]

dezenas = ["","","vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"]

inferior20 = ["zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "catorze", "quinze", "dezasseis", "dezassete", "dezoito", "dezanove"]


def escr_inf100(n):
    if n >= 100 or n < 0:
        raise ValueError
    
    if n < 20:
        return inferior20[n]
    # obter o valor do algarismo das dezenas

    algdez = n // 10
    if  n % 10 == 0:
        return dezenas[algdez]
    return dezenas[algdez] + " e " + inferior20[n%10]


        
def escr_inf1000(n):
    if n >= 1000 or n < 0:
        raise ValueError

    if n < 100:
        return escr_inf100(n)
    
    # obter o valor do algarismo das centenas

    alg = n // 100
    
    if  n % 100 == 0:
        if alg == 1:
            return "cem"
        return centenas[alg]
    return centenas[alg] + " e " +  escr_inf100(n%100)


    
def escr_inf1milhao(n):
    if n >= 1000000 or n < 0:
        raise ValueError

    if n < 1000:
        return escr_inf1000(n)

    milhares = n // 1000

    if milhares > 1:
        res = escr_inf1000(milhares) + " mil"
    else:
        res = "mil"

    if n % 1000 != 0:
        res = res + " e " + escr_inf1000(n%1000)

    return res
    
    

    
