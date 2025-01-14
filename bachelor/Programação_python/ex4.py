# -*- coding: utf-8 -*-
"""
Created on Mon Feb 24 17:04:46 2020

@author: up201905492
"""
conta=0
n=int(input("Quantos numeros?"))
for i in range(n):
    x=int(input("valor?"))
    if x%2==0:
        if x%3!=0:
            conta=conta+1     
    if x%3==0:
        if x%2!=0:
            conta=conta+1        
print("Numero de multiplos ou de 2 ou de 3 = "+str(conta))           