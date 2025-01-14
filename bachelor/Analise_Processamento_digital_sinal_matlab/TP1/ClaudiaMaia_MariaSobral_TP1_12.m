%EXERCÍCIO 12

x = [1 2 3 4 1 2 3 4 1 2 3 4];
y = [2 1 2 3 -2 -1 2];

subplot(3,2,1)
stem([0:11],x)
axis([0 11 0 4])
xlabel('n');
title('Gráfico de x[n]');

subplot(3,2,2)
stem([0:6],y)
axis([0 6 -2 3])
xlabel('n');
title('Gráfico de y[n]');

subplot(3, 2, 3)
rxx = xcorr(x,x);
stem([-11:11],rxx)
axis([-11 11 0 100]);
xlabel('n');
title('Gráfico da auto-correlação rxx[L]');

subplot(3, 2, 4)
ryy = xcorr(y,y);
stem([-6:6],ryy);
axis([-6 6 -10 30]);
xlabel('n');
title('Gráfico da auto-correlação ryy[L]');

subplot(3, 2, 5)
rxy = xcorr(x,y);
stem([-11:11],rxy);
axis([-11 11 0 25]);
xlabel('n');
title('Gráfico da correlação cruzada rxy[L]');


subplot(3, 2, 6)
ryx = xcorr(y,x);
stem([-11:11],ryx);
axis([-11 11 0 25]);
xlabel('n');
title('Gráfico da correlação cruzada ryx[L]');





