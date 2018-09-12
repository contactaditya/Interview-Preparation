import java.io.*;
import java.util.*;

  public class Stack {
    private static LinkedList<Object> stack = new LinkedList<Object>();	
	
    public static void push(Object object) {
     /**
      * Add an item to back of stack.
      */  
      stack.addFirst(object);
    }

    public static Object pop() {
     /**
      * Removes the next item from the front of the stack.	 
      */	 
      System.out.println(); 	  
      if(stack.isEmpty()) {
        System.out.println("The stack is already empty. No element can be removed from the stack.");  
        return -1;
      }
      return stack.removeFirst();
    }

    public static boolean isEmpty() {
     /**
      * Test if the stack is empty.
      */
      System.out.println(); 	   
      if(stack.isEmpty()) {	   
        System.out.println("The stack is currently empty and has no elements.");	 	  	   
      }
 
      else {
        System.out.println("The stack is currently not empty.");	 		   
      }
      return stack.isEmpty();
    }
		 
    public static int size() {
     /**
      * Returns the number of items currently in the stack.
      */
      System.out.println(); 	   
      System.out.println("The size of the stack is: " + stack.size());	 
      return stack.size();
    }
		
    public static void display() {
     /**
      * Displays all the contents of the stack.
      */
      System.out.println(); 		   
      System.out.println("Contents of the stack are: " + stack);
    }
		 
    public static Object peek() {
     /**
      * Returns the front item from the stack without popping it.
      */	 
      if(stack.isEmpty()) {  
        System.out.println("The stack is empty so we can't see the last item of the stack.");  
        return -1;
      }	 
		  
      else {
        System.out.println("The following element is the last element of the stack: " + stack.getFirst());  	  
      }
      return stack.getFirst();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
      int choice = 0;
	    
      do{	
          System.out.println("1. For inserting an element in the stack.");
          System.out.println("2. For deleting an element from the stack.");
       	  System.out.println("3. For displaying the contents of the stack.");
          System.out.println("4. For checking the contents of the stack are empty or not");
          System.out.println("5. For checking the size of the stack");
          System.out.println("6. For returning the last element from the stack without popping it.");
          System.out.println("7. For exiting from the program.");
	       
	  System.out.println(); 	
          System.out.print("Enter your choice: ");
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
          choice = Integer.parseInt(br.readLine());
          switch (choice) {
            case 1:  System.out.println(); 
		     System.out.print("Enter a element to insert in the stack: ");
	             BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
	             String element = br1.readLine();
	     	     push(element);
	             break;
    	    case 2:  pop();
	     	     break;
    	    case 3:  display();
	     	     break;
    	    case 4:  isEmpty();
	     	     break;
            case 5:  size();
	             break;  
            case 6:  peek();
	             break;     
          }
          System.out.println();
        } while(choice!=7);
     }
  }
