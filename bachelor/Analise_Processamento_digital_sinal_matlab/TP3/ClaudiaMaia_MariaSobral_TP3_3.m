% EXERCÍCIO 3

load sintetico.csv
N = 256;
n = 0:N-1;
T = 0.125;    
FS = 1/T;
FC = 2.5;
w1 = n/N*2*pi; 
w2 = w1 (1:N);

P = round(N*FC/FS);
U = round(N*(FS-FC)/FS);

DFT = fft(sintetico);
DFT_nova = DFT;
DFT_nova (P:U) = 0;
sinal_novo = ifft(DFT_nova);

subplot(2,2,1);
plot(n*T,sintetico);
axis([0 255*0.125 -1 4]);
title('Sinal sintético');
xlabel('t(s)');

subplot(2,2,2);
plot(n*T,sinal_novo);
axis([0 255*0.125 -1 4]);
title('Sinal sintético filtrado');
xlabel('t(s)');

subplot(2,2,3);
plot(w2/pi*(FS/2),abs(DFT));
xlabel('f (Hz)');
title('Gráfico do módulo de TF_{sintético}(f)');


subplot(2,2,4);
plot(w2/pi*(FS/2),abs(DFT_nova));
xlabel('f (Hz)');
title('Gráfico do módulo de TF_{sintético filtrado}(f)');

