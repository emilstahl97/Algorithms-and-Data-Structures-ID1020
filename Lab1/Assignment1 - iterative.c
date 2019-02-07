//README This simple program takes in a string of characters and reverses them through a iterative method.

//LAB 1 - ASSIGNMENT 1 - ITERATIVE

//@author emilstahl 

#include<stdio.h>

void reverse(char str[],int count)
{
    int i, j;
    char temp;
    
    for(i=0, j = count-1; i < j; i++, j--){
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    // run a for loop to show the reverse string.
    for(i=0; (putchar(str[i]) != '\0'); i++);
    putchar('\n');
}

int main(void)
{
    char str[50];
    int count;
    
    for(count=0; (str[count]=getchar()) != '\n'; ++count);
    
    str[count+1]='\0';
    
    reverse(str, count);
    
    return 0;
}
