import java.io.*;
import java.util.*;

  public class MyCircularQueue {    
    private int size = 0;
    private int front = 0;
    private int rear = 0;		 
    private int[] queue;  
	  
	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int capacity) {
	  queue = new int[capacity];         
	}
	    
	/** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) { 
	 /**
	  * Add an item to back of queue.
	  */
	  if(isFull()) {  
		return false;
	  }	
	  rear = (rear + 1) % queue.length;    
	  queue[rear] = value; 
	  if(size == 0) {
		front = rear;
	  }
	  size++; 
	  return true;	  
    }
	    
	/** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {   
	 /**
	  * Removes the next item from the front of the queue.	 
	  */	
	  if(isEmpty()) {  
		return false;
	  }	 	
	  front = (front + 1) % queue.length;  
	  size--;
	  return true;  
	}
	    
	/** Get the front item from the queue. */
	public int Front() {
	  return isEmpty() ? -1 : queue[front];      
	}
	    
	/** Get the last item from the queue. */
	public int Rear() {
	  return isEmpty() ? -1 : queue[rear];       
	}
	    
	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
	  return size == 0;      
	}
	    
	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
	  return size == queue.length;       
	}

	public static void main(String[] args) throws IOException {   
	  int choice = 0;
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the maximum queue size: ");
	  int maxSize = input.nextInt();  
	  
	  MyCircularQueue queue = new MyCircularQueue(maxSize);
	  
	  System.out.println();	
	    
	  do{	
		  System.out.println("1. For inserting an element in the circular queue.");
		  System.out.println("2. For deleting an element from the circular queue.");
		  System.out.println("3. For returning the front item from the circular queue.");
		  System.out.println("4. For returning the rear item from the circular queue.");
		  System.out.println("5. For checking the contents of the circular queue are empty or not.");
		  System.out.println("6. For checking the contents of the circular queue are full or not.");
		  System.out.println("7. For exiting from the program.");
		  System.out.println();	  	
		  System.out.print("Enter your choice: ");
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		  choice = Integer.parseInt(br.readLine());
		  switch (choice) {
		  case 1:  System.out.println();
			  	   System.out.print("Enter a element to insert in the circular queue: ");
		      	   BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
		      	   int element = br1.read();
		      	   boolean enQueue = queue.enQueue(element); 
		      	   System.out.println();	
		      	   if(enQueue) {
	 	   			 System.out.println("Yes you can insert the element in the circular queue.");		 
	 	   		   }
	 	   		   else {	 
	 	   			 System.out.println("No you cannot insert the element in the circular queue."); 
	 	   		   }
		    	   break;
	      case 2:  boolean deQueue = queue.deQueue(); 
	               System.out.println();	
	      		   if(deQueue) {
	      			 System.out.println("Yes you can delete the element from the circular queue.");		 
	      		   }
	      		   else {	 
	      			 System.out.println("No you cannot delete the element from the circular queue."); 
	      		   }
	               break;
	      case 3:  int front = queue.Front();
	               System.out.println();
	               System.out.println("The front item of the circular queue is: " + front);	
	               break;
	      case 4:  int rear = queue.Rear();
	               System.out.println();	
	               System.out.println("The rear item of the circular queue is: " + rear);	
	               break;
	      case 5:  boolean isEmpty = queue.isEmpty();
	 	   		   System.out.println();		
	 	   		   if(isEmpty) {
	 	   			 System.out.println("The circular queue is empty.");		 
	 	   		   }
	 	   		   else {	 
	 	   			 System.out.println("The circular queue is not empty."); 
	 	   		   }
		   		   break;
	      case 6:  boolean isFull = queue.isFull(); 
	               System.out.println();	
	      		   if(isFull) {
	      			 System.out.println("The circular queue is full.");		 
	      		   }
	      		   else {	 
	      			 System.out.println("The circular queue is not full."); 
	      		   }
		   		   break;  
	  }
	  System.out.println();
	} while(choice != 7);
  }
 }
