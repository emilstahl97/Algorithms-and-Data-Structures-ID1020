//README This class implements 


// *  This implementation uses a balanced binary search tree. It requires that
// *  the key type implements the <tt>Comparable</tt> interface and calls the
// *  <tt>compareTo()</tt> and method to compare two keys. It does not call either
// *  <tt>equals()</tt> or <tt>hashCode()</tt>.

//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne


import java.util.Iterator;


public class SymbolTable<Key extends Comparable<Key>, Value>{
    
	private Node root; //create node root
    private int size = 0;

    private class Node {
        private Key key;   //key to sort by       
        private Value val;         
        private Node left, right; //reference to left and right node
        private int size;          //height of tree

        public Node(Key key, Value val, int size) { //create new node
        	
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public int size() { //get size of st
        return this.size;
    }

    private int size(Node x) { //return size of node
        
    	if (x == null) //if null return 0
        	return 0;
        else 
        	return x.size;
    }

    public boolean contains(Key key) { //method to check if st contains key
        return get(key) != null;
    }

    public Value get(Key key) { //method to return key
        return get(this.root, key);
    }

    private Value get(Node x, Key key) { //method to get node
    	
        if (x == null) //if node is null, return null
        	return null;
        
        int cmp = key.compareTo(x.key); //set cmp to be difference of kew and xs key
        
        if (cmp < 0) 
        	return get(x.left, key); //if compare is less then node, go to the lest branch
        
        else if (cmp > 0) //if compare is more then node, go right
        	return get(x.right, key);
        
        else              
        	return x.val; //if key match, return value
    }

    public void put(Key key, Value val) { //method to insert key and vale
        this.root = put(this.root, key, val); 
    }


//    * Inserts the key-value pair into the symbol table, overwriting the old value
//    * with the new value if the key is already in the symbol table.
//    * If the value is <tt>null</tt>, this effectively deletes the key from the symbol table.

    private Node put(Node x, Key key, Value val) {
        
    	if (x == null) //if node is empty, return value 1
        	return new Node(key, val, 1);
        
        int cmp = key.compareTo(x.key); //set compare to be key of x
        
        if (cmp < 0) //if compare is less, go left
        	x.left  = put(x.left,  key, val);
        
        else if (cmp > 0)  //if compare is less, go right
        	x.right = put(x.right, key, val);
        else 
        	x.val   = val; //else, key matches
        
        x.size = size(x.left) + size(x.right) + 1; //update size of symbol table
        return x; //return node
    }

    public Key max() { //returns the biggest key in the symbol table 
        return max(root).key;
    }

    private Node max(Node x) { //return the biggest node in symbol table
        if (x.right == null)  //if no more node, return current
        	return x;
        else                 
        	return max(x.right); //recursive call to max to go right where the biggest value is
    }

    public Key min() { //returns the smallest key in symbol table
        return min(root).key; 
    }

    private Node min(Node x) { //returns the smallest node in the symbol table 
        if (x.left == null) //if no more node, return current
        	return x;
        else               
        	return min(x.left); //else go lest where the smallest node is located
    }
    

//    * Returns all of the keys in the symbol table as an iterator.
//    * To iterate over all of the keys in a symbol table named <tt>st</tt>, use the
//    * foreach notation: <tt>for (Key key : st)</tt>.

    public Iterable<Key> keys() { //iterate thru keys
        return keys(min(), max());
    }
    public Iterable<Key> keys(Key lo, Key hi) { 
    	
        Queue<Key> queue = new Queue<>(); //create queue
        keys(root, queue, lo, hi); 
        return queue;
    }

    private void keys(Node x, Queue<Key> q, Key lo, Key hi) {
    	
        if (x == null) //if node is empty
        	return;
        
        int compareLow = lo.compareTo(x.key); //compare low key to current key
        int compareHigh = hi.compareTo(x.key); //compare high key to current key
        
        if (compareLow < 0)  //if less, go left
        	keys(x.left, q, lo, hi);
        
        if (compareLow <= 0 && compareHigh >= 0) 
        	q.enqueue(x.key);
        
        if (compareHigh > 0) //if more, go right in st
        	keys(x.right, q, lo, hi);
    }
}
