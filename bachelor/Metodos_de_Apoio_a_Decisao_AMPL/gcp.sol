Problem:    gcp
Rows:       72
Columns:    42 (42 integer, 42 binary)
Non-zeros:  232
Status:     INTEGER OPTIMAL
Objective:  K = 3 (MINimum)

   No.   Row name        Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 K                           3                             
     2 Color[a]                    1             1             = 
     3 Color[b]                    1             1             = 
     4 Color[c]                    1             1             = 
     5 Color[d]                    1             1             = 
     6 Color[e]                    1             1             = 
     7 Color[f]                    1             1             = 
     8 Edge[a,e,1]                -1                          -0 
     9 Edge[a,e,2]                 0                          -0 
    10 Edge[a,e,3]                 0                          -0 
    11 Edge[a,e,4]                 0                          -0 
    12 Edge[a,e,5]                 0                          -0 
    13 Edge[a,e,6]                 0                          -0 
    14 Edge[a,d,1]                 0                          -0 
    15 Edge[a,d,2]                 0                          -0 
    16 Edge[a,d,3]                -1                          -0 
    17 Edge[a,d,4]                 0                          -0 
    18 Edge[a,d,5]                 0                          -0 
    19 Edge[a,d,6]                 0                          -0 
    20 Edge[a,b,1]                 0                          -0 
    21 Edge[a,b,2]                 0                          -0 
    22 Edge[a,b,3]                -1                          -0 
    23 Edge[a,b,4]                 0                          -0 
    24 Edge[a,b,5]                 0                          -0 
    25 Edge[a,b,6]                 0                          -0 
    26 Edge[b,c,1]                 0                          -0 
    27 Edge[b,c,2]                -1                          -0 
    28 Edge[b,c,3]                 0                          -0 
    29 Edge[b,c,4]                 0                          -0 
    30 Edge[b,c,5]                 0                          -0 
    31 Edge[b,c,6]                 0                          -0 
    32 Edge[b,e,1]                 0                          -0 
    33 Edge[b,e,2]                -1                          -0 
    34 Edge[b,e,3]                 0                          -0 
    35 Edge[b,e,4]                 0                          -0 
    36 Edge[b,e,5]                 0                          -0 
    37 Edge[b,e,6]                 0                          -0 
    38 Edge[c,d,1]                 0                          -0 
    39 Edge[c,d,2]                -1                          -0 
    40 Edge[c,d,3]                 0                          -0 
    41 Edge[c,d,4]                 0                          -0 
    42 Edge[c,d,5]                 0                          -0 
    43 Edge[c,d,6]                 0                          -0 
    44 Edge[c,f,1]                -1                          -0 
    45 Edge[c,f,2]                 0                          -0 
    46 Edge[c,f,3]                 0                          -0 
    47 Edge[c,f,4]                 0                          -0 
    48 Edge[c,f,5]                 0                          -0 
    49 Edge[c,f,6]                 0                          -0 
    50 Edge[d,e,1]                 0                          -0 
    51 Edge[d,e,2]                -1                          -0 
    52 Edge[d,e,3]                 0                          -0 
    53 Edge[d,e,4]                 0                          -0 
    54 Edge[d,e,5]                 0                          -0 
    55 Edge[d,e,6]                 0                          -0 
    56 Edge[d,f,1]                 0                          -0 
    57 Edge[d,f,2]                 0                          -0 
    58 Edge[d,f,3]                -1                          -0 
    59 Edge[d,f,4]                 0                          -0 
    60 Edge[d,f,5]                 0                          -0 
    61 Edge[d,f,6]                 0                          -0 
    62 Edge[e,f,1]                -1                          -0 
    63 Edge[e,f,2]                 0                          -0 
    64 Edge[e,f,3]                 0                          -0 
    65 Edge[e,f,4]                 0                          -0 
    66 Edge[e,f,5]                 0                          -0 
    67 Edge[e,f,6]                 0                          -0 
    68 NoSym[1]                    0            -0               
    69 NoSym[2]                    0            -0               
    70 NoSym[3]                    1            -0               
    71 NoSym[4]                    0            -0               
    72 NoSym[5]                    0            -0               

   No. Column name       Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 x[a,1]       *              0             0             1 
     2 x[a,2]       *              1             0             1 
     3 x[a,3]       *              0             0             1 
     4 x[a,4]       *              0             0             1 
     5 x[a,5]       *              0             0             1 
     6 x[a,6]       *              0             0             1 
     7 x[b,1]       *              1             0             1 
     8 x[b,2]       *              0             0             1 
     9 x[b,3]       *              0             0             1 
    10 x[b,4]       *              0             0             1 
    11 x[b,5]       *              0             0             1 
    12 x[b,6]       *              0             0             1 
    13 x[c,1]       *              0             0             1 
    14 x[c,2]       *              0             0             1 
    15 x[c,3]       *              1             0             1 
    16 x[c,4]       *              0             0             1 
    17 x[c,5]       *              0             0             1 
    18 x[c,6]       *              0             0             1 
    19 x[d,1]       *              1             0             1 
    20 x[d,2]       *              0             0             1 
    21 x[d,3]       *              0             0             1 
    22 x[d,4]       *              0             0             1 
    23 x[d,5]       *              0             0             1 
    24 x[d,6]       *              0             0             1 
    25 x[e,1]       *              0             0             1 
    26 x[e,2]       *              0             0             1 
    27 x[e,3]       *              1             0             1 
    28 x[e,4]       *              0             0             1 
    29 x[e,5]       *              0             0             1 
    30 x[e,6]       *              0             0             1 
    31 x[f,1]       *              0             0             1 
    32 x[f,2]       *              1             0             1 
    33 x[f,3]       *              0             0             1 
    34 x[f,4]       *              0             0             1 
    35 x[f,5]       *              0             0             1 
    36 x[f,6]       *              0             0             1 
    37 y[1]         *              1             0             1 
    38 y[2]         *              1             0             1 
    39 y[3]         *              1             0             1 
    40 y[4]         *              0             0             1 
    41 y[5]         *              0             0             1 
    42 y[6]         *              0             0             1 

Integer feasibility conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
