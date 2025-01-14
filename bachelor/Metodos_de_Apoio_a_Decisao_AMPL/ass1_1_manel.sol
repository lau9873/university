Problem:    ass1_1_manel
Rows:       24
Columns:    23
Non-zeros:  72
Status:     OPTIMAL
Objective:  Profit = 119070 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 Profit       B         119070                             
     2 REVENUE      NS             0            -0             =             1 
     3 PCOST        NS             0            -0             =            -1 
     4 ADCOST       NS             0            -0             =            -1 
     5 DISTCOST     NS             0            -0             =            -1 
     6 BLENDCOST    NS             0            -0             =            -1 
     7 TOTALCOST    NS             0            -0             =            -1 
     8 DISTILL_CAPACITY
                    NU         14000                       14000          0.98 
     9 AD_DEMAND[G1]
                    NS          3000          3000             =         -29.8 
    10 AD_DEMAND[G2]
                    NS          2000          2000             =        -14.85 
    11 AD_DEMAND[G3]
                    NS          1000          1000             =           0.1 
    12 CRUDE_PURCHASE[C1]
                    B           4000                        5000 
    13 CRUDE_PURCHASE[C2]
                    NU          5000                        5000         19.92 
    14 CRUDE_PURCHASE[c3]
                    NU          5000                        5000         24.95 
    15 OCTANE[G1]   NL             0            -0                      -24.95 
    16 OCTANE[G2]   NL             0            -0                      -24.95 
    17 OCTANE[G3]   NL             0            -0                      -24.95 
    18 CRUDE_DISTILL[NAPHTHA]
                    NS             0            -0             =          98.8 
    19 CRUDE_DISTILL[OIL]
                    NS             0            -0             =            -1 
    20 INTERM_QUANTITY[NAPHTHA]
                    NU             0                          -0          99.8 
    21 INTERM_QUANTITY[OIL]
                    B          -1880                          -0 
    22 BLENDING[G1] NS             0            -0             =        -149.7 
    23 BLENDING[G2] NS             0            -0             =        -149.7 
    24 BLENDING[G3] NS             0            -0             =        -149.7 

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 d[C1]        B           4000             0               
     2 d[C2]        B           5000             0               
     3 d[c3]        B           5000             0               
     4 x[NAPHTHA,G1]
                    B           3000             0               
     5 x[OIL,G1]    B              0             0               
     6 x[NAPHTHA,G2]
                    B           1500             0               
     7 x[OIL,G2]    B            500             0               
     8 x[NAPHTHA,G3]
                    B           3250             0               
     9 x[OIL,G3]    B           3250             0               
    10 q[NAPHTHA]   B           7750             0               
    11 q[OIL]       B           5630             0               
    12 g[G1]        B           3000             0               
    13 g[G2]        B           2000             0               
    14 g[G3]        B           6500             0               
    15 ad[G1]       NL             0             0                        -299 
    16 ad[G2]       NL             0             0                      -149.5 
    17 ad[G3]       B            550             0               
    18 Revenue      B         655000                             
    19 Bcost        B          13380                             
    20 Dcost        B          42000                             
    21 Pcost        B         480000                             
    22 Acost        B            550                             
    23 Total_cost   B         535930                             

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 1.46e-11 on row 17
        max.rel.err = 1.40e-16 on row 17
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 2.84e-14 on column 4
        max.rel.err = 3.74e-15 on column 11
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
