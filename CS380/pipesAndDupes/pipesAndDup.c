#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
    int p[2];       //pipe file descriptors
    char buf[1024]; //our buffer
    int n;          //count variable
    int fd;         //another file descriptor

    //create pipe
    if(pipe(p) != 0){
        fprintf(stderr, "Could not create pipe\n");
        exit(-1);

    }

    //pass a message through the pipe
    n = write (p[1], "hello", 5);
    n = read(p[0], buf, 1023);
    
    //add a null terminator to the buffer string
    buf[n] = '\0';

    //print the message from the pipe
    prinf("PIPE Message: %s\n", buf);

    //play with dup
    fd = dup(1);        //duplicate standard out
    write(fd, "hello, dup\n", 11);

    close(1);           //close standard out
    write(fd, "hello, dup\n", 11);

    //dup our pipe's write end
    dup(p[1]);         //map stdout onto p[1]

    //count to 10 using printf
    for(int i = 0; i <= 10; i++){
        printf("%d\n", i);

    }
    close(p[1]);    // close 1 fd for the pipe
    close(1);       //close the last one
    //pipe is now closed

    //read pipe messages
    while((n=read(p[0], buf, 1023)) > 0){
        buf[n] = '\0';
        fprintf(stderr, "PIPE Message: %s", buf);

    }

    return 0;

}