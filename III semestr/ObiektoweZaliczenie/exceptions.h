#pragma once
#include <string>

using std::string;

class Exception
{
	string message;
public:
	Exception();
	Exception(string message);
	string get_message();
};