import java.util.*;
import java.io.*;

  public class MergeFirstHalfAndReversedSecondHalfOfTheLinkedListAlternatively { 	
	private static LinkedListNode head;
	private static LinkedListNode head1;
	private static LinkedListNode head2;
	private static int size;  	
	
	public MergeFirstHalfAndReversedSecondHalfOfTheLinkedListAlternatively() {
	  // this is an empty list, so the reference to the head node is set to a new node with no data				  
	  head = new LinkedListNode(null);
	  size = 0;
    }
	
	public static void MergeLists(LinkedListNode head) {  
	  // Find the mid node	
	  LinkedListNode fast = head; 
	  LinkedListNode slow = head;   
		  
	  while(fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;		   
	  }
	  
	  // Reverse the second half of the list
	  LinkedListNode head1 = reverseLL(slow.next);
	  
	  // Partition the list
	  slow.next = null;
	 
	  LinkedListNode current1 = head, current2 = head1;
	  
	  // Insert the elements in between
	  while(current1 != null && current2 != null) {
		// Next node to be traversed in the first list  
		LinkedListNode dnext1 = current1.next;
		// Next node to be traversed in the second list  
		LinkedListNode dnext2 = current2.next;
		current1.next = current2;
	    current2.next = dnext1;
	    current1 = dnext1;
        current2 = dnext2;
	  }
	}
	
	private static LinkedListNode reverseLL(LinkedListNode head) {
	  /**
	   * Reverses a linked list.
	   */ 
	   LinkedListNode current = head;	  
	   LinkedListNode previous = null;
	 	   
	   while(current!=null) {
	     LinkedListNode next = current.next;
	     current.next = previous;
	     previous = current;
	     current = next;
	   }	
	   
	   head = previous;

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
	  MergeFirstHalfAndReversedSecondHalfOfTheLinkedListAlternatively list = new MergeFirstHalfAndReversedSecondHalfOfTheLinkedListAlternatively();
	  list.head1 = new LinkedListNode(1);
	  list.head1.next = new LinkedListNode(2);
	  list.head1.next.next = new LinkedListNode(3);
	  list.head1.next.next.next = new LinkedListNode(4);
	  list.head1.next.next.next.next = new LinkedListNode(5);
	  
	  System.out.print("Contents of the odd length link list before merging are: ");	 
	  PrintElementsOfALinkedList(head1);
	  
	  MergeLists(head1);
	  
	  System.out.println();	 	  
	  System.out.print("Contents of the odd length link list after merging are: ");	 
	  PrintElementsOfALinkedList(head1);
	  
	  list.head2 = new LinkedListNode(1);
	  list.head2.next = new LinkedListNode(2);
	  list.head2.next.next = new LinkedListNode(3);
	  list.head2.next.next.next = new LinkedListNode(4);
	  list.head2.next.next.next.next = new LinkedListNode(5);
	  list.head2.next.next.next.next.next = new LinkedListNode(6);
	  
	  System.out.println();	 
	  System.out.println();	 
	  System.out.print("Contents of the even length link list before merging are: ");	 
	  PrintElementsOfALinkedList(head2);
	  
	  MergeLists(head2);
	  
	  System.out.println();	 	  
	  System.out.print("Contents of the even length link list after merging are: ");	 
	  PrintElementsOfALinkedList(head2);
	}
  }
