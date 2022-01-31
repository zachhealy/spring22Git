//Author: Zach Healy
#include <stdio.h>

int main() {
  int i;
  while((i = getchar()) != '\n'){
    if(i == ' '){
      putchar('\n');
    }
    else{
      putchar(i);
    }
  }
  putchar('\n');
  return 0;
}
