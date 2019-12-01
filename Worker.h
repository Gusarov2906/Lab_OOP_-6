#pragma once
#include "FIO.h"
#include <iostream>
class Worker: public FIO
{
private:
	FIO fio;
	string post;
	double salary;
public:
	Worker();
	Worker(FIO fio, string post, double salary);
	FIO get_fio();
	string get_post();
	double get_salary();
	void print();
	bool operator== (Worker& worker1);
	
};


