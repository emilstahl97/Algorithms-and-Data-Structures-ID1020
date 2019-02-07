//README This program allows the user to query the system on which are the nth to the n+xth most frequent words 
//in the full text. It's done  thru a binary search tree. 

//LAB 3 - ASSIGNMENT 3

//@author emilstahl 

//OUTPUT 

//The 2nd to 20th most frequent word in 'A tale of two cities' is:

//The word: 'for' is used 915 times
//The word: 'him' is used 970 times
//The word: 'at' is used 989 times
//The word: 'her' is used 1007 times
//The word: 'as' is used 1057 times
//The word: 'you' is used 1229 times
//The word: 'had' is used 1296 times
//The word: 'with' is used 1302 times
//The word: 'he' is used 1459 times
//The word: 'it' is used 1740 times
//The word: 'was' is used 1765 times
//The word: 'that' is used 1841 times
//The word: 'his' is used 1942 times
//The word: 'I' is used 1986 times
//The word: 'in' is used 2522 times
//The word: 'a' is used 2846 times
//The word: 'to' is used 3566 times
//The word: 'of' is used 4052 times





import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Assignment3 {
	
    public static void main(String[] args) throws FileNotFoundException {
    
    	Scanner text =  new Scanner(new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt"));
        BST<String, Integer> BST = new BST<>();

        System.out.println("The 2nd to 20th most frequent word in 'A tale of two cities' is:\n");
        FrequencyCounter.freqChart(BST, text, 2, 18); //calling method in FrequencyCounter class
    }
}