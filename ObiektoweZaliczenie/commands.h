#pragma once
#include "classes.h"


int change_directory(A** object_vector);
int make_object(A** object_vector);
void modify_object(A** objct_vector);
int delete_object(A** object_vector);
void dir_object(A* object_vector);
void save_object(A** object_vector);
void read_object_from_file(A** object_vector);
void show_all(A** object_vector);
void show_object(int object_id);