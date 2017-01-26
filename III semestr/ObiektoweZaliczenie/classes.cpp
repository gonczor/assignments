#include "classes.h"
#include "exceptions.h"

unsigned int global_id = 0;

A::A()
{
	this->className = "A";
	this->value = -1;
	this->leaf = false;
	this->next = NULL;
	this->id = global_id++;
}

string A::getClassName()
{
	return this->className;
}

bool A::isLeaf()
{
	return this->leaf;
}

int A::getValue()
{
	throw new Exception("Can\'t  access values of non-leaf objects.");
}

unsigned int A::getId()
{
	return this->id;
}

void A::setValue(int value)
{
	throw new Exception();
}

A * A::getLastObjectOnTheList(A * first)
{
	if (first->isLeaf())
	{
		A* tmp = first;
		while (tmp->next != NULL)
		{
			tmp = tmp->next;
		}
		return tmp;
	}
	else
	{
		throw new Exception("Non-leaf objects do not support adding elements");
	}
}

A * A::findObjectByValue(int value, A* start)
{
	A* tmp = start;
	while (tmp->getValue() != value)
	{
		if (tmp->next != NULL)
			tmp = tmp->next;
		else
			throw new Exception("Value not found");
	}
	return tmp;
}

A * A::findPrecedingObjectByValue(int value, A * start)
{
	A* tmp = start;
	while (tmp->next->getValue() != value)
	{
		if (tmp->next->next != NULL)
			tmp = tmp->next;
		else
			throw new Exception("Value not found");
	}
	return tmp;
}

void A::addObjectToTail(A * tail, A * new_object)
{
	if (tail->isLeaf())
	{
		tail->next = new_object;
	}
	else
	{
		throw new Exception("Non-leaf objects do not support adding elements");
	}
}

void A::connectListItems(A * first, A * second)
{
	first->next = second;
}

A * A::getNext()
{
	return this->next;
}

B::B()
{
	this->className = "B";
	this->value = -1;
	this->leaf = false;
	this->id = global_id++;
}

C::C()
{
	this->className = "C";
	this->value = -1;
	this->leaf = false;
	this->id = global_id++;
}

D::D()
{
	this->className = "D";
	this->value = 0;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

D::D(int value)
{
	this->className = "D";
	this->value = value;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

int D::getValue()
{
	return this->value;
}

void D::setValue(int value)
{
	this->value = value;
}

E::E()
{
	this->className = "E";
	this->value = 0;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

E::E(int value)
{
	this->className = "E";
	this->value = value;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

int E::getValue()
{
	return this->value;
}

void E::setValue(int value)
{
	this->value = value;
}

F::F()
{
	this->className = "F";
	this->value = 0;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

F::F(int value)
{
	this->className = "F";
	this->value = value;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

int F::getValue()
{
	return this->value;
}

void F::setValue(int value)
{
	this->value = value;
}

G::G()
{
	this->A::className = "G";
	this->A::value = -1;
	this->A::leaf = false;
	this->A::id = global_id++;
}


H::H()
{
	this->className = "H";
	this->value = 0;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

H::H(int value)
{
	this->className = "H";
	this->value = value;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

int H::getValue()
{
	return this->value;
}

void H::setValue(int value)
{
	this->value = value;
}

I::I()
{
	this->className = "I";
	this->value = 0;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

I::I(int value)
{
	this->className = "I";
	this->value = value;
	this->leaf = true;
	this->next = NULL;
	this->id = global_id++;
}

int I::getValue()
{
	return this->value;
}

void I::setValue(int value)
{
	this->value = value;
}

J::J()
{
	this->A::className = "J";
	this->A::value = 0;
	this->A::leaf = true;
	this->A::next = NULL;
	this->A::id = global_id++;
}

J::J(int value)
{
	this->A::className = "J";
	this->A::value = value;
	this->A::leaf = true;
	this->A::next = NULL;
	this->A::id = global_id++;
}

int J::getValue()
{
	return this->A::value;
}

void J::setValue(int value)
{
	this->A::value = value;
}

K::K()
{
	this->A::className = "K";
	this->A::value = 0;
	this->A::leaf = true;
	this->A::next = NULL;
	this->A::id = global_id++;
}

K::K(int value)
{
	this->A::className = "K";
	this->A::value = value;
	this->A::leaf = true;
	this->A::next = NULL;
	this->A::id = global_id++;
}

int K::getValue()
{
	return this->A::value;
}

void K::setValue(int value)
{
	this->A::value = value;
}