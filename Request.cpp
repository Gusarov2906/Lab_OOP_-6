#include "Request.h"

Request::Request()
{
	this->number_of_department = 0;
	this->name_of_position = "Default_name_of_position";
	this->quantity = 0;
	this->cost = 0;
	this->date.tm_year = 1990;
	this->date.tm_mon = 1;
	this->date.tm_mday = 1;
}

Request::Request(int num, string name, int quantity, double cost, Worker worker)
{
	this->number_of_department = num;
	this->name_of_position = name;
	this->quantity = quantity;
	this->cost = cost;
	this->worker = worker;
	this->date.tm_mday = 0;
	this->date.tm_mon = 0;
	this->date.tm_year = 0;
}

tm Request::get_date()
{
	return this->date;
}

int Request::get_number_of_department()
{
	return number_of_department;
}

string Request::get_name_of_position()
{
	return name_of_position;
}

int Request::get_quantity()
{
	return quantity;
}

double Request::get_cost()
{
	return cost;
}

int Request::get_day()
{
	return date.tm_mday;
}

int Request::get_month()
{
	return date.tm_mon;
}

int Request::get_year()
{
	return date.tm_year;
}

Worker Request::get_worker()
{
	return worker;
}

void Request::set_date(tm date)
{
	this->date = date;
}

void Request::print()
{
	cout <<" Number of department: " << number_of_department << " Name of position: " << name_of_position<<endl
		<< " Quantity: " << quantity << " Price: " <<  cost << endl 
		<< " Date: " << date.tm_mday << " " << date.tm_mon << " " << date.tm_year + 1990<<endl
		<<" Worker: "<<worker.get_fio().get_surname()<<" "<< worker.get_fio().get_name() <<" "<< worker.get_fio().get_patronymic()<<endl;
}
