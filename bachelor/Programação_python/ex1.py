x,y,z=map(int,input().split())
if x>0 and y>0 and z>0:
    if x<(y+z) and y<(x+z) and z<(x+y):
        print("("+str(x)+","+str(y)+","+str(z)+")"+"define um triangulo")
else:
    print("("+str(x)+","+str(y)+","+str(z)+")"+"nao define um triangulo")
