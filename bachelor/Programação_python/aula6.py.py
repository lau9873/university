from typing import *


def capicua(x: List[int]) -> bool:
    "Verifica se x define uma capicua"
    n = len(x)
    for i in range(n//2):
        if x[i] != x[n-1-i]:
            return False
    return True


def inverter(x: List[int]):
    "Inverte a lista sem usar operação sobre fatias, i.e., x = x[::-1]"
    n = len(x)
    for i in range(n//2):
        # troca x[i] com x[n-1-i]
        aux = x[i]
        x[i] = x[n-1-i]
        x[n-1-i] = aux


def verifCrescente(x:List[int]) -> bool:
    "Verifica se x é crescente (não necessariamente estritamente crescente)"
    for k in range(1,len(x)):
        if x[k] < x[k-1]:
            return False
    return True


def maiorSeqCrescente(x: List[int]) -> List[int]:
    "Determina a posição da maior sequência crescente de valores contíguos e o seu número de elementos. \
Se houver várias, opta pela primeira."
    posMaior = -1
    comprMaior = 0
    inicio = 0
    while inicio < len(x):
        compr = 1
        seguinte = inicio+1
        while seguinte < len(x) and x[seguinte] >= x[seguinte-1]:
            seguinte = seguinte + 1
            compr = compr + 1
        if compr > comprMaior:
            comprMaior = compr   # comprimento da maior
            posMaior = inicio    # indice da posição inicial
        inicio = seguinte
    # no fim do ciclo retorna o resultado
    return [posMaior,comprMaior]
