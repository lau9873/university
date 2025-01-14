#include <stdlib.h>
#include <math.h>
#include "vector.h"
double  vector_mod(vector* a){
    return sqrt(a->x*a->x+a->y*a->y+a->z*a->z);
};