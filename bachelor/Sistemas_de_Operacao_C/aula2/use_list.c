#include <stdio.h>
#include <stdlib.h>
#include "list.h"
int main(int argc, char** argv) {
  list* z1 = list_new();
  list_print(z1);
  list* z2 = list_new_random(5,10);
  list_print(z2);
  list_add_first(1,z1);
  list_print(z1);
  list_add_last(10,z1);
  list_print(z1);
  printf("primeiro elemento= %i, tamanho= %i\n",list_get_first(z1), list_size(z1));
  printf("ultimo elemento= %i\n",list_get_last(z1));
  list_remove_first(z1);
  list_print(z1);
  list_remove_last(z1);
  list_print(z1);
  return 0;
}