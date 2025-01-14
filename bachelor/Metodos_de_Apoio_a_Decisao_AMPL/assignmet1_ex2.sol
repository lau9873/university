Problem:    assignmet1_ex2
Rows:       29
Columns:    30
Non-zeros:  94
Status:     OPTIMAL
Objective:  lucros = 352250.8889 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 lucros       B         352251                             
     2 ccm          NS             0            -0             =            -1 
     3 cm           NS             0            -0             =            -1 
     4 ccc          NS             0            -0             =            -1 
     5 cc           NS             0            -0             =            -1 
     6 ca           NS             0            -0             =            -1 
     7 lg           NS             0            -0             =             1 
     8 ct           NS             0            -0             =            -1 
     9 nafhptha     NS             0            -0             =         -68.9 
    10 oil          NS             0            -0             =      -67.1222 
    11 mbc          NU         14000                       14000       14.6413 
    12 mc           B        2057.78                        3500 
    13 gas[G1]      NS          3000          3000             =           0.1 
    14 gas[G2]      NS          2000          2000             =      -9.45556 
    15 gas[G3]      NS          1000          1000             =      -19.0111 
    16 crude[C1]    B           4000                        5000 
    17 crude[C2]    NU          5000                        5000       14.2051 
    18 crude[C3]    NU          5000                        5000       22.7738 
    19 octane[G1]   NL             0            -0                   -0.444444 
    20 octane[G2]   NL             0            -0                   -0.444444 
    21 octane[G3]   NL             0            -0                   -0.444444 
    22 destilado[Naphtha]
                    NS             0            -0             =          68.9 
    23 destilado[Oil]
                    NS             0            -0             =       67.1222 
    24 interm[Naphtha]
                    NU             0                          -0          69.9 
    25 interm[Natural]
                    NU             0                          -0       68.1222 
    26 interm[Cracked]
                    NU             0                          -0       68.1222 
    27 misturado[G1]
                    NS             0            -0             =       65.4556 
    28 misturado[G2]
                    NS             0            -0             =       65.4556 
    29 misturado[G3]
                    NS             0            -0             =       65.4556 

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 barril_crude[C1]
                    B           4000             0               
     2 barril_crude[C2]
                    B           5000             0               
     3 barril_crude[C3]
                    B           5000             0               
     4 barril_interm_gas[Cracked,G1]
                    B        2057.78             0               
     5 barril_interm_gas[Cracked,G2]
                    NL             0             0                       < eps
     6 barril_interm_gas[Cracked,G3]
                    NL             0             0                       < eps
     7 barril_interm_gas[Naphtha,G1]
                    B           5750             0               
     8 barril_interm_gas[Natural,G1]
                    B        2572.22             0               
     9 barril_interm_gas[Naphtha,G2]
                    B           1500             0               
    10 barril_interm_gas[Natural,G2]
                    B            500             0               
    11 barril_interm_gas[Naphtha,G3]
                    B            500             0               
    12 barril_interm_gas[Natural,G3]
                    B            500             0               
    13 barril_interm[Naphtha]
                    B           7750             0               
    14 barril_interm[Oil]
                    B           5630             0               
    15 barril_interm_crack[Naphtha]
                    B           7750             0               
    16 barril_interm_crack[Natural]
                    B        3572.22             0               
    17 barril_interm_crack[Cracked]
                    B        2057.78             0               
    18 barril_gas[G1]
                    B          10380             0               
    19 barril_gas[G2]
                    B           2000             0               
    20 barril_gas[G3]
                    B           1000             0               
    21 ad_para_gas[G1]
                    B            738             0               
    22 ad_para_gas[G2]
                    NL             0             0                    -95.5556 
    23 ad_para_gas[G3]
                    NL             0             0                    -191.111 
    24 lucro_gas    B         896600                             
    25 custo_destilar
                    B          42000                             
    26 custo_misturar
                    B          13380                             
    27 custo_crack  B        8231.11                             
    28 custo_crude  B         480000                             
    29 custo_add    B            738                             
    30 custos_totais
                    B         544349                             

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 3.64e-12 on row 20
        max.rel.err = 1.01e-16 on row 20
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 2.84e-14 on column 14
        max.rel.err = 2.10e-16 on column 14
        High quality

KKT.DB: max.abs.err = 1.42e-14 on column 5
        max.rel.err = 1.42e-14 on column 5
        High quality

End of output
