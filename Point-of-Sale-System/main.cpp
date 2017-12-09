#include <iostream>
#include <string>
#include <iomanip>
#include <windows.h>
#include <fstream>
#include "source.h"

using namespace std;
void suppliermenu();
void managermenu();
void cashiermenu();

int main()
{
    Manager ahmed("2012","Ahmed");
	cashier mohamed("2011","Mohamed");
	supplier mido ("2010","mido");
	cout <<"\t\tWelcome to the program"<<endl;
    cout <<"\t\t Please Enter Your ID to login : "<<endl;
    int id;
    string x;
    cin >> id;
    if (id==2012)
    {
        cout <<"Welcome Manager";
        managermenu();
        while (1)
        {
            int choice;
            cin>>choice;
            switch (choice)
            {
            case 1:
                Manager.displayInventory();
            break;
            case 2:
                Manager.call_supplier();
            break;
            case 3:
                cout>>"entet 1 to up and 2 to exit"<<endl;
                while(x = getchar() && x != EOF)
               {
                Manager.update_price(x);
               }
            break;

            case 4:
                return 0;
            break;
            }
        }
    }

void managermenu()
{
    HANDLE hConsole;
    int k=14;
    hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(hConsole, k);
	cout << setw(65) << "----------------------Main Menu--------------------" << endl;
	cout << setw(65) << "|                                                 |" << endl;
	cout << setw(65) << "|--------------1.Display Inventory----------------|" << endl;
	cout << setw(65) << "|--------------2.Call Supplier--------------------|" << endl;
	cout << setw(65) << "|--------------3.Update prices--------------------|" << endl;
	cout << setw(65) << "|--------------4.Quit-----------------------------|" << endl;
	cout << setw(65) << "|                                                 |" << endl;
	cout << setw(65) << "---------------------------------------------------" << endl;
}

void suppliermenu()
{
    HANDLE hConsole;
    int k=14;
    hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(hConsole, k);
	cout << setw(65) << "----------------------Main Menu--------------------" << endl;
	cout << setw(65) << "|                                                 |" << endl;
	cout << setw(65) << "|--------------1.Add Inventory--------------------|" << endl;
	cout << setw(65) << "|--------------2.Update Inventory-----------------|" << endl;
	cout << setw(65) << "|--------------3.Show costs-----------------------|" << endl;
	cout << setw(65) << "|--------------4.Quit-----------------------------|" << endl;
	cout << setw(65) << "|                                                 |" << endl;
	cout << setw(65) << "---------------------------------------------------" << endl;
}
