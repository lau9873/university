set CRUDE;
set INTERM;
set GAS;


param barril_pub;
param custo_destilar1;
param custo_misturar1;
param max_destilar;

param percentages{CRUDE, INTERM};
param octane_rate_i{INTERM};
param octane_rate_g{GAS};
param min_barris{GAS};
param venda{GAS};

param compra{CRUDE};
param max_barris{CRUDE};

var barril_crude{i in CRUDE} >= 0;             
var barril_interm_gas{k in INTERM, j in GAS} >= 0;  
var barril_interm{k in INTERM} >= 0;            
var barril_gas{j in GAS} >= 0;                
var ad_para_gas{j in GAS} >= 0;              
var lucro_gas;                       
var custo_destilar;                         
var custo_misturar;                       
var custo_crude;                        
var custo_add;                          
var custos_totais;          

maximize lucros: lucro_gas - custos_totais;

lg: lucro_gas = sum{i in GAS} venda[i] * barril_gas[i];
cc: custo_crude = sum {i in CRUDE} compra[i]*barril_crude[i];
ca: custo_add = sum {i in GAS} ad_para_gas[i];
cd: custo_destilar = sum {i in CRUDE} barril_crude[i]* custo_destilar1 ;
cm: custo_misturar =  sum {i in INTERM} barril_interm[i]*custo_misturar1 ;
ct: custos_totais = custo_add + custo_crude + custo_misturar + custo_destilar;

subject to mbc: sum {i in CRUDE} barril_crude[i] <= max_destilar;
subject to g {j in GAS}: barril_gas[j] =  min_barris[j] + barril_pub*ad_para_gas[j];
subject to crude {i in CRUDE}: barril_crude[i]<=max_barris[i];
subject to octane {j in GAS}: sum {k in INTERM} barril_interm_gas[k,j]*octane_rate_i[k] >= barril_gas[j] * octane_rate_g[j];
subject to destilado {k in INTERM}: barril_interm[k] = sum {i in CRUDE} barril_crude[i]* percentages[i,k];
subject to interm {k in INTERM}: sum {i in GAS} barril_interm_gas[k,i] <= barril_interm[k];
subject to misturado {j in GAS}: barril_gas[j] = sum {k in INTERM} barril_interm_gas[k,j];


