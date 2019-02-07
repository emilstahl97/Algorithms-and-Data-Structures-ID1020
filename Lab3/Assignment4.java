//README This program counts the most frequent word in a text file. It's done first with a BST and then with a RBBST. 

//filteredVersion is a text file with 130 000 words. Due to the extra operation RBBST
//requires it results in that BST is faster. But "big.txt" contains 18 million words. 
//Here RRBST starts to crush its opponent due to its balanced structure. It is 11 seconds faster than BST. 

//@author emilstahl 

/************OUTPUT******************
The most frequent word is: 'the' and it's used 7508 times
Number of distinct words = 10809
Total number of words    = 139985

The most frequent word is: 'the' and it's used 7508 times
Number of distinct words = 10809
Total number of words    = 139985

Binary Search Tree: 357ms
Red Black Binary Tree: 341ms
**************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Assignment4 {
	
    public static void main(String[] args) throws FileNotFoundException {
        

    	Scanner scan =  new Scanner(new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt"));
    	Scanner scan2 =  new Scanner(new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt"));
    	
//    	Scanner scan =  new Scanner(new FileReader("/Users/emilstahl/Desktop/big.txt"));
//    	Scanner scan2 =  new Scanner(new FileReader("/Users/emilstahl/Desktop/big.txt"));
    	

        RedBlackBST<String, Integer> RBBST = new RedBlackBST<>();
        BST<String, Integer> BST = new BST<>();

        long startTimeForBST = System.currentTimeMillis();
        FrequencyCounter.frequencyCounter(BST, scan);
        long stopTimeBST = System.currentTimeMillis();
        long elapsedTimeBST = stopTimeBST - startTimeForBST;

        long startTimeForRBBST = System.currentTimeMillis();
        FrequencyCounter.frequencyCounter(RBBST, scan2);
        long stopTimeRBBST = System.currentTimeMillis();
        long elapsedTimeRBBST = stopTimeRBBST - startTimeForRBBST;


        System.out.println("Binary Search Tree: " + (elapsedTimeBST) + "ms");
        System.out.println("Red Black Binary Tree: " + (elapsedTimeRBBST)+ "ms");
        
    }
}