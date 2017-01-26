#include "tasks.h"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

void task17()
{
    int d, g;
    int a, b;
    float c;

    printf("\n\nTask 17\n\n");
    printf("Podaj zakres, w jakim maja byc szukane trojki pitaagorejskie\n");
    scanf("%d %d", &d, &g);

    for(a = d; a < g; a++)
        for(b = a; b < g; b++)
            if((c = sqrt(pow(a, 2) + pow(b, 2))) == roundf(c))
                printf("a = %d \tb = %d\tc = %.0f\n", a, b, c);
}

void task18()
{
    srand(time(NULL));
    int matrix_size;
    int i, j;
    int min = 0, max = 10;
    int sum;

    printf("\n\nTask 18\n\n");
    printf("Declare matrix size: ");
    scanf("%d", &matrix_size);
    printf("The program will now create a matrix with random values.\n");

    int matrix[matrix_size][matrix_size];
    sum = 0;
    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
        {
            matrix[i][j] = min + rand() % max;
            if(i == j)
                sum += matrix[i][j];
        }

     printf("Created matrix:\n\n");
     for(i = 0; i < matrix_size; i++)
     {
         for(j = 0; j < matrix_size; j++)
        {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
     }
     printf("Sum: %d\n", sum);

}

void task19()
{
    srand(time(NULL));
    int matrix_size;
    int i, j;
    int sum_main, sum_below;
    int min = 0, max = 10;
    double proportion;

    printf("\n\nTask 19\n\n");
    printf("Declare matrix size: ");
    scanf("%d", &matrix_size);
    printf("The program will now create a matrix with random values.\n");

    int matrix[matrix_size][matrix_size];
    sum_below = sum_main = 0;
    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
        {
            matrix[i][j] = min + rand() % max;
            if(i == j)
                sum_main += matrix[i][j];
            else if(j < i)
                sum_below += matrix[i][j];
        }

     printf("Created matrix:\n\n");
     for(i = 0; i < matrix_size; i++)
     {
         for(j = 0; j < matrix_size; j++)
        {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
     }
     proportion = (double) sum_main/sum_below;
     printf("Sum main: %d\n", sum_main);
     printf("Sum below: %d\n", sum_below);
     printf("Proportion = %lf\n", proportion);
}

void task20()
{
    srand(time(NULL));
    int matrix_size;
    int i, j, k;
    int min = 0, max = 10;
    int sum;

    printf("\n\nTask 20\n\n");
    printf("Declare matrix size: ");
    scanf("%d", &matrix_size);

    int matrix1[matrix_size][matrix_size];
    int matrix2[matrix_size][matrix_size];
    int multiplied_matrix[matrix_size][matrix_size];

    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
            matrix1[i][j] = min + rand() % max;
    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
            matrix2[i][j] = min + rand() % max;

    sum = 0;
    for(i = 0; i < matrix_size; i++)
    {
        for(j = 0; j < matrix_size; j++)
        {
            for(k = 0; k < matrix_size; k++)
                sum += matrix1[i][k] * matrix2[k][j];

            multiplied_matrix[i][j] = sum;
            sum = 0;
        }
    }

    printf("\n");

    for(i = 0; i < matrix_size; i++)
    {
        for(j = 0; j < matrix_size; j++)
       {
           printf("%d\t", multiplied_matrix[i][j]);
       }
       printf("\n");
    }

}

void task21()
{
    int matrix_size, i, j;
    printf("\n\nTask 21\n\n");
    printf("Declare matrix size: ");
    scanf("%d", &matrix_size);
    char matrix[matrix_size][matrix_size];

    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++){
            if(i >= j)
                matrix[i][j] = 'X';
            else
                matrix[i][j] = ' ';
        }

    for(i = 0; i < matrix_size; i++)
    {
        for(j = 0; j < matrix_size; j++)
       {
           printf("%c\t", matrix[i][j]);
       }
       printf("\n");
    }
}

void task22()
{
    srand(time(NULL));
    int matrix_size, i, j;
    int min = 0, max = 2;
    printf("\n\nTask 22\n\n");
    printf("Declare matrix size: ");
    scanf("%d", &matrix_size);
    int matrix[matrix_size][matrix_size];
    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
            matrix[i][j] =min + rand() % max;

    int is_symmetric = 1;
    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
            if(matrix[i][j] != matrix[j][i])
            {
                is_symmetric = 0;
                break;
            }

    if(is_symmetric == 0)
        printf("Macierz nie jest symetryczna.\n");
    else
        printf("Macierz jest symetrycna.\n");

    int contains_empty_columns;
    for(j = 0; j < matrix_size; j++)
    {
        contains_empty_columns = 1;
        for(i = 0; i < matrix_size; i++)
        {
            if(matrix[i][j] != 0)
            {
                contains_empty_columns = 0;
                break;
            }
        }
        if(contains_empty_columns == 1)
            break;
    }

    if(contains_empty_columns == 0)
        printf("Nie zawiera pustych kolumn.\n");
    else
        printf("Zawiera puste kolumny.\n");

    for(i = 0; i < matrix_size; i++)
    {
        for(j = 0; j < matrix_size; j++)
       {
           printf("%d\t", matrix[i][j]);
       }
       printf("\n");
    }
}

void task23()
{
    srand(time(NULL));
    int matrix_size, i, j;
    int min = 0, max = 10;
    double proportion;
    char row_or_col;
    int sel1, sel2, sum1, sum2;
    printf("\n\nTask 23\n\n");
    printf("Declare matrix size: ");
    scanf("%d", &matrix_size);
    int matrix[matrix_size][matrix_size];

    for(i = 0; i < matrix_size; i++)
        for(j = 0; j < matrix_size; j++)
            matrix[i][j] = min + rand() % max;

    for(i = 0; i < matrix_size; i++)
    {
        for(j = 0; j < matrix_size; j++)
       {
           printf("%d\t", matrix[i][j]);
       }
       printf("\n");
    }



    printf("Wpisz w jesli chcesz oblcizac wiersze i k jesli kolumny, oraz ich numery.\n");
    scanf(" %c", &row_or_col);
    scanf("%d", &sel1);
    scanf("%d", &sel2);

    printf("%d, %d\n", sel1, sel2);

    sum1 = sum2 = 0;

    if(row_or_col == 'w')
    {
        for(i = 0; i < matrix_size; i++)
            sum1 += matrix[sel1][i];
        for(i = 0; i < matrix_size; i++)
            sum2 += matrix[sel2][i];
    }
    if(row_or_col == 'k')
    {
        for(i = 0; i < matrix_size; i++)
            sum1 += matrix[i][sel1];
        for(i = 0; i < matrix_size; i++)
            sum2 += matrix[i][sel2];
    }
     proportion = (double) sum1 / sum2;
     printf("sum1: %d, sum2: %d, prop: %lf\n", sum1, sum2, proportion);
}

void task24()
{
    printf("\n\nTask 24\n\n");
    char* base = "abcdefabdefabc";
    char* searched = "abc";
    uint i, j, matches_found;
    char first_searched_char = searched[0];

    matches_found = 0;
    for(i = 0; i < strlen(base); i++)
    {
        if(base[i] == first_searched_char)
        {
            for(j = 0; j < strlen(searched); j++)
            {
                if(base[i+j] != searched[j])
                    break;
                if(searched[j+1] == '\0')
                    matches_found++;
            }
        }
    }

    printf("Matches: %d\n", matches_found);
}

void task25()
{
    printf("\n\nTask 25\n\n");
    char alphabet['z' - 'a' + 1];
    uint number_of_chars = 'z' - 'a' + 1;
    char *input_string = "larvehblidsnblivbealvybolabrliaervlbiebyvlkaelribl";
    uint input_string_len = strlen(input_string);
    uint i;

    for(i = 0; i < number_of_chars; i++)
    {
        alphabet[i] = 0;
    }

    for(i = 0; i < input_string_len; i++)
    {
        char c = input_string[i];
        alphabet[(int)(c - 'a')] += 1;
    }

    for(i = 0; i < number_of_chars; i++)
        printf("%c occured: %d times.\n", 'a' + i, alphabet[i]);
}

void task26()
{
    printf("\n\nTask 26\n\n");
    char* input_string = "aaaabbccddggaaaaaa";
    longest_sequence longest, current;
    uint i, j;

    longest.character = '\0';
    longest.occurences = 0;

    for(i = 0; i < strlen(input_string); i++)
    {
        current.character = input_string[i];
        current.occurences = 1;

        while(current.character == input_string[i+1])
        {
                current.occurences += 1;
                i++;
                if(i == '\0')
                    break;
        }

        if(current.occurences > longest.occurences)
        {
            longest.character = current.character;
            longest.occurences = current.occurences;
        }
    }

    printf("%c hass occured most often: %d\n", longest.character, longest.occurences);
}
