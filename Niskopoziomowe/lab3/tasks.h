#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define BUFFER_SIZE 8
#define WRONG_INSTRUCTION_ERROR -1
#define WORKER_NOT_FOUND_ERROR -2

void task1();
void task2();
void task3();
void task5();
void task6();
void task7();
void task8();
void task9();
void task10();
void task12();

typedef struct {
    char surname[BUFFER_SIZE];
	int salary;
	int premium_percent;
}Worker;

typedef union {
    int i;
    char c;
    float f;
} Bag;

/*
prosty program, który umożliwi użytkownikowi:
a.
wprowadzenie i wyświetlenie danych grupy
n
studentów
–
dane należy przechowywać w
pamięci wykorzystując tablicę,
b.
modyfikację danych wybranego studenta,
c.
wyznacz
enie średniej, maksymalnej i minimalnej oceny dla grupy studentów,
d.
usunięcie danych o grupie studentów. */

typedef struct {
    char name[BUFFER_SIZE];
    char surname[BUFFER_SIZE];
    int album;
    double grade;
} Student;
