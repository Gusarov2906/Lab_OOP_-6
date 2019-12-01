#define _CRT_SECURE_NO_WARNINGS
#pragma once
#include "Database.h"

class Menu
{
private:
	Database* database;

	enum Commands
	{
		Add_worker = 1,
		Add_request,
		Print_all_workers,
		Print_all_requests,
		Close_request,
		Print_not_closed_requests,
		Print_closed_request_of_month,
		Clear,			
		Close
	};
public:
	Menu(Database* ptr);
	~Menu();
	void run();

private:
	void add_worker();
	void add_request();
	void print_all_requests();
	void print_all_workers(); 
	void close_request();
	void print_not_closed_requests();
	void print_closed_request_of_month();
	void close();
	void clear();
};


