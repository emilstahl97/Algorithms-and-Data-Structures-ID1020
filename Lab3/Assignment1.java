//README This program reads a text file and filter out all its non-alphabetic characters.

//The alphabetic characters together with whitespace and newline is then wrritten into a new file.

//LAB 3 - ASSIGNMENT 1

//@AUTHOR emilstahl


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment1 {

    public static void main(String[] args) throws IOException {

        FileReader originalVersion = new FileReader    
                ("/Users/emilstahl/Desktop/ATaleOfTwoCities.txt"); 
        
                
        FileWriter filteredVersion = new FileWriter 
                ("/Users/emilstahl/Desktop/filteredVersion.txt");

            
           int i;
           int numberOfCharacters = 0;
           char CBR; //char that has Been read from file
              
           while ((i=originalVersion.read()) != -1) {
            	  	CBR = (char) i;
                  
            	  	if(Character.isLetter(CBR)) 
            	  	{
            	  		filteredVersion.write(CBR);
                    }
            	  	
            	  	else if(CBR == ' ') 
            	  	{
            	  		filteredVersion.write(CBR);
                    }
            	  	
            	  	else if(CBR == '\n') 
            	  	{
            	  		filteredVersion.write(CBR);
                    }
            	  
            	  	else 
            	  	{
            	  		filteredVersion.write(' ');
                    }
        	  		numberOfCharacters++;

              }
           System.out.println("Number of characters in this text was " + numberOfCharacters);
    }
   
}


