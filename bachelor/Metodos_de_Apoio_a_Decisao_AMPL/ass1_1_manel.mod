set CRUDE;
set GAS;
set INTERM;

param advertising_demand;       
param destillationCostPerUnit;  
param blendingCostPerUnit;
param maxDistill;               


param purchasePrice{CRUDE};
param percentages{CRUDE, INTERM};
param buyLimit{CRUDE};

param octane_rate{INTERM};

param sellingPrice{GAS};
param gas_rating{GAS};
param demand{GAS};


var d{i in CRUDE} >= 0;             # barrels of crude i to buy
var x{k in INTERM, j in GAS} >= 0;  # barrels of intermediate produck k to produce gas j
var q{k in INTERM} >= 0;            # barrels of intermediate k obtained after distillation of the crudes 
var g{j in GAS} >= 0;               # barrels of gas j to produce
var ad{j in GAS} >= 0;              # number of ads for every type of gas
var Revenue;                        # gas sales revenue
var Bcost;                          # interm blending cost
var Dcost;                          # crude distillation cost
var Pcost;                          # crude purchase cost
var Acost;                          # advertising cost
var Total_cost;                     

maximize Profit: Revenue - Total_cost;

REVENUE: Revenue = sum {j in GAS} sellingPrice[j] * g[j];
PCOST: Pcost = sum{i in CRUDE} purchasePrice[i] * d[i];
ADCOST: Acost = sum {j in GAS} ad[j];
DISTCOST: Dcost =  sum{i in CRUDE} d[i] * destillationCostPerUnit;
BLENDCOST: Bcost = sum{k in INTERM} q[k] * blendingCostPerUnit;
TOTALCOST: Total_cost = Dcost+Bcost+Pcost+Acost;

subject to DISTILL_CAPACITY: 
                            sum{i in CRUDE} d[i] <= maxDistill;

subject to AD_DEMAND {j in GAS}: 
                                 g[j] = demand[j] + advertising_demand * ad[j];

subject to CRUDE_PURCHASE {i in CRUDE}:
                                        d[i] <= buyLimit[i];

subject to OCTANE {j in GAS}:
                         sum {k in INTERM} x[k,j] * octane_rate[k] >= gas_rating[j] * g[j];    

subject to CRUDE_DISTILL {k in INTERM}:
                                        q[k] = sum{i in CRUDE} d[i]*percentages[i,k];

subject to INTERM_QUANTITY {k in INTERM}:
                                         sum{j in GAS} x[k,j] <= q[k];

subject to BLENDING  {j in GAS}:  
                                g[j] = sum {k in INTERM} x[k,j];