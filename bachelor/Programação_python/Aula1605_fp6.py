"""
   Resolução de exercícios de revisão  (Folha 6)
   Aula extra - 16.05.2020
"""


import copy

# ex1
# carregar os dados sobre disciplinas e sobre alunos 
def ler_disciplinas():
    disciplinas = []
    ndisc = int(input())
    for _ in range(ndisc):
        nome = input()
        ano = int(input())
        disciplinas.append( (nome,ano) )
    return disciplinas

def ler_dados_alunos():
    alunos = {}
    nalunos = int(input())
    for _ in range(nalunos):
        nome = input()
        linha =  list(map(int,input().split()))
        #alunos[linha[0]]  =  (nome,linha[1], copy.copy(linha[2:]))
        alunos[linha[0]]  =  (nome,linha[1], linha[2:])
    return alunos

def ler_dados():
    disciplinas = ler_disciplinas()
    alunos = ler_dados_alunos()
    return (disciplinas,alunos)

#==========================================================================
# ex2
#  extrair o curso dado o código do aluno    
def cursoAluno(codigo):
    return (codigo  // 1000) % 1000

#  extrair o ano de entrada dado o código do aluno    
def anoAluno(codigo):
    return codigo // 1000000


#==========================================================================
# ex11
# imprimir uma tabela com o número de alunos inscritos a cada disciplina

def totais_por_disciplina(disciplinas,alunos):
    ndisc = len(disciplinas)
    contadores = ndisc*[0]
    for cod in alunos.keys():
        for disc in alunos[cod][2]:
            #incrementar o contador correspondente
            contadores[disc-1] += 1

    # escrever a tabela
    print("Numero de alunos inscritos\n")
    for i in range(len(disciplinas)):
        print(disciplinas[i][0]  + ": " + str(contadores[i]))


#==========================================================================

# ex12 -- tabelar as disciplinas com mais alunos do curso indicado
def disc_moda_curso(disciplinas,alunos,curso):
    # determinar quantos alunos do curso estao inscritos a cada disciplina
    ndisc = len(disciplinas)
    contadores = ndisc*[0]
    for cod in alunos.keys():
        if cursoAluno(cod)  == curso:
            for disc in alunos[cod][2]:
                contadores[disc-1] += 1

    # determinar os identificadores das disciplinas com mais alunos,
    # quantas são e qual é o maximo
    listMax,ndiscMax,maximo = listaMaiores(contadores,ndisc)

    # escrever o resultado
    print("Disciplinas com mais alunos do curso %d\n"  % curso)
    for i in listMax:
        print(disciplinas[i][0])
    print("\nTotal = %d Maximo = %d" %  (ndiscMax, maximo))

# auxiliar -- obter a lista das posicoes do maior elemento de uma lista com elementos >= 0
def listaMaiores(contadores,ndisc):
    maximo = -1     # inicializa o maximo 
    ndiscMax = 0    # nenhum elemento ainda 
    listMax = []    # nenhum elemento ainda 
    for i in range(ndisc):
        if contadores[i] > maximo: 
            maximo = contadores[i]
            listMax = [i]
            ndiscMax = 1
        elif contadores[i] == maximo:
            ndiscMax += 1
            listMax.append(i)
    return (listMax,ndiscMax,maximo)   # 3 dados para poder responder à questão ex12


#==========================================================================

# ex13 - tabelar, por ordem alfabética, os nomes dos alunos dum curso que entraram num dado ano.
def alunosCurso_Ano(curso,ano,alunos):
    resultado = []
    nalunos = 0
    for codigo in alunos.keys():
        if cursoAluno(codigo) == curso and anoAluno(codigo) == ano:
            resultado.append(codigo)   # coloca no fim mas vai ordenar 
            nalunos += 1
            i = nalunos-1     # começa pelo fim a tentar colocar corretamente o codigo
            while i > 0 and alunos[resultado[i-1]][0]> alunos[resultado[i]][0]:
                # se o nome do aluno cujo codigo está na posição i-1 é maior que o da posição i
                # troca as posições resultado[i] com resultado[i-1]
                aux = resultado[i]
                resultado[i]  = resultado[i-1]
                resultado[i-1] = aux
                i = i-1

    # escreve a tabela dos nomes dos alunos cujos códigos estão na lista resultado        
    print("Alunos do curso %d que entraram em %d\n" % (curso,ano))

    for codigo in resultado:
        print(str(codigo)+" "+alunos[codigo][0])

    print("Total %d"  % nalunos)
