//README This class represents a graph


//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne

// *  The <tt>Graph</tt> class represents an undirected graph of vertices
// *  named 0 through <em>V</em> - 1.
// *  It supports the following two primary operations: add an edge to the graph,
// *  iterate over all of the vertices adjacent to a vertex. It also provides
// *  methods for returning the number of vertices <em>V</em> and the number
// *  of edges <em>E</em>. Parallel edges and self-loops are permitted.


import java.util.Scanner;


//* Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
//* param V the number of vertices
//* @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0

public class Graph implements GenericGraph<String, String>{
   
	private int V; //instantiate vertices
    private int E; //instantiate edges
    private SymbolTable<String, Bag<String>> adj; //st of adjacent states

    Graph (Scanner s) {  //scan states into graph
    	
        this.V = 0; //set v to 0
        this.E = 0; //set E to 0 
        
        this.adj = new SymbolTable<>();
        
        while (s.hasNext()){ //while there is a next state
        	
            String v = s.next(); //update v
            String w = s.next(); //update w
            addEdge(v, w); //add edge between them 
        }
    }

    public Iterable<String> vertices() { //create iterator
    	return adj.keys();} 
 
    public int V() { //method to get V
    	return this.V;
    }

    public int edges() { //method to get E
    	return this.E;
    }

    public void addEdge(String v, String w) { //method to connect vertices
    	
        if(!this.adj.contains(v)){ //is adjancy st does not contain v
        	
            Bag<String> bag = new Bag<>(); //create new bag
            this.adj.put(v, bag); 
            this.V++; 
        }
        
        if(!this.adj.contains(w)){ //if adjancy st does not contain w 
        	
            Bag<String> bag = new Bag<>();
            this.adj.put(w, bag); //put w in adj 
            this.V++; //increment vertices
        }

        this.adj.get(v).add(w); //get path from v to w
        this.adj.get(w).add(v); //get path from w to v
        this.E++; //increment edges
    }

    public Iterable<String> adj(String v){ //method to iterate thru  vertices
        return this.adj.get(v); //return v 
    }
}
