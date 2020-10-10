#pragma once
#include "Request.h"


class Database
{
private:
	Request** requests;
	Worker** workers;
	int count_w;
	int count_r;
public:
	Database();
	~Database();

	void add_worker(Worker& worker);
	void add_request(Request &request);

	Request get_request_from_keyboard();
	tm get_date_from_keyboard();
	Worker get_worker_from_keyboard();

	void print_all_workers();
	void print_all_requests();
	void print_not_closed_requests();

	void closed_request_of_month(tm date);

	void close_request(int num, tm date);
	
	bool is_in_workers(Worker& worker);

	bool load();
	void save();

	int input_int_protected();
	double input_double_protected();
	void clear();
};



