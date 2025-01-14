set V;
param c {i in V, j in V: i < j};
param n;   # number of cutting planes
set S {1..n} within V;

var x {i in V, j in V: i<j} binary;

minimize z: sum {i in V, j in V: i < j} c[i,j] * x[i,j];

subject to
Degree {i in V}:
    sum {j in V: j < i} x[j,i] + sum {j in V: j > i} x[i,j] = 2;
Sep {k in 1..n}:
    sum {i in S[k], j in S[k]: i < j} x[i,j] <= card(S[k]) - 1;