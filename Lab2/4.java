//README - "This program takes in an array of numbers 
//from the user and sorts it in ascending order thru selection sort. The program also has en method called 
//"getInvCount that counts how many elements that is not in the right place for the array to be completely sorted"



//Assignment 4 - number of inversions

import java.util.*;

public class inversions {
	

	
	public static void main (String args[]) {
	
	/*Scanner scan = new Scanner(System.in);
	System.out.println("Enter the size the input");
	int size = scan.nextInt(); 
	int[] numbers = new int[size];

    System.out.println("Write some random numbers");

    for (int i = 0; i < numbers.length-1; i++) {
        numbers[i] = scan.nextInt();
    }*/

		
		
	int[] numbers = {1, 2, 4, 3, 5, 0};
	int n = getInvCount(numbers);
	SelectionSort(numbers);
	System.out.println("\n\nNumber of inversions are " + n);
	
	
	}
	
   
   public static int[] SelectionSort(int[] arr){
	   
	   int c = 0;
	   
      for (int i = 0; i < arr.length - 1; i++){
    	  
         int index = i;
         
         for (int j = i + 1; j < arr.length; j++)
        	 
            if (arr[j] < arr[index]) 
               index = j;
               int smallerNumber = arr[index];  
               arr[index] = arr[i];
               arr[i] = smallerNumber;
               
               c++;
               
               System.out.println("\n");
               System.out.println("Swap number: " + c);
           	for(int k = 0; k < arr.length; k++)
           		System.out.print(arr[k] + ",");
           	
         }
         return arr;
   }
   
   
   static int getInvCount(int[] a) { // räknar antalet element som är i fel ordning
	      
	   int size = a.length;
	   int inCount = 0;
	   
	   System.out.println("Here's a list of all the inversions and their index\n");
	   
	   for(int i = 0; i < a.length-1; i++)
		   for(int j = i+1; j<a.length; j++)
			   if(a[i] > a[j]) { 
				   System.out.println("["+i+","+a[i]+"] " + " ["+j+","+a[j]+"]" );  //printar lista med inversioner
//				   System.out.println("Value i = " + a[i] + " at index "+ i + " and value j = " + a[j] + " at index "+ j);
				   inCount++;
			   }
	   
	   return inCount;
   }
   
   
   
   
}
