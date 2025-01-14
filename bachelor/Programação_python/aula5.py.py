from typing import *


def f1(x: float) -> float:
    if x > 20:
        return 3*x+10
    return 2*x*x-7


def f2(x: int) -> int:
    if x > 20:
        return 3*x+10
    return 2*x*x-7


def lerlista(n: int) -> List[int]:
    "retorna lista de inteiros lidos do stdin"
    lista = []
    for i in range(n):
        lista.append( int(input()) )
    return lista

def soma1(lista: List[float]) -> float:
    "retorna a soma dos elementos de uma lista"
    total = 0.0
    for i in range(len(lista)):
        total = total + lista[i]
    return total

def soma2(lista: List[float]) -> float:
    "retorna a soma dos elementos de uma lista"
    total = 0.0
    for x in lista:
        total = total + x
    return total

def maximo(x: List[int]) -> int:
    "retorna o maximo de uma lista de inteiros não vazia"
    maximo = x[0]
    for k in range(1,len(x)):
        if x[k] > maximo:
            maximo = x[k]
    return maximo

def divisores(n: int) -> List[int]:
    "lista de divisores de inteiro positivo"
    if n < 1: 
        return []    # convenção nossa
    if n == 1:
        return [1]

    res = [1,n]
    if n % 2 == 0:
        d = 2
        incr = 1
    else:
        d = 3
        incr = 2  
  
    while d*d < n:
        if n%d == 0:
            res = res + [d,n//d]
        d = d+incr

    if d*d == n:
        res = res + [d]

    res.sort()    # ordenar a lista
    return res

def ocorrencias():
   "Tabelar ocorrencias de cada valor numa sequencia de inteiros de 0 a 9"
   
   contador = [0,0,0,0,0,0,0,0,0,0]
   # contador = 10*[0]    # em alternativa para criar lista com 10 zeros
   
   n = int(input())
   for i in range(n):
       x = int(input())
       contador[x] = contador[x]+1
   
   # escreve resultado
   for i in range(10):
       print(i,":",contador[i])


    

