#include "tasks.h"

void function()
{
    char c;
    if((c = getchar()) != '\n')
        function();
    printf("%c", c);
}

void task7()
{
    printf("Napisz cos.\n");
    function();
    printf("\n");
}
