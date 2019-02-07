//README This class implements a Breadth First Search utilizing a linked queueu

// @author Robert Sedgewick and @author Kevin Wayne
 
//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne
 


public class BFS {
	
    private SymbolTable<String, Boolean> marked; //boolean to check if markeds
    private SymbolTable<String, String> edgeTo; 
    private final String start; //starting vertices

    public BFS(GenericGraph<String, String> Graph, String s){
    	
        this.marked = new SymbolTable<>(); //create new symbol table
        this.edgeTo = new SymbolTable<>(); //create new symbol table
        this.start = s; //
        bfs(Graph, s); //call bfs with Graph and start as argument
    }

    private void bfs(GenericGraph<String, String> Graph, String s){
        
    	Queue<String> queue = new Queue<>(); //create new queue
       
    	this.marked.put(s, true); //mark vertice as visited
    	
        queue.enqueue(s); //enqueue vertices
        
        while (!queue.isEmpty()){ //while queue is not empty 
        	
            String v = queue.dequeue(); //dequeue most recent
            
            for(String w : Graph.adj(v)){  //iterate thru vertices and their neighbours
            	
                if(!this.marked.contains(w))  //if w is not marked
                	this.marked.put(w, false); //mark w as not visited
                
                if(!this.marked.get(w)){ //get w
                	
                    this.edgeTo.put(w, v); //create edge between v and w, connect them
                    this.marked.put(w, true); //mark w as visited
                    queue.enqueue(w); //put w on queue
                }
            }
        }
    }

    public boolean hasPathTo(String v) { //check if path 
        return this.marked.get(v);
    }

    public Iterable<String> pathTo(String v){ //method to iterate thru vertices
    	
        if(!this.hasPathTo(v)) //if no path return null  
        	return null;
        
        Queue<String> path = new Queue<>(); //create new queue of paths
        
        for(String x = v; !x.equals(this.start); x = edgeTo.get(x)){ //loop thru connected vertices and terminate at starting vertice 
            path.enqueue(x); //enqueue path
        }
        path.enqueue(this.start); //enqueu starting vertice
        return path; //return queue to be printed where it was called
    }
}
