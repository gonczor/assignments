#include "tasks.h"

int multiply(int a, int b)
{
    if(b == 1)
        return a;
    else
        return a + multiply(a, b-1);
}

task5()
{
    int a, b, power = 0;
    printf("Podaj 1 liczbe: ");
    scanf("%d", &a);
    printf("Podaj 2 liczbe: ");
    scanf("%d", &b);
    int mul = multiply(a, b);
    printf("Wynik: %d\n", mul);
}
