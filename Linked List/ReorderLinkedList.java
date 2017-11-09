import java.util.*;
import java.io.*;

  public class ReorderLinkedList { 
	private static LinkedListNode head;
	private static int size;  

	public ReorderLinkedList() {
	  // this is an empty list, so the reference to the head node is set to a new node with no data				  
	  head = new LinkedListNode(null);
      size = 0;
    }
	
	public void reorderList(LinkedListNode head) {
	   if (head == null || head.next == null || head.next.next == null) {
	     return;	
	   }
	   // STEP 1: Find the middle of the list
	   LinkedListNode slow = head;
	   LinkedListNode fast = head;
	  
       while(fast != null && fast.next!=null && fast.next.next!=null) { 
         slow = slow.next;
         fast = fast.next.next;
       }
      
       LinkedListNode secondHead = slow.next;
       slow.next = null; //truncate the first half
      
       // STEP 2: Cut from the middle and reverse the second half
       LinkedListNode previous = secondHead;
       LinkedListNode current = secondHead.next;	  

  	   while(current!=null) {
  		 LinkedListNode next = current.next;
         current.next = previous;
         previous = current;
         current = next;
       } 	
  	   // setup the new head
       secondHead.next = null;
       secondHead = previous;
     
       // STEP 3: Merge the two lists together
       LinkedListNode p1 = head;       // head
       LinkedListNode p2 = secondHead;  // head of reversed part
       while(p2 != null) {
    	 LinkedListNode temp1 = p1.next;
    	 LinkedListNode temp2 = p2.next;
         p1.next = p2;
         p2.next = temp1;
         p1 = temp1;
         p2 = temp2;
       }
    }
	
	public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	  LinkedListNode current = head; 		    
	  while(current != null) {	   
		System.out.print(current.getData() + " ");	 	
		current = current.getNext();
	  }
	} 	

	public static void main(String[] args) { 	 
	  ReorderLinkedList list = new ReorderLinkedList();	
	  list.head = new LinkedListNode(1);
	  list.head.next = new LinkedListNode(2);
	  list.head.next.next = new LinkedListNode(3);
	  list.head.next.next.next = new LinkedListNode(4);
	  
	  System.out.print("Contents of the linked list before reordering the linked list are: ");
	  PrintElementsOfALinkedList(head);	
	  		    
	  list.reorderList(head);
	  System.out.println();		  
	  System.out.println();		
	  System.out.print("Contents of the linked list after reordering the linked list are: ");
	  PrintElementsOfALinkedList(head);	

	}
  }
