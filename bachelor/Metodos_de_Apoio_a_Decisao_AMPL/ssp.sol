Problem:    ssp
Rows:       6
Columns:    6 (6 integer, 6 binary)
Non-zeros:  16
Status:     INTEGER OPTIMAL
Objective:  z = 3 (MAXimum)

   No.   Row name        Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 z                           3                             
     2 Edge[a,c]                   1                           1 
     3 Edge[a,f]                   1                           1 
     4 Edge[b,f]                   1                           1 
     5 Edge[b,d]                   1                           1 
     6 Edge[c,e]                   1                           1 

   No. Column name       Activity     Lower bound   Upper bound
------ ------------    ------------- ------------- -------------
     1 x[a]         *              1             0             1 
     2 x[b]         *              1             0             1 
     3 x[c]         *              0             0             1 
     4 x[d]         *              0             0             1 
     5 x[e]         *              1             0             1 
     6 x[f]         *              0             0             1 

Integer feasibility conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
