//Author: Zach Healy
#include <stdio.h> 

int main(){
  int counter = 0;
  int i;
  printf("Enter a string: ");
  
  while((i = getchar()) != '\n'){
    if(counter != 29){
      putchar(i);

    }
    else if(i == ' ' && counter == 29){
      printf("\n");
      counter = 0;

    }
    else{
      printf("-\n");
      putchar(i);

    }
    counter++;

  }
  printf("\n");

}
