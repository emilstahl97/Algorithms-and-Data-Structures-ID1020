//README - This simple takes in a string of characters and calls a function reverse that's
//reverses the order

//LAB 1 - ASSIGNMENT 1 - RECURISIVE

//@author emilstahl

#include<stdio.h>

void reverse(void)
{
    char c;
    if((c = getchar()) != '\n'){
        
    reverse(); }
    putchar(c);
    
    return;
}

int main(void)
{
    printf("Enter a line of text below\n");
    reverse();
    putchar('\n');
}
