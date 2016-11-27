#pragma once
#include <string>
#include "commands_list.h"

const int NUMBER_OF_CLASSES = 11;
extern unsigned int global_id;

using std::string;

class A
{
protected:
	string className;
	unsigned int id;
	int value;
	bool leaf;
	A *next;
public:
	A();
	virtual string getClassName();
	virtual bool isLeaf();
	virtual int getValue();
	virtual unsigned int getId();
	virtual void setValue(int value);
	virtual A * getLastObjectOnTheList(A* first);
	virtual A * findObjectByValue(int value, A * start);
	virtual A * findPrecedingObjectByValue(int value, A* start);
	virtual void addObjectToTail(A* tail, A* new_object);
	virtual void connectListItems(A* first, A* second);

	virtual A* getNext();
};

class B : public A
{
public:
	B();
};

class C : public A
{
public:
	C();
};

class D : public B
{
public:
	D();
	D(int value);
	int getValue();
	void setValue(int value);
};

class E : public B
{
public:
	E();
	E(int value);
	int getValue();
	void setValue(int value);
};

class F : public B
{
public:
	F();
	F(int value);
	int getValue();
	void setValue(int value);
};

class G : public B, public C
{
public:
	G();
};

class H : public C
{
public:
	H();
	H(int value);
	int getValue();
	void setValue(int value);
};

class I : public C
{
public:
	I();
	I(int value);
	int getValue();
	void setValue(int value);
};

class J : public G
{
public:
	J();
	J(int value);
	int getValue();
	void setValue(int value);
};

class K : public G
{
public:
	K();
	K(int value);
	int getValue();
	void setValue(int value);
};