import java.io.*;
import java.util.*;

  public class Queue {
	
    private static LinkedList<Object> queue = new LinkedList<Object>();
	
    public static void enqueue(Object object) {
      /**
       * Add an item to back of queue.
       */
       queue.addLast(object);
    }

    public static Object dequeue() {
      /**
       * Removes the next item from the front of the queue.	 
       */	 
       if(queue.isEmpty()) {
         System.out.println("The queue is already empty. No element can be removed from the queue.");  
         return -1;
       }
       return queue.removeFirst();
    }

    public static boolean isEmpty() {
      /**
       *Test if the queue is empty.
       */	
       if(queue.isEmpty()) {	   
         System.out.println("The queue is currently empty and has no elements.");	 	  	   
       }
       else {
         System.out.println("The queue is currently not empty.");	 		   
       }
       return queue.isEmpty();
    }
 
    public static int size() {
      /**
       * Returns the number of items currently in the queue.
       */
       System.out.println("The size of the queue is: " + queue.size());	 
       return queue.size();
    }
 
    public static void display() {
      /**
       * Displays all the contents of the queue.
       */
       System.out.println("Contents of the queue are: " + queue);
    }
 
    public static Object peek() {
      /**
       * Returns the front item from the queue without popping it.
       */	 
       if(queue.isEmpty()) {  
         System.out.println("The queue is empty so we can't see the front item of the queue.");  
         return -1;
       }	 
       else {
         System.out.println("The following element is the top element of the queue:" + queue.getFirst());  	  
       }
       return queue.getFirst();
    }
 	
    public static void main(String[] args) throws NumberFormatException, IOException {  
      int choice = 0;
    
      do{	
        System.out.println("1. For inserting an element in the queue.");
    	System.out.println("2. For deleting an element from the queue.");
    	System.out.println("3. For displaying the contents of the queue.");
    	System.out.println("4. For checking the contents of the queue are empty or not");
    	System.out.println("5. For checking the size of the queue");
    	System.out.println("6. For returning the front item from the queue without popping it.");
    	System.out.println("7. For exiting from the program.");
    	
    	System.out.println("Enter your choice: ");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	choice = Integer.parseInt(br.readLine());
    	switch (choice) {
      	  case 1:  System.out.println("Enter a element to insert in the queue: ");
      	       	   BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
      	           String element = br1.readLine();
    	           enqueue(element);
    	           break;
      	  case 2:  dequeue();
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
