#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#include <time.h>
#include "Header.h"

using namespace std;

int score, hscore, key = 0, prev_key;
double speed = 0.1;

char base[MAX_Y][MAX_X]; 

typedef struct Body { 
	int y;
	int x;
	struct Body *prev;
	struct Body *next;
} body;

body *Head = NULL; 
body *Tail = NULL; 
struct point { 
	int y;
	int x;
} food_pos;
void load()
{
    int row,col,r,c,q;
    gotoxy(36,9);
    cout<<"loading...";
    gotoxy(30,10);
    for(r=1; r<=20; r++)
    {
        for(q=0; q<=100000000; q++); 
        cout<<"/";
    }
	system("cls");
}


void welcome()
{
	int key;
	system("title Snake");
	system("cls");
	gotoxy(35, 1);
	cout <<"Snake";
	gotoxy(28, 4);
	cout <<".:Game Information:.";
	gotoxy(35, 6);
	cout <<"Food: *";
	gotoxy(30, 10);
	cout<<"Move: Arrow keys";
	gotoxy(28, 15);
	cout<<"Press Enter to start.";
	key = _getch();
	system("cls");
	load();
}



void busy_wait(double speed)
{
	clock_t busy_wait;
	busy_wait = clock() + speed * CLOCKS_PER_SEC;
	while (clock() < busy_wait) {}
}

void gotoxy(unsigned short x, unsigned short y)
{
	HANDLE handle = GetStdHandle(STD_OUTPUT_HANDLE);
	COORD position = { x, y };
	SetConsoleCursorPosition(handle, position);
}

void Creation()
{
	int y, x;
	score = 0;
	for (y = 0; y < MAX_Y; y++) {
		for (x = 0; x < MAX_X; x++) {
			base[y][x] = ' ';
		}
	}
	for (y = 1; y < MAX_Y - 1; y++) {
		base[y][0] = 186;
		base[y][MAX_X - 1] = 186;
	}

	for (x = 1; x < MAX_X - 1; x++) {
		base[0][x] = 205;
		base[MAX_Y - 1][x] = 205;
	}
	base[0][0] = 201;
	base[0][MAX_X - 1] = 187;
	base[MAX_Y - 1][0] = 200;
	base[MAX_Y - 1][MAX_X - 1] = 188;
	add_body(10, 30);
	add_body(10, 29);
	Draw();
	food();
	key = (rand() % DOWN);
	while ((key != UP) && (key != LEFT) && (key != RIGHT) && (key != DOWN)) {
		key = (rand() % DOWN);
	}
	prev_key = key;
}

void end()
{
	int key;

	deallocation();
	system("cls");
	gotoxy(30, 1);
	cout<<"You lost. Score: "<< score;
	gotoxy(10, 3);
		switch(prev_key)
		{
	case  LEFT :
		cout<<"you should have pressed left or right, good luck next time";
	break;
	case  RIGHT :
		cout<<"you should have pressed left or right, good luck next time";
	break;
	case UP :
		cout<<"you should have pressed up or down, good luck next time";
	break;
	case DOWN :
		cout<<"you should have pressed up or down, good luck next time";
	break;
		}
	gotoxy(10, 6);
	cout<<"Wanna play again? Press Enter to replay or Escape to exit. ";

	key = _getch();
	
	if (key == 13) {
		main();
	}
	else if (key == 27) {
		exit(0);
	}
}

void add_body(int y, int x)
{
	body *tmp;

	tmp = (body *)malloc(sizeof(body));

	if (Head == NULL) {	
		Head = tmp;
		tmp->prev = NULL;
	}
	else {	
		Tail->next = tmp;
		tmp->prev = Tail;
	}

	tmp->y = y;
	tmp->x = x;
	tmp->next = NULL;
	Tail = tmp;
}

void Draw()
{
	body *curr;
	curr = Head;

	while (curr != NULL) { 
		base[curr->y][curr->x] = '*';
		curr = curr->next;
	}
	self_eat();
}

void display()
{
	gotoxy(0, 0);
	int y, x;

	cout<<"Score: "<< score<<endl;

	for (y = 0; y < MAX_Y; y++) {
		cout<<"\t";
		for (x = 0; x < MAX_X; x++) {
			cout <<base[y][x];
		}
		cout<<endl;
	}
	busy_wait(speed);
}

void input()
{
	if (kbhit()) { 
		prev_key = key;
		key = getch(); 
		key = getch();

	}

	if (prev_key == RIGHT && key == LEFT) { 
		key = prev_key;
	}
	else if (prev_key == LEFT && key == RIGHT) { 
		key = prev_key;
	}
	else if (prev_key == UP && key == DOWN) { 
			key = prev_key;
	}
	else if (prev_key == DOWN && key == UP) { 
		key = prev_key;
	}
}

void direction()
{
	int y = Head->y, x = Head->x;

	if (key == UP) {
		y--;
		move(y, x);
	}
	else if (key == DOWN) {
		y++;
		move(y, x);
	}
	else if (key == RIGHT) {
		x++;
		move(y, x);
	}
	else if (key == LEFT) {
		x--;
		move(y, x);
	}
	else {
		key = prev_key;
		direction();
	}

}

void move(int y, int x)
{
	body *curr;
	curr = Tail;

	base[Tail->y][Tail->x] = ' ';

	while (curr != Head) {
		curr->y = curr->prev->y;
		curr->x = curr->prev->x;
		curr = curr->prev;
	}

	Head->y = y;
	Head->x = x;

	Draw();
	check();
}

void food()
{
	body *b_tmp;
	int b_con = 0;

	food_pos.x = (rand() % (MAX_X - 3)) + 1;
	food_pos.y = (rand() % (MAX_Y - 3)) + 1;

	b_tmp = Head;
	while (b_tmp != NULL) {
		if ((food_pos.y == b_tmp->y) && (food_pos.x == b_tmp->x)) {
			b_con = 1;
			b_tmp = NULL;
		}
		else {
			b_tmp = b_tmp->next;
		}
	}

	if (b_con == 1) {
		food();
	}

	base[food_pos.y][food_pos.x] = '@';
}


void check()
{
	if ((Head->y == food_pos.y) && (Head->x == food_pos.x)) {
		food();
		++score;
		speed -= 0.02;

		add_body(Tail->y, Tail->x);
		Draw();
	}                                               
	if ((Head->y == 0) || (Head->x == 0) || (Head->y == (MAX_Y - 1)) || (Head->x == (MAX_X - 1))) {
		end();
	}
}

void self_eat()
{
	body *tmp;
	tmp = Head->next;

	while (tmp != NULL) {
		if ((Head->y == tmp->y) && (Head->x == tmp->x)) {
			tmp = NULL;
			end();
		}
		else {
			tmp = tmp->next;
		}
	}
}

void deallocation()
{
	body *b_curr, *b_next;

	b_curr = Head;
	while (b_curr != NULL) {
		b_next = b_curr->next;
		free(b_curr);
		b_curr = b_next;
	}

	Head = NULL;
	Tail = NULL;
}
