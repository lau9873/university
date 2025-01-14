set SKILLS;
set PROGRAMMERS;
set TASKS;

param lower;
param ProgTask;
param a {SKILLS, PROGRAMMERS} default 0;
param review {SKILLS, PROGRAMMERS} default 0;


param hours{PROGRAMMERS};
param costperhour{PROGRAMMERS};

param price{TASKS};

param hourspertask {TASKS, SKILLS} default 0;
param taskill {i in TASKS, s in SKILLS} := if hourspertask[i,s] = 0 then 0 else 1;  #If hourspertask > 0 means that the task i demands skill s

var Task {i in TASKS, k in PROGRAMMERS} binary;       # Task i is done by Programmer k
var ProgH {k in PROGRAMMERS} >= 0;                     # Number of hours of work to buy for each Programmer
var d {i in TASKS} binary;                         # Task d[i] = 1 means that Task#i is done, 0 otherwise

var TaskRevenue >= 0;
var ProgrammerCost >= 0;

maximize z : TaskRevenue - ProgrammerCost;

TASK {i in TASKS}: d[i] = sum{k in PROGRAMMERS} Task[i,k]; 
REV: TaskRevenue = sum{i in TASKS} d[i] * price[i];
PROGCOST: ProgrammerCost = sum{k in PROGRAMMERS} ProgH[k]*costperhour[k];

HOURS {k in PROGRAMMERS}: ProgH[k] = sum{i in TASKS} Task[i,k] * sum{s in SKILLS} hourspertask[i,s]; 
PROGHOURS {k in PROGRAMMERS}: ProgH[k] <= hours[k];
PROGPERTASK {i in TASKS}: sum{k in PROGRAMMERS} Task[i,k] <= ProgTask;
SKILL{i in TASKS, k in PROGRAMMERS, s in SKILLS}: Task[i,k] * taskill[i,s] <= Task[i,k] * a[s,k]; 
