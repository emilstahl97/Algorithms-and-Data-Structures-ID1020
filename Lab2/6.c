//README C program that puts all the negative numbers first before the positive. The array is not being sorted. It also includes an loop invariant.

#include <stdio.h>
#include <math.h>

//Input: an Aay A storing n integers
//Output: the same Array with the elements sorted with negative numbers put first. But otherwise in random order

void insertionSort(int A[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = A[i];
        j = i-1;
        
        while (j >= 0 && A[j] > 0) // Invariant: A[0..j-1] contains the same elements as
            // the original subAay A[0..j-1], but there negative numbers are put before the positive. Other than that, the array is in random order.
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

