% EXERCÍCIO 4a

n = 0:255;
x0 = 0.25 * n .* exp(-0.03*n);
ra = [cos(0.82*pi*n) + sin(0.85*pi*n) + sin(0.91*pi*n) + cos(0.95*pi*n)]/4;
rb = rand(1,256)*1.2-0.6;
xa = x0 + ra;
xb = x0 + rb;
xc = x0 + ra + rb.*xa;

subplot(2,3,1);
stem(n,x0);
xlabel('n');
title('Sinal x0');
axis([0 255 0 4]);

subplot(2,3,2)
stem(n,ra);
xlabel('n');
title('Sinal ra');
axis([0 255 -1 1]);

subplot(2,3,3)
stem(n,rb);
xlabel('n');
title('Sinal rb');
axis([0 255 -1 1]);

subplot(2,3,4)
stem(n,xa);
xlabel('n');
title('Sinal xa');
axis([0 255 -1 4]);

subplot(2,3,5)
stem(n,xb);
xlabel('n');
title('Sinal xb');
axis([0 255 -1 4]);

subplot(2,3,6)
stem(n,xc);
xlabel('n');
title('Sinal xc');
axis([0 255 -2 6]);