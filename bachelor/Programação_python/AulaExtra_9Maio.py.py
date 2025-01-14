"""
   Aula Extra (Revisões)  9 Maio 2020

   Problemas: Cigarras Tontas.py
   (e revisão de "Não lhes dês Troco")
"""



"""
Exemplo de input

1513
3171
178
1316
1600
1513
1774
178
3171
672
1315
0

Exemplo de output
1513
1774
178
3171
672
1315
"""

def cigarras():
    local = int(input())
    percurso = 30*[0]
    percurso[0] = local  # origem
    n = 1   # parte relevante é percurso[0], percurso[1], ... percurso[n-1]
    local = int(input())
    while local != 0:   # percurso não terminou
        # ver se o local está no percurso
        i = 0
        while i < n and percurso[i] != local:
            i = i + 1
        # o que aconteceu para o ciclo terminar?
        if i == n:      # não está no percurso
            percurso[n] = local
            n = n+1
        else:      # percurso[i] == local 
            n = i+1
        local = int(input())

    for i in range(n):    0, 1, 2, ..., n-1
        print(percurso[i])



"""
def cigarras():
    local = int(input())
    percurso = [local]  # origem
    local = int(input())
    while local != 0:   # percurso não terminou
        i = 0
        while i < len(percurso) and percurso[i] != local:
            i = i + 1
        # o que aconteceu para o ciclo terminar?
        if i == len(percurso):    
            percurso.append(local)
        else: 
            del percurso[i+1:]
        local = int(input())

    for x in percurso:
        print(x)
"""
        
                 
