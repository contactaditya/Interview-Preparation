import java.util.*;
import java.io.*;

  public class PairwiseSwapElementsOfALinkedList { 
	private static LinkedListNode head;
	private static int size;  

	public PairwiseSwapElementsOfALinkedList() {
	   // this is an empty list, so the reference to the head node is set to a new node with no data				  
	   head = new LinkedListNode(null);
	   size = 0;
	}
		
    public static LinkedListNode getpairWiseSwap(LinkedListNode node) {	 
	   if (node == null || node.next == null) {
         return node;
       }	
	  
	   // Store head of list after two nodes
       LinkedListNode remaining = node.next.next;

       // Change head of the linked list
       LinkedListNode newhead = node.next;

       // Change next of second node
       node.next.next = node;

       // Recurse for the remaining list and change next of head
       node.next = getpairWiseSwap(remaining);
	 
	   return newhead;
    }  
   
    public static LinkedListNode getpairWiseSwap1(LinkedListNode node) {	 
	   if (node == null || node.next == null) {
	     return node;
	   }	
		  
	   LinkedListNode previous = node;
	   LinkedListNode current = node.next;

       node = current;
      
       while(true) {
    	 LinkedListNode next = current.next;
    	 current.next = previous;
    	
    	 // If next is NULL or next is the last node
         if (next == null || next.next == null) {
           previous.next = next;
           break;
         }
        
         // Change next of previous to next of next
         previous.next = next.next;
        
         // Update previous and curr
         previous = next;
         current = previous.next;
       }
      
	  return node;
   }  
		
   public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	  LinkedListNode current = head; 		    
      while(current != null) {	   
	    System.out.print(current.getData() + " ");	 	
        current = current.getNext();
	  }
   }  		
	 
   public static void main(String[] args) {  
	  PairwiseSwapElementsOfALinkedList list = new PairwiseSwapElementsOfALinkedList();
	  list.head = new LinkedListNode(1);
	  list.head.next = new LinkedListNode(2);
	  list.head.next.next = new LinkedListNode(3);
	  list.head.next.next.next = new LinkedListNode(4);
	  list.head.next.next.next.next = new LinkedListNode(5);
	  list.head.next.next.next.next.next = new LinkedListNode(6);
	  list.head.next.next.next.next.next.next = new LinkedListNode(7);
	   
	  System.out.print("Contents of the linked list before pairwise swap are: ");	 
	  PrintElementsOfALinkedList(head);
	  
	  LinkedListNode current = getpairWiseSwap(head);
	  
	  System.out.println();	
	  System.out.println();	
	  System.out.print("Contents of the linked list after pairwise swap are: ");
	  PrintElementsOfALinkedList(current);
   }
 }
