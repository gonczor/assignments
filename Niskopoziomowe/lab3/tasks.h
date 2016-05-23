#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define BUFFER_SIZE 8
#define WRONG_INSTRUCTION_ERROR -1
#define WORKER_NOT_FOUND_ERROR -2

void task1();
void task2();

typedef struct {
    char surname[BUFFER_SIZE];
	int salary;
	int premium_percent;
}Worker;
