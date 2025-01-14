var A in {39, 6, 75, 88, 15, 57};
var B in {9, 2, 58, 68, 48, 64};
var C in {28, 55, 16, 67, 8, 91};
var D in {40, 54, 66, 22, 32, 25};
var E in {49, 1, 17, 41, 14, 30};
var F in {44, 63, 10, 83, 46, 3};


subject to
SUM: A + B + C + D + E + F = 419;


solve;
display A,B,C,D,E,F;
display A + B + C + D + E + F;