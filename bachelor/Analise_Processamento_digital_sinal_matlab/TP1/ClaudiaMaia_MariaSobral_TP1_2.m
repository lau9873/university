% EXERCICIO 2

function ClaudiaMaia_MariaSobral_TP1_2(n1,n2)
    subplot(3,1,1);
    format compact;
    A=1.9; f=0.06; fase=0.25*pi;
    n=n1:n2;
    x= A*cos(2*pi*f*n+fase);
    stem(n,x);
    axis([n1 n2 -2 2]);
    grid;
    xlabel('n') , ylabel('x[n]');
    delta = [ zeros(1,-n1) 1 zeros(1,n2) ];
    title ('Gráfico de x[n]')

    subplot(3,1,2);
    stem(n,delta);
    title ('Impulso Unitário')
    xlabel('n')

    subplot(3,1,3);
    miu = [ zeros(1,-n1) ones(1,n2+1) ];
    stem(n,miu);
    title ('Degrau Unitário')
    xlabel('n')
end

