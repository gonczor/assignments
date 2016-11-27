#include "exceptions.h"

Exception::Exception()
{
	this->message = "Unexpected error occurred.\n";
}

Exception::Exception(string message)
{
	this->message = message;
}

string Exception::get_message()
{
	return this->message;
}