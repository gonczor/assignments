#include "tasks.h"

/*N : nowy pracownik - wczytać dane opisujące i wprowadzić do kolejnej pozycji
 tabeli struktur,
 P : nowa wartość pensji dla pracownika o podanym nazwisku,
 R : nowa wartość procentu premii dla pracownika o podanym nazwisku,
 W : wypłata, obliczyć ile potrzeba złotych na wszystkie pensje i premie,
 K : koniec programu.*/

int non_ending_instruction_selected(char instruction)
{
	if (instruction == 'N' || instruction == 'P' ||
		instruction == 'W')
		return 1;
	else if (instruction == 'K')
		return 0;
	else
		return WRONG_INSTRUCTION_ERROR;
}

/*void perform_requested_operation(void* function, Worker &workers)
{
	(*function)(workers);
}*/

void new_worker()
{
	printf("New worker\n");
}

void update_salary()
{
	printf("Update salary\n");
}

void update_premium()
{
	printf("Update premium\n");
}

void count_entire_salary()
{
	printf("Count entire salary\n");
}

void task1()
{
	const int max_workers = 10;
	//Worker workers[max_workers];
	char instruction;
	void(*operation)(void);

	printf("\n\nTask1\n\n");
	printf("Give instruction\n");
	scanf("%c", &instruction);

	while (non_ending_instruction_selected(instruction) == 1)
	{
		if (instruction == 'N')
			operation = &new_worker;
		else
			operation = &update_premium;

		(*operation)();

		printf("Give instruction\n");
		scanf("%c", &instruction);
	}
}
