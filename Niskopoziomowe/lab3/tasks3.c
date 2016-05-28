#include "tasks.h"

const int STUDENTS_NUMBER = 10;
int array_pointer;

void show_data(Student *s)
{
    int i;
    for(i = 0; i < array_pointer; i++)
    {
       printf("%d\t%s\t%s%d\t%d\n");
    }
}

void enter_data(Student *s)
{
    printf("Dodawaj dane studentow. K konczy dodawanie.\n");
}

void modify_data(Student *s)
{

}

void show_statistics(Student *s)
{

}

void delete_data(Student *s)
{
    free(s);
    array_pointer = 0;
}

task3()
{
    printf("Uzywanie:\n*p-pokz dane\n*w-wprowadz dane\n*m-wybierz i modyfikuj\
    dane studenta\n*s-wyswietl statystyki grupy\n*d-usun dane\n*k-zakoncz program\n");
    char instruction = getchar();
    Student students[STUDENTS_NUMBER];
    while (instruction != 'k')
    {

    }
}
