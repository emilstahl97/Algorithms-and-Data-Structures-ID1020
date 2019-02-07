//README This class implements a weighted Graph to be able to calculate the distance between different states


// *  The <tt>Graph</tt> class represents an undirected graph of vertices
// *  named 0 through <em>V</em> - 1.
// *  It supports the following two primary operations: add an edge to the graph,
// *  iterate over all of the vertices adjacent to a vertex. It also provides
// *  methods for returning the number of vertices <em>V</em> and the number
// *  of edges <em>E</em>. Parallel edges and self-loops are permitted.
// *  <p>
// *  This implementation uses an adjacency-lists representation, which 
// *  is a vertex-indexed array of {@link Bag} objects.
// *  All operations take constant time (in the worst case) except
// *  iterating over the vertices adjacent to a given vertex, which takes
// *  time proportional to the number of such vertices.
// *  <p>
// *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/41undirected">Section 4.1</a> of
// *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.


//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne

import java.util.Scanner;


public class WeightedGraph implements GenericGraph<String, Edge<String, Integer>> {

	private int V; //instantiate vertice
    private int E; //instantiate edge
    private SymbolTable<String, Bag<Edge<String, Integer>>> adj;

    WeightedGraph (Scanner s) {
    	
        this.V = 0; //set v to 0  
        this.E = 0; //set E to 0
        
        this.adj = new SymbolTable<>(); //create new SymbolTable with adjacenys
        
        while (s.hasNext()){ //while input has next 
        	
            String v = s.next(); //set v to state
            String w = s.next(); //set w to adjacent state
            
            Integer weight = s.nextInt(); //set weight to be the number after the two states, see text file 
            addEdge(v, new Edge<>(v, w, weight)); //create edge and connect
        }
    }

    


    /**
     * Returns the vertices adjacent to vertex <tt>v</tt>.
     * @return the vertices adjacent to vertex <tt>v</tt> as an Iterable
     * @param v the vertex
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    
    @Override
    public Iterable<String> vertices() {
    	return adj.keys();    	
}

    @Override
    public int V() { //method to get V
        return V;
    }

    @Override
    public int edges() { //method to get E
        return E;
    }

    @Override
    public void addEdge(String v, Edge<String, Integer> w) { //method to create edge between two vertices
    	
        if(!this.adj.contains(v)){ //if v is not in st of adjacent state
        	
            Bag<Edge<String, Integer>> bag = new Bag<>(); //Create bag 
            this.adj.put(v, bag); //put v there
            this.V++; //increment vertices
        }
        
        if(!this.adj.contains(w.other(v))) { //if st not contains other w 
        	
            Bag<Edge<String, Integer>> bag = new Bag<>(); //create bag
            
            this.adj.put(w.other(v), bag); //put it in st
            this.V++; //increment vertices
        }

        this.adj.get(v).add(w); //get v and add w to symbol table
        this.adj.get(w.other(v)).add(w.flipped()); //flipping
        this.E++; //increment edges
    }

    @Override //method to iterate thru vertices
    public Iterable<Edge<String, Integer>> adj(String v) {
        return this.adj.get(v);
    }
}
