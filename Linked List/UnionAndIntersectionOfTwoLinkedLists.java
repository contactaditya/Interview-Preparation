import java.util.*;
import java.io.*;

 public class UnionAndIntersectionOfTwoLinkedLists {     
      private static LinkedListNode head;
      private static LinkedListNode head1;
      private static LinkedListNode head2;
      private static int size;  	
	
      public UnionAndIntersectionOfTwoLinkedLists () {
	// this is an empty list, so the reference to the head node is set to a new node with no data				  
	  head = new LinkedListNode(null);
	  size = 0;
      } 	
	
      public static boolean isPresent(LinkedListNode head, int data) {
 	 LinkedListNode current = head;

 	 while (current != null) {
 	    if ((int)current.data == data) {
 	      return true;
 	    }
 	   current = current.next;
 	 } 
 	return false;  
      }
	
      public static void addFirst(int data) {
	 /**
	  * Add an item to the front of the linkedlist.
	  */
	   LinkedListNode temp = new LinkedListNode(data);
	   LinkedListNode current = head;	  
		  
	   if(head == null) {
             head = temp;
	     head.next = null;
	   }
	   else {
	     temp.next = head;
	     head = temp;
	   }
	  size++;   	
      }
		
     public static void getIntersection(LinkedListNode headA, LinkedListNode headB) {
	 LinkedListNode result = null;
	 LinkedListNode current1 = headA;
		   	   
	 while (current1 != null) {
	    if (isPresent(head2, (int) current1.data)) {
	      addFirst((int)current1.data);
	    } 
	    current1 = current1.next;
	  } 
	  System.out.println();	
	  System.out.print("Contents of the linked list after intersection are: ");	 
	  PrintElementsOfALinkedList(head);
	  System.out.println();	
     }
	
     public static void getUnion(LinkedListNode headA, LinkedListNode headB) {
	 LinkedListNode list1 = headA;
	 LinkedListNode list2 = headB;
	   
	 // Insert all elements of list1 in the result		     
	 while (list1 != null) {
	    addFirst((int)list1.data);
            list1 = list1.next;
	 }
	   
	 // Insert all elements of list2 that are not present in list1
	 while (list2 != null) {
	   if (!isPresent(head1, (int) list2.data)) {
	      addFirst((int)list2.data);
	   } 
	   list2 = list2.next;
	 }
	   
	 System.out.println();	
	 System.out.print("Contents of the linked list after union are: ");	 
	 PrintElementsOfALinkedList(head);
    }	
	
    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	LinkedListNode current = head; 
	while(current != null) {	   
	   System.out.print(current.getData() + " ");	 	
	   current = current.getNext();
        }
    } 	

    public static void main(String[] args) {   
	UnionAndIntersectionOfTwoLinkedLists list = new UnionAndIntersectionOfTwoLinkedLists();
	list.head1 = new LinkedListNode(11);
	list.head1.next = new LinkedListNode(10);
	list.head1.next.next = new LinkedListNode(15);
	list.head1.next.next.next = new LinkedListNode(4);
	list.head1.next.next.next.next = new LinkedListNode(20);
	  
	list.head2 = new LinkedListNode(8);
	list.head2.next = new LinkedListNode(4);
	list.head2.next.next = new LinkedListNode(2);
	list.head2.next.next.next = new LinkedListNode(20);
	  
	System.out.print("Contents of the first linked list are: ");	 
	list.PrintElementsOfALinkedList(head1);
	System.out.println();	
	  
	System.out.println();	
	System.out.print("Contents of the second linked list are: ");	 
	list.PrintElementsOfALinkedList(head2);
	System.out.println();	
	  	  	  	  	  
	getIntersection(list.head1, list.head2);
	getUnion(list.head1, list.head2);
	   
    }
 }
