var x1 >= 0;
var x2 >= 0;
var x3 >= 0;
var x4 >= 0;
var x5 >= 0;
var x6 >= 0;

minimize tempo: x6-x1;
a: x3 >= x1 + 6;
b: x2 >= x1 + 9;
fict: x3 >= x2;
c: x5 >= x3 + 8;
d: x4 >= x3 + 7;
e: x5 >= x4 + 10;
f: x6 >= x5 + 12;