#include "Worker.h"

Worker::Worker()
{
	this->post = "default_post";
	this->salary = 0;
}

Worker::Worker(FIO fio, string post, double salary)
{
	this->fio = fio;
	this->post = post;
	this->salary = salary;
}

FIO Worker::get_fio()
{
	return this->fio;
}

string Worker::get_post()
{
	return this->post;
}

double Worker::get_salary()
{
	return this->salary;
}

void Worker::print()
{
	fio.print();
	cout << " Post: " << post << " Salary: " << salary ;
}

bool Worker::operator==(Worker& worker1)
{
	if (this->fio == worker1.fio)
		return true;
	return false;
}
