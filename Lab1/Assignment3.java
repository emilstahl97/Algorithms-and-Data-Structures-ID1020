//README This program implements a iterable FIFO-QUEUE that lets the user 

//       push to start and pop elements from end of queue.

//Assignment 3 - LAB 1

//INPUT - PUSH 1,2,3,4
//OUTPUT - 1,2,3,4
// POP FIRST ELEMENT 
//OUTPUT - 2,3,4
//PUSH 1
//OUTPUT - 2,3,4,1

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

	
	public void push(Data data) { //Method to push elements on queue
		
		Node previousLast = last; //set previousLast
		last = new Node(); //new nod set to last
		last.data = data; //point data
		last.next = null; //since new node is last, there's no next
		last.previous = previousLast; //new last node previous pointer points to the node that's ahead in queue

		
		
		if (isEmpty()) 
		{
			first = last; //if empty, first is also last
 		}
		else {
			
			previousLast.next = last; //previousLast nextpointer set to point to new last node
		}
		size++; //increment queue size
	}

	public Data pop() { //Method to pop elements from queue
		
		Data data = first.data; // get first elements data
		first = first.next; //update first
		
		if (isEmpty())
			last = null; //if empty, last is null 
			first.previous = null; //there's no previous
		
		size--; //decrement queue size
		return data; //return element
	}
	
	public Iterator<Data> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Data> {  //iterator object
		
		private Node node = first; //set nod to first in queue

		public boolean hasNext() { //method to check if current node is not null
			return node != null;
		}

		public Data next() { 
			Data data = node.data; //get data
			node = node.next; //move to next node
			return data; //return element
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



public class Assignment3 {
	
	public static void main (String[] args) {	
		
		
		Queue<String> queue = new Queue<>(); //new queue object

		queue.push("1"); 
		queue.push("2");
		queue.push("3");
		queue.push("4");
		System.out.println(queue.toString()+"\n");
		System.out.println("Remove first element in queue\n");
		queue.pop();
		System.out.println(queue.toString()+"\n");
		queue.push("1");
		System.out.println("Add element 1 to end of queue\n");
		System.out.println(queue.toString());
	}
}	