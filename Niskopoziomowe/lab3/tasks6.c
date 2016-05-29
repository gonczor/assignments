#include "tasks.h"

int factorial(int);

task6()
{
    int num;
    printf("Podaj n: ");
    scanf("%d", &num);
    printf("Silnia: %d\n", factorial(num));
}

int factorial(int n)
{
    if(n>1)
       return n * factorial(n-1);
    else
        return 1;
}
