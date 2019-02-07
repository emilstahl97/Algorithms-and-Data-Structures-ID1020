/* README - This class reads data from a database of states and puts them in a undirected graph. To find a path between
 * two vertices it uses Breadth First Search. 

Lab 4 - Assignment 2 

@author - emilstahl 

*/
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;


public class L4A2 {
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
    	
		URL Database = new URL("https://introcs.cs.princeton.edu/java/data/contiguous-usa.dat"); //Read from database of states
		Scanner states = new Scanner(Database.openStream()); //scan
		
        Graph graph = new Graph(states); //put the states into the graph
        BFS BFS = new BFS(graph, Start); //utilize Depth First Search
        
        System.out.println("\nThe path is:\n");
        
        for(String s : BFS.pathTo(Goal)){ //while there's a path between vertices
        	
            System.out.print(s); 
            if(!s.equals(Start)) 
            	System.out.print(" --> ");
            else
            System.out.print("");
        }
    }
}