//README interface for generic graph that lets the user chose data type


//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne


public interface GenericGraph<NodeType, EdgeType> {
    
	Iterable<String> vertices();
    
	int V();
    int edges();
    
    void addEdge(NodeType v, EdgeType w);
    
    Iterable<EdgeType> adj(NodeType v);
}
