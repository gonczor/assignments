#include "tasks.h"

task10()
{
    printf("Jak chcesz przedstawic wczytywana liczbe?:\n");
    printf("d-dziesietnie\ns-szesnastkowo\no-osemkowo\n");

    char c = getchar();
    char cn = getchar();
    int num;

    switch (c) {
    case 'd':
        scanf("%d", &num);
        break;
    case 's':
        scanf("%x", &num);
        break;
    case 'o':
        scanf("%o", &num);
        break;
    default:
        break;
    }

    printf("Jak chcesz przedstawic wypisywana liczbe?:\n");
    printf("d-dziesietnie\ns-szesnastkowo\no-osemkowo\n");

    cn=getchar();
    c = getchar();
    cn = getchar();

    switch (c) {
    case 'd':
        printf("%d\n", num);
        break;
    case 's':
        printf("%x\n", num);
        break;
    case 'o':
        printf("%o\n", num);
        break;
    default:
        break;
    }
}
