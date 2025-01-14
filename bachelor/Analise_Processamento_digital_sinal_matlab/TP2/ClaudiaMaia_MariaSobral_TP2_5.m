% EXERCÍCIO 5

fid = fopen ('INS_10k.txt');
B = textscan(fid, '%f %f %f %f %f %f %f');
XAR = B{1};
YAR = B{2};
ZAR = B{3};
XAG = B{4};
YAG = B{5};
ZAG = B{6};
%t = B{7};
fclose(fid);
clear B;

T = 0.020;     % 20ms = 0.02 s
Fs=1/T;
N=10000;
n = 0:N-1;
w = n/10000*2*pi;   
w2=w(1:N/2);
t=n/Fs;
DFTXar=fft(XAR);
DFTYar=fft(YAR);
DFTZar=fft(ZAR);
DFTXag=fft(XAG);
DFTYag=fft(YAG);
DFTZag=fft(ZAG);

subplot(2,2,1);
plot(t,XAR);
xlabel('t (s)');
title('Gráfico de X(t)');

subplot(2,2,2);
plot(w/pi,abs(DFTXar));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{X}(\omega)');

subplot(2,2,3);
plot(w2/pi,abs(DFTXar(1:N/2)));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{X}(\omega)');

subplot(2,2,4);
plot(w2/pi*(Fs/2),abs(DFTXar(1:N/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF{X}(f)');

figure
subplot(2,3,1);
plot(t,XAR);
xlabel('t (s)');
title('Gráfico de X(t)');

subplot(2,3,2);
plot(t,YAR);
xlabel('t (s)');
title('Gráfico de Y(t)');

subplot(2,3,3);
plot(t,ZAR);
xlabel('t (s)');
title('Gráfico de Z(t)');

subplot(2,3,4);
plot(w2/pi*(Fs/2),abs(DFTXar(1:N/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF{X}(f)');

subplot(2,3,5);
plot(w2/pi*(Fs/2),abs(DFTYar(1:N/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF{Y}(f)');

subplot(2,3,6);
plot(w2/pi*(Fs/2),abs(DFTZar(1:N/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF{Z}(f)');


figure
subplot(2,3,1);
plot(t,XAG);
xlabel('t (s)');
title('Gráfico de X´(t)');

subplot(2,3,2);
plot(t,YAG);
xlabel('t (s)');
title('Gráfico de Y´(t)');

subplot(2,3,3);
plot(t,ZAG);
xlabel('t (s)');
title('Gráfico de Z´(t)');

subplot(2,3,4);
plot(w2/pi*(Fs/2),abs(DFTXag(1:N/2)));
xlabel('f (Hz)');
axis ([0 3 0 50]);
title('Gráfico do módulo de TF{X´}(f)');

subplot(2,3,5);
plot(w2/pi*(Fs/2),abs(DFTYag(1:N/2)));
xlabel('f (Hz)');
axis ([0 3 0 100]);
title('Gráfico do módulo de TF{Y´}(f)');

subplot(2,3,6);
plot(w2/pi*(Fs/2),abs(DFTZag(1:N/2)));
xlabel('f (Hz)');
axis ([0 3 0 20000]);
title('Gráfico do módulo de TF{Z´}(f)');