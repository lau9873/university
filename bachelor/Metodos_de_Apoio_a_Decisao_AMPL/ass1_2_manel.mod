set CRUDE;
set GAS;
set INTERM;

param advertising_demand;       
param distillationCostPerUnit;  
param blendingCostPerUnit;
param maxDistill;               
param CrackCostPerUnit;
param maxCrack;

param purchasePrice{CRUDE};
param percentages{CRUDE, INTERM};
param buyLimit{CRUDE};

param octane_rate{INTERM};

param sellingPrice{GAS};
param gas_rating{GAS};
param demand{GAS};


var d{i in CRUDE} >= 0;                 # number of crude i to buy
var g{j in GAS} >= 0;                   # number of gas j to produce
var q{k in INTERM} >= 0;                # number of interms after distillation of crude
var q1{k in INTERM} >= 0;               # number of interms used for blending
var ad{j in GAS} >= 0;                  # number of ads for gas j
var x{k in INTERM, j in GAS} >= 0;      # number of interms k to make gas j

var DistillCost >= 0;
var BlendingCost >= 0;
var AdCost >= 0;
var PurchaseCost >= 0;
var Revenue >= 0;
var TotalCost >= 0;
var CrackGas >= 0;                      # number of cracked gas barrels produced
var CrackCost >= 0;                     # cost of producing the barrels of cracked gas 
maximize Profit: Revenue - TotalCost;

REVENUE: Revenue = sum {j in GAS} sellingPrice[j] * g[j];
PURCHASECOST: PurchaseCost = sum {i in CRUDE} purchasePrice[i] * d[i];
BLENDINGCOST: BlendingCost = sum {k in INTERM} blendingCostPerUnit * q1[k];
DISTILLCOST: DistillCost = sum {i in CRUDE} d[i] * distillationCostPerUnit;
CRACKCOST: CrackCost = CrackGas * CrackCostPerUnit;
ADCOST: AdCost = sum {j in GAS} ad[j];
TOTAL: TotalCost = PurchaseCost + BlendingCost + DistillCost + AdCost + CrackCost;

subject to CRUDE_PURCHASE 
                            {i in CRUDE}: d[i] <= buyLimit[i];
subject to DISTILL_CAPACITY:  
                            sum {i in CRUDE} d[i] <= maxDistill;

subject to DISTILLATION {k in INTERM}:
                            q[k] = sum {i in CRUDE} d[i]*percentages[i,k];

subject to DEMAND {j in GAS}:
                            g[j] = demand[j] + ad[j]*advertising_demand;

subject to BLENDING {j in GAS}:
                            g[j] = sum{k in INTERM} x[k,j];

subject to INTERM_BOUNDS {k in INTERM}: 
                            q1[k] >= sum {j in GAS} x[k,j];

subject to OCTANE {j in GAS}:
                            sum {k in INTERM} x[k,j] * octane_rate[k] >= sum {k in INTERM} x[k,j] * gas_rating[j]; 

subject to OIL_FOR_BLENDING:
                            q1['OIL'] = q['OIL'] - CrackGas;    

subject to CGAS_FOR_BLENDING:
                            q1['CGAS'] = CrackGas;

subject to NAPHTHA_FOR_BLENDING:
                            q1['NAPHTHA'] = q['NAPHTHA'];

subject to CRACK_CAPACITY:
                            q1['CGAS'] <= maxCrack;