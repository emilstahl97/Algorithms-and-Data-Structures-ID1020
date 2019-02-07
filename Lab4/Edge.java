//README Class to represent edges in graph

// @author Robert Sedgewick and @author Kevin Wayne
 
//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne
 
//
// *  The <tt>Edge</tt> class represents a weighted edge in an 
// *  {@link EdgeWeightedGraph}. Each edge consists of two integers
// *  (naming the two vertices) and a real-value weight. The data type
// *  provides methods for accessing the two endpoints of the edge and
// *  the weight. The natural order for this data type is by
// *  ascending order of weight.

public class Edge<Vertices, Weight extends Comparable<Weight>> implements Comparable<Edge<Vertices, Weight>> {
    
	private final Vertices v; //instantiate vertice v 
    private final Vertices w; //instantiate vertice w 
    private final Weight weight; //create var weight to store weight of edge

    
    public Edge(Vertices v, Vertices w, Weight weight) { //edge 
    	
        this.v = v; //instance variable v
        this.w = w; //instance variable w
        this.weight = weight; //instance of weight
    }

    public Weight weight() { //method to return weight
        return this.weight;
    }


    /**
     * Returns either endpoint of the edge.
     * @return either endpoint of the edge
     */

    
    public Vertices either(){ //
        return this.v;
    }


    /**
     * Returns the endpoint of the edge that is different from the given vertex
     * (unless the edge represents a self-loop in which case it returns the same vertex).
     * @param vertex one endpoint of the edge
     * @return the endpoint of the edge that is different from the given vertex
     *   (unless the edge represents a self-loop in which case it returns the same vertex)
     * @throws java.lang.IllegalArgumentException if the vertex is not one of the endpoints
     *   of the edge
     */
    
    public Vertices other(Vertices i) { 
        return (i.equals(this.v) ? this.w : this.v);
    }

    public Edge<Vertices, Weight> flipped(){
        return new Edge<>(this.other(this.either()), this.either(), this.weight);
    }

    public int compareTo(Edge<Vertices, Weight> other) { //compareTo method to compare methods
        return this.weight().compareTo(other.weight());
    }
}
