#include <stdlib.h>
#include <math.h>
#include "vector.h"
vector* vector_scale(double a, vector* b){
    return vector_new(a*b->x, a*b->y, a*b->z);
};
