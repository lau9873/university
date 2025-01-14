set V;
set E within {V,V};

var x {V} binary;

maximize z: sum {i in V} x[i];

subject to
Edge {(i,j) in E}: x[i] + x[j] <= 1;
