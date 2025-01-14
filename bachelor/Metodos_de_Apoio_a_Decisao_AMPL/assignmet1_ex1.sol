Problem:    assignmet1_ex1
Rows:       24
Columns:    23
Non-zeros:  72
Status:     OPTIMAL
Objective:  lucros = 119070 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 lucros       B         119070                             
     2 lg           NS             0            -0             =             1 
     3 cc           NS             0            -0             =            -1 
     4 ca           NS             0            -0             =            -1 
     5 cd           NS             0            -0             =            -1 
     6 cm           NS             0            -0             =            -1 
     7 ct           NS             0            -0             =            -1 
     8 mbc          NU         14000                       14000          0.98 
     9 g[G1]        NS          3000          3000             =         -29.8 
    10 g[G2]        NS          2000          2000             =        -14.85 
    11 g[G3]        NS          1000          1000             =           0.1 
    12 crude[C1]    B           4000                        5000 
    13 crude[C2]    NU          5000                        5000         19.92 
    14 crude[C3]    NU          5000                        5000         24.95 
    15 octane[G1]   NL             0            -0                      -24.95 
    16 octane[G2]   NL             0            -0                      -24.95 
    17 octane[G3]   NL             0            -0                      -24.95 
    18 destilado[Naphtha]
                    NS             0            -0             =          98.8 
    19 destilado[Oil]
                    NS             0            -0             =            -1 
    20 interm[Naphtha]
                    NU             0                          -0          99.8 
    21 interm[Oil]  B          -1880                          -0 
    22 misturado[G1]
                    NS             0            -0             =        -149.7 
    23 misturado[G2]
                    NS             0            -0             =        -149.7 
    24 misturado[G3]
                    NS             0            -0             =        -149.7 

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 barril_crude[C1]
                    B           4000             0               
     2 barril_crude[C2]
                    B           5000             0               
     3 barril_crude[C3]
                    B           5000             0               
     4 barril_interm_gas[Naphtha,G1]
                    B           3000             0               
     5 barril_interm_gas[Oil,G1]
                    B              0             0               
     6 barril_interm_gas[Naphtha,G2]
                    B           1500             0               
     7 barril_interm_gas[Oil,G2]
                    B            500             0               
     8 barril_interm_gas[Naphtha,G3]
                    B           3250             0               
     9 barril_interm_gas[Oil,G3]
                    B           3250             0               
    10 barril_interm[Naphtha]
                    B           7750             0               
    11 barril_interm[Oil]
                    B           5630             0               
    12 barril_gas[G1]
                    B           3000             0               
    13 barril_gas[G2]
                    B           2000             0               
    14 barril_gas[G3]
                    B           6500             0               
    15 ad_para_gas[G1]
                    NL             0             0                        -299 
    16 ad_para_gas[G2]
                    NL             0             0                      -149.5 
    17 ad_para_gas[G3]
                    B            550             0               
    18 lucro_gas    B         655000                             
    19 custo_destilar
                    B          42000                             
    20 custo_misturar
                    B          13380                             
    21 custo_crude  B         480000                             
    22 custo_add    B            550                             
    23 custos_totais
                    B         535930                             

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
