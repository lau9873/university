%EXERCÍCIO 13


function [Vmax,Lmax] = ClaudiaMaia_MariaSobral_TP1_13(x,y,graf)
    [rxx,Lxx] = xcorr(x,x);
    [ryy,Lyy] = xcorr(y,y);
    [rxy,Lxy] = xcorr(x,y);
    [ryx,Lyx] = xcorr(y,x);
    roxx = rxx/rxx(length(x));
    roxy = rxy/sqrt(rxx(length(x))*ryy(length(y)));
    royy = ryy/ryy(length(y));
    maxlength = max(length(x),length(y));
    [Vmax,Posicao] = max(roxy);
    Lmax=Lxy(Posicao);
    
    if (graf==1) 
        subplot(5,1,1)
        stem([0:length(x)-1],x)
        axis([0 length(x)-1 min(x) max(x)]);
        xlabel('n');
        title('Gráfico de x');
        
        subplot(5,1,2)
        stem([0:length(y)-1],y)
        axis([0 length(y)-1 min(y) max(y)]);
        xlabel('n');
        title('Gráfico de y');
        
        subplot(5,1,3)
        stem(Lxx,roxx)
        axis([-length(x)+1 length(x)+1 -1 1]);
        xlabel('L');
        title('Gráfico da normalização da sequência de correlação ro_xx[L]');
        
        subplot(5,1,4)
        stem(Lyy,royy)
        axis([-length(y)+1 length(y)+1 -1 1]);
        xlabel('L');
        title('Gráfico da normalização da sequência de correlação ro_yy[L]');
        
        subplot(5,1,5)
        stem(Lxy,roxy)
        axis([-maxlength+1 maxlength+1 -1 1]);
        xlabel('L');
        title('Gráfico da normalização da sequência de correlação ro_xy[L]');
        
    end
end
        
  