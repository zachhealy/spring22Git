#include <stdio.h>
#include <stdlib.h>

int strend(char *s, char *t){
  int sLen = 0, tLen = 0;
  while(*t != '\0'){
    t++;
    tLen++;
  }
  t--;
  while(*s != '\0'){
    s++;
    sLen++;
  }
  s--;
  for(; tLen > 0; tLen--){
      if(*s != *t)
        return 0;
      s--;
      t--;
  }
  return 1;

}

int main(){
  char is[50];
  printf("S: ");
  gets(is);
  char *s = is;

  char it[50];
  printf("T: ");
  gets(it);
  char *t = it;


  printf("%d\n", strend(s, t));

}
