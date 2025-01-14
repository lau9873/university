def c():
    texto=str(input())
    s=0
    for x in texto:
        if x in 'Pp':
            s=s+1
    print(s)
c()
