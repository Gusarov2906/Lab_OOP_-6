#pragma once
#include "Worker.h"
#include <iostream>
#include <time.h>
class Request:public Worker
{
private:
	int number_of_department;
	string name_of_position;
	int quantity;
	double cost;
	tm date;
	Worker worker;
public:
	Request();
	Request(int num, string name, int quantity, double cost, Worker worker);
	tm get_date();
	int get_number_of_department();
	string get_name_of_position();
	int get_quantity();
	double get_cost();
	int get_day();
	int get_month();
	int get_year();
	Worker get_worker();
	void set_date(tm date);
	void print();

};

