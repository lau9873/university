var F1;
var F2;
var F3;
subject to Pol1: 0.1*F1 + 0.2*F2 + 0.4*F3 >= 30;
subject to Pol2: 0.45*F1 + 0.25*F2 + 0.3*F3 >= 40;
LimiteA: 0 <= F1;  
LimiteA: 0 <= F2; 
LimiteA: 0 <= F3; 
maximize lucro: 15*F1 + 10*F2 + 20*F3;

