%EXERCICIO 1

subplot(3,1,1);
format compact;
A=1.9; f=0.06; fase=0.25*pi;
n=-25:25;
x= A*cos(2*pi*f*n+fase);
stem(n,x);
axis([-25 25 -2 2]);
grid;
xlabel('n') , ylabel('x[n]');
delta = zeros(1,51);
delta(26)= 1;
title ('Gráfico de x[n]')

subplot(3,1,2);
stem(n,delta);
title ('Impulso Unitário')
xlabel('n')

subplot(3,1,3);
miu = ones(1,51);
miu(1:25) = 0;
stem(n,miu);
title ('Degrau Unitário')
xlabel('n')

