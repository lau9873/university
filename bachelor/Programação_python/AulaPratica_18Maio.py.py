"""
   Resolução de exercícios de revisão  (Folha 6)
   Aula pratica - 18.05.2020
"""


import copy

# ex2
# adaptar resolucao de ex1 para carregar os dados a partir de um ficheiro
def fler_disciplinas(fich):
    disciplinas = []
    ndisc = int(fich.readline())
    for _ in range(ndisc):
        nome = fich.readline()
        lnome = nome.split('\n')
        ano = int(fich.readline())
        disciplinas.append( (lnome[0],ano) )
    return disciplinas

def fler_dados_alunos(fich):
    alunos = {}
    nalunos = int(fich.readline())
    for _ in range(nalunos):
        nome = fich.readline()
        lnome = nome.split('\n')
        linha =  list(map(int,fich.readline().split()))
        #alunos[linha[0]]  =  (nome,linha[1], copy.copy(linha[2:]))
        alunos[linha[0]]  =  (lnome[0],linha[1], linha[2:])
    return alunos

def fler_dados(fichnome):
    fich = open(fichnome,"r")
    disciplinas = fler_disciplinas(fich)
    alunos = fler_dados_alunos(fich)
    fich.close()
    return (disciplinas,alunos)


#==========================================================================
# ex4

def discAluno(codigo,alunos,disciplinas):
    listadisc = alunos[codigo][2]
    print("Disciplinas de %d (%s)\n" % (codigo,alunos[codigo][0]))

    for d in listadisc:
        print(disciplinas[d-1][0])    # escrever o nome da disciplina d


        
#==========================================================================
# ex5
def discAluno(codigo,alunos,disciplinas,nomefich):
    f = open(nomefich,"w")
    listadisc = alunos[codigo][2]
    f.write("Disciplinas de %d (%s)\n\n" % (codigo,alunos[codigo][0]))

    for d in listadisc:
        f.write(disciplinas[d-1][0]+'\n')    # escrever o nome da disciplina d

    f.close()
    

#==========================================================================
#ex6

def discAno(ano,disciplinas):
    res = []
    for i in range(len(disciplinas)):
        anodisc = disciplinas[i][1] 
        if anodisc == ano:
            res.append(i+1)
    return res

"""
def discAno(ano,disciplinas):
    return [ i+1 for i in range(len(disciplinas)) if disciplinas[i][1] == ano]
"""


#==========================================================================
#ex7
def alunos_em_disc(disc,alunos):
    res = []
    for codigo in alunos:    # alunos.keys()
        if disc in alunos[codigo][2]:   # se disc pertence à lista de disciplinas do aluno
            res.append(codigo)
    return res
                

#==========================================================================
#ex8
def codigoAluno(nome,alunos):
    res = []
    for codigo in alunos:
        if alunos[codigo][0] == nome:
            res.append(codigo)
    return res

# [codigo for codigo in alunos if alunos[codigo][0] == nome]

#==========================================================================
#ex9

def codigo_disc(nome,disciplinas):
    for i in range(len(disciplinas)):
        if disciplinas[i][0] == nome:
            return i+1
    return -1

def inscritos_disc(nome,disciplinas,alunos):
    coddisc = codigo_disc(nome,disciplinas)
    if coddisc != -1:   # disciplina existe
        return alunos_em_disc(coddisc,alunos)
    return []

#ex10
def media_ndisc(curso,alunos):
    nalunos = 0
    ntotaldisc = 0
    for codigo in alunos:
        if cursoAluno(codigo) == curso:
            nalunos = nalunos + 1
            ntotaldisc  = ntotaldisc + alunos[codigo][1]

    if nalunos == 0:
        return 0
    return  ntotaldisc / nalunos
    

    







#==========================================================================
# ex
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
