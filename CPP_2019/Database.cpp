#include "Database.h"
#include <time.h>

#include <cstdlib>
#include <cstring>
#include <iostream>
#include <fstream>

#define MAX_TEXT_LEN 100

Database::Database()
{
	count_w = 0;
	count_r = 0;
	requests = nullptr;
	workers = nullptr;
}

Database::~Database()
{
	delete[] requests;
	delete[] workers;
}

void Database::add_worker(Worker &worker)
{
	
	Worker** workers_tmp = static_cast<Worker**>(realloc(workers, sizeof(Worker*) * (this->count_w + 1)));
	if (workers_tmp)
	{
		workers = workers_tmp;
		workers[count_w] = new Worker(worker);
		count_w++;
	}
	
	
}

Worker Database::get_worker_from_keyboard()
{
	string name , surname, patronymic,post;
	double salary;
	cout << "Write surname: " << endl;
	cin >> surname;
	cout << "Write name: " << endl;
	cin >> name;
	cout << "Write patronymic: " << endl;
	cin >> patronymic;
	FIO fio = FIO(name, surname, patronymic);
	cout << "Write post: " << endl;
	cin >> post;
	cout << "Write salary: " << endl;
	salary = input_double_protected();
	Worker worker = Worker(fio, post, salary);
	return worker;
}

tm Database::get_date_from_keyboard()
{
	int day, month, year;
	while (1)
	{
		try
		{
			std::cout << "Write day: " << endl;
			day = input_int_protected();
			if (day < 1 || day >31)
			{
				throw  exception("Value of day is in range 1 - 31!\n");
				continue;
			}
			break;
		}
		catch (exception ex)
		{
			cout << ex.what();
		}
	}
	while (1)
	{
		try
		{
			std::cout << "Write month: " << endl;
			month = input_int_protected();
			if (month < 1 || month >12)
			{
				throw  exception("Value of month is in range 1 - 12!\n");
				continue;
			}
			break;
		}
		catch (exception ex)
		{
			cout << ex.what();
		}
	}
	while (1)
	{
		try {
			cout << "Write year: " << endl;
			year = input_int_protected();
			if (year < 1990 || year >2019)
			{
				throw  exception("Value of year is in range 1990 - 2019!\n");
				continue;
			}
			break;
		}
		catch (exception ex)
		{
			cout << ex.what();
		}
	}
	tm date = tm();
	date.tm_mday = day;
	date.tm_mon = month;
	date.tm_year = year - 1990;
	return date;
}

void Database::add_request(Request &request)
{
	Request** requests_tmp = static_cast<Request**>(realloc(requests, sizeof(Request*) * (this->count_r + 1)));
	if (requests_tmp)
	{
		requests = requests_tmp;
		requests[count_r] = new Request(request);
		count_r++;
	}

	
}

Request Database::get_request_from_keyboard()
{
	Worker worker;
	while (true)
	{
		if (workers)
		{
			try {
				cout << "Commands:" << endl << "1:Select worker" << endl << "2:New worker" << endl;
				int n;
				n = input_int_protected();
				if (n == 1)
				{
					print_all_workers();
					n = input_int_protected();
					n--;
					worker = *workers[n];
					break;
				}
				else if (n == 2)
				{
					worker = get_worker_from_keyboard();
					break;
				}
				else
					throw exception("Cmd must be in range 1 - 2\n");
			}
			catch (exception ex)
			{
				cout << ex.what();
			}
		}
		else
		{
			worker = get_worker_from_keyboard();
			break;
		}
	}

	int num, quantity;
	double cost;
	string name;
	cout << "Write number of department: " << endl;
	num = input_int_protected();
	cout << "Write name of position: " << endl;
	cin >> name;
	cout << "Write quantity: " << endl;
	quantity = input_int_protected();
	cout << "Write price: " << endl;
	cost = input_double_protected();
	if (!is_in_workers(worker))
		add_worker(worker);
	Request request = Request(num, name, quantity, cost, worker);
	return request;



}

void Database::print_all_workers()
{
	for (int i = 0; i < count_w; i++)
	{
		cout << i+1 << ":";
		workers[i]->print();
		cout << endl <<endl;
	}
}

void Database::print_all_requests()
{
	for (int i = 0; i < count_r; i++)
	{
		cout << i+1 << ":";
		requests[i]->print();
		cout << endl;
	}
}

void Database::close_request(int num, tm date)
{
	requests[num]->set_date(date);
}

void Database::print_not_closed_requests()
{
	bool flag = false;
	cout << "Not closed requests: "<< endl;
	tm date = tm();
	for (int i = 0; i < count_r; i++)
	{
		tm date = requests[i]->get_date();
		if (date.tm_year == 0)
		{
			cout << i + 1 << ":";
			requests[i]->print();
			flag = true;
			cout << endl;
		}
	}
	if (!flag)
		cout << "There aren't not closed requests!" << endl;
}

void Database::closed_request_of_month(tm date)
{
	bool flag = false;
	cout << "Closed last month requests: " << endl;
	tm date1 = tm();
	for (int i = 0; i < count_r; i++)
	{
		tm date1 = requests[i]->get_date();
		if (date1.tm_mon == date.tm_mon && date1.tm_year == date.tm_year && date1.tm_year != 0)
		{
			cout << i << ":";
			requests[i]->print();
			flag = true;
			cout << endl;
		}
	}
	if (!flag)
		cout << "There aren't closed requests!" << endl;
}

bool Database::is_in_workers(Worker& worker)
{
	for (int i = 0; i < count_w; i++)
	{
		if (workers[i]->operator==(worker))
			return true;
	}
	return false;
}

bool Database::load()
{
	fstream file;
	file.exceptions(ifstream::badbit | ifstream::failbit);
	try {
		file.open("db.txt", std::fstream::in);
		cout << "Database file is loaded!" << endl;
		int dbSize = 0;
		file >> dbSize;			
		for (int i = 0; i < dbSize; i++)
		{
			string name_of_worker;
			string surname_of_worker;			
			string patronymic_of_worker;
			string post;
			double salary;
			int number_of_department;
			string name_of_position;
			int quantity;
			double cost;
			int day;
			int month;
			int year;
			file >> name_of_worker >> surname_of_worker >> patronymic_of_worker >> post >>
				salary >> number_of_department >> name_of_position >> quantity
				>> cost >> day >> month >> year;
			FIO fio(name_of_worker, surname_of_worker, patronymic_of_worker);
			Worker worker(fio, post, salary);
			tm date;
			date.tm_mday = day;
			date.tm_mon = month;
			date.tm_year = year;
			Request request(number_of_department, name_of_position, quantity, cost, worker);
			request.set_date(date);
			if (!is_in_workers(worker))
				add_worker(worker);
			add_request(request);
		}
		file.close();
		return true;
		}
	catch (const ifstream::failure & ex)
	{
		cout << "Failed to open database!" << endl;
		cout << ex.what() << endl;
		cout << ex.code() << endl;
		return false;
	}
}

void Database::save()
{
	fstream file;
	file.exceptions(ofstream::badbit | ofstream::failbit);
	try {
		file.open("db.txt", fstream::out);
		cout << "Database file is saved!" << endl;
		
		file << count_r << " " << std::endl;

		for (int i = 0; i < count_r; i++)
		{
			file << requests[i]->get_worker().get_fio().get_name() << " " << requests[i]->get_worker().get_fio().get_surname() << " "
				<< requests[i]->get_worker().get_fio().get_patronymic() << " " << requests[i]->get_worker().get_post() << " "
				<< requests[i]->get_worker().get_salary() << " " << requests[i]->get_number_of_department() << " "
				<< requests[i]->get_name_of_position() << " " << requests[i]->get_quantity() << " "
				<< requests[i]->get_cost() << " " << requests[i]->get_day() << " " << requests[i]->get_month() << " "
				<< requests[i]->get_year() << " " << std::endl;
		}

		file.close();
		
	}
	catch (const ifstream::failure & ex)
	{
		cout << "Failed to save database!" << endl;
		cout << ex.what() << endl;
		cout << ex.code() << endl;
	}
}

int Database::input_int_protected()
{
	while (1)
	{
		int tmp;
		std::cin >> tmp;
		if (std::cin.fail())
		{
			std::cin.clear();
			std::cin.ignore(32767, '\n');
			cout << "Wrong type! Required int:";
		}
		else
		{
			std::cin.ignore(32767, '\n');
			return tmp;
		}
	}
}

double Database::input_double_protected()
{
	while (1)
	{

		double tmp;
		std::cin >> tmp;
		if (std::cin.fail())
		{
			std::cin.clear();
			std::cin.ignore(32767, '\n');
			cout << "Wrong type! Required double:";
		}
		else
		{
			std::cin.ignore(32767, '\n');
			return tmp;
		}
	}
}

void Database::clear()
{
	count_w = 0;
	count_r = 0; 
	delete[] requests;
	delete[] workers;
}

