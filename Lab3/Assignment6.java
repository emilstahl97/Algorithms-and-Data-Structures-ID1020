//README This program allows the user to ask the question "on which 
//positions in the text (i.e. the number of characters from the beginning) you find the word X". 
//The program lists the position of all occurrences of X as answer to the query

//@author emilstahl

//LAB 3 - ASSIGNMENT 6

//INPUT
//Harbour

//OUTPUT
//Harbour is written [2] times in the text:

//Place:[1] At character [104821-104828] 
//Place:[2] At character [136777-136784] 

//Total execution time for work was 134ms


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class findIndex {

    public static void main(String[] args) throws FileNotFoundException {

    	
    	FileReader numberOfWords = new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt");
        Scanner scan = new Scanner(numberOfWords); //scanner to scan number of words

        int words = 0;
               
        while (scan.hasNext()) {
        	
            if (null == scan.next()) //if null break
            {
                break;
            }
            words++;
        }

        FileReader input = new FileReader("/Users/emilstahl/Desktop/filteredVersion.txt"); //scanner to read characters
        Scanner text = new Scanner(input);


        Scanner userIn = new Scanner(System.in); //scanner to scan users input
        System.out.println("Enter a word to search for: ");
        String target = userIn.next().toLowerCase(); //convert users input so that all words can be found regardless of case
        userIn.close();

        int targetLen = target.length(); //determine target length so that words with other length can be ignored
        int WC = 0; //word counter
        int CC = 0; //character counter
        int index = 0; 
        int hits = 0; //number of matches in file

        String[] placeInText = new String[words]; 

        long startTime = System.currentTimeMillis(); //start measuring time 

        while (text.hasNext()) { //if there is a character
        	
            String word = text.next().toLowerCase(); // get next word
            WC++; //increment word counter
            CC += word.length(); //increment character counter
            
            if (word.length() < targetLen || word.length() > targetLen) // ignore smaller and bigger words
                continue; // continue
            
            if (word.equals(target)) 
            {
                hits++;
                placeInText[index++] = ((CC - word.length()) + "-" + CC); //cc - length of word results in that character that the word starts at
            }
            
            if (words == WC)
            {
                break; 
            }
        }

        if (0 == hits) //if no hits, print message
        {
            System.out.println("[" + target + "] was not found in file ");
        }
        else {
        	
        	System.out.println("\n"+target + " is written [" + hits + "] times in the text:\n"); //print number of hits
        }
        
        for (int i = 0; i < hits; i++) { //print each index of hit 
            if (null == placeInText[i]) //if null then break 
            {
                break;
            }
            
            System.out.println("Place:["+ i+"] At character ["+ placeInText[i] + "] "); //print at which characters word can be found
            
        }
        long stopTime = System.currentTimeMillis(); //stop measure time 
        long exTime = stopTime - startTime; //total time
        System.out.println();
        System.out.println("Total execution time for work was " + exTime + "ms"); //print execution time

    }
}