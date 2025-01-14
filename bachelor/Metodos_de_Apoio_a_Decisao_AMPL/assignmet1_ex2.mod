set CRUDE;
set INTERM;
set GAS;
set INTERM_after; 


param barril_pub;
param custo_destilar1;
param custo_misturar1;
param max_destilar;
param custo_crack1;
param max_crack;


param percentages{CRUDE, INTERM};
param octane_rate_i{INTERM_after};
param octane_rate_g{GAS};
param min_barris{GAS};
param venda{GAS};

param compra{CRUDE};
param max_barris{CRUDE};

var barril_crude{i in CRUDE} >= 0;             # barrels of crude i to buy
var barril_interm_gas{k in INTERM_after, j in GAS} >= 0;  # barrels of intermediate produck k to produce gas j
var barril_interm{k in INTERM} >= 0;            # barrels of intermediate k obtained after distillation of the crudes before crack
var barril_interm_crack {k in INTERM_after} >= 0; # barrels of intermediate k obtained after distillation of the crudes after crack
var barril_gas{j in GAS} >= 0;               # barrels of gas j to produce
var ad_para_gas{j in GAS} >= 0;              # number of ads for every type of gas
var lucro_gas;                        # gas sales revenue
var custo_destilar;                          # interm blending cost
var custo_misturar;                          # crude distillation cost
var custo_crack;
var custo_crude;                          # crude purchase cost
var custo_add;                          # advertising cost
var custos_totais;          


maximize lucros:  lucro_gas - custos_totais;

lg: lucro_gas = sum{i in GAS} venda[i] * barril_gas[i];
cc: custo_crude = sum {i in CRUDE} compra[i]*barril_crude[i];
ca: custo_add = sum {i in GAS} ad_para_gas[i];
ccm: custo_destilar = custo_destilar1 * sum {i in CRUDE} barril_crude[i];
cm: custo_misturar = custo_misturar1 * sum {i in INTERM_after} barril_interm_crack[i];
ct: custos_totais = custo_add + custo_crude + custo_misturar + custo_destilar + custo_crack;
ccc : custo_crack = custo_crack1* sum { i in GAS} barril_interm_gas["Cracked" ,i]; 

subject to naphtha: barril_interm["Naphtha"]= barril_interm_crack["Naphtha"];
subject to oil: barril_interm["Oil"]=barril_interm_crack["Natural"]+barril_interm_crack["Cracked"];
subject to mc: barril_interm_crack["Cracked"]<= max_crack;

subject to mbc: sum {i in CRUDE} barril_crude[i] <= max_destilar;
subject to g {i in GAS}: barril_gas[i] =  min_barris[i] + barril_pub*ad_para_gas[i];
subject to crude {i in CRUDE}: barril_crude[i]<=max_barris[i];

/ subject to octane {j in GAS}: sum {k in INTERM_after} barril_interm_gas[k,j]*octane_rate_i[k] >= barril_gas[j] * octane_rate_g[j];
subject to destilado {k in INTERM}: barril_interm[k] = sum {i in CRUDE} barril_crude[i]* percentages[i,k];

/ subject to interm {k in INTERM_after}: sum {j in GAS} barril_interm_gas[k,j] <= barril_interm_crack[k];
/ subject to misturado {j in GAS}: barril_gas[j] = sum {k in INTERM_after} barril_interm_gas[k,j];




