% EXERCÍCIO 4b

n = 0:255;
x0 = 0.25 * n .* exp(-0.03*n);
ra = [cos(0.82*pi*n) + sin(0.85*pi*n) + sin(0.91*pi*n) + cos(0.95*pi*n)]/4;
xa = x0 + ra;

w1 = 0:2*pi/(256-1):2*pi;
w2 = -pi:2*pi/(256-1):pi;
w3 = 0:pi/(256/2-1):pi;

DFT1 = freqz(xa,1,w1);
DFT2 = freqz(xa,1,w2);
DFT3 = freqz(xa,1,w3);

subplot(3,2,1);
plot(w1/pi,abs(DFT1));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');

subplot(3,2,2);
plot(w1/pi,angle(DFT1));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');

subplot(3,2,3);
plot(w2/pi,abs(DFT2));
axis([-1 1 0 300]);
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');

subplot(3,2,4);
plot(w2/pi,angle(DFT2));
axis([-1 1 -5 5]);
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');

subplot(3,2,5);
plot(w3/pi,abs(DFT3));
axis([0 1 0 300]);
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');

subplot(3,2,6);
plot(w3/pi,angle(DFT3));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');