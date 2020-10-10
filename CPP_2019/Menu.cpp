#include "Menu.h"





Menu::Menu(Database* ptr)
{
	database = ptr;
}

Menu::~Menu()
{
}

void Menu::run()	
{
	if (!database->load())
	{
		add_request();
	}


	while (true)
	{
		int cmd;
		while (1)
		{
			try {
				std::cout << "Command: " << endl << "1:Add worker" << endl << "2:Add request" << endl
					<< "3:Print all workers" << endl << "4:Print all requests" << endl
					<< "5:Close requset" << endl << "6:Print not closed requests" << endl
					<< "7:Print closed request of month" << endl << "8:Clear" << endl
					<< "9:Close" << endl << "Enter cmd: ";
				cmd = database->input_int_protected();
				if (cmd < 0 || cmd>9)
				{
					throw exception("Cmd must be in range 1 - 9\n");
					continue;
				}
				break;
			}
			catch (exception ex)
			{
				cout << ex.what() << endl;
			}
		}
		switch (cmd)
		{
		case Commands::Add_worker:
			add_worker();
			break;

		case Commands::Add_request:
			add_request();
			break;

		case Commands::Print_all_workers:
			print_all_workers();
			break;

		case Commands::Print_all_requests:
			print_all_requests();
			break;

		case Commands::Close_request:
			close_request();
			break;

		case Commands::Print_not_closed_requests:
			print_not_closed_requests();
			break;

		case Commands::Print_closed_request_of_month:
			print_closed_request_of_month();
			break;

		case Commands::Clear:
			clear();
			break;

		case Commands::Close:
			close();
			break;

		default:
			break;
		}
	}
}

void Menu::add_worker()
{
	Worker worker = database->get_worker_from_keyboard();
	database->add_worker(worker);
}

void Menu::add_request()
{
	Request request = database->get_request_from_keyboard();
	database->add_request(request);
}

void Menu::print_all_requests()
{
	database->print_all_requests();
}

void Menu::print_all_workers()
{
	database->print_all_workers();
}

void Menu::close_request()
{
	int n;
	cout << "Write number of request: ";
	n = database->input_int_protected();
	tm date = database->get_date_from_keyboard();
	database->close_request(n-1, date);
}

void Menu::print_not_closed_requests()
{
	database->print_not_closed_requests();
}

void Menu::print_closed_request_of_month()
{
	int month, year;
	while (1)
	{
		try
		{
			std::cout << "Write month: " << endl;
			month = database->input_int_protected();
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
			year = database->input_int_protected();
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
	date.tm_mon = month;
	date.tm_year = year - 1990;
	database->closed_request_of_month(date);
}

void Menu::close()
{
	database->save();

	exit(0);
}

void Menu::clear()
{
	database->clear();
}
