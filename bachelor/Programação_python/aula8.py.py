#==========================================================================
#   A.P.Tomas (Aula CC1015-S2)     16.03.2020
#        Exemplos de utilizacao de sequencias de carateres
#==========================================================================


from typing import *

#==============================================================
#  formar string que resulta de repetir a string c n vezes
#  e imprimi-la
#=================================================================

def impr_nvezes_v0(c:str,n:int):
    s = ""
    for i in range(n):
        s = s + c        # substitui por s concatenado com c
    print(s)

# alternativa usando operacao especifica do Python para efetuar a repeticao
def impr_nvezes(c:str,n:int):
    s = n*c        # formar uma string repetindo n vezes a string c
    print(s)


#==================================================================
#     exemplos de codigos de carateres
#===================================================================    

def codigosLetras():
    "Escreve os codigos das letras"
  
    abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    
    for i in range(2):  
        for c in abc:
            print(c+": ", ord(c)) 
        if i==0: 
            print("\n")     # linha em branco
            abc = abc.lower()  # converte para minusculas
                                     
def exemplos_codigos():
    "Escreve codigos dos digitos e de alguns sinais"
  
    print("\n",ord('\n'))     # mudar de linha
    print("Mudou de linha e escreveu 10 (o codigo do carater correspondente)")
    
    print(" ",ord(' '), " para o espaco")      # espaco
    print("\t", ord('\t'), " para tabelar")     # tabelar
    print(".", ord('.'), " para o ponto")       # ponto final
    
    print("\n\nDigitos\n")
    seq = "0123456789"
    for c in seq:
        print(c+": ", ord(c))
    
    print("\n As maiusculas, minusculas e os digitos com codigos consecutivos")

    
    print('\n')
    
    print(ord('ç'), ":", 'ç')
    print(ord('ã'),":",'ã')

#==================================================================
#    impressão de carateres usando os codigos
#===================================================================    

def codigos2carateres():
    "Escrever os carateres com codigos em [33,127]"

    for i in range(33,127):
        print (i, ":", chr(i))

# Cautela:  alguns carateres sao de controlo... nao devem ser escritos
        
#===========================================================================
# Verificar se uma string tem comprimento 1 e corresponde a minuscula 
#===========================================================================

def minuscula(c:str) -> bool:
    "Testa se c se reduz a uma letra minuscula"
    if len(c) != 1:
        return False
    return c >= 'a' and c <= 'z'

# Para experimentar, escrever na shell
#    minuscula('r')
#    minuscula('R')
#    minuscula('abcd')
# e comparar com   'r'.islower()      'R'.islower()    'abcd'.islower()
# 
#   islower()     isupper()    aplicam-se a strings  no Python

#==============================================================
# Verificar se uma string tem apenas minusculas
#=============================================================
    
def apenasMinusculas(x:str) -> bool:
    "Verifica se a string x tem apenas minusculas"
    for c in x:
        if (not(minuscula(c))) :
            return False
    return True


def exemplo_de_uso():
    x = "ananahshsjhkiuiud5s67677vvgsyqg$.+<<<===y"
    print("x = ", x)
    y = "ananahshsjhkiuiud"
    print("y = ", y)

    if apenasMinusculas(y):
        print("A testar apenasMinusculas.... Para y: tem apenas minusculas")
    if not(apenasMinusculas(x)):
        print("A testar apenasMinusculas.... Para x: nao tem apenas minusculas")

    teste = input("Introduza uma sequencia de carateres para testar:   ")

    if apenasMinusculas(teste):
        print("Escreveu\n\t"+teste+"\n....TINHA APENAS MINUSCULAS!")
    else:
        print("o que escreveu nao tinha apenas minusculas!  :-) ")

#===================================================================
#  converter minusculas para maiusculas sem usar  a funcao upper()
#  Se usar  upper  bastaria    x = x.upper()
#  em vez de   x = minusculas2maisculas(x)
#====================================================================

def minusculas2maiusculas(x:str) -> str:
    "Converte todas as minusculas para maiusculas em x"

    resp =""      #  para construir a resposta a partir da string vazia

    for c in x:
        if minuscula(c):
            novoc = chr(ord(c) + ord('A')-ord('a'))
        else:
            novoc = c
        resp = resp + novoc

    return resp


#  exemplo de uso
#  escrever na shell a sequencia de instrucoes seguinte sem os comentarios
#     x = 'gsgk81771HD%!!!!hassR'
#     minusculas2maiusculas(x)
#     print(x)
#     x = minusculas2maiusculas(x)
#     print(x)
#
#     x.lower()
#     print(x)
#     x = x.lower()
#     print(x)

