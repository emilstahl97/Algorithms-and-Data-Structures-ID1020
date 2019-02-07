//frequency counter  class provides a client for 
//reading in a sequence of words and printing a word (exceeding
//a given length) that occurs most frequently. It is useful as
// a test client for various symbol table implementations.


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//@author Robert Sedgewick
//@author Kevin Wayne
 
public class FrequencyCounter {

    // Do not instantiate.
    private FrequencyCounter() { }

    public static void frequencyCounter(GenericStore<String, Integer> BST, Scanner text) {
        
    	int distinct = 0; 
        int words = 0;

        // compute frequency counts
        while (text.hasNext()) {
            String key = text.next();
            words++;
            
            if (BST.contains(key)) 
            {
                BST.put(key, BST.get(key) + 1);
            }
            else {
                BST.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        BST.put(max, 0);
        for (String word : BST.keys()) {
            if (BST.get(word) > BST.get(max))
                max = word;
        }

        System.out.println("The most frequent word is: " + "'"+max+"'" + " and it's used " + BST.get(max) + " times");
        System.out.println("Number of distinct words = " + distinct);
        System.out.println("Total number of words    = " + words);
        System.out.println("");
    }

    public static void freqChart(GenericStore<String, Integer> BST, Scanner text, Integer n, Integer x) {
    	
        class Pair {
        	
            String word; //instantiate
            Integer numberOfTimes; //instantiate
             
            Pair(String word, Integer numberOfTimes) {
            	
                this.word = word;
                this.numberOfTimes = numberOfTimes;
            }

            @Override
            public String toString(){ //toString method
                return "The word: " + "'"+ word +"'" + " is used " + numberOfTimes + " times"; //printing words and frequency 
            }
        }

        class Compare implements Comparator<Pair>{
            @Override
            
            public int compare(Pair a, Pair b) {
                
            	if(a.numberOfTimes > b.numberOfTimes)
                {
                    return 1;
                } 
                
                else {
                    return -1;
                }
            }
        }

        while (text.hasNext()) {
        	
            String key = text.next(); //update key
            
            if (BST.contains(key)) //if there is a key 
            {
                BST.put(key, BST.get(key) + 1); //increment key 
            }
            else {
                BST.put(key, 1); //if no key, create one
            }
        }

        ArrayList<Pair> frequencyList = new ArrayList<>(); //create ArrayList 
        
        Compare compare = new Compare();  //new compare object
        
        for (String word : BST.keys()) { //go thru words
        	
            frequencyList.add(new Pair(word, BST.get(word)));
            frequencyList.sort(compare);
            
            if(frequencyList.size() > (n + x)) // if nth to the n+xth
            {
                frequencyList.remove(0); //pop first word  in list to get to those you want 
            }
        }

        for (int i = 0; i < x; i++){
        	
            System.out.println(frequencyList.get(i));
            
        }    
    }
    
    public static void main(String[] args) {
    	
        int distinct = 0; 
        int words = 0;
        
        int minlen = Integer.parseInt(args[0]);
        
        BinarySearchST<String, Integer> symbolTable = new BinarySearchST<>();
        Scanner text = new Scanner(System.in);

        // compute frequency counts
        while (!text.hasNext()) {
        	
            String key = text.next();
            
            if (key.length() < minlen) 
            	continue;
            
            words++;
            
            if (symbolTable.contains(key)) 
            {
                symbolTable.put(key, symbolTable.get(key) + 1);
            }
            else {
                symbolTable.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        symbolTable.put(max, 0);
        
        for (String word : symbolTable.keys()) {
        	
            if (symbolTable.get(word) > symbolTable.get(max))
                max = word;
        }

        System.out.println(max + " " + symbolTable.get(max));
        System.out.println("Number of distinct words:	=  " + distinct);
        System.out.println("Total number of words:	= " + words);
    }
}
