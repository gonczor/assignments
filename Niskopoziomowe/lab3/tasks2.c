#include "tasks.h"
#include <limits.h>

void task2()
{
    const int n = 10;
    Bag bag[10];
    int index, field;

    for(index = 0; index < n; index++)
    {
        field = rand()%3;
        if(field == 0)
        {
            bag[index].i = rand()%100;
            printf("Integer: %d\n", bag[index].i);
        }
        else if(field == 1)
        {
            bag[index].f = (float)rand()/(float)(100);
            printf("Floating point: %f\n", bag[index].f);
        }
        else
        {
            bag[index].c = rand()%CHAR_MAX;
            printf("Character: %c\n", bag[index].c);
        }
    }
}
