#include "tasks.h"

/*N : nowy pracownik - wczytać dane opisujące i wprowadzić do kolejnej pozycji
 tabeli struktur,
 P : nowa wartość pensji dla pracownika o podanym nazwisku,
 R : nowa wartość procentu premii dla pracownika o podanym nazwisku,
 W : wypłata, obliczyć ile potrzeba złotych na wszystkie pensje i premie,
 K : koniec programu.*/

const int MAX_WORKERS = 10;
int worker_count = 0;

void empty_input_buffer()
{
    int ch;
    while ((ch=getchar()) != EOF && ch != '\n')
        ;
}


int non_ending_instruction_selected(char instruction)
{
	if (instruction == 'N' || instruction == 'P' ||
        instruction == 'W' || instruction == 'R')
		return 1;
	else if (instruction == 'K')
		return 0;
	else
		return WRONG_INSTRUCTION_ERROR;
}

void set_worker_surname(char *ws)
{
    int i;
    char c;

    printf("Enter surname: ");

    i = 0;
    while((c = getchar()) != '\n')
    {
        if(i < BUFFER_SIZE)
            ws[i++] = c;
    }
    //fgets((w+worker_count)->surname, BUFFER_SIZE, stdin);

    ws[i] = '\0';
}

void set_worker_salary(int *ws)
{
    printf("Enter salary: ");
    char buf[10];
    fgets(buf, 10, stdin);
    *ws = atoi(buf);
}

void set_worker_premium(int *wp)
{
    printf("Enter premium percent: ");
    char buf[10];
    fgets(buf, 10, stdin);
    *wp = atoi(buf);
}

void new_worker(Worker *w)
{

    set_worker_surname((w+worker_count)->surname);
    set_worker_salary(&(w+worker_count)->salary);
    set_worker_premium(&(w+worker_count)->premium_percent);
    worker_count++;
}

int search_for_worker_by_surname(const char* surname, Worker* w)
{
    int i = 0;
    while(i < worker_count)
    {
        if(strcmp(surname, (w+i)->surname) == 0)
            return i;
        else
            i++;
    }
    return WORKER_NOT_FOUND_ERROR;
}

void update_salary(Worker *w)
{
    Worker searched_worker;
    int worker_position;
    set_worker_surname(searched_worker.surname);
    worker_position = search_for_worker_by_surname(searched_worker.surname, w);
    if(worker_position >= 0)
        set_worker_salary(&(w+worker_position)->salary);
    else
        printf("Worker not found\n");
}

void update_premium(Worker *w)
{
    Worker searched_worker;
    int worker_position;
    set_worker_surname(searched_worker.surname);
    worker_position = search_for_worker_by_surname(searched_worker.surname, w);
    if(worker_position >= 0)
        set_worker_premium(&(w+worker_position)->premium_percent);
    else
        printf("Worker not found\n");
}

void count_entire_salary(Worker *w)
{
    Worker searched_worker;
    int worker_position;
    set_worker_surname(searched_worker.surname);
    worker_position = search_for_worker_by_surname(searched_worker.surname, w);
    searched_worker.salary = (w+worker_position)->salary;
    searched_worker.premium_percent = (w+worker_position)->premium_percent;
    if(worker_position >= 0)
    {
        float p = (float)(searched_worker.premium_percent);
        p /= 100;
        float f = searched_worker.salary * (1+p);
        printf("Base salary: %d, premium: %d\%, entire payroll: %f\n",
               searched_worker.salary,
               searched_worker.premium_percent,
               f);
    }
    else
        printf("Worker not found\n");
}

void* get_operation(char instruction)
{
    if (instruction == 'N')
        return &new_worker;
    else if(instruction == 'P')
        return &update_salary;
    else if(instruction == 'R')
        return &update_premium;
    else if(instruction == 'W')
        return &count_entire_salary;
}

void show_workers(Worker *w)
{
    int i;
    for(i = 0; i < worker_count; i++)
        printf("%s, %d, %d\n", (w+i)->surname, (w+i)->salary, (w+i)->premium_percent);
}

void task1()
{
    Worker workers[MAX_WORKERS];
    char instruction;
    void(*operation)(Worker *);

	printf("\n\nTask1\n\n");

    do
    {
        printf("Give instruction: ");
        instruction = getchar();
        empty_input_buffer();

        operation = get_operation(instruction);

        (*operation)(workers);
        show_workers(workers);
    }while (non_ending_instruction_selected(instruction) == 1);
}
