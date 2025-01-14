Problem:    ex1
Rows:       5
Columns:    6
Non-zeros:  13
Status:     OPTIMAL
Objective:  lucro = 21 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 lucro        B             21                             
     2 a            NS            24            24             =          0.75 
     3 b            NS             6             6             =           0.5 
     4 c            NS             1             1             =         < eps
     5 d            NS             2             2             =         < eps

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 x1           B              3             0               
     2 x2           B            1.5             0               
     3 s1           NL             0             0                       -0.75 
     4 s2           NL             0             0                        -0.5 
     5 s3           B            2.5             0               
     6 s4           B            0.5             0               

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 8.88e-16 on column 1
        max.rel.err = 8.07e-17 on column 1
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
