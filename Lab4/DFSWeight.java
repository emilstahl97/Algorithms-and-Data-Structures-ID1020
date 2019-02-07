//README This class implements a edge weighted Deapth First Search utilizing a queue


// @author Robert Sedgewick and @author Kevin Wayne
 
//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne
 

public class DFSWeight {
	
    private SymbolTable<String, Boolean> marked; //st of marked vs
    private SymbolTable<String, Integer> distanceTo; //st of distances
    private SymbolTable<String, String> edgeTo; //st of edges 
    private String start; //starting state string
    private int count;

    public DFSWeight(GenericGraph<String, Edge<String, Integer>> G, String s){
    	
        this.marked = new SymbolTable<>(); //new st marked
        this.edgeTo = new SymbolTable<>(); //new st edgeTo
        this.distanceTo = new SymbolTable<>(); //st of distance
        this.count = 0; //set count to 0 
        this.start = s; //set s to starting state
        dfs(G, s);
    }


    private void dfs(GenericGraph<String, Edge<String, Integer>> G, String v) {
    	
        this.marked.put(v, true);//mark v as visited
        
        for (Edge<String, Integer> w : G.adj(v)) { //loop thru w 
        	
            String weight = w.other(v); //set weight to 
            this.count += w.weight(); //increment count
            
            if(!this.marked.contains(weight)) //if weight is not in st marked
            	this.marked.put(weight, false); //set weight to not marked
            
            if(!this.distanceTo.contains(weight)) //is weight is not in distance st
            	this.distanceTo.put(weight, this.count); //put weight in distance st
            
            if (!this.marked.get(weight)) { //if not in marked st
                this.edgeTo.put(weight, v); //put weight and vertice in edgeTo st
                dfs(G, w.other(v)); //next vertice
            }
            
            if(this.count < this.distanceTo.get(weight)){ //if count less than distance to vertice
            	
                this.distanceTo.put(weight, this.count); //put weight in distance st
                this.edgeTo.put(weight, v); //put weight in edgeTo st
                dfs(G, w.other(v)); 
            }
            this.count -= w.weight();  //decrement count
        }
    }

    public boolean hasPathTo(String v) { //if there's a path return vertices
        return this.marked.get(v);
    }

    public Integer pathTo(String v){ //method to get path 
    	
        if(!this.hasPathTo(v)) //if no path return null 
        	return null;
        
        Queue<String> path = new Queue<>(); //create queue of paths
        
        for(String x = v; !x.equals(this.start); x = edgeTo.get(x)){  //loop thru vertices and terminate at start, get edges
            path.enqueue(x); //put vertices/state on queue
        }
        path.enqueue(this.start); //enqueue  starting state

        for (String s : path){ //iterate thru states and paths
        
        	System.out.print(s); //print state
            if(!s.equals(start)) //if not starting state
            	System.out.print(" --> "); 
            else
            System.out.println("");        }

        return this.distanceTo.get(v); //print total distance
    }
}