set programmers;
set skills;
set tasks;


param skills_programmer {skills, programmers} default 0;
param hours{programmers};
param cost_hour{programmers};
param lucros{tasks};
param requer {tasks, skills} default 0;

var x {programmers,tasks} >=0;
var y {programmers, tasks} binary;

var lucro;
var despesa;
var horas_nec{tasks};

l: lucro = sum {i in programmers} sum {j in tasks} y[i,j]*lucros[j];
d: despesa = sum {i in programmers} sum {j in tasks} x[i,j]* cost_hour[i];

maximize z: lucro - despesa;
h{j in tasks}: horas_nec[j]= sum{i in skills} requer[j,i];
xi{i in programmers, j in tasks }: x[i,j]=y[i,j]*horas_nec[j];
totalpessoa {i in programmers}: sum{j in tasks} x[i,j]<= hours[i];
yi{i in programmers, j in tasks}: y[i,j]<= prod{s in skills} requer[j,s]*skills_programmer[i,s];




