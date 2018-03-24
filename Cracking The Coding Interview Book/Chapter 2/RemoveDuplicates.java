import java.util.*;

  public class RemoveDuplicates { 	
    private static LinkedListNode head;
    private static int size;  

    public RemoveDuplicates() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				   
      head = new LinkedListNode(null);
      size = 0;
    }
	
    public static void removeDuplicates() {
      /**
       * Removes the duplicates from the linked list.	 
       */	 
				    
       HashSet<Object> set = new HashSet<Object>();
       LinkedListNode previous = null;
       LinkedListNode current = head;
		  	  
       if(size==0) {	   
	 System.out.println();  
	 System.out.println("The linked list is currently empty and has no elements so no elements can be removed.");	
       }	 
       else {
	 while (current != null) {
	   if (set.contains(current.data)) {
	     previous.next = current.next;
	   } else {
	     set.add(current.data);
             previous = current;
	   }
	     current = current.next;
	 }
       }
    }

    public static void main(String[] args) { 	  
      RemoveDuplicates list = new RemoveDuplicates();
      list.head = new LinkedListNode(3);
      list.head.next = new LinkedListNode(5);
      list.head.next.next = new LinkedListNode(8);
      list.head.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next = new LinkedListNode(10);
      list.head.next.next.next.next.next = new LinkedListNode(2);
      list.head.next.next.next.next.next.next = new LinkedListNode(1);
      list.head.next.next.next.next.next.next.next = new LinkedListNode(2);
	 
      size = 8;
      removeDuplicates();
      LinkedListNode current = head;
      System.out.print("Contents of the linked list are: ");	 
      while(current != null) {	   
	System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    }
  }
