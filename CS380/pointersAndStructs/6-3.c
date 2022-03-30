#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void cross(FILE* nFile){
  char letter;
  int counter[100];
  int sloc = 0, aloc = 0, boolean = 0, holder = 0;
  char string[20];
  char strArr[200][20];

  while(fscanf(nFile, "%c", &letter) > 0){
    if((letter == ' ') || (letter == '\n')){
      for(int i = 0; i < aloc; i++){
        if(strcmp(string, strArr[i]) == 0){
          boolean = 1;
          holder = 1;

        }

      }
      if(boolean == 1){
        counter[holder]++;
        memset(string, 0, strlen(string));
        sloc = 0;
        boolean = 0; 
      }else{
        counter[aloc] = 1;
        strcpy(strArr[aloc++], string);
        memset(string, 0, strlen(string));
        sloc = 0;
      }
    }else{
      string[sloc++] = letter; 
    }

  }
  for(int i = 0; i < aloc; i++){
    if(strcmp(string, strArr[i]) == 0){
      boolean = 1;
      holder = 1;
    }

  }
  if(boolean == 1){
    counter[holder]++;
  }else{
    counter[aloc] = 1;
    strcpy(strArr[aloc++], string);

  }
  for(int i = 0; i < aloc; i++){
    printf("%s: %d\n", strArr[i], counter[i]);

  }
}
int main(){
  FILE *nFile = fopen("test.txt", "r");
  cross(nFile);

}