# -*- coding: utf-8 -*-
"""
Created on Mon Feb 24 16:54:32 2020

@author: up201905492
"""

x,y,z=map(int,input().split())
if x>0 and y>0 and z>0:
    if x<(y+z) and y<(x+z) and z<(x+y):
         if x==y and y==z and x==z:
             print("("+str(x)+","+str(y)+","+str(z)+")"+"define um triangulo equilatero")
         if x==y or y==z or x==z:
             print("("+str(x)+","+str(y)+","+str(z)+")"+"define um triangulo isosceles")    
         if x!=y and y!=z and x!=z    :
             print("("+str(x)+","+str(y)+","+str(z)+")"+"define um triangulo escaleno") 
else:
    print("("+str(x)+","+str(y)+","+str(z)+")"+"nao define um triangulo")
