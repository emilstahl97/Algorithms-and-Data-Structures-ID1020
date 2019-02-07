//README - "This program takes in an array of numbers 
//from the user and sorts it in ascending order thru selection sort. When the array is sorted, the array is printed
//backwards in form of a for loop to print the numbers in descending order" 

//Assignment 2 - Descending order

import java.util.*;

public class descending {
	

	
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
    	  
         int index = i;
         
         for (int j = i + 1; j < arr.length; j++)
        	 
            if (arr[j] < arr[index]) 
               index = j;
               int smallerNumber = arr[index];  
               arr[index] = arr[i];
               arr[i] = smallerNumber;
               
               
               System.out.println("\n");
               for(int c = arr.length-1; c >= 0; c--) //printar arrayen baklänges för att sortera i nedåtgående ordning
               System.out.print(arr[c] + ",");
           	
         }
      
      
      
      
         return arr;
   }
   
}
