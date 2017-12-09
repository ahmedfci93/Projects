#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#include <time.h>
#include "Header.h"

using namespace std;

int main(void)
{
	welcome();
	srand(time(NULL));
	Creation();
	display();

	while (1) {
		direction();
		input();
		display();
	}
	return 0;
}