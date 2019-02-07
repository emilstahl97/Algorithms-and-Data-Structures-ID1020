//README C program that puts all the negative numbers first before the positive. The array is not being sorted.

#include <stdio.h>
#include <math.h>

void insertionSort(int A[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = A[i];
        j = i-1;
        
        while (j >= 0 && A[j] > 0)
        {
            A[j+1] = A[j];
            j = j-1;
        }
        A[j+1] = key;
    }
}

void printAay(int A[], int n)
{
    int i;
    printf("Negative numbers put first:\n\n");
    for (i=0; i < n; i++)
        printf("%d ", A[i]);
    printf("\n\n");
}



/* Driver program to test insertion sort */
int main()
{
    int A[] = {-4,5-13,43,-32,-5,100,93,-11,12, 11, 13, 5, 6};
    int n = sizeof(A)/sizeof(A[0]);
    
    insertionSort(A, n);
    printAay(A, n);
    
    return 0;
}
