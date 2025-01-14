% EXERCÍCIO 2

n = 0:15;
w = (0:1023)/1024;

x1 = ones(1,16);
DFT1 = fft(x1);
DTFT1 = fft(x1,1024);

x2 = cos(3*pi*n/8);
DFT2 = fft(x2);
DTFT2 = fft(x2,1024);

subplot(2,1,1);
stem(n,x1);
xlabel('n');
ylabel('Amplitude');
title('Sinal x1');

subplot(2,1,2);
plot(n/16, abs(DFT1),'o',w,abs(DTFT1));
xlabel('\omega/(2*\pi)');
ylabel('Módulo');
title('DFT/DTFT de x1');

figure
subplot(2,1,1);
stem(n,x2);
xlabel('n');
ylabel('Amplitude');
title('Sinal x2');

subplot(2,1,2);
plot(n/16, abs(DFT2),'o',w,abs(DTFT2));
xlabel('\omega/(2*\pi)');
ylabel('Módulo');
title('DFT/DTFT de x2');