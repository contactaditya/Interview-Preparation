import java.io.*;
import java.util.*;

 public class CircularQueue {  
   private static int size = 0;
   private static int front = 0;
   private static int rear = 0;		 
   private static int capacity;	
   private static Object[] queue;
   
   public CircularQueue(int capacity) {
      this.capacity = capacity;
      this.queue = new Object[capacity];   
   }

   public static void enqueue(Object object) {
    /**
     * Add an item to back of queue.
     */
     if(size == queue.length) {  
	System.out.println();	 
	System.out.println("The queue is full. No new element can be inserted.");  
     }	 	
     else {
	queue[rear] = object; 
	rear = (rear + 1) % queue.length;     
	size++; 
	System.out.println();
	System.out.print("Element " + object + " has been successfully added to the queue.");
	System.out.println();
     }   
   }

   public static Object dequeue() {
     /**
      * Removes the next item from the front of the queue.	 
      */	 
      if(size == 0) {  
        System.out.println(); 
        System.out.println("The queue is empty so we can't see the front item of the queue.");  
        return -1;
      }	 
      else {
        Object temp = queue[front]; 
        queue[front] = null;
        front = (front + 1) % queue.length;  
        size--;
        return temp;  
      }
   }

   public static boolean isEmpty() {
    /**
     * Test if the queue is empty.
     */	
     if(size == 0) {	  
       System.out.println();	 
       System.out.println("The queue is currently empty and has no elements.");	 	  	   
     }
     else{
       System.out.println();	 
       System.out.println("The queue is currently not empty.");	 		   
     }
     return size == 0;
   }
   
  public static boolean isFull() {
    /**
     * Test if the queue is full.
     */	
    if(size == capacity) {	   
       System.out.println();  
       System.out.println("The queue is full. No new element can be inserted.");	 	  	   
    }
    else {
       System.out.println();
       System.out.println("The queue is currently not full.");	 		   
    }
    return size == capacity;
  }

  public static int size() {
   /**
    * Returns the number of items currently in the queue.
    */
    System.out.println();  
    System.out.println("The size of the queue is: " + size);	 
    return size;
  }

  public static void display() {
   /**
    * Displays all the contents of the queue.
    */
	  
    System.out.println();
    if (size == 0) { 
      System.out.println("The queue is currently empty and has no elements."); 
      System.out.println();
    }
    else {
      System.out.print("Contents of the queue are: ");  
      for (int i = 0; i < queue.length; i++) {
	System.out.print(queue[i]+" ");    
      }
    }
   System.out.println();
  }

  public static Object peek() {
   /**
    * Returns the front item from the queue without popping it.
    */	 
    if (size == 0) {  
       System.out.println();	    
       System.out.println("The queue is empty so we can't see the front item of the queue.");  
       return -1;
    }	 
    else {
       System.out.println();	  
       System.out.println("The following element is the top element of the queue: " + queue[front]);  	  
    }
    return queue[front];
  }
	
 public static void main(String[] args) throws NumberFormatException, IOException { 	  
     int choice = 0;
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the maximum queue size: ");
     int maxSize = input.nextInt();  
	  
     CircularQueue queue = new CircularQueue(maxSize);
	   
     System.out.println();	
	    
     do {	
	  System.out.println("1. For inserting an element in the circular queue.");
	  System.out.println("2. For deleting an element from the circular queue.");
	  System.out.println("3. For displaying the contents of the circular queue.");
	  System.out.println("4. For checking the contents of the circular queue are empty or not");
	  System.out.println("5. For checking the size of the circular queue");
	  System.out.println("6. For returning the front item from the circular queue without popping it.");
	  System.out.println("7. For exiting from the program.");
	  System.out.println();	  	
	  System.out.print("Enter your choice: ");
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	  choice = Integer.parseInt(br.readLine());
	  switch (choice) {
             case 1:  System.out.println();
		      System.out.print("Enter a element to insert in the circular queue: ");
		      BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
		      String element = br1.readLine();
		      queue.enqueue(element);
		      break;
	     case 2:  queue.dequeue();
	              break;
	     case 3:  queue.display();
	              break;
	     case 4:  queue.isEmpty();
	              break;
	     case 5:  queue.isFull();
 		      break;
	     case 6:  queue.size();
 		      break;  
	     case 7:  queue.peek();
	      	      break;     
	  }
	System.out.print("\n");
      } while(choice!=8);
   }
 }

