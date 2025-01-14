% EXERCÍCIO 7


[x,Fs] = audioread('Canto1.mp3');
x1=x(:,1);
subplot(2,2,1)
[S,F,T,P] = spectrogram(x1,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto 1 (amostra 1) - Espectrograma')

subplot(2,2,2)
x1=x(:,1);
t1=(1:length(x1))/Fs;
plot(t1,x1)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original 1 (amostra 1)')

x2=x(:,2);
subplot(2,2,3)
[S,F,T,P] = spectrogram(x2,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto 1 (amostra 2) - Espectrograma')

subplot(2,2,4)
x2=x(:,2);
t1=(1:length(x2))/Fs;
plot(t1,x2)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original 1 (amostra 2)')


figure
[x,Fs] = audioread('Canto2.mp3');
x1=x(:,1);
subplot(2,2,1)
[S,F,T,P] = spectrogram(x1,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto 2 (amostra 1) - Espectrograma')

subplot(2,2,2)
x1=x(:,1);
t1=(1:length(x1))/Fs;
plot(t1,x1)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original 2 (amostra 1)')

x2=x(:,2);
subplot(2,2,3)
[S,F,T,P] = spectrogram(x2,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto 2 (amostra 2) - Espectrograma')

subplot(2,2,4)
x2=x(:,2);
t1=(1:length(x2))/Fs;
plot(t1,x2)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original 2 (amostra 2)')


figure
[x,Fs] = audioread('Canto3.mp3');
x1=x(:,1);
subplot(2,2,1)
[S,F,T,P] = spectrogram(x1,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto 3 (amostra 1) - Espectrograma')

subplot(2,2,2)
x1=x(:,1);
t1=(1:length(x1))/Fs;
plot(t1,x1)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original 3 (amostra 1)')

x2=x(:,2);
subplot(2,2,3)
[S,F,T,P] = spectrogram(x2,128,96,128,Fs);
surf(T,F,10*log10(P),'edgecolor','none')
axis tight, view(0,90)
xlabel ('Tempo (s)'), ylabel ('Frequencia (Hz)'), title ('Canto 3 (amostra 2) - Espectrograma')

subplot(2,2,4)
x2=x(:,2);
t1=(1:length(x2))/Fs;
plot(t1,x2)
xlabel('Tempo (s)'), ylabel('Amplitude'), title ('Sinal Original 3 (amostra 2)')

% Tendo em conta os gráficos dos sinais apresentados, podemos concluir que,
% no canto 1, as duas amostras são muito parecidas e que a frequência com
% que ela canta é baixa, mas a frequencia do canto é alta.

% Por outro lado, no canto 2, detetamos mais ruído na segunda amostra,
% apesar de a frequência ser a mesma e a frquencia com que ele canta é
% muito alta (já que ele canta muitas vezes e faz pausas muito curtas)

% Por fim, verificamos que no canto 3 as duas amostras são consideravelmente 
% diferentes, já que a primeira parece ter mais ruído. Embora as duas amostras tenham
% amplitudes diferentes, a frequência do canto é a mesma.

% Concluindo, verificamos que o canto 1 é o mais agudo, embora tenha
% pausas longas. O canto 3 é o mais grave, já que tem frequências mais
% baixas.