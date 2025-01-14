%EXERCÍCIO 9

n = 0:120;
r = rand(1,121)*0.6 - 0.3;
x = 3*cos(0.1*pi*n) + 0.3*sin(0.8*pi*n)+ r;
a =(1/7) * ones(1,7);
y = filter(a,1,x);
y2a = filter(a,1,[x zeros(1,3)])
y2b = y2a(4:(length(x)+3));

subplot(3,1,1)
stem(n,x)
xlabel('n')
title('Gráfico de x[n]')

subplot(3,1,2)
stem(n,y)
xlabel('n')
title ('Gráfico de y[n]')

subplot(3,1,3)
stem(n,y2b);
xlabel('n')
title ('Gráfico de y2[n]')