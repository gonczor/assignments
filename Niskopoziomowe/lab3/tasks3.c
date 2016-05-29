#include "tasks.h"

const int STUDENTS_NUMBER = 10;
int array_pointer;

void show_data(Student *s)
{
    int i;
    printf("Album nazwisko imie ocena\n");
    for(i = 0; i < array_pointer; i++)
    {
       printf("%d\n%s%s%lf\n", (s+i)->album, (s+i)->surname, (s+i)->name, (s+i)->grade);
    }
}

void enter_data(Student *s)
{
    char n[BUFFER_SIZE];
    printf("Nazwisko: ");
    fgets((s+array_pointer)->surname, BUFFER_SIZE, stdin);
    printf("Imie: ");
    fgets((s+array_pointer)->name, BUFFER_SIZE, stdin);
    printf("Ocena: ");
    fgets(n, BUFFER_SIZE, stdin);
    (s+array_pointer)->grade = atof(n);
    printf("Nr albumu: ");
    fgets(n, BUFFER_SIZE, stdin);
    (s+array_pointer)->album = atoi(n);
    array_pointer++;
}

void modify_data(Student *s)
{
    char n[BUFFER_SIZE];
    int album;
    printf("Podaj numer albumu: ");
    fgets(n, BUFFER_SIZE, stdin);
    album = atoi(n);

    int i = 0;
    while(i < array_pointer && album != (s+i)->album)
        i++;

    printf("Nazwisko: ");
    fgets((s+i)->surname, BUFFER_SIZE, stdin);
    printf("Imie: ");
    fgets((s+i)->name, BUFFER_SIZE, stdin);
    printf("Ocena: ");
    fgets(n, BUFFER_SIZE, stdin);
    (s+i)->grade = atof(n);
    printf("Nr albumu: ");
    fgets(n, BUFFER_SIZE, stdin);
    (s+i)->album = atoi(n);
}

void show_statistics(Student *s)
{
    double max, min, avg = 0.0;
    min = max = s->grade;
    int i;
    for(i = 0; i < array_pointer; i++)
    {
        if(max < (s+i)->grade)
            max = (s+i)->grade;
        if(min > (s+i)->grade)
            min = (s+i)->grade;
        avg += (s+i)->grade;
    }
    avg /= array_pointer;

    printf("min: %f, max: %f, avg:%f\n", min, max, avg);
}

void delete_data(Student *s)
{
    free(s);
    array_pointer = 0;
}

void task3()
{
    printf("Uzywanie:\n*p-pokz dane\n*w-wprowadz dane\n*m-wybierz i modyfikuj\
    dane studenta\n*s-wyswietl statystyki grupy\n*d-usun dane\n*k-zakoncz program\n");
    char instruction;
    char c;
    Student students[STUDENTS_NUMBER];

    while (instruction != 'k')
    {
        instruction = getchar();
        c = getchar();
        switch (instruction) {
        case 'p':
            show_data(students);
            break;
        case 'w':
            enter_data(students);
            break;
        case 'm':
            modify_data(students);
            break;
        case 's':
            show_statistics(students);
            break;
        case 'd':
            delete_data(students);
            break;
        case 'k':
            break;
        default:
            printf("Nieznana instrukcja.\n");
            break;
        }
    }
}
