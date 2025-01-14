%EXERCÍCIO 10


n = 0:250;

x1 = 2*cos(0.1*pi*n);
x2 = 2*cos(0.2*pi*n);
x3 = 2*cos(0.3*pi*n);

x1c = [0 x1 0];
x1at = [0 0 x1];
x1ad = [x1 0 0];

x2c = [0 x2 0];
x2at = [0 0 x2];
x2ad = [x2 0 0];

x3c = [0 x3 0];
x3at = [0 0 x3];
x3ad = [x3 0 0];

y1i = x1c.^2 - x1at .* x1ad
y2i = x2c.^2 - x2at .* x2ad
y3i = x3c.^2 - x3at .* x3ad

y1 = y1i(2:252);
y2 = y2i(2:252);
y3 = y3i(2:252);


figure
subplot(2,1,1)
stem(n,x1)
xlabel('n')
title('Sinal de Input 1');

subplot(2,1,2)
stem(n,y1)
xlabel('n')
title('Sinal de Output 1');

figure
subplot(2,1,1)
stem(n,x2)
xlabel('n')
title('Sinal de Input 2');

subplot(2,1,2)
stem(n,y2)
xlabel('n')
title('Sinal de Output 2');

figure
subplot(2,1,1)
stem(n,x3)
xlabel('n')
title('Sinal de Input 3');

subplot(2,1,2)
stem(n,y3)
xlabel('n')
title('Sinal de Output 3');



    