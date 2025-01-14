Problem:    otimizacaoLinear
Rows:       5
Columns:    8
Non-zeros:  39
Status:     OPTIMAL
Objective:  custos = 8820 (MINimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 custos       B           8820                             
     2 a[A]         NL           700           700                    0.181818 
     3 a[C]         B        1633.33           700               
     4 a[B1]        B            700           700               
     5 a[B2]        NL           700           700                     12.4182 

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 quantidades[bife]
                    NL             0             0                     121.818 
     2 quantidades[frango]
                    NL             0             0                     9.18182 
     3 quantidades[peixe]
                    NL             0             0                     103.364 
     4 quantidades[hamburger]
                    NL             0             0                     157.545 
     5 quantidades[macarrao]
                    B        46.6667             0               
     6 quantidades[empada]
                    B              0             0               
     7 quantidades[esparguete]
                    NL             0             0                     8.18182 
     8 quantidades[peru]
                    NL             0             0                     113.909 

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 2.84e-14 on column 2
        max.rel.err = 1.08e-16 on column 4
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
