#include "list.h"

void InsertList(int p, listentry e, List * pl)
{
	int i;
	for (i = pl->lsize - 1; i >= p; i--)
		pl->entry[i + 1] = pl->entry[i];
	pl->entry[p] = e;
	pl->lsize++;
}

void deletelist(int p, listentry *pe, List *pl)
{
	int i;
	*pe = pl->entry[p];
	for (i = p + 1; i <= pl->lsize - 1; i++)
		pl->entry[i - 1] = pl->entry[i];
	pl->lsize--;
}

void createlist(List * pl)
{
	pl->lsize = 0;
}

void destroylist(List * pl)
{
	pl->lsize = 0;
}

int listsize(List *pl)
{
	return pl->lsize;
}
void RetrieveList(int p, listentry*pe, List*pl)
{
	*pe = pl->entry[p];
}

void ReplaceList(int p, listentry e, List*pl)
{
	pl->entry[p] = e;
}

void TraverseList(List *pl, void(*visit)(listentry))
{
    int i = 0;
	for ( i = 0; i<pl->lsize; i++)
	{
		(*visit)(pl->entry[i]);
	}
}

int searchID(int target, List * pl)
{
	int current, s = listsize(pl);
	listentry currententry;
	for (current = 0; current<s; current++)
	{
		RetrieveList(current, &currententry, pl);
		if (EQ(target, currententry.id))
			return current;
	}
	return -1;
}

void insertstudent(listentry e, List *pl)
{
	int current, s = listsize(pl);
	listentry currententry;
	for (current = 0; current<s; current++)
	{
		RetrieveList(current, &currententry, pl);
		if (LE(e.classID, currententry.classID))
			break;
	}
	InsertList(current, e, pl);
}

int listempty(List *pl)
{
	return !pl->lsize;
}

int listfull(List *pl)
{
	return pl->lsize == MAXLIST;
}
int searchclassID(int target, List * pl)
{
	int current, s = listsize(pl);
	listentry currententry;
	for (current = 0; current<s; current++)
	{
		RetrieveList(current, &currententry, pl);
		if (EQ(target, currententry.classID))
			return current;
	}
	return -1;
}


int searchname(char target[10], List * pl)
{
	int current, s = listsize(pl);
	listentry currententry;
	for (current = 0; current<s; current++)
	{
		RetrieveList(current, &currententry, pl);
		if (!EQ(target, currententry.name))
			return current;
	}
	return -1;
}
