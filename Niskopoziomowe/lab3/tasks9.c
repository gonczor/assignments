#include "tasks.h"

void task9()
{
    char num[] = "12.56";

    int i = 0;
    int sum = 0;

    while(num[i] != '.')
        i++;

    while(num[i] != '\0')
    {
        sum += (int)(num[i]) - 48;
        i++;
    }

    printf( "The sum is %d.\n", sum );
}
