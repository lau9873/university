# -*- coding: utf-8 -*-
"""
Created on Mon Feb 24 16:51:53 2020

@author: up201905492
"""

x,y,z=map(int,input("x,y,z?").split())
if x>0 and y>0 and z>0:
    if x<(y+z) and y<(x+z) and z<(y+x):
        print("("+str(x)+","+str(y)+","+str(z)+")"+"define um triangulo")
else:
     print("("+str(x)+","+str(y)+","+str(z)+")"+"nao define um triangulo")