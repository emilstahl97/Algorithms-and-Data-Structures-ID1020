//README This program implements a generalized queue that lets the user insert elements at any given index. 
//Furthermore, the user can also remove the ith element in the queue. 

//LAB 1 - ASSIGNMENT 5 

//INPUT = 1,2,3 
//OUTPUUT = 3,2,1
//POP AT INDEX 1
//OUTPUT = 2,1 

//@emilstahl

public class Assignment5 {
	
	Node head;
	
	private class Node {

		Node next;
		int data;

	}
	
	public void push(int data)
	{
		Node node = new Node(); 
		node.data = data; //point data
		node.next = null;
		
		if (head == null)
		
		{
			head = node; //if emtpy, set node to head
		}
		
		else
			
		{
			Node n = head; //set to head
			
			while(n.next!=null) //loop thru
			
			{
				n = n.next; //link together nodes
			}
			n.next =  node;
		}
		
	}
	public void pushToStart(int data) //method to insert elements at start of queue
	{
		Node node = new Node(); //create new node 
		node.data = data; 
		node.next = null; 
		node.next = head; //new nodes next points to old head
 		head = node; //update node
	}
	
	public void pushTo(int index,int data)
	{
		Node node = new Node(); //create new node
		node.data = data; //point data 
		node.next = null; 
		
		if(index == 0 || index == 1) //if first, use pushToStart method
		{
			pushToStart(data);
		}
		
		else {
			
		Node n = head; //start at head
		
		for(int i = 1; i < index; i++) //loop thru list until index is found
			
		{
			n = n.next; //link together nodes
		}
		node.next = n.next; //set new nodes next to point where n pointed to 
		n.next = node;
		}
	}
	
	public void popAt(int index)
	{
		if(index == 1 || index == 0)
		{
			head = head.next; //update head
		}
		else
		{
			Node n = head; 
			Node n1 = null;  
			
			for(int i = 1; i < index; i++) //loop thru list until index is found
			{
				n = n.next; //link together node
			}
			n1 = n.next; 
			n.next = n1.next;
			n1 = null; //remove node
		}
	}
        
        
	
        
	public void print()
	{
		Node node = head; //start at head
		
		while (node.next != null) //if there's a node
		{
			System.out.print(node.data + ", "); //print data
			node = node.next; //go to next node
		}
		System.out.print(node.data +"\n"); 
	}
	
	
	
	public static void main(String[] args) {
		

			Assignment5 Queue = new Assignment5();

			Queue.pushToStart(1);
			Queue.pushToStart(2);
			Queue.pushToStart(3);
			
			Queue.print();

			Queue.popAt(1);
			
			Queue.print();

			Queue.pushTo(1, 3);
			
			Queue.print();
			
  }	
}
