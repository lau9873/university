%EXERCÍCIO 14

load SR
figure
subplot(2,3,1)
stem([0:length(R1)-1],R1)
axis ([0 length(R1)-1 0 max(R1)])
xlabel('n')
title('Gráfico do sinal de referência de R1')

subplot(2,3,2)
stem([0:length(R2)-1],R2)
axis ([0 length(R2)-1 0 max(R2)])
xlabel('n')
title('Gráfico do sinal de referência de R2')

subplot(2,3,3)
stem([0:length(R3)-1],R3)
axis ([0 length(R3)-1 0 max(R3)])
xlabel('n')
title('Gráfico do sinal de referência de R3')

subplot(2,3,4)
stem([0:length(R4)-1],R4)
axis ([0 length(R4)-1 0 max(R4)])
xlabel('n')
title('Gráfico do sinal de referência de R4')

subplot(2,3,5)
stem([0:length(R5)-1],R5)
axis ([0 length(R5)-1 0 max(R5)])
xlabel('n')
title('Gráfico do sinal de referência de R5')

subplot(2,3,6)
stem([0:length(R6)-1],R6)
axis ([0 length(R6)-1 0 max(R6)])
xlabel('n')
title('Gráfico do sinal de referência de R6')

figure
subplot(2,1,1)
stem([0:length(S1)-1], S1)
[Vmax1,Lmax1]=ClaudiaMaia_MariaSobral_TP1_13(R4,S1,0);
title(['Gráfico do sinal S1, Vmax = ', num2str(Vmax1) , ' e Lmax = ', num2str(Lmax1)]);
xlabel('n');
subplot(2,1,2)
stem([0:length(R4)-1],R4)
xlabel('n');
title('Gráfico do sinal de referência de R4')

figure
subplot(2,1,1)
stem([0:length(S2)-1], S2)
[Vmax2,Lmax2]=ClaudiaMaia_MariaSobral_TP1_13(R5,S2,0);
title(['Gráfico do sinal S2, Vmax = ', num2str(Vmax2) , ' e Lmax = ', num2str(Lmax2)]);
xlabel('n');
subplot(2,1,2)
stem([0:length(R5)-1],R5)
xlabel('n');
title('Gráfico do sinal de referência de R5')

figure
subplot(2,1,1)
stem([0:length(S3)-1], S3)
[Vmax3,Lmax3]=ClaudiaMaia_MariaSobral_TP1_13(R1,S3,0);
title(['Gráfico do sinal S3, Vmax = ', num2str(Vmax3) , ' e Lmax = ', num2str(Lmax3)]);
xlabel('n');
subplot(2,1,2)
stem([0:length(R1)-1],R1)
xlabel('n');
title('Gráfico do sinal de referência de R1')