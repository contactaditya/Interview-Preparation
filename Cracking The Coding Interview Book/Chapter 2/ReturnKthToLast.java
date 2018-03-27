import java.util.*;

 public class ReturnKthToLast { 
    private static LinkedListNode head;
    private static int size;  

    public ReturnKthToLast() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
	
    public static LinkedListNode displayNthToLast(LinkedListNode head, int k) { 
     /**
      * Displays the kth to last element of a singly linked list.
      */
				  
      System.out.println();	
      LinkedListNode p1 = head; 
      LinkedListNode p2 = head;
			  	   
      if(k <= 0) {  
	System.out.println("Index entered by the user is either negative or null.");
	return null; 
      }
      if(k > size) {  
	System.out.println("Index entered by the user is greater than size.");
	return null;
      }
      if(size == 0) {	   
	System.out.println("The linked list is currently empty and has no elements.");	 	  	   
      }
		  
      // Move p2 forward k nodes into the list.
			  
      else {		
        for(int i = 0; i < k-1; i++) {
	  if(p2 == null) {
	    System.out.println("The linked list has ended before reaching the index.");	
	    return null;
	  }
	  p2 = p2.getNext();
        }
		  
        // Now, move p1 and p2 at the same speed. When p2 hits the end, p1 will be at the right element.
        while(p2.next != null) {
	  p1 = p1.getNext();
	  p2 = p2.getNext();	  
        }	  
      }
      return p1;
    }  

    public static void main(String[] args) { 	  
      ReturnKthToLast list = new ReturnKthToLast();
      list.head = new LinkedListNode(50);
      list.head.next = new LinkedListNode(20);
      list.head.next.next = new LinkedListNode(15);
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(10);
	  
      size = 5;
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the index of the kth to last element in the linkedlist: ");
      int value = input.nextInt();  
	  
      LinkedListNode display = displayNthToLast(head, value);
	  
      if(display != null) {
        System.out.println("Content of the specific element of the linked list is: " + display.getData());
      }
    }
 }
