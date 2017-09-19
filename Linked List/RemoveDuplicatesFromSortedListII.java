import java.util.*;
import java.io.*;

 public class RemoveDuplicatesFromSortedListII {
	private static LinkedListNode head;
	private static int size;  

    public RemoveDuplicatesFromSortedListII() {
	   // this is an empty list, so the reference to the head node is set to a new node with no data				  
	   head = new LinkedListNode(null);
	   size = 0;
	}	 
	 
	public static LinkedListNode deleteDuplicates(LinkedListNode head) {
	   if (head == null) {
		 return null;
	   }
		
	   if (head.next != null && (int)head.data == (int)head.next.data) {
	     while (head.next != null && (int)head.data == (int)head.next.data) {
	       head = head.next;
	     }
	     return deleteDuplicates(head.next);
	   } else {   
		 head.next = deleteDuplicates(head.next);
	   }
		
	   return head;    
	}
	 
	public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	  LinkedListNode current = head; 
	  while(current != null) {	   
		System.out.print(current.getData() + " ");	 	
	    current = current.getNext();
	  }
	} 		 

	public static void main(String[] args) {
	  RemoveDuplicatesFromSortedListII list = new RemoveDuplicatesFromSortedListII();
	  list.head = new LinkedListNode(1);
	  list.head.next = new LinkedListNode(2);
	  list.head.next.next = new LinkedListNode(3);
	  list.head.next.next.next = new LinkedListNode(3);
	  list.head.next.next.next.next = new LinkedListNode(4);
	  list.head.next.next.next.next.next = new LinkedListNode(4);
	  list.head.next.next.next.next.next.next = new LinkedListNode(5);
		  
	  size = 7;
	  LinkedListNode current = list.deleteDuplicates(head); 
	  System.out.print("Contents of the linked list after removing all duplicates from the linked list are: ");
	  PrintElementsOfALinkedList(current);	
	}
 }
