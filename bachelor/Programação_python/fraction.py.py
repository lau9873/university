class Fraction:
    def __init__(self, num, denom):
        if denom==0:
            raise ZeroDivisionError("denominador zero")
        if denom<0:
            denom = -denom
            num = -num
        d = mdc(absval(num),denom)
        self.num = num//d
        self.denom = denom//d

    def __str__(self):
        # fraccao irredutivel com denominador 1 se o valor for ineiro
        if self.denom == 1:
            return str(self.num)
        return '%d/%d' % (self.num, self.denom)
    
    def __add__(self,other):
        r = Fraction(self.num*other.denom + self.denom*other.num,
                 self.denom*other.denom)
        return r
    
    def __mul__(self, other):
        r = Fraction(self.num*other.num, self.denom*other.denom)
        return r

    def __sub__(self,other):
        sym_other = Fraction(-other.num,other.denom)
        return self + sym_other
    
    def __eq__(self,other):
        return self.num*other.denom == self.denom*other.num

    def __lt__(self,other):
        return self.num*other.denom < self.denom*other.num

    def __le__(self,other):
        return self.num*other.denom <= self.denom*other.num


def absval(x):
    if x < 0: 
        return -x
    return x

def mdc(a,b):
    if b == 0:
        if a == 0:
            raise ValueError("mdc(%d,%d) indefinido" % (a,b))
        return a
    return mdc(b, a%b)


# calculadora para somas algebricas de fraccoes
"""
Dada uma string  que representa a expressão a avaliar,
analisá-la e calcular o valor.

6/7+   5 / 8
-6/7 + 8/6 - 5/4 + 11/5
-6 + 5/6
-6 + 7 - 3/5 + 12/3 -7

Restringir o formato a ter uma lista com operadores '-' ou '+' e
cadeias de carateres que são da forma NUM  ou  NUM/NUM, como por exemplo:
L = ['-', '6', '+', '5/3', '-', '17/8', '+', '3/2']

"""


def convfraction(x):
    separar = x.split('/')
    if len(separar) == 1:
        return  Fraction(int(separar[0]), 1)
    return Fraction(int(separar[0]), int(separar[1]))


def soma_algebrica(L):
    res = Fraction(0,1)
    i = 0
    operador = '+'
    while i < len(L):
        if L[i] == '+' or L[i] == '-':
            operador = L[i]
            i = i + 1
        x = convfraction(L[i])
        if operador == '+':
            res = res + x
        else:
            res = res - x
        i = i +1
    return res

def consomeNumero(expr,i):
    ''' um inteiro ou uma fracção, se tiver uma / depois do inteiro '''
    
    #expr[i] tem um digito
    lnum = []
    while i < len(expr) and expr[i] >= '0' and expr[i] <= '9':
        lnum.append(expr[i])
        i = i+1
    if i < len(expr):
        while i < len(expr) and expr[i] == ' ':
            i = i+1
        if i < len(expr):
            if expr[i] == '/':
                lnum.append(expr[i])
                i = i + 1
                while expr[i] == ' ':
                    i = i+1
                while i < len(expr) and expr[i] >= '0' and expr[i] <= '9':
                    lnum.append(expr[i])
                    i = i+1
    return (i, "".join(lnum))    # i aponta a posicao onde ficou e retorna a string que consumiu


def normaliza_expr(expr):
    ''' normaliza uma string que pode ter espaços arbitarios, mas representa uma soma
    algébrica bem formada; a normalização retira espaços entre digitos e / e acrescenta um espaço de
    separação depois de cada operador

    >>>  normaliza_expr("9/5 -3/2+3/10 + 5 - 2       +7   -7")
    '9/5 - 3/2 + 3/10 + 5 - 2 + 7 - 7'

    '''
    
    resexpr = []
    i=0
    while (i < len(expr)):
        if expr[i] != ' ':
            if expr[i] == '+' or expr[i] == '-':
                resexpr.append(expr[i])
                i = i+1
            else:
                i,num = consomeNumero(expr,i)
                resexpr.append(num)
        else:
            i = i+1
    return " ".join(resexpr)


def calcular():
    ''' o utilizador indica uma soma algébrica de frações simples e o programa avalia '''
    x = input("Indique uma soma algebrica: ")
    xn = normaliza_expr(x)
    print(soma_algebrica(xn.split()))
    
        
    

