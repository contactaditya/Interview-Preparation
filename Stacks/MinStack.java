import java.util.*;
import java.io.*;

  public class MinStack {  
	
	private int min;
	private java.util.Stack<Integer> stack;
	
	/** initialize your data structure here. */
	public MinStack() {
	  stack = new java.util.Stack<Integer>();     
	  min = Integer.MAX_VALUE;
	}
	    
	public void push(int x) {     
	 /**
	  * Add an item to back of stack.
	  */
			   
	  if(x <= min) {          
	    stack.push(min);
	    min = x;
	  }
	        
	  stack.push(x);  
	}
	    
	public void pop() {
	 /**
	  * Removes the next item from the front of the stack.	 
	  */	 	
      if(stack.pop() == min) {
    	min = stack.pop();
      }
	}
	    
	public int top() {
	  return stack.peek();
	}
	    
	public int getMin() { 
	  /**
	   * It finds the minimum value of the stack.
	   */	 
						  
	   return min;
	}

	public static void main(String[] args) throws IOException {   
	  MinStack minStack = new MinStack();	
	  int choice = 0;
    
      do{	
    	  System.out.println("1. For inserting an element in the stack.");
    	  System.out.println("2. For deleting an element from the stack.");
    	  System.out.println("3. For displaying the top element of the stack.");
    	  System.out.println("4. For retrieving the minimum element in the stack.");
    	  System.out.println("5. For exiting from the program.");
    
    	  System.out.println();
    	  System.out.print("Enter your choice: ");
    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	  choice = Integer.parseInt(br.readLine());
    	  switch (choice) {
    	  	case 1:  System.out.println();
    	  	   		 System.out.print("Enter a element to insert in the stack: ");
    	  	   		 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
    	  	   		 int element = Integer.parseInt(br1.readLine());    	  	   	     
    	  	   		 minStack.push(element);
    	  	   		 break;
    	  	case 2:  minStack.pop();
               		 break;
    	  	case 3:  int top = minStack.top();
    	  	   		 System.out.println();
    	  	   		 System.out.println("The top element of the stack is: " + top);
    	  	   		 break;
    	  	case 4:  int getMin = minStack.getMin();
    	  	   		 System.out.println();
    	  	   		 System.out.println("The minimum element in the stack is: " + getMin);
    	  	   		 break;     
          }
    	  System.out.println();
		} while(choice!=5);
	}
  }
