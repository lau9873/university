#include <stdlib.h>
#include <math.h>
#include "complex.h"
complex* complex_div(complex* z, complex* w){
    int i = w->x*w->x+w->y*w->y;
    return complex_new((z->x * w->x + z->y * w->y)/i,
                     (z->y * w->x - z->x * w->y)/i);
}