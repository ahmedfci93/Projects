

#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED

#define EQ(a,b) ((a)==(b))
#define LE(a,b) ((a)<=(b))
#include <string.h>
#include <stdio.h>
#define MAXLIST 20

typedef struct listentry
{
	int id;
	char name[10];
	int classID;


}listentry;

typedef struct List
{
	int lsize;
	listentry entry[MAXLIST];

}List;


void InsertList(int p, listentry, List *);
void createlist(List *);
void destroylist(List *);
void deletelist(int p, listentry *, List *);
int listsize(List *);
void RetrieveList(int p, listentry*, List*);
void ReplaceList(int p, listentry, List*);
void TraverseList(List *, void(*visit)(listentry));
int searchID(int, List *);
int searchname(char *, List *);
void insertstudent(listentry, List *);
int listempty(List *);
int listfull(List *);
int searchclassID(int, List *);

#endif // LIST_H_INCLUDED
