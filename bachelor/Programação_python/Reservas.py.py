"""
Resolução do problema -- Reservas
"""

def ler_grafo(nverts,nramos):
    grafo = {}
    for _ in range(nramos):
        x,y,nlug,custo = map(int,input().split())
        grafo[(x,y)] = [nlug,custo]
    return grafo

def processa_reserva(grafo):
    dados = list(map(int,input().split()))
    nlugares = dados[0]
    nnos = dados[1]
    # percurso começa em dados[2] e tem nnos
    bilhete = 0   # custo total por pessoa
    x = dados[2]
    i = 3
    while i < 2 + nnos:
        y = dados[i]
        if (x,y) in grafo.keys():
            if grafo[(x,y)][0] >= nlugares:
                bilhete = bilhete + grafo[(x,y)][1] 
                grafo[(x,y)][0] -= nlugares
            else:
                print("Sem lugares suficientes em (%d,%d)"  % (x,y))
                break;
        else:
            print("(%d,%d) inexistente" % (x,y))
            break;
        x = y
        i = i+1
    # no fim do ciclo
    if i == 2 + nnos:
        print("Total a pagar: %d"  %  (bilhete*nlugares))
    else:   # repor as reservas como estavam antes ....
        x = dados[2]
        for j in range(3,i):     # ultimo y válido dados[i-1] 
            y = dados[j]
            grafo[(x,y)][0]  += nlugares   
            x = y


def reservas():
    nverts, nramos = map(int, input().split())
    grafo = ler_grafo(nverts,nramos)
    t = int(input())
    while t > 0:
        processa_reserva(grafo)
        t -= 1




"""
Exemplos que estão no enunciado

Exemplo 1

Input

6 7
4 3 9 10
3 5 6 7
5 2 6 2
2 4 3 5
1 2 8 4
5 6 7 4
6 5 2 10
5
2 3 5 2 4
3 4 1 2 4 3
1 4 1 2 4 3
1 3 1 2 4
1 3 1 2 5

Output

Total a pagar: 14
Sem lugares suficientes em (2,4)
Total a pagar: 19
Sem lugares suficientes em (2,4)
(2,5) inexistente


Exemplo 2

Input

5 11
4 3 9 10
3 5 6 7
5 2 6 2
1 4 10 7
2 4 3 5
1 2 8 4
4 1 0 20
3 4 15 8
3 1 23 20
2 1 17 10
5 4 20 10
6
8 3 1 4 3
2 3 1 4 3
2 5 1 2 5 4 3
1 2 5 4
2 3 3 1 2
1 2 1 3


Output

Total a pagar: 136
Sem lugares suficientes em (4,3)
(2,5) inexistente
Total a pagar: 10
Total a pagar: 48
(1,3) inexistente



Exemplo 3

Input

5 11
4 3 9 10
3 5 6 7
5 2 6 2
1 4 10 7
2 4 3 5
1 2 8 4
4 1 0 20
3 4 15 8
3 1 23 20
2 1 17 10
5 4 20 10
4
5 3 1 4 3
2 3 1 4 3
1 2 5 4
1 2 4 1
Output

Total a pagar: 85
Total a pagar: 34
Total a pagar: 10
Sem lugares suficientes em (4,1)
"""
