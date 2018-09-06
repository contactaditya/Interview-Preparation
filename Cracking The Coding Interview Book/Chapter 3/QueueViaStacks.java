import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

 public class QueueViaStacks<T> {
   Stack<T> stackNewest, stackOldest;
    
   public QueueViaStacks() {
     stackNewest = new Stack<T>();	
     stackOldest = new Stack<T>();	
   }
    
   public int size() {
     System.out.println();
     System.out.println("The size of the queue is: " + stackNewest.size() + stackOldest.size()); 
     return stackNewest.size() + stackOldest.size();	
   }
    
   public void add(T value) {
     // Push onto stackNewest, which always the newest elements on top	
     stackNewest.push(value);	 	
   }
    
   private void shiftStacks() {
     if(stackOldest.isEmpty()) {
       while(!stackNewest.isEmpty()) {
         stackOldest.push(stackNewest.pop());	
       }
     }
   }
    
   public void display() {
    /**
     * Displays all the contents of the queue.
     */
    	
     shiftStacks();
     System.out.println();
     System.out.print("Contents of the queue are: "); 
     for (int i = stackOldest.size() - 1; i >= 0; i--) {
       System.out.print(stackOldest.get(i) + " ");
     }
	  
     System.out.println();
   }
    
   public boolean isEmpty() {
    /**
     * Test if the queue is empty.
     */
    
     shiftStacks();
     System.out.println();
     if(stackOldest.isEmpty()) {	   
       System.out.println("The queue is currently empty and has no elements.");	 	  	   
     }
     else {
       System.out.println("The queue is currently not empty.");	 		   
     }
     return stackOldest.isEmpty();
   }
    
   public T peek() {
     shiftStacks(); //	Ensure stackOldest has the current element
     System.out.println();
     if(stackOldest.isEmpty()) {  
       System.out.println("The queue is empty so we can't see the front item of the queue.");  
       return null;
     }	 
     else {
       System.out.println("The following element is the top element of the queue: " + stackOldest.peek());  	  
     }
      
     return stackOldest.peek();    	
   }
    
   public T remove() {
     shiftStacks(); // Ensure stackOldest has the current element
     return stackOldest.pop();   
   }

   public static void main(String[] args) throws NumberFormatException, IOException { 
     int choice = 0;
     QueueViaStacks<Integer> queue = new QueueViaStacks<Integer>();	
    
     do{	
         System.out.println("1. For inserting an element in the queue.");
         System.out.println("2. For deleting an element from the queue.");
    	 System.out.println("3. For displaying the contents of the queue.");
         System.out.println("4. For checking the contents of the queue are empty or not");
         System.out.println("5. For checking the size of the queue");
         System.out.println("6. For returning the front item from the queue without popping it.");
         System.out.println("7. For exiting from the program.");
    	
         System.out.println();
         System.out.print("Enter your choice: ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
         choice = Integer.parseInt(br.readLine());
         switch (choice) {
      	   case 1:  System.out.println();  
    	            System.out.print("Enter a element to insert in the queue: ");
    	       	    Scanner input = new Scanner(System.in);
      	       	    int element = input.nextInt();
    	            queue.add(element);
    	       	    break;
      	   case 2:  queue.remove();
                    break;
      	   case 3:  queue.display();
               	    break;
      	   case 4:  queue.isEmpty();
               	    break;
      	   case 5:  queue.size();
      	       	    break;  
      	   case 6:  queue.peek();
	       	    break;     
       }
       System.out.print("\n");
     } while(choice!=7);
   }
 }

