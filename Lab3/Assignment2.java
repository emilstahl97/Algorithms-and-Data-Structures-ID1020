//README This number searches thru a given textfile to determine the most frequent word and how many times it's used.

//Furthermore, it counts the number of distinct words as weel as total number of words. 

//LAB 3 - ASSIGNMENT 2 

//AUTHOR emilstahl

//OUTPUT
//Symbol Table: 
//
//The most frequent word is: the 7508
//Number of distinct words = 10809
//Total number of words    = 139985
//
//Binary Search Tree: 
//
//The most frequent word is: the 7508
//Number of distinct words = 10809
//Total number of words    = 139985
//
//Symbol Table: 768ms
//Binary Search Tree: 265ms



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Assignment2 {
	
    public static void main(String[] args) throws FileNotFoundException {
    	
    	//read in textfile
        Scanner scanST =  new Scanner(new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt"));
        Scanner scanBST =  new Scanner(new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt"));

        
        BinarySearchST<String, Integer> symbolTable = new BinarySearchST<>();
        BST<String, Integer> BST = new BST<>();

        System.out.print("Symbol Table: \n\n");
        long startTimeST = System.currentTimeMillis(); //start measure time for ST
        FrequencyCounter.frequencyCounter(symbolTable, scanST);
        long exeTimeST = System.currentTimeMillis(); //end measure time for ST
        
        System.out.print("Binary Search Tree: \n\n");
        long startTimeBST = System.currentTimeMillis(); //start measure time for BST
        FrequencyCounter.frequencyCounter(BST, scanBST);
        long exeTimeBST = System.currentTimeMillis(); //end measure time for BST

        System.out.println("Execution times:");
        System.out.println("Symbol Table: " + ((exeTimeST - startTimeST)) + "ms"); //execution time for ST
        System.out.println("Binary Search Tree: " + ((exeTimeBST - startTimeBST)) + "ms"); //execution time for BST
    }
}

