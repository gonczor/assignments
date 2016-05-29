#include "tasks.h"

int get_number_of_digits(int number)
{
    int nod = 0;
    while(number > 0)
    {
        nod++;
        number /= 10;
    }
    return nod;
}

int square(int num)
{
    return num*num;
}

void task8()
{
    int start, stop;
    printf("Podaj zakres: ");
    scanf("%d %d", &start, &stop);
    int range[stop-start+1];
    int i;
    for (i = 0; i < stop-start+1; i++)
        range[i] = start + i;
    for(i = 0; i < stop-start+1; i++)
    {
        printf("%d: ", range[i]);
        int nod = get_number_of_digits(range[i]);
        int test = 10 * nod;
        if((square(range[i])-range[i]) % test == 0)
            printf("Yes\n");
        else
            printf("No\n");
    }
    printf("\n");
}
