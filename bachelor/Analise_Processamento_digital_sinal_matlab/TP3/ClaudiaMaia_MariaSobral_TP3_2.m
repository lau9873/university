%  EXERCÍCIO 2

load cello
load EEG
load sintetico.csv

N_sint = 256;
n_sint = 0:N_sint-1;
T_sint = 0.125;    
F_sint = 1/T_sint;
w1_sint = n_sint/N_sint*2*pi; 
w2_sint = w1_sint (1:N_sint/2);
DFT_sint = fft(sintetico);

subplot(2,1,1);
plot(n_sint*T_sint,sintetico);
axis([0 255*0.125 -1 4]);
title('Sinal sintético');
xlabel('t(s)');

subplot(2,1,2);
plot(w2_sint/pi*(F_sint/2),abs(DFT_sint(1:N_sint/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF_{sintético}(f)');

figure;

N_cello = 9288;
n_cello = 0:N_cello-1;
T_cello = cello.dt;    
F_cello = 1/T_cello;
w1_cello = n_cello/N_cello*2*pi; 
w2_cello = w1_cello (1:N_cello/2);
DFT_cello = fft(cello.x(1:end));

subplot(2,1,1);
plot(n_cello*T_cello,cello.x(1:end));
axis([0 9287*T_cello -0.5 0.5]);
title('Sinal cello');
xlabel('t(s)');

subplot(2,1,2);
plot(w2_cello/pi*(F_cello/2),abs(DFT_cello(1:N_cello/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF_{cello}(f)');
axis([0 F_cello/2 0 350]);

figure;

N_EEG = 2000;
n_EEG = 0:N_EEG-1;    
F_EEG = 100;
T_EEG = 1/F_EEG;
w1_EEG = n_EEG/N_EEG*2*pi; 
w2_EEG = w1_EEG (1:N_EEG/2);
DFT_EEG = fft(data);

subplot(2,1,1);
plot(n_EEG*T_EEG,data);
axis([0 1999*T_EEG -600000 600000]);
title('Sinal EEG');
xlabel('t(s)');

subplot(2,1,2);
plot(w2_EEG/pi*(F_EEG/2),abs(DFT_EEG(1:N_EEG/2)));
xlabel('f (Hz)');
title('Gráfico do módulo de TF_{EEG}(f)');
