set jogadores;
 
param Manuseio{jogadores};
param Arremesso{jogadores};
param Rebote{jogadores};
param Defesa{jogadores};

var x {jogadores} binary;
var y1 binary;
var y2 binary;

maximize z: sum {i in jogadores} Defesa[i]*x[i];
o: sum{i in jogadores} x[i]<=5;
a: x[1]+x[3]+x[5]+x[7]>=4;
b: x[3]+x[4]+x[5]+x[6]+x[7]>=2;
c: x[2]+x[4]+x[5]+x[6]>=1;
d: sum{i in jogadores} Arremesso[i]*x[i]>=2;
e: sum{i in jogadores} Rebote[i]*x[i]>=2;
f: sum{i in jogadores} Manuseio[i]*x[i]>=2;
g: x[2]+x[3]>=1;
h: x[6]<=y1;
i: x[3]<=1-y1;
j: -x[4]-x[5]+2<=2*y2;
k: x[1] <= 2*(1-y2);