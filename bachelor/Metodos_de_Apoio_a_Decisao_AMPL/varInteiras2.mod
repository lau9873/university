var x1>=0;
var x2>=0;
var x3>=0;

var y1 binary;
var y2 binary;
var y3 binary;

minimize z: 100000*y1+60000*y2+40000*y3+20*x1+30*x2+40*x3;
a: 0.4*x1 + 0.25*x2 + 0.20*x3 >= 80000;
b: 0.3*x1 + 0.2*x2 + 0.25*x3 >= 50000;
c: x1 <= 200000*y1;
d: x2 <= 320000*y2;
e: x3 <= 400000*y3;