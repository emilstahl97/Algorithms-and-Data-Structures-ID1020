//README This program implements a generic iterable circular linked list which allows the user to insert and remove 
//elements to/from the front and back end of the queue. 

//Assignment 4 - LAB 1

//INPUT - PUSH 1,2,3,4
//OUTPUT - 1,2,3,4
// REMOVE FIRST ELEMENT 
//OUTPUT - 1,2,3,
//ADD 5 to end of queue
//OUTPUT - 1,2,3,5

// @Author emilstahl


import java.util.*;



class Queue<Data> implements Iterable<Data> {
	
	private Node first;
	private Node last;
	private int size;

	private class Node {
		
		Data data;
		Node next;	
		Node previous;		
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return size;
	}

	
	public void pushToEnd(Data data) { //Method to push elements to end of queue
		
		Node previousLast = last; //set previousLast
		last = new Node(); //new node set to last
		last.data = data; //point data
		last.next = first; // instead of pointing at null, last node points to first node which makes it a circular list
		
		if (isEmpty()) 
	 	{
			first = last; //if empty, first is also last
		}
		
		else
		
		{	
			previousLast.next = last; //previousLast nextpointer set to point to new last node

		}	
		
		size++; //increment queue size
	}

	public void pushToFront(Data data) { //method to push elements to front of queue
		
		Node previousFirst = first; //set previousFirst
		first = new Node(); //new node set to first
		first.data = data; //point data
		first.next = previousFirst; //new first node next pointer points to the node that's ahead in queue

		
		if (isEmpty()) 
		{
			last = first; //if empty, first is also last
			last.next = first; //make it circular
		
		} 
		else
		{
			last.next = first; //make it circular
		}
	    
		size++; //increment queue size
	}

	public Data popAtEnd() { //Method to pop elements from end of queue
		
		Node newLast = new Node();
		Data data = last.data; //get last nodes data
		newLast = first; //update 
		
		while (newLast.next.next != first) { //loop thru list
		    	newLast = newLast.next; }
		
		last.next = first; //make it circular
		last = newLast; 
		last.next = first;
		
		size--;
		
		return data;
	}

	public Data popAtFront() { //Method to pop elements from front of queue
		
		Data data = first.data; //get data
		first = first.next; //update first
		last.next = first; //make it circular 
		
		if (isEmpty())
		{
			last = null;
		}
		
		size--;
		
		return data;
	}
	
	public Iterator<Data> iterator() {
		return new QueueIterator();
	}
 
	private class QueueIterator implements Iterator<Data> { //iterator object
	
		private Node node = first; //set node to first in queue
		private boolean completedLoop; //to detect one loop thru circular list

		public boolean hasNext() {
			return node != null && !completedLoop; //while  node is not null and not complete loop 
		}

		public Data next() {
			if (node.next == first) // if node.next is first, then we have completed one loop thru list
				completedLoop = true;  //set to true
				
			Data data = node.data; //get data
			node = node.next; //move to next node
			return data;
		}
	}

	public String toString() {
		
		Iterator<Data> myIterator = iterator(); //create new iterator
		StringBuilder SB = new StringBuilder();

		for(Data data : this) { //loop thru queue
			
			if(myIterator.hasNext() == true) //if there's a next node, append comma
			{
			
			SB.append("[");
			SB.append(myIterator.next());
			SB.append("], ");
			
			}
			
			else 
			{
				SB.append("[");
				SB.append(myIterator.next());
				SB.append("] "); //end without queue comma
			}
		}

		return SB.toString();
	}
	
}



public class Assignment4 {
	
	public static void main (String[] args) {	
		
		
		Queue<String> queue = new Queue<>(); //new queue object

		queue.pushToEnd("1"); 
		queue.pushToEnd("2");
		queue.pushToEnd("3");
		queue.pushToEnd("4");
		System.out.println(queue.toString()+"\n");
		System.out.println("Remove last [4] element in queue\n");
		queue.popAtEnd();
		System.out.println(queue.toString()+"\n");
		queue.pushToEnd("5");
		System.out.println("Add element 5 to end of queue\n");
		System.out.println(queue.toString());
	}
}	