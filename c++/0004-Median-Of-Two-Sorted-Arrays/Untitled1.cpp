
#include<stdio.h>

int main()
{
  int arr[]= {19,20,21,22,23};
  int *pr = arr;
  *(pr++)+=100;
  printf("%d %d\n",*pr,*(pr++));
  sizeof
  return 0;
}
