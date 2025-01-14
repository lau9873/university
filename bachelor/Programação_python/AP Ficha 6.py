# =============================================================================
# EX1
# =============================================================================
import copy
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

# =============================================================================
# EX2
# =============================================================================
import copy
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

# =============================================================================
# EX3
# =============================================================================
def anoAluno(codigo):
    return codigo // 1000000

def cursoAluno(codigo):
    return (codigo  // 1000) % 1000

# =============================================================================
# EX4
# =============================================================================
def discAluno(codigo,alunos,disciplinas):
    listadisc = alunos[codigo][2]
    print("Disciplinas de %d (%s)\n" % (codigo,alunos[codigo][0]))
    for d in listadisc:
        print(disciplinas[d-1][0])    # escrever o nome da disciplina d

# =============================================================================
# EX5
# =============================================================================
def discAlunomod(codigo,alunos,disciplinas,nomefich):
    f = open(nomefich,"w")
    listadisc = alunos[codigo][2]
    f.write("Disciplinas de %d (%s)\n\n" % (codigo,alunos[codigo][0]))

    for d in listadisc:
        f.write(disciplinas[d-1][0]+'\n')    # escrever o nome da disciplina d

    f.close()

# =============================================================================
# EX6
# =============================================================================
def discAno(ano,disciplinas):
    res = []
    for i in range(len(disciplinas)):
        anodisc = disciplinas[i][1] 
        if anodisc == ano:
            res.append(i+1)
    return res

# =============================================================================
# EX7
# =============================================================================
def alunos_em_disc(disc,alunos):
    res = []
    for codigo in alunos:    # alunos.keys()
        if disc in alunos[codigo][2]:   # se disc pertence à lista de disciplinas do aluno
            res.append(codigo)
    return res
# =============================================================================
# EX8
# =============================================================================
def codigoAluno(nome,alunos):
    res = []
    for codigo in alunos:
        if alunos[codigo][0] == nome:
            res.append(codigo)
    return res

# =============================================================================
# EX9
# =============================================================================
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

# =============================================================================
# EX10
# =============================================================================
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

# =============================================================================
# EX11
# =============================================================================
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

# =============================================================================
# EX12
# =============================================================================
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

# =============================================================================
# EX13
# =============================================================================
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

# =============================================================================
# EX14
# =============================================================================
import copy

class Aluno:
    def __init__(self,nomealuno,nucs,ucs):
        self.nome = copy.copy(nomealuno)
        self.ndisc = nucs
        self.disc = copy.copy(ucs)

    def  __str__(self):
        s =  "Aluno %s inscrito a %d ucs: " % (self.nome,self.ndisc)
        return s + str(self.disc)

    def getname(self):
        return self.nome

    def ldiscs(self):
        return self.disc

    def getndisc(self):
        return self.ndisc


class Disciplina:
    def __init__(self,nomedisc,anodisc):
        self.nome = copy.copy(nomedisc)
        self.ano = anodisc
        
    def  __str__(self):
        return  "Disciplina:  %s  ano %d " % (self.nome,self.ano)

    def getyear(self):
        return self.ano

    def getname(self):
        return self.nome

    def newName(self,nome):
        self.nome = copy.copy(nome)



def fler_disciplinas2(fich):
    disciplinas = []
    ndisc = int(fich.readline())
    for _ in range(ndisc):
        nome = fich.readline()
        lnome = nome.split('\n')
        ano = int(fich.readline())
        disciplinas.append(Disciplina(lnome[0],ano))   #disciplinas liste de objetos 
    return disciplinas

def fler_dados_alunos2(fich):
    alunos = {}
    nalunos = int(fich.readline())
    for _ in range(nalunos):
        nome = fich.readline()
        lnome = nome.split('\n')
        linha =  list(map(int,fich.readline().split()))
        #alunos[linha[0]]  =  (nome,linha[1], copy.copy(linha[2:]))
        alunos[linha[0]]  =  Aluno(lnome[0],linha[1], linha[2:])
    return alunos

def fler_dados2(fichnome):
    fich = open(fichnome,"r")
    disciplinas = fler_disciplinas(fich)
    alunos = fler_dados_alunos(fich)
    fich.close()
    return (disciplinas,alunos)

# ex4 ------------
def discAluno2(codigo,alunos,disciplinas):
    listadisc = alunos[codigo].ldiscs()
    print("Disciplinas de %d (%s)\n" % (codigo,alunos[codigo].getname()))
    for d in listadisc:
        print(disciplinas[d-1].getname())    # escrever o nome da disciplina d
    

#ex5 -----------
def discAlunomod2(codigo,alunos,disciplinas,nomefich):
    f = open(nomefich,"w")
    listadisc = alunos[codigo].ldiscs()
    f.write("Disciplinas de %d (%s)\n\n" % (codigo,alunos[codigo].getname()))

    for d in listadisc:
        f.write(disciplinas[d-1].getname()+'\n')    # escrever o nome da disciplina d

    f.close()

