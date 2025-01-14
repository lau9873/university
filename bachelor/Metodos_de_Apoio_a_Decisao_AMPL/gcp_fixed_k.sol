Problem:    gcp_fixed_k
Rows:       48
Columns:    37 (37 integer, 37 binary)
Non-zeros:  151
Status:     INTEGER OPTIMAL
Objective:  Z = 5 (MINimum)

   No.   Row name        Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 Z                           5                             
     2 Color[1]                    1             1             = 
     3 Color[2]                    1             1             = 
     4 Color[3]                    1             1             = 
     5 Color[4]                    1             1             = 
     6 Color[5]                    1             1             = 
     7 Color[6]                    1             1             = 
     8 Color[7]                    1             1             = 
     9 Color[8]                    1             1             = 
    10 Color[9]                    1             1             = 
    11 BadEdge[1,2,1]
                                   1                           1 
    12 BadEdge[1,2,2]
                                   1                           1 
    13 BadEdge[1,3,1]
                                   1                           1 
    14 BadEdge[1,3,2]
                                   1                           1 
    15 BadEdge[1,8,1]
                                   1                           1 
    16 BadEdge[1,8,2]
                                   1                           1 
    17 BadEdge[1,9,1]
                                  -1                           1 
    18 BadEdge[1,9,2]
                                   1                           1 
    19 BadEdge[2,3,1]
                                   1                           1 
    20 BadEdge[2,3,2]
                                  -1                           1 
    21 BadEdge[2,4,1]
                                   1                           1 
    22 BadEdge[2,4,2]
                                   1                           1 
    23 BadEdge[2,5,1]
                                   1                           1 
    24 BadEdge[2,5,2]
                                   1                           1 
    25 BadEdge[2,7,1]
                                   1                           1 
    26 BadEdge[2,7,2]
                                   1                           1 
    27 BadEdge[2,9,1]
                                   1                           1 
    28 BadEdge[2,9,2]
                                   1                           1 
    29 BadEdge[3,4,1]
                                   1                           1 
    30 BadEdge[3,4,2]
                                   1                           1 
    31 BadEdge[3,9,1]
                                   1                           1 
    32 BadEdge[3,9,2]
                                   1                           1 
    33 BadEdge[4,6,1]
                                   1                           1 
    34 BadEdge[4,6,2]
                                   1                           1 
    35 BadEdge[4,7,1]
                                  -1                           1 
    36 BadEdge[4,7,2]
                                   1                           1 
    37 BadEdge[5,6,1]
                                   1                           1 
    38 BadEdge[5,6,2]
                                   1                           1 
    39 BadEdge[5,7,1]
                                  -1                           1 
    40 BadEdge[5,7,2]
                                   1                           1 
    41 BadEdge[5,8,1]
                                   1                           1 
    42 BadEdge[5,8,2]
                                   1                           1 
    43 BadEdge[6,8,1]
                                   1                           1 
    44 BadEdge[6,8,2]
                                  -1                           1 
    45 BadEdge[7,8,1]
                                   1                           1 
    46 BadEdge[7,8,2]
                                   1                           1 
    47 BadEdge[8,9,1]
                                   1                           1 
    48 BadEdge[8,9,2]
                                   1                           1 

   No. Column name       Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 x[1,1]       *              0             0             1 
     2 x[1,2]       *              1             0             1 
     3 x[2,1]       *              1             0             1 
     4 x[2,2]       *              0             0             1 
     5 x[3,1]       *              1             0             1 
     6 x[3,2]       *              0             0             1 
     7 x[4,1]       *              0             0             1 
     8 x[4,2]       *              1             0             1 
     9 x[5,1]       *              0             0             1 
    10 x[5,2]       *              1             0             1 
    11 x[6,1]       *              1             0             1 
    12 x[6,2]       *              0             0             1 
    13 x[7,1]       *              0             0             1 
    14 x[7,2]       *              1             0             1 
    15 x[8,1]       *              1             0             1 
    16 x[8,2]       *              0             0             1 
    17 x[9,1]       *              0             0             1 
    18 x[9,2]       *              1             0             1 
    19 z[1,2]       *              0             0             1 
    20 z[1,3]       *              0             0             1 
    21 z[1,8]       *              0             0             1 
    22 z[1,9]       *              1             0             1 
    23 z[2,3]       *              1             0             1 
    24 z[2,4]       *              0             0             1 
    25 z[2,5]       *              0             0             1 
    26 z[2,7]       *              0             0             1 
    27 z[2,9]       *              0             0             1 
    28 z[3,4]       *              0             0             1 
    29 z[3,9]       *              0             0             1 
    30 z[4,6]       *              0             0             1 
    31 z[4,7]       *              1             0             1 
    32 z[5,6]       *              0             0             1 
    33 z[5,7]       *              1             0             1 
    34 z[5,8]       *              0             0             1 
    35 z[6,8]       *              1             0             1 
    36 z[7,8]       *              0             0             1 
    37 z[8,9]       *              0             0             1 

Integer feasibility conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
