import java.io.*;
import java.util.*;

  public class MyCircularDeque {      
	private int size = 0;
    private int front = 0;
    private int rear = 0;		 
    private int[] dequeue;  
	
	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
	  dequeue = new int[k];             
	}
	    
	/** Adds an item at the front of Deque. Return true if the operation is successful. */
  	public boolean insertFront(int value) {   
  	  if(isFull()) {
        return false;
      }
  	  if (!isEmpty()) {
        front = front == 0 ? dequeue.length - 1 : front - 1;
  	  }
  	  dequeue[front] = value;
  	  size++;
      return true;
	}
	    
	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {   	
	  if(isFull()) {
        return false;
      }
	  if (!isEmpty()) {
        rear = (rear + 1) % dequeue.length;
	  }
	  dequeue[rear] = value;
  	  size++;
	  return true;      
	}
	    
	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {  
	  if(isEmpty()) {
        return false;
      }
	  if (front != rear) {
		front = (front + 1) % dequeue.length;    
	  }
	  size--;
	  return true;    
	}
	    
	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {  
	  if(isEmpty()) {
        return false;
      }
	  if (front != rear) {
		rear = rear == 0 ? dequeue.length - 1 : rear - 1;
	  }
	  size--;
	  return true;          
	}
	    
	/** Get the front item from the deque. */
	public int getFront() {  
	  if(isEmpty()) {
        return -1;
      } else {
        return dequeue[front];
      }
	}
	    
	/** Get the last item from the deque. */
	public int getRear() {
	  if(isEmpty()) {
	    return -1;
	  } else {
		return dequeue[rear];
	  }        
	}
	    
	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
	  return size == 0;      
	}
	    
	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
	  return size == dequeue.length;             
	}
	
	public void printDequeue() {
	  System.out.println();
	  System.out.print("Contents of the circular dequeue are: ");  
	  for (int i = 0; i < dequeue.length; i++) {
	    System.out.print(dequeue[i] + " ");    
	  }
      System.out.println();
	}
		  
	public static void main(String[] args) throws NumberFormatException, IOException { 	  
	  int choice = 0;
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the maximum dequeue size: ");
	  int maxSize = input.nextInt();  
	  
	  MyCircularDeque circularDeque = new MyCircularDeque(maxSize);
	  
	  System.out.println();	
	    
	  do{	
		  System.out.println("1. For inserting an element in the front of the circular dequeue.");
		  System.out.println("2. For inserting an element in the rear of the circular dequeue.");
		  System.out.println("3. For deleting an element from the front of the circular dequeue.");
		  System.out.println("4. For deleting an element from the rear of the circular dequeue.");
		  System.out.println("5. For returning the front item from the circular dequeue.");
		  System.out.println("6. For returning the rear item from the circular dequeue.");
		  System.out.println("7. For checking the contents of the circular dequeue are empty or not.");
		  System.out.println("8. For checking the contents of the circular dequeue are full or not.");
		  System.out.println("9. For displaying the contents of the circular dequeue.");
		  System.out.println("10. For exiting from the program.");
		  System.out.println();	  	
		  System.out.print("Enter your choice: ");
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		  choice = Integer.parseInt(br.readLine());
		  switch (choice) {
		    case 1:  System.out.println();
			  	     System.out.print("Enter a element to insert in the front of the circular dequeue: ");
		      	     BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  	
		      	     int element = Integer.parseInt(br1.readLine());
		      	     boolean insertFront = circularDeque.insertFront(element); 
		      	     System.out.println();	
		      	     if(insertFront) {
	 	   			   System.out.println("Yes you can insert the element in the circular dequeue.");		 
	 	   		     }
	 	   		     else {	 
	 	   			   System.out.println("No you cannot insert the element in the circular dequeue."); 
	 	   		     }
		    	     break;
		    case 2:  System.out.println();
	  	             System.out.print("Enter a element to insert in the rear of the circular dequeue: ");
     	             BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));  	
     	             int element1 = Integer.parseInt(br2.readLine());
     	             boolean insertLast = circularDeque.insertLast(element1); 
     	             System.out.println();	
     	             if(insertLast) {
   			           System.out.println("Yes you can insert the element in the circular dequeue.");		 
   		             }
   		             else {	 
   			           System.out.println("No you cannot insert the element in the circular dequeue."); 
   		             }
   	                 break;
	        case 3:  boolean deleteFront = circularDeque.deleteFront(); 
	                 System.out.println();	
	      		     if(deleteFront) {
	      			   System.out.println("Yes you can delete the element from the circular dequeue.");		 
	      		     }
	      		     else {	 
	      			   System.out.println("No you cannot delete the element from the circular dequeue."); 
	      		     }
	                 break;
	        case 4:  boolean deleteLast = circularDeque.deleteLast(); 
                     System.out.println();	
 		             if(deleteLast) {
 			           System.out.println("Yes you can delete the element from the circular dequeue.");		 
 		             }
 		             else {	 
 			           System.out.println("No you cannot delete the element from the circular dequeue."); 
 		             }
 		             break;
	        case 5:  int getFront = circularDeque.getFront(); 
	                 System.out.println();	
	                 System.out.println("The front item of the circular dequeue is: " + getFront);	
	                 break;
	        case 6:  int getRear = circularDeque.getRear(); 
                     System.out.println();	
                     System.out.println("The rear item of the circular dequeue is: " + getRear);	
                     break;
	        case 7:  boolean isEmpty = circularDeque.isEmpty();
	 	   		     System.out.println();		
	 	   		     if(isEmpty) {
	 	   			   System.out.println("The circular dequeue is empty.");		 
	 	   		     }
	 	   		     else {	 
	 	   			   System.out.println("The circular dequeue is not empty."); 
	 	   		     }
		   		     break;
	        case 8:  boolean isFull = circularDeque.isFull(); 
	                 System.out.println();	
	      		     if(isFull) {
	      			   System.out.println("The circular dequeue is full.");		 
	      		     }
	      		     else {	 
	      			   System.out.println("The circular dequeue is not full."); 
	      		     }
		    case 9:  circularDeque.printDequeue(); 
	                 break;  
	      }
	    System.out.println();
	  } while(choice != 10);
	}
  }
