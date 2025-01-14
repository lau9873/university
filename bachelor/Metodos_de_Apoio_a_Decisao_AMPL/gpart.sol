Problem:    gpart
Rows:       22
Columns:    16 (16 integer, 16 binary)
Non-zeros:  76
Status:     INTEGER OPTIMAL
Objective:  z = 4 (MINimum)

   No.   Row name        Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 z                           4                             
     2 Equipart                    3             3             = 
     3 AcrossLR[a,e]
                                   0                          -0 
     4 AcrossLR[a,d]
                                   0                          -0 
     5 AcrossLR[a,b]
                                   0                          -0 
     6 AcrossLR[b,c]
                                   0                          -0 
     7 AcrossLR[b,e]
                                   0                          -0 
     8 AcrossLR[c,d]
                                   0                          -0 
     9 AcrossLR[c,f]
                                   0                          -0 
    10 AcrossLR[d,e]
                                  -2                          -0 
    11 AcrossLR[d,f]
                                   0                          -0 
    12 AcrossLR[e,f]
                                   0                          -0 
    13 AcrossRL[a,e]
                                   0                          -0 
    14 AcrossRL[a,d]
                                  -2                          -0 
    15 AcrossRL[a,b]
                                   0                          -0 
    16 AcrossRL[b,c]
                                  -2                          -0 
    17 AcrossRL[b,e]
                                   0                          -0 
    18 AcrossRL[c,d]
                                   0                          -0 
    19 AcrossRL[c,f]
                                   0                          -0 
    20 AcrossRL[d,e]
                                   0                          -0 
    21 AcrossRL[d,f]
                                   0                          -0 
    22 AcrossRL[e,f]
                                  -2                          -0 

   No. Column name       Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 x[a]         *              1             0             1 
     2 x[b]         *              1             0             1 
     3 x[c]         *              0             0             1 
     4 x[d]         *              0             0             1 
     5 x[e]         *              1             0             1 
     6 x[f]         *              0             0             1 
     7 y[a,e]       *              0             0             1 
     8 y[a,d]       *              1             0             1 
     9 y[a,b]       *              0             0             1 
    10 y[b,c]       *              1             0             1 
    11 y[b,e]       *              0             0             1 
    12 y[c,d]       *              0             0             1 
    13 y[c,f]       *              0             0             1 
    14 y[d,e]       *              1             0             1 
    15 y[d,f]       *              0             0             1 
    16 y[e,f]       *              1             0             1 

Integer feasibility conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
