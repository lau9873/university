Problem:    ass1_2_manel
Rows:       31
Columns:    32
Non-zeros:  91
Status:     OPTIMAL
Objective:  Profit = 352250.8889 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 Profit       B         352251                             
     2 REVENUE      NS             0            -0             =             1 
     3 PURCHASECOST NS             0            -0             =            -1 
     4 BLENDINGCOST NS             0            -0             =            -1 
     5 DISTILLCOST  NS             0            -0             =            -1 
     6 CRACKCOST    NS             0            -0             =            -1 
     7 ADCOST       NS             0            -0             =            -1 
     8 TOTAL        NS             0            -0             =            -1 
     9 CRUDE_PURCHASE[C1]
                    B           4000                        5000 
    10 CRUDE_PURCHASE[C2]
                    NU          5000                        5000       14.2051 
    11 CRUDE_PURCHASE[c3]
                    NU          5000                        5000       22.7738 
    12 DISTILL_CAPACITY
                    NU         14000                       14000       14.6413 
    13 DISTILLATION[NAPHTHA]
                    NS             0            -0             =          68.9 
    14 DISTILLATION[OIL]
                    NS             0            -0             =       67.1222 
    15 DISTILLATION[CGAS]
                    NS             0            -0             =         < eps
    16 DEMAND[G1]   NS          3000          3000             =           0.1 
    17 DEMAND[G2]   NS          2000          2000             =      -9.45556 
    18 DEMAND[G3]   NS          1000          1000             =      -19.0111 
    19 BLENDING[G1] NS             0            -0             =          69.9 
    20 BLENDING[G2] NS             0            -0             =       69.4556 
    21 BLENDING[G3] NS             0            -0             =       69.0111 
    22 INTERM_BOUNDS[NAPHTHA]
                    NL             0            -0                       -69.9 
    23 INTERM_BOUNDS[OIL]
                    NL             0            -0                    -68.1222 
    24 INTERM_BOUNDS[CGAS]
                    NL             0            -0                    -72.1222 
    25 OCTANE[G1]   NL             0            -0                   -0.444444 
    26 OCTANE[G2]   NL             0            -0                   -0.444444 
    27 OCTANE[G3]   NL             0            -0                   -0.444444 
    28 OIL_FOR_BLENDING
                    NS             0            -0             =       67.1222 
    29 CGAS_FOR_BLENDING
                    NS             0            -0             =       71.1222 
    30 NAPHTHA_FOR_BLENDING
                    NS             0            -0             =          68.9 
    31 CRACK_CAPACITY
                    B        2057.78                        3500 

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 d[C1]        B           4000             0               
     2 d[C2]        B           5000             0               
     3 d[c3]        B           5000             0               
     4 g[G1]        B          10380             0               
     5 g[G2]        B           2000             0               
     6 g[G3]        B           1000             0               
     7 q[NAPHTHA]   B           7750             0               
     8 q[OIL]       B           5630             0               
     9 q[CGAS]      B              0             0               
    10 q1[NAPHTHA]  B           7750             0               
    11 q1[OIL]      B        3572.22             0               
    12 q1[CGAS]     B        2057.78             0               
    13 ad[G1]       B            738             0               
    14 ad[G2]       NL             0             0                    -95.5556 
    15 ad[G3]       NL             0             0                    -191.111 
    16 x[NAPHTHA,G1]
                    B           5750             0               
    17 x[OIL,G1]    B        2572.22             0               
    18 x[CGAS,G1]   B        2057.78             0               
    19 x[NAPHTHA,G2]
                    B           1500             0               
    20 x[OIL,G2]    B            500             0               
    21 x[CGAS,G2]   NL             0             0                       < eps
    22 x[NAPHTHA,G3]
                    B            500             0               
    23 x[OIL,G3]    B            500             0               
    24 x[CGAS,G3]   NL             0             0                       < eps
    25 DistillCost  B          42000             0               
    26 BlendingCost B          13380             0               
    27 AdCost       B            738             0               
    28 PurchaseCost B         480000             0               
    29 Revenue      B         896600             0               
    30 TotalCost    B         544349             0               
    31 CrackGas     B        2057.78             0               
    32 CrackCost    B        8231.11             0               

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 9.09e-13 on row 13
        max.rel.err = 2.27e-16 on row 17
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 1.42e-14 on column 31
        max.rel.err = 9.92e-17 on column 31
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
