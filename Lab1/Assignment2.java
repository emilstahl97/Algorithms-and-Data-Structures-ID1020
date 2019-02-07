//README This program implements a stack through a linked list in order to
//print a number of characters in reversed order

//LAB 1 - ASSIGNMENT 2

//@author emilstahl



import java.util.Scanner;

public class Assignment2<Data> {
	
	private class Node {
		
		Data data; 
		Node next;
		
	public Node(Data data) {
		   this.data = data;
		}
	}
	
	private int size;
	private Node head;
	
	public Assignment2() {
		size = 0; 		  
		head = null;
	}
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;   //check if empty
	}
	
	public void push(Data data) {
		
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode; //if empty, head is newNode		
		} 
		
		else 
		
		{ 
			newNode.next = head; //otherwise set newNodes next to point at "old" head
			head = newNode; //update head
		}
		size++; //update size of list
	}

	public Data pop() {
		
		if (head == null) return null; //if list is empty
		
		Node node = head; //set node to head
		head = head.next; //update head to be next node
		size--; //update size of list
		
		return node.data; //return data of head
	}
	
	public Data peek() { // lookup head without removing
		
		if (head == null) return null;
			return head.data; 
	}
	
	
	public static void main(String args[]) {
            
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Write something\n");
            String w = scan.next();
            char[] stringToCharArray = w.toCharArray(); //convert to char array to be able to push on stack
            int length = stringToCharArray.length;      
      
     
            Assignment2 stack = new Assignment2(); 
      
            for(int u = 0; u < length; u++) {
                stack.push(stringToCharArray[u]); //push each character on stack
            }

            for(int i = length-1; i >= 0; i--) {
                System.out.print((stack.pop())); //print out characters
   
            }
                System.out.println("\n");
      	}
}