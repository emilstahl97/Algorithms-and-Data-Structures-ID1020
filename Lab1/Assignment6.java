//README This program lets you check if a textfile is properly balanced with its brackets. This process is made thru a stack.
//The program takes in an external textfile and converts it into an array of characters. Opening brackets is pushed on stack. 
//If stack is empty after all characters has been popped, then the file is properly balanced. 

//@author emil stahl

//LAB 1 - ASSIGNMENT 6

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filter {
	
	private Scanner file;
	private char[] textToCheck;
	private Stack<Character> stack = new Stack<Character>();
	

	private class Stack<Data>{
			Node first;
	
			private class Node{
			Data data;
			Node next;
			public Node(Data data) {
				this.data = data;
			}
			
			public Data getData(){
				return data;
			}
		}
		
			private void push(Data data){ //method to push characters on stack
			
				if(first == null) { //if stack is empty then first is set to new node
				
					first = new Node(data); 
			
				} else {
				
					Node newNode = new Node(data); //otherwise set first to new node and it's pointer to old first
					newNode.next = first;
					first = newNode;
				}
		}
		
		private Data pop(){ //remove elements from stack
			
			Data d = first.getData(); //get first element
			
			if(first.next != null) { //if a element exist 				
				first = first.next; //update first
			
			}else {
			
				first = null; //if stack is empty
			}
						
			return d; //return the element
		}
		
		private boolean isEmpty(){
			return first == null;
		}
		
		public Data peek(){ //method to get first element without popping it
			
			if(!isEmpty()) {				
			
				return first.getData();
			
			}else {
				
				System.out.println("Empty stack");
				
				return null;
			}
		}
		
		public void optimize() { //method to clean memory
			
			first = null;
		}
	}
	
	
	public void getFile(String Path) { //this method loads file from computers filesystem and converts it into an array of characters
		
		try {
		
			file = new Scanner(new File(Path + ".txt"));
			convertToArray(); //call converting method
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("File doesn't exist in this path"); //if file doesn't exist
		}
	}

	private void convertToArray() { 
		
		String s = "";
		while (file.hasNext()) {
			s += file.next();
		}
		textToCheck = s.toCharArray();
	}

	private boolean match(char text, char stack) { //This method gets characters from both the array and the stack to determine if the brackets is balanced
		
		if (stack == '(' && text == ')') { //if this is true, it means the text is balanced
			return true;
		
		} else if (stack == '[' && text == ']') { //if this is true, it means the text is balanced
			return true;
		
		} else if (stack == '{' && text == '}') { //if this is true, it means the text is balanced
			return true;
		
		} else {
			return false;
		}
	}

	private boolean check() { 
		
		for (char c : textToCheck) { //loop as long as it is characters to fetch in the array
			
			if (c == '{' || c == '(' || c == '[') { //opening brackets is pushed on stack
			
				stack.push(c);
			
			} else if (c == '}' || c == ')' || c == ']') { 
			
				if (!stack.isEmpty()) {
				
					if (match(c, stack.peek())) { //if match method is true, pop the stack
					
						stack.pop();
					
					} else {
					
						stack.optimize();
						return false; //if match returns false, it means that text not balanced
					}
				} 
			}
		}
		if (!stack.isEmpty()) {
			stack.optimize();
			return false;
		} else {
			return true; //if stack is empty, text is balanced
		}
	}
	
	
	public static void main(String[] args) {
		
		Filter filter = new Filter();
		
		String f = "No, it's not properly balanced";
		String t = "Yes, the brackets in this file is properly balanced"; 
		String path = "/Users/emilstahl/eclipse-workspace/L1A6/"; //searchpath to where files are stored
		
		filter.getFile(path+"test1");
		if(filter.check() == true) {
			System.out.println("Test 1:  "+t+"\n");
		}
		else {
			System.out.println("Test 1:  "+f+"\n");
		}
		
		filter.getFile(path+"test2");
		if(filter.check() == true) {
			System.out.println("Test 2:  "+t+"\n");
		}
		else {
			System.out.println("Test 2:  "+f+"\n");
		}
		
		filter.getFile(path+"test3");
		if(filter.check() == true) {
			System.out.println("Test 3:  "+t+"\n");
		}
		else {
			System.out.println("Test 3:  "+f+"\n");
		}
		
		filter.getFile(path+"test4");
		if(filter.check() == true) {
			System.out.println("Test 4:  "+t+"\n");
		}
		else {
			System.out.println("Test 4:  "+f+"\n");
		}
		
	}
}






