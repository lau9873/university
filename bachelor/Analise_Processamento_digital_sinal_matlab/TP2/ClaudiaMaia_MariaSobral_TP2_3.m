% EXERCÍCIO 3

N = 256;
n = 0:N-1;
pad = zeros(1,N-1);


x1 = 2*n.*(0.97).^n;
x2 = cos(6*pi*n/N);
x3 = sin(12*pi*n/N);

C12 = conv(x1,x2);
C13 = conv(x1,x3);
C23 = conv(x2,x3);
x1e =[x1 pad];
x2e =[x2 pad];
x3e =[x3 pad];
TF1 = fft(x1e);
TF2 = fft(x2e);
TF3 = fft(x3e);
U12 = TF1.*TF2;
U13 = TF1.*TF3;
U23 = TF2.*TF3;
C12f = ifft(U12);
C13f = ifft(U13);
C23f = ifft(U23);


subplot(3,3,1)
plot(x1);
title('Gráfico do Sinal x1');
axis([0 N-1 0 30]);
xlabel('n');

subplot(3,3,2)
plot(x2);
title('Gráfico do Sinal x2');
axis([0 N-1 -1 1]);
xlabel('n');

subplot(3,3,3)
plot(x3);
title('Gráfico do Sinal x3');
axis([0 N-1 -1 1]);
xlabel('n');

subplot(3,3,4)
plot(real(C12f));
title('Convolução de x1 e x2 via DFT');
axis([0 2*N-2 -400 400]);
xlabel('f (Hz)');

subplot(3,3,5)
plot(real(C13f));
title('Convolução de x1 e x3 via DFT');
axis([0 2*N-2 -200 400]);
xlabel('f (Hz)');

subplot(3,3,6)
plot(real(C23f));
title('Convolução de x2 e x3 via DFT');
axis([0 2*N-2 -20 20]);
xlabel('f (Hz)');

subplot(3,3,7)
plot(C12);
title('Convolução de x1 e x2 com conv');
axis([0 2*N-2 -400 400]);
xlabel('t (s)');

subplot(3,3,8)
plot(C13);
title('Convolução de x1 e x3 com conv');
axis([0 2*N-2 -200 400]);
xlabel('t (s)');

subplot(3,3,9)
plot(C23);
title('Convolução de x2 e x3 com conv');
axis([0 2*N-2 -20 20]);
xlabel('t (s)');


