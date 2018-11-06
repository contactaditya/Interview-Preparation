import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

 public class StackMin {
    public static Stack<NodeWithMin> stack = new Stack<NodeWithMin>();	 
	
    public static class NodeWithMin {
      public int value;
      public int min;
      public NodeWithMin next;

      //Node constructor
		    
      public NodeWithMin(int value, int min) {
	this.value = value;
	this.min = min;	   
      }
    }

    public static void push(int value) {
     /**
      * Add an item to back of stack.
      */
      if(stack.isEmpty()){
        stack.push(new NodeWithMin(value, value));
      } else {	
	if(stack.peek().min > value){	
	  stack.push(new NodeWithMin(value, value)); 
	}
	else {
	  stack.push(new NodeWithMin(value, stack.peek().min));  
	}
      }
    }
	
    public static int pop() {
     /**
      * Removes the next item from the front of the stack.	 
      */	 			  
      if(stack.isEmpty()) {
        System.out.println("The stack is already empty. No element can be removed from the stack.");  
	return -1;
      } 
      return stack.pop().value;
    }
	
    public static boolean isEmpty() {
     /**
      * Test if the stack is empty.
      */  
      if(stack.isEmpty()) {	   
	System.out.println("The stack is currently empty and has no elements.");	 	  	   
      }		   
      else {
	System.out.println("The stack is currently not empty.");	 		   
      }
      return stack.isEmpty();
    }
	 
    public static int min() {
     /**
      * It finds the minimum value of the stack.
      */	 			  
      if(stack.isEmpty()) {
        System.out.println("The stack is empty. No element can be returned from the stack.");  
        return Integer.MAX_VALUE;
      }  else {
        System.out.println("The minimum element in the stack is: " + stack.peek().min);  	
        return stack.peek().min;	
      }
    }
	 
    public static int size() {
     /**
      * Returns the number of items currently in the stack.
      */		   
      System.out.println("The size of the stack is: " + stack.size());	 
      return stack.size();
    }
	   
    public static int peek() {
     /**
      * Returns the front item from the stack without popping it.
      */	 			  
      if(stack.isEmpty()) {  
        System.out.println("The stack is empty so we can't see the last item of the stack.");  
        return -1;
      }	 			  
      else {
        System.out.println("The following element is the last element of the stack: " + stack.peek().value);  	  
      }
      return stack.peek().value;
    }
	   
    public static void display() {
     /**
      * Displays all the contents of the stack.
      */
      System.out.print("Contents of the stack are: "); 
 		 
      for (int i = 0; i < stack.size(); i++) {
        System.out.print(stack.get(i).value + " ");
      }  
      System.out.println(); 
   }
	 
  public static void main(String[] args) { 		  
      int choice = 0;
	    
   do{	
       System.out.println("1. For inserting an element in the stack.");
       System.out.println("2. For deleting an element from the stack.");
       System.out.println("3. For displaying the contents of the stack.");
       System.out.println("4. For checking the contents of the stack are empty or not");
       System.out.println("5. For checking the size of the stack");
       System.out.println("6. For returning the last element from the stack without popping it.");
       System.out.println("7. For finding the minimum element from the stack.");
       System.out.println("8. For exiting from the program.");
		    
       System.out.println();
       System.out.print("Enter your choice: ");
       Scanner input = new Scanner(System.in);
       choice = input.nextInt();  
       switch (choice) {
	 case 1:  System.out.println();
		  System.out.print("Enter a element to insert in the stack: ");
		  Scanner input1 = new Scanner(System.in);
		  int element = input1.nextInt();  
		  push(element);
	 	  break;
	 case 2:  pop();
		  break;
	 case 3:  System.out.println();
		  display();
		  break;
	 case 4:  System.out.println();
		  isEmpty();
		  break;
	 case 5:  System.out.println();
		  size();
		  break;  
	 case 6:  System.out.println();
		  peek();
		  break;     
         case 7:  System.out.println();
		  min();
   	  	  break;     
       }
       System.out.print("\n");
     }  while(choice!=8);
   }
}
