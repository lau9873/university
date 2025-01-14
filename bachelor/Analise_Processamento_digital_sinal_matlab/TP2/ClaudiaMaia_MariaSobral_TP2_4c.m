% EXERCÍCIO 4c

n = 0:255;
x0 = 0.25 * n .* exp(-0.03*n);
ra = [cos(0.82*pi*n) + sin(0.85*pi*n) + sin(0.91*pi*n) + cos(0.95*pi*n)]/4;
rb = rand(1,256)*1.2-0.6;
xa = x0 + ra;
xb = x0 + rb;
xc = x0 + ra + rb.*xa;

w = 0:pi/(256/2-1):pi;

DFT_x0 = freqz(x0,1,w);
DFT_ra = freqz(ra,1,w);
DFT_rb = freqz(rb,1,w);
DFT_xa = freqz(xa,1,w);
DFT_xb = freqz(xb,1,w);
DFT_xc = freqz(xc,1,w);

subplot(2,3,1);
plot(w/pi,abs(DFT_x0));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{x0}(\omega)');

subplot(2,3,2);
plot(w/pi,abs(DFT_ra));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{ra}(\omega)');


subplot(2,3,3);
plot(w/pi,abs(DFT_rb));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{rb}(\omega)');


subplot(2,3,4);
plot(w/pi,abs(DFT_xa));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xa}(\omega)');


subplot(2,3,5);
plot(w/pi,abs(DFT_xb));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xb}(\omega)');


subplot(2,3,6);
plot(w/pi,abs(DFT_xc));
xlabel('\omega/\pi');
title('Gráfico do módulo de TF{xc}(\omega)');