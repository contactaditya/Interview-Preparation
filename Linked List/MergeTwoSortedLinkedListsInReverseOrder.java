import java.util.*;
import java.io.*;
 
   public class MergeTwoSortedLinkedListsInReverseOrder { 	
     private static LinkedListNode head;
     private static LinkedListNode head1;
     private static LinkedListNode head2;
     private static int size;  	
	
     public MergeTwoSortedLinkedListsInReverseOrder() {
        // this is an empty list, so the reference to the head node is set to a new node with no data				  
	head = new LinkedListNode(null);
        size = 0;
     }
	
     public static LinkedListNode MergeListsInReverseOrder(LinkedListNode headA, LinkedListNode headB) { 
       LinkedListNode list = headA;
       LinkedListNode list1 = headB;
       LinkedListNode result = null;
		       
       if (list == null && list1 == null) {
         return null; 
       }
		      
       if (list == null) {
	 return list1; 
       }
		    	   
       if (list1 == null) {
	 return list;
       }
	   
       while (list != null && list1 != null) {
	 if ((int)list.data <= (int)list1.data) {
	   LinkedListNode temp = list.next; 
	   list.next = result; 
	   result = list;
	   list = temp;	       
	 } else {
	   LinkedListNode temp = list1.next; 
	   list1.next = result; 
	   result = list1;
	   list1 = temp;	  
	 }
       }
	   
       // If second list reached end, but first list has nodes. Add remaining nodes of first list at the front of result list.   
       while (list != null) {
         LinkedListNode temp = list.next;
         list.next = result;
         result = list;
         list = temp;
       }
	   
       // If first list reached end, but second list has node. Add remaining nodes of first list at the front of result list
       while (list1 != null) {
	 LinkedListNode temp = list1.next;
	 list1.next = result;
	 result = list1;
	 list1 = temp;
       }	
       return result;
     }	
	
     public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
       LinkedListNode current = head; 
       while(current != null) {	   
	 System.out.print(current.getData() + " ");	 	
	 current = current.getNext();
       }
     } 		

     public static void main(String[] args) {  
       MergeTwoSortedLinkedListsInReverseOrder list = new MergeTwoSortedLinkedListsInReverseOrder();
       list.head1 = new LinkedListNode(5);
       list.head1.next = new LinkedListNode(10);
       list.head1.next.next = new LinkedListNode(15);
	  
       list.head2 = new LinkedListNode(2);
       list.head2.next = new LinkedListNode(3);
       list.head2.next.next = new LinkedListNode(20);
	  
       System.out.print("Contents of the first linked list are: ");	 
       list.PrintElementsOfALinkedList(head1);
       System.out.println();	
	  
       System.out.println();	
       System.out.print("Contents of the second linked list are: ");	 
       list.PrintElementsOfALinkedList(head2);
       System.out.println();	
	  	  
       LinkedListNode current = MergeListsInReverseOrder(list.head1, list.head2);
	  
       System.out.println();	
       System.out.print("Merged linked list in reverse order is: ");	 
       list.PrintElementsOfALinkedList(current);
     }
   }
