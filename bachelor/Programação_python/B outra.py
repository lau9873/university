def preciosismos():
    a,b=map(int,input().split())
    c,d=map(int,input().split())
    if d-b<0:
        minu=60-b+d
        horas=c-a-1
    if d-b>=0:
        minu=d-b
        horas=c-a
    if horas >0:
        if minu==1:
            if horas==1:
                print('Passaram apenas '+str(minu+(horas*60))+ ' minutos!')
                print('Queres dizer, '+str(horas)+' hora e '+str(minu)+' minuto?!')
            if horas>1:
                print('Passaram apenas '+str(minu+(horas*60))+ ' minutos!')
                print('Queres dizer, '+str(horas)+' horas e '+str(minu)+' minuto?!')
        if minu>1:
            if horas==1:
                print('Passaram apenas '+str(minu+(horas*60))+ ' minutos!')
                print('Queres dizer, '+str(horas)+' hora e '+str(minu)+' minutos?!')
            if horas>1:
                print('Passaram apenas '+str(minu+(horas*60))+ ' minutos!')
                print('Queres dizer, '+str(horas)+' horas e '+str(minu)+' minutos?!')
        if minu==0:
            if horas==1:
                print('Passaram apenas '+str(minu+(horas*60))+ ' minutos!')
                print('Queres dizer, '+str(horas)+' hora?!') 
            if horas>1:
                print('Passaram apenas '+str(minu+(horas*60))+ ' minutos!')
                print('Queres dizer, '+str(horas)+' horas?!') 
    if horas==0:
        if minu>1:
            print('Passaram apenas '+str(minu)+' minutos!')
            print('De facto!')
        if minu==1:
            print('Passou apenas '+str(minu)+' minuto!')
            print('De facto!')
                
preciosismos()