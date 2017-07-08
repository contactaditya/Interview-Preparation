import java.io.*;
import java.util.*;

public class BoundedStack { 
	
  private static Object[] array;
  private static int size = 0;

  public BoundedStack(int capacity) {
    array = new Object[capacity];
  }

  public static void push(Object object) {
    /**
     * Add an item to back of stack.
     */
	  
     if (size == array.length) {
       throw new IllegalStateException("The stack is already full. You cannot add more items to the stack.");
     } 	  
		   
     array[size++] = object;
  }

  public static Object pop() {
    /**
     * Removes the next item from the front of the stack.	 
     */	 
	  
     if(size == 0) {
       System.out.println("The stack is already empty. No element can be removed from the stack.");  
       return -1;
     }
  
     Object result = array[size-1];
     array[--size] = null; 
 
    return result;
  }

  public static boolean isEmpty() {
    /**
     * Test if the stack is empty.
     */
	   
     if(size == 0) {
       System.out.println();		 
       System.out.println("The stack is currently empty and has no elements.");	 	  	   
     }
		   
     else {
       System.out.println();		 
       System.out.println("The stack is currently not empty.");	 		   
     }
    return size == 0;
  }
		 
  public static int size() {
    /**
     * Returns the number of items currently in the stack.
     */
	 
     System.out.println();			   
     System.out.println("The size of the stack is: " + size);	 
  
    return size;
  }
		
  public static void display() {
    /** 
     * Displays all the contents of the stack.
     */
	 
    System.out.println();		 
	 
    System.out.print("Contents of the stack are: ");	
	 
    for(int i = 0; i< array.length; i++) {	 		   
      System.out.print(array[i] + " ");  
    }
  
    System.out.println();	
  }
		 
  public static Object peek() {
   /**
    * Returns the front item from the stack without popping it.
    */	 
		  
   if(size == 0) {  
     System.out.println();			 
     System.out.println("The stack is empty so we can't see the last item of the stack.");  
     return -1;
   }	 
		  
   else {
     System.out.println();			 
     System.out.println("The following element is the last element of the stack: " + array[size - 1]);  	  
   }
   return array[size - 1];
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
	
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
     System.out.print("Enter number of elements in the array: ");
     int number = Integer.parseInt(br.readLine());  

     BoundedStack stack = new BoundedStack(number);
		  
     int choice = 0;
     System.out.println();	
	    
     do {	
          System.out.println("1. For inserting an element in the stack.");
          System.out.println("2. For deleting an element from the stack.");
       	  System.out.println("3. For displaying the contents of the stack.");
          System.out.println("4. For checking the contents of the stack are empty or not");
          System.out.println("5. For checking the size of the stack");
          System.out.println("6. For returning the last element from the stack without popping it.");
          System.out.println("7. For exiting from the program.");
	    
          System.out.println();	
	    	
          System.out.print("Enter your choice: ");
          BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  
          choice = Integer.parseInt(br1.readLine());
          switch (choice) {
	    case 1:  System.out.println();	
	    	     System.out.print("Enter a element to insert in the stack: ");
	      	     BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));  	
	      	     String element = br2.readLine();
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
       System.out.print("\n");
     } while(choice!=7);
   }
}
	
