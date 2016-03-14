#include "tasks.h"
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <time.h>

static double get_greatest(double, double, double);
static double fahrenheit_to_celsius(double);
static double celsius_to_fahrenheit(double);
static int users_choice_incorrect(char);
static int is_square(Figure);
static int sides_are_equall(double, double);
static double get_side_length(Point, Point);
static char* count_circle();
static char* count_triangle();
static char* count_square();
static char* count_rectangle();
static char* count_trapeze();
static int help(int, int, char);

double task1()
{
    double num1, num2, num3;
    printf("\n\nTask 1\n\n");
    printf("Enter three numbers.\n");
    scanf("%lf,", &num1);
    scanf("%lf,", &num2);
    scanf("%lf,", &num3);

    return get_greatest(num1, num2, num3);
}

double get_greatest(double num1, double num2, double num3)
{
    if(num1 >= num2 && num1 >= num3)
        return num1;
    else
    {
        if(num2 >= num1 && num2 >= num3)
            return num2;
        else
            return num3;
    }
}

double task2()
{
    int a = 1, b = 2;
    printf("\n\nTask 2\n\n");
    printf("This will compute an expression for default values a = %d, b = %d\n", a, b);
    return a * (a + b) / pow((a + b), 2);
}

double task3()
{
    float a = 0.0, b = 0.0;
    printf("\n\nTask 3\n\n");
    printf("Default values: a = %f, b = %f\n", a, b);
    return 4 * a + 2 * ((a - b -1) / (pow(a, 2) + pow(b, 2) + 1));
}

double task4()
{
    int m = 0, n = 1;
    printf("\n\nTask 4\n\n");
    printf("Default m = %d, n = %d\n", m, n);

    double denominator = 5 + (4 + (3 + 2 * (m - n - 1)));
    double numerator = (((2 * (m + n + 1) - 3) - 4) -5);
    return denominator / numerator;
}

double task5()
{
    double x = 1;
    printf("\n\nTask 5\n\n");
    printf("Default value of x = %lf\n", x);
    double numerator = pow(sin(pow(x, 3)), 2) + 1.25;
    double denominator = pow(cos(pow(x, 2)), 3) + 1.25;
    double main_denominator = log(pow(tan(x + 2), 2)) + 2.5;
    return sqrt(numerator / denominator) / main_denominator;
}

char* task6()
{
    printf("\n\nTask 6\n\n");
    char users_choice = 0;
    double temperature = 0.0;
    char s[64];
    do
    {
        printf("Please, enter c if you want to convert from fahrenheit to celsius and f if otherwise.\n");
        scanf("%c", &users_choice);
    }while(users_choice_incorrect(users_choice));

    printf("Enter the temperature\n");
    scanf("%lf", &temperature);

    if(users_choice == 'c' || users_choice == 'C')
    {
        sprintf(s, "%.2lf C", fahrenheit_to_celsius(temperature));
        return s;
    }
    else
    {
        sprintf(s, "%.2lf F", celsius_to_fahrenheit(temperature));
        return s;
    }
}

int users_choice_incorrect(char choice)
{
    if(choice == 'c' || choice == 'C' || choice == 'f' || choice == 'F')
        return 0;
    else
    {
        printf("Invalid choice. Try again\n");
        return 1;
    }
}

double fahrenheit_to_celsius(double temperature)
{
    return (5.0 / 9.0) * (temperature - 32.0);
}

double celsius_to_fahrenheit(double temperature)
{
    return 9.0 / 5.0 * temperature + 32.0;
}

char* task7()
{
    Figure figure;
    printf("\n\nTask 7\n\n");
    printf("Podaj wierzcholki\n");
    scanf("%lf", &figure.point1.x);
    scanf("%lf", &figure.point1.y);
    scanf("%lf", &figure.point2.x);
    scanf("%lf", &figure.point2.y);
    scanf("%lf", &figure.point3.x);
    scanf("%lf", &figure.point3.y);
    scanf("%lf", &figure.point4.x);
    scanf("%lf", &figure.point4.y);
    if (is_square(figure))
        return "Kwadrat";
    else
        return "Prostokat";

}

int is_square(Figure f)
{
    //Zakladamy, ze wprowadzonon kolejne wierzcholki i ze figura jest albo prostokatem, albo kwadratem,
    //czyli ma katy proste. Wowczas wystarczy porownac 2 sasiednie boki.
    double len_p1_p2 = get_side_length(f.point1, f.point2);
    double len_p2_p3 = get_side_length(f.point2, f.point3);
    if(sides_are_equall(len_p1_p2, len_p2_p3))
        return 1;
    else
        return 0;
}

static int sides_are_equall(double side_1_len, double side_2_len)
{
    //Ze wzgledu na to, ze double maja skonczona precyzje, musimy zostawic margines bledu.
    double u = 0.001;
    if(abs(side_1_len - side_2_len) < u)
        return 1;
    else
        return 0;
}

double get_side_length(Point p1, Point p2)
{
    double a = abs(p1.x - p2.x);
    double b = abs(p1.y - p2.y);
    return sqrt(pow(a, 2) + pow(b, 2));
}

char* task8()
{
    Line line1, line2;
    Point meeting_point;
    char s[512];
    printf("\n\nTask 8\n\n");
    printf("Podaj wspolczynnii a i b prostych.\n");
    scanf("%lf", &line1.a);
    scanf("%lf", &line1.b);
    scanf("%lf", &line2.a);
    scanf("%lf", &line2.b);
    if(line1.a == line2.a)
        return "Proste rownloegle, lub pokrywajce sie.";
    else
    {
        meeting_point.x = (line2.b - line1.b) / (line1.a - line2.a);
        meeting_point.y = meeting_point.x * line1.a + line1.b;
        sprintf(s, "x = %.2lf, y = %.2lf{", meeting_point.x, meeting_point.y);
        return s;
    }
}

char* task9()
{
    double a, b, c, delta, x1, x2;
    char s[512];
    printf("\n\nTask 9\n\n");
    printf("Podaj wspolczynnii a, b, c rownania kwadratowego.\n");
    scanf("%lf", &a);
    scanf("%lf", &b);
    scanf("%lf", &c);
    delta = pow(b, 2) - 4*a*c;
    if (delta < 0)
        return "Brak rozwiazan rzeczywistych";
    else if(delta == 0)
        x1 = x2 = b - (2 * a);
    else
    {
        x1 = (-b - sqrt(delta)) / (2 * a);
        x2 = (-b + sqrt(delta)) / (2 * a);
    }
    sprintf(s, "x1 = %.2lf, x2 = %.2lf", x1, x2);
    return s;
}

char* task10()
{
    char choice;
    printf("\n\nTask 10\n\n");
    printf("Wybierz, co chcesz liczyc.\n");
    printf("\t* 1 dla kola\n");
    printf("\t* 2 dla trojkata\n");
    printf("\t* 3 dla kwadratu\n");
    printf("\t* 4 dla prostokata\n");
    printf("\t* 5 dla trapezu\n");
    scanf("%c", &choice);
    switch (choice)
    {
        case '1':
            return count_circle();
        case '2':
            return count_triangle();
        case '3':
            return count_square();
        case '4':
            return count_rectangle();
        case '5':
            return count_trapeze();
        default:
            return "Bad entry.";
    }
}

char* count_circle()
{
    char s[512];
    Circle circle;
    printf("Podaj promien. r = ");
    scanf("%lf", &circle.radius);
    circle.field = M_PI * pow(circle.radius, 2);
    circle.perimeter = M_PI * 2 * circle.radius;
    sprintf(s, "P = %.2lf O = %.2lf", circle.field, circle.perimeter);
    return s;
}

char* count_rectangle()
{
    char s[512];
    Rectangle rectangle;
    printf("Podaj dlugosc boku a = ");
    scanf("%lf", &rectangle.a);
    printf("Podaj dlugosc boku b = ");
    scanf("%lf", &rectangle.b);

    rectangle.field = rectangle.a * rectangle.b;
    rectangle.perimeter = 2 * rectangle.a + 2 * rectangle.b;

    sprintf(s, "P = %.2lf, O = %.2lf", rectangle.field, rectangle.perimeter);
    return s;
}

char* count_square()
{
    char s[512];
    Square square;
    printf("Podaj dlugosc boku a = ");
    scanf("%lf", &square.side);
    square.field = pow(square.side, 2);
    square.perimeter = 4 * square.side;
    sprintf(s, "P = %.2lf, O = %.2lf", square.field, square.perimeter);
    return s;
}

char* count_trapeze()
{
    char s[512];
    Trapeze trapeze;
    printf("Podaj dlugosc pierwszej podstawy: ");
    scanf("%lf", &trapeze.a);
    printf("Podaj dlugosc drugiej podstawy: ");
    scanf("%lf", &trapeze.b);
    printf("Podaj dlugosc pierwszego boku: ");
    scanf("%lf", &trapeze.c);
    printf("Podaj dlugosc drugiego boku: ");
    scanf("%lf", &trapeze.d);
    printf("Podaj wysokosc: ");
    scanf("%lf", &trapeze.h);
    trapeze.field = (trapeze.a + trapeze.b) / 2 * trapeze.h;
    trapeze.perimeter = trapeze.a + trapeze.b + trapeze.c + trapeze.d;
    sprintf(s, "P = %.2lf, O = %.2lf", trapeze.field, trapeze.perimeter);
    return s;
}

char* count_triangle()
{
    char s[512];
    Triangle triangle;
    printf("Podaj dlugosc podstawy a = ");
    scanf("%lf", &triangle.a);
    printf("Podaj dlugosc boku b = ");
    scanf("%lf", &triangle.b);
    printf("Podaj dlugosc boku c = ");
    scanf("%lf", &triangle.c);
    printf("Podaj wysokosc h =");
    scanf("%lf", &triangle.h);
    triangle.field = triangle.a * triangle.h / 2;
    triangle.perimeter = triangle.a + triangle.b + triangle.c;
    sprintf(s, "P = %.2lf, O = %.2lf", triangle.field, triangle.perimeter);
    return s;
}

double task11()
{
    char choice;
    double n;
    double n2;
    printf("\n\nTask 11\n\n");
    printf("Wybierz operacje.\n");
    printf("\t* 1 - potegowanie\n");
    printf("\t* 2 - odwrotnosc\n");
    printf("\t* 3 - logarytm naturalny\n");
    printf("\t* 4 - sinus\n");
    printf("\t* 5 - tangens\n");
    scanf("%c", &choice);
    printf("Podaj liczbe: ");
    scanf("%lf", &n);
    switch(choice)
    {
        case '1':
            printf("Podaj potege: ");
            scanf("%lf", &n2);
            return pow(n, n2);
        case '2':
            if(n == 0)
            {
                printf("Blad!. Podano 0.\n");
                return 0;
            }
            else
                return 1/n;
        case '3':
            return log(n);
        case '4':
            return sin(n);
        case '5':
            return tan(n);
        default:
            printf("Podano bledna wartosc.\n");
            return 0;
    }
}

char* task12()
{
    printf("\n\nTask 12\n\n");
    printf("Podaj dlugosci bokow.\n");
    double a, b, c;
    scanf("%lf", &a);
    scanf("%lf", &b);
    scanf("%lf", &c);
    if(a < (b + c) && (b < (a + c)) && (c < (a + b)))
        return "Podane dlugosci moga byc dlugosciami bokow trojkata.";
    else
        return "Podane dlugosci bokow nie moga byc dlugosciami bokow trojkata.";
}

char* task13()
{
    int n;
    char s[512];
    printf("\n\nTask 13\n\n");
    printf("Podaj, z ilu liczb chcesz wyciagac srednia.\n");
    scanf("%d",&n);
    double numbers[n];
    double geom, artm, temp;
    int i;
    for(i = 0; i < n; i++)
        scanf("%lf", &numbers[i]);

    temp = 0.0;
    for(i = 0; i < n; i++)
        temp += numbers[i];
     artm = temp / n;

     temp = 1.0;
     for(i = 0; i < n; i++)
         temp *= numbers[i];

     geom = pow(temp, 1/n);

     sprintf(s, "Sr. arytm: %.2lf, geom: %.2lf", artm, geom);
     return s;
}

void task14()
{
    srand(time(NULL));
    int count, max;
    printf("\n\nTask 14\n\n");
    printf("Podaj koniec zakresu, w jakim chcesz losowac: ");
    scanf("%d", &max);
    printf("Podaj, ile chesz przprowadzic losowan: ");
    scanf("%d", &count);
    int nums[count];
    int i;
    for(i = 0; i < count; i++)
    {
        nums[i] = rand() % max;
    }
    for(i = 0; i < count; i++)
    {
        printf("Losowanie: %d, wynik: %d\n", i, nums[i]);
    }

}

char* task15()
{
    Point p1, p2, p3;
    double a, b;
    printf("\n\nTask 15\n\n");
    printf("Podaj wspolrzedne 3 punktow.\n");
    scanf("%lf", &p1.x);
    scanf("%lf", &p1.y);
    scanf("%lf", &p2.x);
    scanf("%lf", &p2.y);
    scanf("%lf", &p3.x);
    scanf("%lf", &p3.y);

    if(((p1.x == p2.x) && (p1.x != p3.x)) ||
            ((p1.x == p3.x) && (p1.x != p2.x)) ||
            ((p2.x == p3.x) && (p1.x != p3.x)) )
        return "Nie sa wspoliniowe";

    a = (p1.y - p2.y) / (p1.x - p2.x);
    b = p1.y - a * p1.x;

    if(p3.y - a*p3.x - b == 0)
        return "Sa wspoliniowe";
    else
        return "Nie sa wspoliniowe";
}

void task16(char* message)
{
    int move, move_back;
    int message_len;
    int i;
    printf("\n\nTask 16\n\n");
    printf("Podaj, o ile chcesz przesunac.");
    scanf("%d", &move);
    move_back = -move;
    message_len = sizeof(message) / sizeof(char);
    char message_tmp[message_len];

    printf("Szyfrowanie\n");
    for (i = 0; i < message_len; i++)
    {
        if ((message[i] >= 'A') && (message[i] <= 'Z'))
        {
            printf("%c", help(move, 'A', message[i]));
            message_tmp[i] = help(move, 'A', message[i]);
        }
        else if ((message[i] >= 'a') && (message[i] <= 'z'))
        {
            printf("%c", help(move, 'a', message[i]));
            message_tmp[i] = help(move, 'a', message[i]);
        }
        else
        {
            printf("%c", message[i]);
            message_tmp[i] = message[i];
        }
    }
    printf("\nFull: %s \n", message_tmp);
    printf("\nDeszyfrowanie\n");
    for (i = 0; i < message_len; i++)
    {
        if ((message[i] >= 'A') && (message[i] <= 'Z')) //wielkie litery
        {
            printf("%c", help(move_back, 'A', message_tmp[i]));
            message_tmp[i] = help(move_back, 'A', message_tmp[i]);
        }
        else if ((message[i] >= 'a') && (message[i] <= 'z'))//male litery
        {
            printf("%c", help(move_back, 'a', message_tmp[i]));
            message_tmp[i] = help(move_back, 'a', message_tmp[i]);
        }
        else
        {
            printf("%c", message[i]);//inne
            message_tmp[i] = message[i];
        }
    }
    printf("\nFull: %s \n", message_tmp);
    printf("\n");
}

int help(int move, int start, char c)
{
    const int LETTERS_IN_ALPHA = 'Z' - 'A' + 1;
    int l = (c - start + move) % LETTERS_IN_ALPHA + start;
    if (l >= start)
    {
        return l;
    }
    else
    {
        return (c - start + move) % LETTERS_IN_ALPHA + LETTERS_IN_ALPHA + start;
    }
}
