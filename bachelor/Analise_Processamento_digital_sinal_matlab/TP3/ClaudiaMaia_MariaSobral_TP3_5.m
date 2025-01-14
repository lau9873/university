% EXERCÍCIO 5

load ClaudiaMaia_MariaSobral_TP3_5_filtros;
N = 255;
w = 0:pi/N:pi;

subplot(2,2,1);
[numa,dena]=sos2tf(SOSa,Ga);
ha = freqz(numa,dena,w);
ga = 20* log10(abs(ha));
plot(w/pi,ga);
title('Eliptico - Passa baixo - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(2,2,2);
plot(w/pi,angle(ha));
title('Gráfico de fase');
xlabel ('f(Hz)');
ylabel('Amplitude');

subplot(2,2,3);
impz(numa,dena,80);
title('Gráfico da resposta impulsional');
axis([0 80 -0.15 0.25]);

subplot(2,2,4);
zplane(numa,dena);
title('Gráfico de zeros e polos');

figure;
subplot(2,2,1);
[numb,denb]=sos2tf(SOSb,Gb);
hb = freqz(numb,denb,w);
gb = 20* log10(abs(hb));
plot(w/pi,gb);
title('Eliptico - Passa alto - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');


subplot(2,2,2);
plot(w/pi,angle(hb));
title('Gráfico de fase');
xlabel ('f(Hz)');
ylabel('Amplitude');

subplot(2,2,3);
impz(numb,denb,75);
title('Gráfico da resposta impulsional');

subplot(2,2,4);
zplane(numb,denb);
title('Gráfico de zeros e polos');

figure;
subplot(2,2,1);
[numc,denc]=sos2tf(SOSc,Gc);
hc = freqz(numc,denc,w);
gc = 20* log10(abs(hc));
plot(w/pi,gc);
title('Eliptico - Passa banda - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(2,2,2);
plot(w/pi,angle(hc));
title('Gráfico de fase');
xlabel ('f(Hz)');
ylabel('Amplitude');

subplot(2,2,3);
impz(numc,denc,90);
title('Gráfico da resposta impulsional');
axis([0 90 -0.15 0.15]);

subplot(2,2,4);
zplane(numc,denc);
title('Gráfico de zeros e polos');

figure;
subplot(2,2,1);
[numd,dend]=sos2tf(SOSd,Gd);
hd = freqz(numd,dend,w);
gd = 20* log10(abs(hd));
plot(w/pi,gd);
title('Eliptico - Corta Banda - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(2,2,2);
plot(w/pi,angle(hd));
title('Gráfico de fase');
xlabel ('f(Hz)');
ylabel('Amplitude');

subplot(2,2,3);
impz(numd,dend,75);
title('Gráfico da resposta impulsional');

subplot(2,2,4);
zplane(numd,dend);
title('Gráfico de zeros e polos');