//README This class implements a Deapth First Search utilizing a linked queue

// *  This implementation uses depth-first search.
// *  The constructor takes time proportional to <em>V</em> + <em>E</em>
// *  (in the worst case),
// *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
// *  It uses extra space (not including the graph) proportional to <em>V</em>.
// *  <p>
// *  For additional documentation, see <a href="/algs4/41graph">Section 4.1</a> of
// *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.

// @author Robert Sedgewick and @author Kevin Wayne
 
//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne
 



public class DFS {
	
    private SymbolTable<String, Boolean> marked; //symbol table to check if marked
    private SymbolTable<String, Integer> distanceTo; //symbol table of distances
    private SymbolTable<String, String> edgeTo; //st of edges
    private final String Goal; //String for goal state
    private int count;

    public DFS(GenericGraph<String, String> Graph, String s){ 
    	
        this.marked = new SymbolTable<>(); //instance to marked st
        this.distanceTo = new SymbolTable<>(); //instance to distance st
        this.edgeTo = new SymbolTable<>(); //instance to edge st
        this.Goal = s; //set s to goal state
        this.count = 0; //set count to 0 
        this.dfs(Graph, s); //call dfs
    }


    /* Computes the vertices in graph <tt>G</tt> that are
    * connected to the source vertex <tt>s</tt>.
    * @param G the graph
    * @param s the source vertex
    */
    
    private void dfs(GenericGraph<String, String> Graph, String v) {
    	
        this.count++; //increment count
        this.marked.put(v, true); //mark v as visited
        
        for (String w : Graph.adj(v)) { //loop thru w 
        	
            if(!this.marked.contains(w))  //is w is not marked
            	this.marked.put(w, false); //mark w as not visited
            
            if(!this.distanceTo.contains(w)) //is distance st not contains w 
            	this.distanceTo.put(w, count); //put w there and increment size of st
            
            if (!this.marked.get(w)) { 
                this.edgeTo.put(w, v); //create edge between v and w
                dfs(Graph, w); 
            }
            
            if(this.count < this.distanceTo.get(w)){ 
            	
                this.distanceTo.put(w, this.count); //put w in distance st
                this.edgeTo.put(w, v); //create edge
                dfs(Graph, w); 
            }
        }
        this.count--; //decrement count
    }

    public boolean hasPathTo(String v) {
        return this.marked.get(v); //if v has a path return true
        
    }

    public int count() { //method to get count
        return count;
    }

    public Iterable<String> pathTo(String v){ //method to iterate thru vertices
    	
        if(!this.hasPathTo(v)) //if there's no path return null 
        	return null;
        
        Queue<String> path = new Queue<>(); //new queue of paths
      
        for(String x = v; !x.equals(this.Goal); x = edgeTo.get(x)){ //while x != goal, get edge
            path.enqueue(x); //put vertice on queue
        }
        path.enqueue(this.Goal); //enqueu goal state
        return path;
    }
}
