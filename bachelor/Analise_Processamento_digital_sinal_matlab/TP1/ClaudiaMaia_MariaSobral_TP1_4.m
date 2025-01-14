% EXERC�CIO 4

subplot(3,1,1)
x1 = rand(1,100) * 6 -3
stem(x1)
title ('Gr�fico x1[n]')
xlabel('n') 
ylabel('Amplitude')

subplot(3,1,2)
x2 = sqrt(2) * randn(1,100)
stem(x2)
title ('Gr�fico x2[n]')
xlabel('n') 
ylabel('Amplitude')

subplot(3,1,3)
u = rand(1,100)
x3 = (u > 0.3)
stem(x3)
title ('Gr�fico x3[n]')
xlabel('n') 
ylabel('Amplitude')



