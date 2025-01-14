% EXERCÍCIO 4

N = 255;
w = 0:pi/N:pi;
wc = 0.3*pi;
fc = 0.3;
Rp = 0.5;
Rs = 40;

subplot(3,4,1);
[num4b,den4b] = butter(4,fc,'low');
h4b = freqz(num4b,den4b,w);
g4b = 20* log10(abs(h4b));
plot(w/pi,g4b);
axis ([0 1 -60 5]);
title('Butterworth - 4a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,2);
[num6b,den6b] = butter(6,fc,'low');
h6b = freqz(num6b,den6b,w);
g6b = 20* log10(abs(h6b));
plot(w/pi,g6b);
axis ([0 1 -60 5]);
title('Butterworth - 6a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,3);
[num8b,den8b] = butter(8,fc,'low');
h8b = freqz(num8b,den8b,w);
g8b = 20* log10(abs(h8b));
plot(w/pi,g8b);
axis ([0 1 -60 5]);
title('Butterworth - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,4);
[num10b,den10b] = butter(10,fc,'low');
h10b = freqz(num10b,den10b,w);
g10b = 20* log10(abs(h10b));
plot(w/pi,g10b);
axis ([0 1 -60 5]);
title('Butterworth - 10a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,5);
[num4c,den4c] = cheby1(4,Rp,fc,'low');
h4c = freqz(num4c,den4c,w);
g4c = 20* log10(abs(h4c));
plot(w/pi,g4c);
axis ([0 1 -60 5]);
title('Chebyshev - 4a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,6);
[num6c,den6c] = cheby1(6,Rp,fc,'low');
h6c = freqz(num6c,den6c,w);
g6c = 20* log10(abs(h6c));
plot(w/pi,g6c);
axis ([0 1 -60 5]);
title('Chebyshev - 6a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,7);
[num8c,den8c] = cheby1(8,Rp,fc,'low');
h8c = freqz(num8c,den8c,w);
g8c = 20* log10(abs(h8c));
plot(w/pi,g8c);
axis ([0 1 -60 5]);
title('Chebyshev - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,8);
[num10c,den10c] = cheby1(10,Rp,fc,'low');
h10c = freqz(num10c,den10c,w);
g10c = 20* log10(abs(h10c));
plot(w/pi,g10c);
axis ([0 1 -60 5]);
title('Chebyshev - 10a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');




subplot(3,4,9);
[num4e,den4e] = ellip(4,Rp,Rs,fc,'low');
h4e = freqz(num4e,den4e,w);
g4e = 20* log10(abs(h4e));
plot(w/pi,g4e);
axis ([0 1 -60 5]);
title('Eliptico - 4a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,10);
[num6e,den6e] = ellip(6,Rp,Rs,fc,'low');
h6e = freqz(num6e,den6e,w);
g6e = 20* log10(abs(h6e));
plot(w/pi,g6e);
axis ([0 1 -60 5]);
title('Eliptico - 6a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,11);
[num8e,den8e] = ellip(8,Rp,Rs,fc,'low');
h8e = freqz(num8e,den8e,w);
g8e = 20* log10(abs(h8e));
plot(w/pi,g8e);
axis ([0 1 -60 5]);
title('Eliptico - 8a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');

subplot(3,4,12);
[num10e,den10e] = ellip(10,Rp,Rs,fc,'low');
h10e = freqz(num10e,den10e,w);
g10e = 20* log10(abs(h10e));
plot(w/pi,g10e);
axis ([0 1 -60 5]);
title('Eliptico - 10a Ordem');
xlabel ('\omega/\pi');
ylabel('Ganho, dB');