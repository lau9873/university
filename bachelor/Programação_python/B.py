def preciosismos():
    a,b=map(int,input().split())
    c,d=map(int,input().split())
    total = (c*60)+d-((a*60)+b)
    horas=total // 60
    minutos=total % 60
    if horas>0:
        if minutos==1:
            if horas==1:
                print('Passaram apenas '+str(total)+ ' minutos!')
                print('Queres dizer, '+str(horas)+' hora e '+str(minutos)+' minuto?!')
            if horas>1:
                print('Passaram apenas '+str(total)+ ' minutos!')
                print('Queres dizer, '+str(horas)+' horas e '+str(minutos)+' minuto?!')
        if minutos>1:
            if horas==1:
                print('Passaram apenas '+str(total)+ ' minutos!')
                print('Queres dizer, '+str(horas)+' hora e '+str(minutos)+' minutos?!')
            if horas>1:
                print('Passaram apenas '+str(total)+ ' minutos!')
                print('Queres dizer, '+str(horas)+' horas e '+str(minutos)+' minutos?!')
        if minutos==0:
            if horas==1:
                print('Passaram apenas '+str(total)+ ' minutos!')
                print('Queres dizer, '+str(horas)+' hora?!') 
            if horas>1:
                print('Passaram apenas '+str(total)+ ' minutos!')
                print('Queres dizer, '+str(horas)+' horas?!') 
    if horas==0:
        if minutos>1:
            print('Passaram apenas '+str(minutos)+' minutos!')
            print('De facto!')
        if minutos==1:
            print('Passou apenas '+str(minutos)+' minuto!')
            print('De facto!')
            
preciosismos()