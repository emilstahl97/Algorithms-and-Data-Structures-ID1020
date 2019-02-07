//README This class implements a bag utilizing a linked list



//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne



// *  The <tt>Bag</tt> class represents a bag (or multiset) of 
// *  generic items. It supports insertion and iterating over the 
// *  items in arbitrary order.
// *  <p>
// *  This implementation uses a singly-linked list with a static nested class Node.
// *  See {@link LinkedBag} for the version from the
// *  textbook that uses a non-static nested class.

import java.util.Iterator;

public class Bag<Data> implements Iterable<Data>{
    
	private Node<Data> first;
    private int size;

    private static class Node<Data> {
       
    	private Data val;
        private Node<Data> next;
    }

    public Bag(){
    	
        this.first = null; //initialize first
        this.size = 0; //size is 0
    }

    public void add(Data data){ //method to add data
        
    	Node<Data> temp = this.first; //create temp
        this.first = new Node<>(); //new node
        this.first.val = data; // point data to node
        this.first.next = temp; //first next pointer points to previousy first / temp
        this.size++; //increment size
    }

    public boolean isEmpty() {
        return this.first == null; // if empty bag, first is null 
    }

    public int size() {
    	return size; //method to return size
    }
    public Iterator<Data> iterator()  { //iterator to iterate bag
        return new ListIterator<>(this.first);
    }

    private class ListIterator<Data> implements Iterator<Data> {
        private Node<Data> current; //list iterator

        ListIterator(Node<Data> first) { 
            current = first; //start at first
        }
        
        public boolean hasNext()  { //if there's a node  
        	return current != null;
        }
        
        public Data next() { //method to get next node
        	
            if (!hasNext()) //if bag's empty
            	return null; //return null
            
            Data data = current.val; 
            current = current.next; //update current
            return data; //return data of old current 
        }
    }
}
