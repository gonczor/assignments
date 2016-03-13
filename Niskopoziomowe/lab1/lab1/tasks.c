#include "tasks.h"
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

static double get_greatest(double, double, double);
static double fahrenheit_to_celsius(double);
static double celsius_to_fahrenheit(double);
static int users_choice_incorrect(char);

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
    printf("Default value of x = %lf\n");
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
