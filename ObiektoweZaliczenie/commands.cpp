#include "commands.h"
#include "exceptions.h"
#include <iostream>
#include <fstream>

using namespace std;

bool name_is_valid(string name)
{
	if (name.length() > 1)
		throw new Exception("Invalid name provided.");
	if (name[0] - 'A' >= NUMBER_OF_CLASSES)
		throw new Exception("Exceeded object vector size.");
	return true;
}

int get_name_position_in_vector(string name)
{
	if (name_is_valid(name))
		return name[0] - 'A';
	else
		throw new Exception("Invalid name");
}

string get_name_by_position(int position)
{
	return string(1, 'A' + position);
}

bool object_exists(A *object)
{
	return object != NULL;
}

bool object_name_matches(string name, A* object)
{
	return name == object->getClassName();
}

int change_directory(A** object_vector)
{
	string name;
	cout << "Give the name of the object you want to get: ";
	cin >> name;
	int i = get_name_position_in_vector(name);
	if (object_exists(object_vector[i]))
		return i;
	else
	{
		cerr << "Object doesn't exist. Enter \"mo\" to create it.";
		return 0;
	}
}

A* create_new(string name)
{
	int value;
	cout << "Give value: ";
	cin >> value;
	if (name == "D")
		return new D(value);
	if (name == "E")
		return new E(value);
	if (name == "F")
		return new F(value);
	if (name == "H")
		return new H(value);
	if (name == "I")
		return new I(value);
	if (name == "J")
		return (B*) new J(value);
	if (name == "K")
		return (B*) new K(value);

}

A* create_new_with_value(string name, int value)
{
	if (name == "D")
		return new D(value);
	if (name == "E")
		return new E(value);
	if (name == "F")
		return new F(value);
	if (name == "H")
		return new H(value);
	if (name == "I")
		return new I(value);
	if (name == "J")
		return (B*)new J(value);
	if (name == "K")
		return (B*)new K(value);
}

void create_next(string name, A* object)
{
	A* last_element_on_list = object->getLastObjectOnTheList(object);
	A* new_object;

	int value;
	cout << "Give value: ";
	cin >> value;

	if (name == "D")
	{
		new_object = new D(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "E")
	{
		new_object = new E(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "F")
	{
		new_object = new F(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "H")
	{
		new_object = new H(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "I")
	{
		new_object = new I(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "J")
	{
		new_object = (B*)new J(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "K")
	{
		new_object = (B*)new K(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
}

void create_next_with_value(string name, A* object, int value)
{
	A* last_element_on_list = object->getLastObjectOnTheList(object);
	A* new_object;

	if (name == "D")
	{
		new_object = new D(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "E")
	{
		new_object = new E(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "F")
	{
		new_object = new F(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "H")
	{
		new_object = new H(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "I")
	{
		new_object = new I(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "J")
	{
		new_object = (B*)new J(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
	if (name == "K")
	{
		new_object = (B*)new K(value);
		last_element_on_list->addObjectToTail(last_element_on_list, new_object);
	}
}

int make_object(A ** object_vector)
{
	string name;
	cout << "Give the name of the object you want to create: ";
	cin >> name;
	int position = get_name_position_in_vector(name);
	if (object_exists(object_vector[position]))
	{
		if (object_vector[position]->isLeaf())
		{
			create_next(name, object_vector[position]);
		}
		else
		{
			throw new Exception("Cant\'t add new object at non-leaf position.");
		}
	}
	else
	{
		object_vector[position] = create_new(name);
	}
	return position;
}

void modify_object(A ** object_vector)
{
	string name;
	cout << "Give the name of the object you want to modify: ";
	cin >> name;
	int position = get_name_position_in_vector(name);
	if (!object_vector[position]->isLeaf())
	{
		throw new Exception("Can\'t modify non-leaf objects.");
	}
	if (object_exists(object_vector[position]))
	{
		int value;
		A* tmp = object_vector[position];
		cout << "Give value to modify: ";
		cin >> value;
		tmp = tmp->findObjectByValue(value, tmp);
		cout << "Give new value: ";
		cin >> value;
		tmp->setValue(value);
	}
}

int delete_object(A ** object_vector)
{
	string name;
	cout << "Give the name of the object you want to delete: ";
	cin >> name;
	int position = get_name_position_in_vector(name);
	if (!object_vector[position]->isLeaf())
	{
		throw new Exception("Can\'t delete non-leaf objects.");
	}
	if (object_exists(object_vector[position]))
	{
		int value;
		cout << "Give value to be deleted: ";
		cin >> value;
		A* object = object_vector[position]->findObjectByValue(value, object_vector[position]);
		cout << object->getValue() << endl;
		if (object == object_vector[position])
		{
			object_vector[position] = object->getNext();
			delete object;
		}
		else
		{
			A * previous = object->findPrecedingObjectByValue(value, object_vector[position]);
			previous->connectListItems(previous, object->getNext());
			delete object;
		}
	}
	return 0;
}

void dir_object(A * object)
{
	if (object_exists(object))
	{
		if (!object->isLeaf())
		{
			cout << "Object " << object->getClassName() << " is not leaf." << endl;
		}
		else
		{
			int i = 0;
			do
			{
				cout << "Object " << object->getClassName() << " at position " << i++ << " with value: " << object->getValue() << endl;
			} while ((object = object->getNext()) != NULL);
		}
	}
}

void show_object(A ** object_vector)
{
	string name;
	cout << "Give the name of the object you want to see: ";
	cin >> name;
	int position = get_name_position_in_vector(name);
	if (object_exists(object_vector[position]))
	{
		A * tmp = object_vector[position];
		if (tmp->isLeaf())
		{
			cout << "Give value." << endl;
			int value;
			cin >> value;
			try
			{
				tmp = tmp->findObjectByValue(value, tmp);
				cout << name << " value: " << tmp->getValue() << " leaf" << endl;
			}
			catch (Exception *e)
			{
				cerr << e->get_message();
			}
		}
		else
		{
			cout << name << " not leaf." << endl;
		}

	}
	else
	{
		cout << name << " does not exist yet." << endl;
	}
}

void save_all(A ** object_vector)
{
	for (int i = 0; i < NUMBER_OF_CLASSES; i++)
	{
		if (object_exists(object_vector[i]))
		{
			if (object_vector[i]->isLeaf())
			{
				A * object = object_vector[i];
				ofstream file(object_vector[i]->getClassName() + ".txt");
				while (object != NULL)
				{
					file << object->getValue();
					if ((object = object->getNext()) != NULL)
						file << '\n';
				}
				file.close();
			}
		}
	}
}

void save_object(A ** object_vector)
{
	string name;
	cout << "Give the name of the object you want to save or enter ALL if you want to save all: ";
	cin >> name;
	if (name == "ALL")
		save_all(object_vector);
	else
	{
		int position = get_name_position_in_vector(name);
		if (object_exists(object_vector[position]))
		{
			A * object = object_vector[position];
			ofstream file(object_vector[position]->getClassName() + ".txt");
			while (object != NULL)
			{
				file << object->getValue();
				if((object = object->getNext()) != NULL)
					file << '\n';
			}
			file.close();
		}
	}
}

void read_all_objects(A** object_vector)
{
	int data;
	for (int i = 0; i < NUMBER_OF_CLASSES; i++)
	{
		if (object_exists(object_vector[i]))
		{
			if (object_vector[i]->isLeaf())
			{
				ifstream file(object_vector[i]->getClassName() + ".txt");
				do
				{
					file >> data;
					if (object_exists(object_vector[i]))
					{
						create_next_with_value(object_vector[i]->getClassName(), object_vector[i], data);
					}
					else
					{
						object_vector[i] = create_new_with_value(object_vector[i]->getClassName(), data);
					}
				} while (!file.eof());
			}
		}
		else
		{
			string name = get_name_by_position(i);
			ifstream file(name + ".txt");
			if (file.good())
			{
				do
				{
					file >> data;
					if (object_exists(object_vector[i]))
					{
						create_next_with_value(object_vector[i]->getClassName(), object_vector[i], data);
					}
					else
					{
						object_vector[i] = create_new_with_value(name, data);
					}
				} while (!file.eof());
			}

		}
	}
}

void read_object_from_file(A ** object_vector)
{
	string name;
	cout << "Give the name of the object you want to read or ALL to read all: ";
	cin >> name;
	if (name == "ALL") 
	{
		read_all_objects(object_vector);
	}
	else
	{
		int position = get_name_position_in_vector(name);
		if (object_exists(object_vector[position]))
			if (!object_vector[position]->isLeaf())
				throw new Exception("Not permitted for non-leaves");

		int data;
		ifstream file(name + ".txt");
		do
		{
			file >> data;
			if (object_exists(object_vector[position]))
			{
				create_next_with_value(name, object_vector[position], data);
			}
			else
			{
				object_vector[position] = create_new_with_value(name, data);
			}
		} while (!file.eof());
	}
	
}

void show_all(A ** object_vector)
{
	for (int i = 0; i < NUMBER_OF_CLASSES; i++)
	{
		dir_object(object_vector[i]);
	}
}
