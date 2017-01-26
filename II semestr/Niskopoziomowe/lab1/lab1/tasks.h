#ifndef TASKS_H
#define TASKS_H

double  task1();
double  task2();
double  task3();
double  task4();
double  task5();
char*   task6();
char*   task7();
char*   task8();
char*   task9();
char*   task10();
double  task11();
char*   task12();
char*   task13();
void    task14();
char*   task15();
void    task16(char *message);

typedef struct{
    double x;
    double y;
} Point;

typedef struct{
    Point point1, point2, point3, point4;
} Figure;

typedef struct{
    double a, b;
} Line;

typedef struct{
    double radius;
    double field, perimeter;
} Circle;

typedef struct{
    double side;
    double field, perimeter;
}Square;

typedef struct{
    double a, b;
    double field, perimeter;
}Rectangle;

typedef struct{
    double h, a, b, c;
    double field, perimeter;
}Triangle;

typedef struct{
    double h, a, b, c, d;
    double field, perimeter;
}Trapeze;
#endif // TASKS_H
