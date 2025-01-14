% EXERCICIO 5

function ClaudiaMaia_MariaSobral_TP1_5(x)
    n = 1:length(x);
    stem(n',[real(x)',imag(x)'])
    title ('Gráfico da sequência')
    xlabel('n')
    ylabel('x[n]')
    L1 = norm(x,1)
    L2 = norm(x,2)
    L3 = norm(x,3)
    Linf = norm(x,inf)

    %L1z = sum(abs(x))
    %L2z = sum(abs(x).^2).^(1/2)
    %L3z = sum(abs(x).^3).^(1/3)
    %Linfz = max(abs(x))
    
    E = sum(abs(x).^2)
    P = 1/length(x)*E
    
end
