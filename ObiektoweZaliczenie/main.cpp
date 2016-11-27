#include <iostream>
#include <string>
#include <sstream>
#include <stdio.h>
#include <vector>

#include "classes.h"
#include "commands.h"
#include "commands_list.h"
#include "exceptions.h"

using std::string;
using namespace std;

void split(const std::string &s, char delim, std::vector<std::string> &elems) {
	std::stringstream ss;
	ss.str(s);
	std::string item;
	while (std::getline(ss, item, delim)) {
		elems.push_back(item);
	}
}

std::vector<std::string> split(const std::string &s, char delim) {
	std::vector<std::string> elems;
	split(s, delim, elems);
	return elems;
}

vector<string> get_command_vector()
{
	string c_string;
	cout << "Give command." << endl;
	cin >> c_string;
	return split(c_string, ' ');
}

COMMAND get_command(string c_string)
{

	if (c_string == "cd")
		return CD;
	if (c_string == "mo")
		return MO;
	if (c_string == "do")
		return DO;
	if (c_string == "mdo")
		return MDO;
	if (c_string == "dir")
		return DIR;
	if (c_string == "show")
		return SHOW;
	if (c_string == "save")
		return SAVE;
	if (c_string == "read")
		return READ;
	if (c_string == "tree")
		return TREE;
	if (c_string == "exit")
		return EXIT;
	throw new Exception("Unknown command.");
}

void initialize_object_array(A** object_vector)
{
	for (int i = 0; i < NUMBER_OF_CLASSES; i++)
		object_vector[i] = NULL;

	object_vector[0] = new A();
	object_vector[1] = new B();
	object_vector[2] = new C();
	object_vector[6] = (B*)new G();
}


int main()
{
	vector<string> command_vector;
	COMMAND command;
	A *object_array[NUMBER_OF_CLASSES];
	//gets modified with cd command;
	int current_array_position = 0;
	try
	{
		initialize_object_array(object_array);
		do
		{
			command_vector = get_command_vector();
			command = get_command(command_vector[0]);

			switch (command)
			{
			case(CD) :
				current_array_position = change_directory(object_array);
				break;
			case(MO) :
				current_array_position = make_object(object_array);
				break;
			case(MDO) :
				modify_object(object_array);
				break;
			case(DO) :
				current_array_position = delete_object(object_array);
				break;
			case(SHOW) :
				// show_object(object_array);
				break;
			case(DIR) :
				dir_object(object_array[current_array_position]);
				break;
			case(SAVE) :
				save_object(object_array);
				break;
			case(READ) :
				read_object_from_file(object_array);
				break;
			case(TREE) :
				show_all(object_array);
				break;
			}
		} while (command != EXIT);

	}
	catch (Exception *e)
	{
		cerr << e->get_message() << endl;
	}

	cout << "Goodbye!" << endl;
	getchar();
	getchar();

	return 0;
}