% EXERCÍCIO 6

[x,Fs] = audioread('Canto1.mp3');

x1=x(:,1);
t1=(1:length(x1))/Fs;

Ti=8; Tf=10;
xn=x1(Ti*Fs:Tf*Fs);
tn=(Ti*Fs:Tf*Fs)/Fs;
Ti=13; Tf=15;
xs=x1(Ti*Fs:Tf*Fs);
ts=(Ti*Fs:Tf*Fs)/Fs;

subplot(2,2,[1 2]), plot(t1,x1)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original')
subplot(2,2,3), plot(tn,xn)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Seccao com Ruido')
subplot(2,2,4), plot(ts,xs)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Seccao com Canto')


figure
subplot(2,3,1)
plot(t1,x1)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original')
subplot(2,3,2)
plot(tn,xn)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Seccao com Ruído')
subplot(2,3,3)
plot(ts,xs)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Seccao com Canto')

N_x = length(x1);
n_x = 0:N_x-1;
T_x = 27/(length(x1)-1);    
F_x = 1/T_x;
w1_x = n_x/N_x*2*pi; 
w2_x = w1_x (1:N_x/2);
DFT_x = fft(x1);

subplot(2,3,4)
plot((w2_x/pi*(F_x/2))/1000,abs(DFT_x(1:N_x/2)));
xlabel('f (KHz)');
title('Gráfico do módulo de TF_{Sinal Original}(f)');

N_xn = length(xn);
n_xn = 0:N_xn-1;
T_xn = 2/(length(xn)-1);    
F_xn = 1/T_xn;
w1_xn = n_xn/N_xn*2*pi; 
w2_xn = w1_xn (1:N_xn/2);
DFT_xn = fft(xn);

subplot(2,3,5)
plot((w2_xn/pi*(F_xn/2))/1000,abs(DFT_xn(1:N_xn/2)));
xlabel('f (KHz)');
title('Gráfico do módulo de TF_{Seccao com Ruído}(f)');

N_xs = length(xs);
n_xs = 0:N_xs-1;
T_xs = 2/(length(xs)-1);    
F_xs = 1/T_xs;
w1_xs = n_xs/N_xs*2*pi; 
w2_xs = w1_xs (1:N_xs/2);
DFT_xs = fft(xs);

subplot(2,3,6)
plot((w2_xs/pi*(F_xs/2))/1000,abs(DFT_xs(1:N_xs/2)));
xlabel('f (KHz)');
title('Gráfico do módulo de TF_{Seccao com Canto}(f)');


figure
[S,F,T,P] = spectrogram(x1,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto - Espectrograma')