# Week 7 - 25/11/2022

## Exercício 1

```
-----BEGIN DH PARAMETERS-----
MIICCAKCAgEAux0Gojz+Dg6hCLPKAsphVM5GzoBBSdFaqBHPePiiEWJGPUrMY/0G
poNJyk1ltbA+BMDE7IjHV68ZDfm179UE2TXOqrfeMpNEhfKFIdO4CfiCM+AG9/i5
Q/MA1lujWtJdsP+qEYzaQ0HIeyaMW7GUudwYhJs+9VFWhLtnvKn/Sav6RYs914s6
vI+3kNHOZp+kHT8DKyLvhC915O9CWonl37azGdedMQKlsC/s52JU2G5cJ6BMqnH9
vbxZnbyGWkTX9gUx1jBFHwodjyAOOToYHwUlyuh3OYqasV1HnAWhw/hjSZMwveuI
D1w+fqo5PH3pciO5y+soEKj55RJrKxwXvXnH+tELHEsD4NnFUuJIyLPukTrcKU9Z
FenXW6UoO69k7aIybx6D7Qtuc+i5UJfLjDJI06j9Du8AZpFGLHctB/vsDmZyq21Q
QynaDPXVAQC7Bbs2M4Z8S28xbX21cz19vSz5uJiWW1erN4tpMB9Ac4DKAknefam4
oHtf0UM91yAQoeKhLhqm5qopgSJ/9MiVhEmzPQh3SCmMo9vfnIegBzj2IOF+/UNC
5H3zLA/jemk6WpnzjyuZNr+rQcGLukSCeLA0UBYsBakez+0UnOgzua/zIF/Smc0F
k3pOlB86P4OhC7CO+cIFxIMQ7aFyQsqLkrEJ4AxWZOwY9rqV8iSnozMCAQI=
-----END DH PARAMETERS-----

```

## Exercício 2

```
-----BEGIN X9.42 DH PARAMETERS-----
MIIELAKCAgEAh/pVNCPkeQvetk5HygBmQ6dnKdEbkS3567AAxr36HeyeNIADwlqM
+ZKNnxYlGcWgOkzKL8xXHYjV0Ys7nBsgTNPB5UjXG5iAwvbsge7k9COGmbPHZF+r
MtmEjot6ueqD0ksa2ny16VaAYjXmgl7lz5Gqh/7tlVx2YtsxPJ5UEKSE/YO1wWLs
Y3n0WmJAKImCnVjtveCbanViU8A0fj8aOhdQHSGXbEtwjDJRfWSUhTqQtXBLuzmM
8qlYTMyv9yaV0+od+KPpJFy0omHnftmVWS8RmzTM2vj2RsM/w1HCzD6e/Kg326VT
sk66a7MY8GlyJ1JuyliPQ6G8x/4LhKwuCQ3OjpzpRIKA0hINllF45BISqi8IW/UR
6jA3jJJWytPtlj8zsNw9HwJhvusY9YYJUTugTh3Tk5Sf/Sdn68xIF+D0v4aOkwai
0J6qRzC7nEdnJn/020EZrZpvm+WZpZHN23v/a77XWUwUZQUUFoPI3E+cJ30UtXYP
UVCkKFU1F0ys6quzFb+XY6Ao4kWUNtBCW0P1VzaGxg+Jgp5jmeu/qgsOrgxFCAj1
FsLSJmUqRLSEsglIgwmsYNZ4ICSKr2EwDICD796sxTXgSswrv2RwWAcspiDPIqbP
X/Mdv7z6F/3wuXE9/nI0BkEuGiDPFxzvcv1US/sogLWUtnp3oSiXK30CggIAft+y
A8xtPKBxxFdvpwKaPws/6IIsKQFB/ci44xSM/dShK2EyeyFSmpzi7t1at0MI3jiI
l1LRhrwCm6WwMS+b3fBoT16t7FL51uYkI9S2PKY/oNzYjPFwgBjBh83i59bbFq96
oIYdhFEitYkfg//zHkoZFtcy2dOyr4ydqfqweMtuKZ4Uje9pfUYc/e2Iu9gHseLV
bgAunrj09v/9ekHW382/5c3IzuHIrDI2b/BQ36RmvDyF1PyzeXFwBXkRRzhX2mob
9nE1HRmjZuEjBMcCwpX9U1+hSvuvFZMynK70ZG92zmsjSqa+2FFBtmeSe+WPVdLk
+ZcOLfkqj7PiMjY5gDGD9PoVwldBTiSYyaN9XZ6BE4tpWJyr8XSETszbFRG+qhjD
1TZDdl3Yixdj33u/0/NGpsgquBa/4ce4N/2gaS/6OUOX5C2xclOTMWE/9FPP1urD
jk3B1LYkEsZStrWVkpK41rGOJIEtYlTUEv3Urfd+yfFW93DEy8Iwd6JrZaYHOdtT
kaISgyAXzAerfCCPpjj9C66nl6duijI58x94vBdstW47EBfSK58H6X7zge8koo1I
U0klT6wLMGY5djgETzuoP/RsBfeAOhQhM1Bj0xxDTUm9yxspjzYiPQpS+SFpqwqy
wrpgftlatQBGj7uTgZesYZk9jtZEydForsTbxFUCIQDI7RUYzMSAaEr738cxhStD
6hFl8aT/HXwOaxF8IxSAwQ==
-----END X9.42 DH PARAMETERS-----
```

## Exercício 3

A primeira abordagem demora bastante mais tempo pois tem que obedecer às regras tradicionais de primos Diffie Hellman, isto é, seja o primo gerado *p*, para *p* ser admissível, *(p-1)/2* terá também que ser primo. Esta regra (não aplicada na geração do segundo parâmetro DH), leva a que o conjunto de números primos que são elegíveis seja bastante mais reduzido, tornando assim mais exigente a computação destes mesmos primos (o que explica a diferença considerável no tempo de cálculo do exercício 1 para o exercício 2).

### Código para verificar a estrutura:

```
#!/usr/bin/env sage -python
import sys
import numpy as np
import sage as sg
from sage.all import *

payload = 0xBB1D06A23CFE0E0EA108B3CA02CA6154CE46CE804149D15AA811CF78F8A21162463D4ACC63FD06A68349CA4D65B5B03E04C0C4EC88C757AF190DF9B5EFD504D935CEAAB7DE32934485F28521D3B809F88233E006F7F8B943F300D65BA35AD25DB0FFAA118CDA4341C87B268C5BB194B9DC18849B3EF5515684BB67BCA9FF49ABFA458B3DD78B3ABC8FB790D1CE669FA41D3F032B22EF842F75E4EF425A89E5DFB6B319D79D3102A5B02FECE76254D86E5C27A04CAA71FDBDBC599DBC865A44D7F60531D630451F0A1D8F200E393A181F0525CAE877398A9AB15D479C05A1C3F863499330BDEB880F5C3E7EAA393C7DE97223B9CBEB2810A8F9E5126B2B1C17BD79C7FAD10B1C4B03E0D9C552E248C8B3EE913ADC294F5915E9D75BA5283BAF64EDA2326F1E83ED0B6E73E8B95097CB8C3248D3A8FD0EEF006691462C772D07FBEC0E6672AB6D504329DA0CF5D50100BB05BB3633867C4B6F316D7DB5733D7DBD2CF9B898965B57AB378B69301F407380CA0249DE7DA9B8A07B5FD1433DD72010A1E2A12E1AA6E6AA2981227FF4C8958449B33D087748298CA3DBDF9C87A00738F620E17EFD4342E47DF32C0FE37A693A5A99F38F2B9936BFAB41C18BBA448278B03450162C05A91ECFED149CE833B9AFF3205FD299CD05937A4E941F3A3F83A10BB08EF9C205C48310EDA17242CA8B92B109E00C5664EC18F6BA95F224A7A333

toCheck = (payload - 0x1)//2

print(is_pseudoprime(toCheck)) #True

``` 


## Exercício 5
Código de resolução:

```
#!/usr/bin/env sage -python
import sys
import numpy as np
from sage.all import *

#Calcular Y

p = 1373
g = 2
y = 871

Y = (g^y)%p

print('Y enviado pelo Bob: ' + str(Y))

# Descobrir o Expoente secreto da Alice

X = 974

_,gA,_ = xgcd(X,p) #g^a vai ser o inverso multiplicativo do valor enviado pela Alice e do primo escolhido

if(gA < 0): #Condição necessária pois não existem logaritmos de números negativos
    gA = gA + p

secExp = log(gA,g).n() #Expoente Secreto 

print('Expoente secreto da Alice: ' + str(secExp))
```

## Exercício 6

### Problema CDH:
O problema CDH consiste na capacidade de, dado *g^a* e *g^b*, se conseguir computar *g^ab*, tornando possível computar o segredo partilhado com apenas informação disponível no canal.

### Problema DDH:
O problema DDH, consiste num problema de indistinguibilidade, ou seja, conhecendo *g^a* e *g^b*, ser capaz de distinguir, com uma probabilidade superior a 1/2, *g^ab* de um *g^c* em que *c* é um expoente aleatório. Ou seja, ser capaz de distinguir o segredo partilhado de um elemento aleatório.

### Resposta:
Dadas as definições acima descritas, assumindo a existência de um algoritmo que resolva CDH, esse mesmo algoritmo, dadas as informações disponíveis no problema DDH, é capaz de, dado um *g^a* e um *g^b*, calcular *g^ab* e por fim comparar com o valor facultado, avaliando se é de facto o segredo ou um elemento aleatório e resolvendo assim também DDH.