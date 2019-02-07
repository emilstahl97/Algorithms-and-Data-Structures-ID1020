//README This class implements a Linked Queue thru a singly linked list


//this implementation is heavily inspired of the book Algorithms, 4th ed by 
//@author Robert Sedgewick
//@author Kevin Wayne

/*
 *  The <tt>LinkedQueue</tt> class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the first data,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a non-static nested class 
 *  for linked-list nodes.  See {@link Queue} for a version that uses a static nested class.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 
 */

import java.util.Iterator;

public class Queue<Data> implements Iterable<Data> {
	
    private Node first; //instantiate first 
    private Node last; //instantiate last
    private int size; //var to store size of queue

    private class Node{
    	
        private Node next; //next pointer 
        private Data data; //data pointer
    }

    public boolean isEmpty() { //if queue is empty return null
    	return this.first == null;
    }

    public int size() { //method to return size
    	return size; 
    }
    
    public void enqueue(Data data) { //method to add elements at back of queue
    	
        Node oldLast = this.last; //copy last to oldlast
        
        this.last = new Node(); //create new node last
        this.last.data = data; //point data to new node last
        this.last.next = null; //last next pointer is null
        
        if(this.isEmpty()){ //is queue is empty, last is also first 
            this.first = this.last; 
        }
        
        else{
            oldLast.next = this.last; //set oldlasts next pointer to point to new last
        }
        this.size++; //increment size
    }

    
    public Data dequeue() { //Method to remove items from front of queue
    	
        Data data = this.first.data; //set data to firsts data
        this.first = first.next; //update first to be the node after it
        
        if(this.isEmpty()){ //if queue is empty, set last to be null 
            this.last = null;
        
        }
        
        this.size--; //decrement size of queue
        return data; //return firsts data
    }

    private class NodeIterator implements Iterator<Data> //method to iterate thru node
    {
        private Node current = first; // set current to be first node

        public boolean hasNext() { //method to check if there's a next node
        	return current != null; 
        }
        
        
        public Data next()
        {
            Data data = current.data; //set data to currents data
            current = current.next; //update current
            return data; //return data
        }
    }

    @Override
    public Iterator<Data> iterator() {
        return new NodeIterator();
    }
}
