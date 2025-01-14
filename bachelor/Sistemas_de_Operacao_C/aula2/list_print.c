#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "list.h"
void list_print(list* l) {
  printf("[");
  node* p = l->first;
  int i;
  if (l->size>=1){
    for(i = 0; i < l->size-1; i++){
        printf(" %i,",p->val);
        p=p->next;
    }
    printf(" %i",p->val);  
  }
  printf("]\n");
}