#include <iostream>
#include <string>
using namespace std;

class Person
{
protected:
	string name;
	string id;
public:
	void setid(string);
	void setname(string);
	string getid();
	string getname();
};

class Manager : public Person
{
public:
	Manager(string,string);
	void displayInventory();
	void call_supplier();
	bool update_price(string);
	bool deleteitem(string);
};

class cashier :public  Person
{
public:
	cashier(string,string);
	void take_order();
	void update_order();
	void delete_order();
	void show_invoice();
	void save_sales();
	bool update_inventory();
};

class supplier :public  Person
{
public:
	supplier(string,string);
	void add_inventory();
	bool update_inventory();
	void show_costs();
};

class customer : public Person
{
private:
	string address;
public:
	void set_address(string);
	string get_address();
	void set_order(int, int);
	void set_deliver(string, int);
};

class Items
{
private:
	string item_name;
	string item_id;
	float item_price;
	int item_quantity;
public:
	void setitem_name(string);
	void setitem_id(string);
	void setitem_price(float);
	void setitem_quantity(int);
	string getitem_name();
	string getitem_id();
	float getitem_price();
	int getitem_quantity();
};

class market
{
private:
	string name;
	string address;
	string phone;
public:
	void setname(string);
	void setaddress(string);
	void setphone(string);
	string getphone();
	string getname();
	string getaddress();
};
