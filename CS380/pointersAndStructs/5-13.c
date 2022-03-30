#include <stdio.h>
#include <stdlib.h>

void tail(FILE *nFile, int n){
  char letter;
  int j = 0;
  while(fscanf(nFile, "%c", &letter) > 0){
    if(letter == '\n'){
      j++;
    }
  }
  int d = j - n;
  j = 0;
  rewind(nFile);
  while(fscanf(nFile, "%c", &letter) > 0){
    if(j > d){
      printf("%c", letter);
    }
    if(letter == '\n'){
      j++;
    }
    
  }
  printf("\n");

}

int main(int argc, char *argv[]){
  int n;
  printf("N: ");
  scanf("%d", &n);

  FILE *nFile = fopen("test.txt", "r'");

  tail(nFile, n);
    
}
