#include "FIO.h"

FIO::FIO()
{
	this->name = "Ivan(Default)";
	this->surname = "Ivanov(Default)";
	this->patronymic = "Ivanovich(Default)";
}

FIO::FIO(string name, string surname, string patronymic)
{
	this->name = name;
	this->surname = surname;
	this->patronymic = patronymic;
}

string FIO::get_name()
{
	return this->name;
}

string FIO::get_surname()
{
	return this->surname;
}

string FIO::get_patronymic()
{
	return this->patronymic;
}

void FIO::print()
{
	cout << "FIO: " << surname << " " << name << " " << patronymic;
}

void FIO::set_name(string name)
{
	this->name = name;
}

void FIO::set_surname(string surname)
{
	this->surname = surname;
}

void FIO::set_patronymic(string patronymic)
{
	this->patronymic = patronymic;
}

bool FIO::operator==(FIO fio1)
{
	if (this->name == fio1.name && this->surname == fio1.surname && this->patronymic == fio1.patronymic)
		return true;
	return false;
}

