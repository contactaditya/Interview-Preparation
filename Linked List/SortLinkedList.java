import java.util.*;
import java.io.*;

 public class SortLinkedList {
   private LinkedListNode head;
   private static int size;  

   public SortLinkedList() {
     // this is an empty list, so the reference to the head node is set to a new node with no data				  
     head = new LinkedListNode(null);
     size = 0;
   } 

   public LinkedListNode sortLinkedList(LinkedListNode head) { 
     if (head == null || head.next == null) {
       return head;	 
     }
	    
     // step 1. Cut the list to two halves
     LinkedListNode dummy = head; 
     LinkedListNode slow = head;
     LinkedListNode fast = head;
	    
     while (fast != null && fast.next != null) {
       dummy = slow;
       slow = slow.next;
       fast = fast.next.next;
     }
	    
     dummy.next = null;
			    
     // step 2. Sort the two Linked List and merge 
     return merge(sortLinkedList(head), sortLinkedList(slow));
   }   
	 	 
   private LinkedListNode merge(LinkedListNode list1, LinkedListNode list2) {	   
     if (list1 == null) {
       return list2;
     }
     if (list2 == null) {
       return list1;
     }
     if ((int)list1.data <= (int)list2.data) {
       list1.next = merge(list1.next, list2);
       return list1;
     } else {
       list2.next = merge(list1, list2.next);
       return list2;
     }
   }

   public void PrintElementsOfALinkedList(LinkedListNode head) {	 
     LinkedListNode current = head; 		    
     while(current != null) {	   
       System.out.print(current.getData() + " ");	 	
       current = current.getNext();
     }
   } 	 

   public static void main(String[] args) { 
     SortLinkedList list = new SortLinkedList(); 
     list.head = new LinkedListNode(15); 
     list.head.next = new LinkedListNode(10); 
     list.head.next.next = new LinkedListNode(5);  
     list.head.next.next.next = new LinkedListNode(20);
     list.head.next.next.next.next = new LinkedListNode(3);	  
     list.head.next.next.next.next.next = new LinkedListNode(2);

     System.out.print("Contents of the linked list before sorting are: ");	 
     list.PrintElementsOfALinkedList(list.head);
     LinkedListNode sortedList = list.sortLinkedList(list.head); 
     System.out.println();
     System.out.println();
     System.out.print("Contents of the linked list after sorting are: ");	 
     list.PrintElementsOfALinkedList(sortedList);		
   }
 }
