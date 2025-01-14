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



def fler_disciplinas(fich):
    disciplinas = []
    ndisc = int(fich.readline())
    for _ in range(ndisc):
        nome = fich.readline()
        lnome = nome.split('\n')
        ano = int(fich.readline())
        disciplinas.append(Disciplina(lnome[0],ano))   #disciplinas liste de objetos 
    return disciplinas

def fler_dados_alunos(fich):
    alunos = {}
    nalunos = int(fich.readline())
    for _ in range(nalunos):
        nome = fich.readline()
        lnome = nome.split('\n')
        linha =  list(map(int,fich.readline().split()))
        #alunos[linha[0]]  =  (nome,linha[1], copy.copy(linha[2:]))
        alunos[linha[0]]  =  Aluno(lnome[0],linha[1], linha[2:])
    return alunos

def fler_dados(fichnome):
    fich = open(fichnome,"r")
    disciplinas = fler_disciplinas(fich)
    alunos = fler_dados_alunos(fich)
    fich.close()
    return (disciplinas,alunos)

# ex4 ------------
def discAluno(codigo,alunos,disciplinas):
    listadisc = alunos[codigo].ldiscs()
    print("Disciplinas de %d (%s)\n" % (codigo,alunos[codigo].getname()))
    for d in listadisc:
        print(disciplinas[d-1].getname())    # escrever o nome da disciplina d
    

#ex5 -----------
def discAluno_fich(codigo,alunos,disciplinas,nomefich):
    f = open(nomefich,"w")
    listadisc = alunos[codigo].ldiscs()
    f.write("Disciplinas de %d (%s)\n\n" % (codigo,alunos[codigo].getname()))

    for d in listadisc:
        f.write(disciplinas[d-1].getname()+'\n')    # escrever o nome da disciplina d

    f.close()

