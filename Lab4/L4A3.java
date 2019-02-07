/* README - This class reads data from a database of states and distance and 
 * puts them in a undirected graph. To find a path between
 * two vertices it uses Deapth First Search. 

Lab 4 - Assignment 3 

@author - emilstahl 

*/
import java.net.URL;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;


public class L4A3 {
    public static void main(String[] args) throws IOException {
        
    	String Start;
    	String Goal;
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter current location:"); //Read in starting state
    	Start = sc.nextLine();
    	Start = Start.toUpperCase();
    
    	System.out.println("Enter your goal"); //Read in goal 
    	Goal = sc.nextLine();
    	Goal = Goal.toUpperCase();
    	
    	if(args.length > 1) { 
    		Start = args[0];
    		Goal = args[1];
    	}
    	else {
    		Start = Start;
    		Goal = Goal;
    	}

       // Scanner scan =  new Scanner(new FileReader("/Users/emilstahl/Desktop/statesWeighted.txt"));
//    	URL Database = new URL("https://www.icloud.com/iclouddrive/0VsLK6dJEfMFlsio3RKRvjE5Q#statesWeighted.txt"); //Read from database of states
//		Scanner states = new Scanner(Database.openStream()); //scan

    	URL url = L4A3.class.getResource("statesWeighted.txt");
        Scanner states =  new Scanner(new FileReader(url.getPath()));
        
    	
    	WeightedGraph wgraph = new WeightedGraph(states);
        DFSWeight dfs = new DFSWeight(wgraph, Start);
        System.out.println("\nThe path and distance is:\n");
        System.out.println("Total distance is: " + dfs.pathTo(Goal));

    }
}