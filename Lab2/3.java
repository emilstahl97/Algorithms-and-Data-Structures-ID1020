//README - "This program takes in an array of numbers 
//from the user and sorts it in ascending order thru selection sort. The program then counts how many swaps that
// is performed during the sort. Which for selection sort is N-1 swaps"

//Assignment 3 - Number of Swaps

public class numberOfSwaps {
	

	
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
	   
	   int c = 0;
	   
      for (int i = 0; i < arr.length - 1; i++){
    	  
         int index = i;
         
         for (int j = i + 1; j < arr.length; j++)
        	 
            if (arr[j] < arr[index]) 
               index = j;
               int smallerNumber = arr[index];  
               arr[index] = arr[i];
               arr[i] = smallerNumber;
               
               c++; // antal swaps
               
               System.out.println("\n");
               System.out.println("Swap number: " + c); //printar swaps
           	for(int k = 0; k < arr.length; k++)
           		System.out.print(arr[k] + ",");
           	
         }
         return arr;
   }
   
}
