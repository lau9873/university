def d():
    A=input()
    B=input()
    a=0
    b=0
    for i in range(10):
        if (A[i]=="R" and B[i]=="T") or (A[i]=="T" and B[i]=="P") or (A[i]=="P" and B[i]=="R"):
            a=a+1
        if (B[i]=="R" and A[i]=="T") or (B[i]=="T" and A[i]=="P") or (B[i]=="P" and A[i]=="R"):
            b=b+1
    print(a)
    print(b)
d()