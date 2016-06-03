#include "tasks.h"
int count_chars(const FILE* file, const char searched_char)
{
    unsigned int counter = 0;
    char c;
    while((c = getc(file)) != EOF)
        if (c == searched_char)
            counter++;
    return counter;
}

void task1()
{
    char *file_name = "file.txt";
    char searched_char = 'e';
    FILE *file = fopen(file_name, "r");
    if(file)
        printf("Character: %c has occurred %d times in %s file.\n",
               searched_char,
               count_chars(file, searched_char),
               file_name);
    else
        perror("Error occurred.\n");
}

void task2()
{
    int num1, num2;
    char operation;
    char c;
    printf("Podaj 1 liczbe: ");
    scanf("%x", &num1);
    c = getchar();
    printf("Podaj operacje: ");
    scanf("%c", &operation);
    c = getchar();
    printf("Podaj  liczbe: ");
    scanf("%x", &num2);
    c = getchar();
    printf("Wynik: ");
    switch (operation)
    {
    case '+':
        printf("%x\n", num1+num2);
        break;
    case '-':
        printf("%x\n", num1-num2);
        break;
    case '*':
        printf("%x\n", num1*num2);
        break;
    }
}
