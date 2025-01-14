%  EXERCÍCIO 1

num1 = [1 -1];
den1 = [1 -0.2];
h60_1 = impz(num1,den1,60);
h40_1 = impz(num1,den1,40);
h20_1 = impz(num1,den1,20);

num2 = [4.5 -1.3 1.4];
den2 = [1 -0.2 0.75 -0.27];
h60_2 = impz(num2,den2,60);
h40_2 = impz(num2,den2,40);
h20_2 = impz(num2,den2,20);

num3 = [0 0.5 0];
den3 = [1 -1  0.15];
h60_3 = impz(num3,den3,60);
h40_3 = impz(num3,den3,40);
h20_3 = impz(num3,den3,20);

num4 = [3 4.5];
den4 = [1 -2.9 -2.1];
h60_4 = impz(num4,den4,60);
h40_4 = impz(num4,den4,40);
h20_4 = impz(num4,den4,20);

num5 = [1];
den5 = [1 -1.845  0.850586];
h60_5 = impz(num5,den5,60);
h40_5 = impz(num5,den5,40);
h20_5 = impz(num5,den5,20);

num6 = [1];
den6 = [1 -1.85  0.85];
h60_6 = impz(num6,den6,60);
h40_6 = impz(num6,den6,40);
h20_6 = impz(num6,den6,20);

subplot(2,2,1);
stem(h60_1);
E20_1 = sum(abs(h20_1).^2);
E40_1 = sum(abs(h40_1).^2);
E60_1 = sum(abs(h60_1).^2);
title(['h1 - E20=', num2str(E20_1), ' ;E40=', num2str(E40_1), '; E60=',num2str(E60_1)]);
xlabel('n(samples)');
ylabel('Amplitude');

subplot(2,2,2);
[z1,p1,k1] = tf2zpk (num1,den1);
zplane(z1,p1);
title('H1');

subplot(2,2,3);
stem(h60_2);
E20_2 = sum(abs(h20_2).^2);
E40_2 = sum(abs(h40_2).^2);
E60_2 = sum(abs(h60_2).^2);
title(['h2 - E20=', num2str(E20_2), ' ;E40=', num2str(E40_2), '; E60=',num2str(E60_2)]);
xlabel('n(samples)');
ylabel('Amplitude');

subplot(2,2,4);
[z2,p2,k2] = tf2zpk (num2,den2);
zplane(z2,p2);
title('H2');

figure;
subplot(2,2,1);
stem(h60_3);
E20_3 = sum(abs(h20_3).^2);
E40_3 = sum(abs(h40_3).^2);
E60_3 = sum(abs(h60_3).^2);
title(['h3 - E20=', num2str(E20_3), ' ;E40=', num2str(E40_3), '; E60=',num2str(E60_3)]);
xlabel('n(samples)');
ylabel('Amplitude');

subplot(2,2,2);
[z3,p3,k3] = tf2zpk (num3,den3);
zplane(z3,p3);
title('H3');

subplot(2,2,3);
stem(h60_4);
E20_4 = sum(abs(h20_4).^2);
E40_4 = sum(abs(h40_4).^2);
E60_4 = sum(abs(h60_4).^2);
title(['h4 - E20=', num2str(E20_4), ' ;E40=', num2str(E40_4), '; E60=',num2str(E60_4)]);
xlabel('n(samples)');
ylabel('Amplitude');

subplot(2,2,4);
[z4,p4,k4] = tf2zpk (num4,den4);
zplane(z4,p4);
title('H4');

figure;
subplot(2,2,1);
stem(h60_5);
E20_5 = sum(abs(h20_5).^2);
E40_5 = sum(abs(h40_5).^2);
E60_5 = sum(abs(h60_5).^2);
title(['h5 - E20=', num2str(E20_5), ' ;E40=', num2str(E40_5), '; E60=',num2str(E60_5)]);
xlabel('n(samples)');
ylabel('Amplitude');

subplot(2,2,2);
[z5,p5,k5] = tf2zpk (num5,den5);
zplane(z5,p5);
title('H5');

subplot(2,2,3);
stem(h60_6);
E20_6= sum(abs(h20_6).^2);
E40_6 = sum(abs(h40_6).^2);
E60_6 = sum(abs(h60_6).^2);
title(['h6 - E20=', num2str(E20_6), ' ;E40=', num2str(E40_6), '; E60=',num2str(E60_6)]);
xlabel('n(samples)');
ylabel('Amplitude');

subplot(2,2,4);
[z6,p6,k6] = tf2zpk (num6,den6);
zplane(z6,p6);
title('H6');
