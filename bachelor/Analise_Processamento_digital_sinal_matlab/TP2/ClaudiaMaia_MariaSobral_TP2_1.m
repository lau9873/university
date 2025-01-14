% EXERCÍCIO 1

w1 = -4*pi;
w2 = 4*pi;
n = 1000;
w = w1:(w2-w1)/(n-1):w2

num_x = [1.8 0.5 -0.3]
den_x = [1 0.3 -0.2]
h_x = freqz(num_x,den_x,w);

den_u = [1,0.5];
num_u = [1];
h_u = freqz(num_u,den_u,w);

num_v = [1 2 3 4 1 3]
den_v = [1]
h_v = freqz(num_v,den_v,w);


subplot(2,1,1)
plot(w/pi, abs(h_x));
xlabel('\omega/\pi');
title('Gráfico do módulo de X');

subplot(2,1,2)
plot(w/pi,angle(h_x));
xlabel('\omega/\pi');
title('Gráfico de fase de X');

figure
subplot(2,1,1)
plot(w/pi, abs(h_u));
xlabel('\omega/\pi');
title('Gráfico do módulo de U');

subplot(2,1,2)
plot(w/pi,angle(h_u));
xlabel('\omega/\pi');
title('Gráfico de fase de U');

figure
subplot(2,1,1)
plot(w/pi, abs(h_v));
xlabel('\omega/\pi');
title('Gráfico do módulo de V');

subplot(2,1,2)
plot(w/pi,angle(h_v));
xlabel('\omega/\pi');
title('Gráfico de fase de V');

