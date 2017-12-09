#include <stdio.h>
#include<stdlib.h>//system(cls);
#include "list.h"

void SaveFile(List * ps)
{
    int i = 0;
	FILE*cfptr;

	if ((cfptr=fopen("StudentData.dat", "wb+"))== NULL)
	{
		puts("Could Not Open The File");

	}
	else{
		for (i = 0; i < ps->lsize; i++)
			fwrite(&ps->entry[i], sizeof(listentry), 1, cfptr);
	}
}
void ReadFile(List* ps)
{
    int i;
	FILE*cfptr;
	if ((cfptr=fopen("StudentData.dat", "wb+"))== NULL)
	{
		puts("Could Not Open The File");

	}
	else{
		//for (i = 0; i < ps->lsize; i++)
			fread(&ps->entry, 1, 1, cfptr);
        }
        printf("%d%d%s",ps->entry[0].classID,ps->entry[0].id,ps->entry[0].name);
}

void menu()
{
	puts("1-add student. \n "
      "2-Delete student. \n "
      "3-Delete class. \n "
      "4-Update student. \n "
      "5-search student ID. \n"
      "6- search student Name \n "
      "7- show all students\n "
      "8- save to file). \n "
      "0-Exit to program.\n");
}

void print(listentry e)
{
	printf("Class : %d ,Name :%s   , ID : %d \n\n", e.classID, e.name, e.id);
}
int main()
{
	int i;
	listentry e;
	List l;
	int choise;
	int p = 0;
	int x = 0;
	int b = 0;
	createlist(&l);
	//ReadFile(&l);
	char name[10];

	do
	{
		menu();
		scanf("%d", &choise);
		switch (choise)
		{
		case 1://// add student
			system("cls");
			if (!listfull(&l))
			{
				printf("Enter class ID\n");
				scanf("%d", &e.classID);
				printf("enter your name \n");
				scanf("%s", &e.name);
				printf("enter your ID number \n");
				scanf("%d", &e.id);
				insertstudent(e, &l);
				printf("your Id added succesfully\n\n");
				printf("size of school is : %d \n \n\n", listsize(&l));
			}
			else
			{
				printf("class is full\n");
			}
			break;


		case 2://// delete student
			system("cls");
			if (!listempty(&l))
			{
				printf("Enter Id you want to delete \n");
				scanf("%d", &p);
				p = searchID(p, &l);
				if (p != -1)
				{
					printf("This student deleted succesfully \n");
					deletelist(p, &e, &l);
					printf("size of school is : %d \n\n\n", listsize(&l));
				}
				else
				{
					printf("student isn't found \n\n");
				}

			}
			else
			{
				printf("class is empty\n\n");
			}

			break;

		case 3:/// delete class
			system("cls");
			if (listsize(&l) != 0)
			{
				printf("Enter ID of class you want to delete\n");
				scanf("%d", &b);
				b = searchclassID(b, &l);
				if (b != -1)
				{

					deletelist(b, &e, &l);
					printf("your class deleted succesfully \n\n");
					printf("size of class is : %d \n", listsize(&l));

				}
				else
				{
					printf("student isn't found \n\n");
				}

			}
			else
			{
				printf("this is no class created\n");
			}
			break;


		case 4:
			system("cls"); ////update student
			printf("enter student ID\n");
			scanf("%d", &x);
			x = searchID(x, &l);
			if (x != -1)
			{
				RetrieveList(x, &e, &l);
				if (!listfull(&l))
				{
					deletelist(x, &e, &l);
					printf("Enter class new ID\n");
					scanf("%d", &e.classID);
					printf("enter your new name \n");
					scanf("%s", &e.name);
					printf("enter your new ID number \n");
					scanf("%d", &e.id);
					insertstudent(e, &l);
					printf("your Id added succesfully\n\n");
					printf("Class : %d ,Name :%s   , ID : %d \n\n", e.classID, e.name, e.id);
					printf("size of school is : %d \n \n\n", listsize(&l));
				}
				else
				{
					printf("class is full\n");
				}
			}
			else
			{
				printf("student is not founded \n\n");
			}
			break;

		case 5:////// search student ID
			system("cls");
			printf("enter student ID\n");
			scanf("%d", &x);
			x = searchID(x, &l);
			if (x != -1)
			{
				RetrieveList(x, &e, &l);
				printf("Class : %d ,Name :%s   , ID : %d \n\n", e.classID, e.name, e.id);
				printf("size of school is : %d \n\n\n", listsize(&l));
			}
			else
			{
				printf("student is not founded \n\n");
			}

			break;
		case 6:///search student Name
			system("cls");
			printf("enter student Name\n");
			scanf("%d", &name);
			x = searchname(name, &l);
			if (x != -1)
			{
				RetrieveList(x, &e, &l);
				printf("Class : %d ,Name :%s   , ID : %d \n\n", e.classID, e.name, e.id);
				printf("size of school is : %d \n\n\n", listsize(&l));
			}
			else
			{
				printf("student is not founded \n\n");
			}

			break;

		case 7:
			system("cls");
			TraverseList(&l, &print);
			break;

		case 8:
			system("cls");
			SaveFile(&l);

			break;

		}//switch
	}//do
	while (choise != 0);
}//main
