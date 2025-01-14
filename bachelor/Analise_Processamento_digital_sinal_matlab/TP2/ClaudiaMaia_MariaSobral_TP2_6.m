% EXERCÍCIO 5

N = 512;
v_tct = zeros(1,10);
v_tcf = zeros(1,10);

for i=1:10
    n = 0:N-1;
    pad = zeros(1,N-1);
    x = 2*n.*(0.97).^n;
    y = cos(6*pi*n/N);
    
    tic
    Cxy = conv(x,y);
    v_tct(i) = toc;
    
    tic
    xe =[x pad];
    ye =[y pad];
    TFx = fft(xe);
    TFy = fft(ye);
    Uxy = TFx.*TFy;
    Cxyf = ifft(Uxy);
    v_tcf(i) = toc;
    
    N = N*2;
end

plot([0:9],v_tct,[0:9],v_tcf);
legend('Convolução no domínio do tempo','Convolução no domínio das frequências');
xlabel('quantidade de vezes que multiplicamos o número de pontos por dois');
ylabel('tempo de execução em segundos');

