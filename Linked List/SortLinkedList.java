import java.util.*;
import java.io.*;

 public class SortLinkedList {
   private static LinkedListNode head;
   private static int size;  

   public SortLinkedList() {
	   // this is an empty list, so the reference to the head node is set to a new node with no data				  
	   head = new LinkedListNode(null);
	   size = 0;
	} 

	public static LinkedListNode sortLinkedList(LinkedListNode head) { 
	   if (head == null || head.next == null) {
		 return head;	 
	   }
	    
	   // step 1. Cut the list to two halves
	   LinkedListNode previous = null; 
	   LinkedListNode slow = head;
	   LinkedListNode fast = head;
	    
	   while (fast != null && fast.next != null) {
	     previous = slow;
	     slow = slow.next;
	     fast = fast.next.next;
	   }
	    
	   previous.next = null;
		
	   // step 2. Sort each half 
	   LinkedListNode list1 = sortLinkedList(head);
	   LinkedListNode list2 = sortLinkedList(slow);
	    
	   // step 3. merge l1 and l2
	   return merge(list1, list2);
	}   
	 	 
	private static LinkedListNode merge(LinkedListNode left, LinkedListNode right) {	   
	   LinkedListNode l = new LinkedListNode(0), p = l;
	   
	   while (left != null && right != null) {
		 if ((int)left.data < (int)right.data) {
		   p.next = left;
		   left = left.next;
		 } else {
		   p.next = right;
		   right = right.next;
		 }
		 p = p.next;
	   }
		    
	   if (left != null) {
		 p.next = left;
	   }
		    
	   if (right != null) {
		 p.next = right;
	   }
	  return l.next;
    }

	public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	    LinkedListNode current = head; 		    
	    while(current != null) {	   
		   System.out.print(current.getData() + " ");	 	
		   current = current.getNext();
	    }
     } 	 

	public static void main(String[] args) {
	  SortLinkedList list = new SortLinkedList();
	  list.head = new LinkedListNode(2);
	  list.head.next = new LinkedListNode(3);
	  list.head.next.next = new LinkedListNode(4);
	  list.head.next.next.next = new LinkedListNode(3);
	  list.head.next.next.next.next = new LinkedListNode(4);	  
	  list.head.next.next.next.next.next = new LinkedListNode(5);

	  System.out.print("Contents of the linked list before sorting are: ");	 
	  list.PrintElementsOfALinkedList(head);
	  list.sortLinkedList(head); 
	  System.out.println();
	  System.out.println();
	  System.out.print("Contents of the linked list after sorting are: ");	 
	  list.PrintElementsOfALinkedList(head);		
	}
 }
