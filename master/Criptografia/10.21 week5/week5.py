from data import packets
from bitstring import BitArray

flag=1
print('g')
for i in range (1000):
    for j in range (i+1,1000):
        xor=bytes(a^b for a,b in zip(packets[i],packets[j]))  
        c= BitArray(hex=xor)
        for k in range(len(c)/8):
            if c.bin[8*k]:
                flag=0
                break
        if (flag==1):
            print(packets[i],'e',packets[j],'posicao',i,j)
print('r')            