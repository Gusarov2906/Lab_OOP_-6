#include "Menu.h"

int main(int argc, char* argv[])
{
	cout << "PURCHASE DEPARTMENT DATABASE by Gusarov A.A." << endl;
	Database database;
	Menu menu(&database);
	menu.run();
}