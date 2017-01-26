#include <stdlib.h>
#include <stdio.h>

#define WRONG_INSTRUCTION_ERROR -1

void task1();

typedef struct {
	char surname[128];
	int salary;
	int premium_percent;
}Worker;
