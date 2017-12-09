#include<iostream>
#include <string>
#include<fstream>
#include "User.h"
using namespace std;
void Person::setid(string myid)
{
	id = myid;
}
void Person::setname(string myname)
{
	name = myname;
}

string Person::getname()
{
	return name;
}
string Person::getid()
{
	return id;
}

void Manager::displayInventorry()
{

}

Manager::Manager(string myid, string myname)
{
	setid(myid);
	setname(myname);
}

supplier::supplier(string myid, string myname)
{
	setid(myid);
	setname(myname);
}

bool Manager :: add_item()
{
    string id;
	string name;
	int quantity;
	double price;
	ofstream myfile("inventory.txt", ios::app|ios::out);
	while (cin >> id >> name >> price >> quantity)
	{
	myfile << id << " " << name << " " << quantity << " " << prince << endl;
	}
	myfile.close();
	return true;
}

bool Manager :: deleteitem(string an_id)
{
	ifstream movetoarr("inventory.txt", ios::in);
	if (!movetoarr)
	{
		cerr << "Could not open file";
		return false;
	}
	string itemname;
	int  i_quantity, keyloc;
	float i_prince;
	string i_id;
	Items* existingitems[100];
	int counter = 0;
	int found = 0;
	while (!movetoarr.eof()) //copy elements from files->array
	{
		movetoarr >> i_id >> itemname >> i_prince >> i_quantity;
		existingitems[counter] = new Items();
		existingitems[counter]->setitem_id(i_id);
		existingitems[counter]->setitem_name(itemname);
		existingitems[counter]->setitem_price(i_prince);
		existingitems[counter]->setitem_quantity(i_quantity);
		counter++;
	}
	if (movetoarr.is_open())
		movetoarr.close();
	for (int i = 0; i < counter - 1; i++) //search in array
	{
		if (existingitems[i]->getitem_id() == an_id)
		{
			keyloc = i;
			i = counter;
			found++;
		}
	}
	if (found)
	{
		ofstream updatefile("inventory.txt", ios::out);
		for (int k = 0; k < counter - 1; k++)      //Creating new file with the updated items
		{
			if (k == keyloc)
			{
				continue;
			}
			updatefile << existingitems[k]->getitem_id() << ' ' << existingitems[k]->getitem_name() << ' ' << existingitems[k]->getitem_price() << ' ' << existingitems[k]->getitem_quantity() << endl;
		}
		if (updatefile.is_open())
			updatefile.close();

		if (!updatefile.good())
		{
			return false;
		}

		return true;
	}
	return false;
}

bool Manager :: update_item(string an_id)
{
	ifstream movetoarr("inventory.txt", ios::in);
	if (!movetoarr)
	{
		cerr << "Could not open file";
		return false;
	}
	string itemname;
	int  i_quantity, keyloc, q;
	float i_prince, p;
	string i_id;
	Items* existingitems[100];
	int counter = 0;
	int found = 0;
	while (!movetoarr.eof()) //copy elements from files->array
	{
		movetoarr >> i_id >> itemname >> i_prince >> i_quantity;
		existingitems[counter] = new Items();
		existingitems[counter]->setitem_id(i_id);
		existingitems[counter]->setitem_name(itemname);
		existingitems[counter]->setitem_price(i_prince);
		existingitems[counter]->setitem_quantity(i_quantity);
		counter++;
	}
	if (movetoarr.is_open())
		movetoarr.close();
	for (int i = 0; i < counter - 1; i++) //search in array
	{
		if (existingitems[i]->getitem_id() == an_id)
		{
			keyloc = i;
			i = counter;
			found++;
		}
	}
	if (found)
	{
		cin >> p >> q;
		existingitems[keyloc]->setitem_price(p);    //Updating
		existingitems[keyloc]->setitem_quantity(q);
		ofstream updatefile("inventory.txt", ios::out);
		for (int k = 0; k < counter - 1; k++)      //Creating new file with the updated items
		{
			updatefile << existingitems[k]->getitem_id() << ' ' << existingitems[k]->getitem_name() << ' ' << existingitems[k]->getitem_price() << ' ' << existingitems[k]->getitem_quantity() << endl;
		}
		if (updatefile.is_open())
			updatefile.close();

		if (!updatefile.good())
		{
			return false;
		}

		return true;
	}
	return false;
}

void Manager :: call_supplier()
{
    int x;
    cout<<"Enter the number of the supplier you want"<<endl;
    cout<<"1.Food supplier"<<endl;
    cout<<"2.meat supplier"<<endl;
    cout<<"3.fruit supplier"<<endl;
    cout<<"4.dirnks supplier"<<endl;
    cout<<"5.exit"<<endl;
    while (1)
        {
            cin>>x;
            switch (choice)
            {
            case 1:
                cout<<"Food supplier's Info"<<endl;
                cout<<"Name : ahmed essam"<<endl;
                cout<<"Tele : 011"<<endl;
                cout<<"Address : fuck street"<<endl;
            break;
            case 2:
                cout<<"Meat supplier's Info"<<endl;
                cout<<"Name : ahmed essam"<<endl;
                cout<<"Tele : 011"<<endl;
                cout<<"Address : fuck street"<<endl;
            break;
            case 3:
                cout<<"Fruit supplier's Info"<<endl;
                cout<<"Name : ahmed essam"<<endl;
                cout<<"Tele : 011"<<endl;
                cout<<"Address : fuck street"<<endl;
            break;
            case 4:
                cout<<"Dirnks supplier's Info"<<endl;
                cout<<"Name : ahmed essam"<<endl;
                cout<<"Tele : 011"<<endl;
                cout<<"Address : fuck street"<<endl;
            break;
            case 5:
                return 0;
            break;
        }
}


void market:: setname(string myname)
{
	name = myname;
}

void market:: setaddress(string myaddress)
{
	address = myaddress;

}
void market:: setphone(string myphone)
{
	phone = myphone;
}

string market::getphone()
{
	return phone;
}

string market:: getname()
{
	return name;
}
string market:: getaddress()
{
	return address;
}

void Items:: setitem_name(string myname)
{
	item_name = myname;
}

void Items:: setitem_id(string myid)
{
item_id	=myid;
}

void Items:: setitem_price(float myprice)
{
	item_price = myprice;
}

void Items::setitem_quantity(int myqyantity)
{
	item_quantity = myqyantity;
}

string Items::getitem_name()
{
	return item_name;
}

string Items::getitem_id()
{
	return item_id;
}

float Items::getitem_price()
{
	return item_price;
}

int Items::getitem_quantity()
{
	return item_quantity;
}

cashier:: cashier(string myid, string myname)
{
	setid(myid);
	setname(myname);
}


void cashier::update_order()
{

}

void cashier::delete_order()
{

}

void customer::set_address(string myaddress)
{
	address = myaddress;
}

string customer::get_address()
{
	return address;
}

void customer::set_order(int, int)
{

}

void customer::set_deliver(string, int)
{

}
