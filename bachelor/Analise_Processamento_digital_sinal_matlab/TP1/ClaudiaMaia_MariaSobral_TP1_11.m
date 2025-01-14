%EXERCÍCIO 11


n = 0:255;
x = cos(20*pi*n/256) + cos(200*pi*n/256);
y1 = filter([0.5 0.4 0.3],1,x);
y2 = filter([0.4 0.5 0.4],[1 -0.5 0.4],x);

subplot(3,1,1)
stem(n,x)
xlabel('n')
title('Gráfico de x[n] como input')
axis([0 255 -2 2])

subplot(3,1,2)
stem(n,y1)
xlabel('n')
title('Gráfico de output para o sistema 1')
axis([0 255 -2 2])

subplot(3,1,3)
stem(n,y2)
xlabel('n')
title('Gráfico de output para o sistema 2')
axis([0 255 -2 2])