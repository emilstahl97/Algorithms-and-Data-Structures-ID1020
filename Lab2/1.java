//README - "This program takes in an array of numbers 
//from the user and sorts it in ascending order thru selection sort."


//Assignment 1 - Ascending order

import java.util.*;

public class main {
	

	
	public static void main (String args[]) {
	

/*	System.out.println("How many ints?");
	
	Scanner sc = new Scanner(System.in);
	int size = sc.nextInt();
	
	int[] numbers = new int[size];
	
	System.out.println("Insert values:");
	
	for(int i = 0; i < size; i++) {
		numbers[i] = sc.nextInt();
 			
	}
	
	sc.close();
*/	

		int[] numbers = {1,2,4,3,5,0};
		SelectionSort(numbers);
	
	}
	
   
   public static int[] SelectionSort(int[] arr){
	   
	   
      for (int i = 0; i < arr.length - 1; i++){ 
    	  
         int index = i; //börjar på 0 / första elementet i arrayen
         
         for (int j = i + 1; j < arr.length; j++) 
        	 
            if (arr[j] < arr[index]) //kollar om j är mindre än index
               index = j; 
               int smallerNumber = arr[index];  
               arr[index] = arr[i]; 
               arr[i] = smallerNumber;
               
               
               System.out.println("\n");
           	for(int k = 0; k < arr.length; k++)
           		System.out.print(arr[k] + ",");
           	
         }
         return arr;
   }
   
}
