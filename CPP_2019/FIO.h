#pragma once

#include <iostream>
using namespace std;
class FIO
{
private:
	string name;
	string surname;
	string patronymic;
public:
	FIO();
	FIO(string name, string surname, string patronymic);
	string get_name();
	string get_surname();
	string get_patronymic();
	void print();
	void set_name(string name);
	void set_surname(string surname);
	void set_patronymic(string patronymic);
	bool operator ==(FIO fio1);
};

