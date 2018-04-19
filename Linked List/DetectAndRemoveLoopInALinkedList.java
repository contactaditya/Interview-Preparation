import java.util.*;
import java.io.*;
 
   public class DetectAndRemoveLoopInALinkedList { 	
     private static LinkedListNode head;
     private static int size;  

     public DetectAndRemoveLoopInALinkedList() {
        // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
     }
	
     public static void detectAndRemoveLoopInALinkedList(LinkedListNode node) {
       // If list is empty or has only one node without loop
       if (node == null || node.next == null) {
         return;
       }
	   
       LinkedListNode slow = node; 
       LinkedListNode fast = node;
	   
       // Move slow and fast 1 and 2 steps ahead respectively.
       slow = slow.next;
       fast = fast.next.next;
       
       // Search for loop using slow and fast pointers
       while (fast != null && fast.next != null) {
         if (slow == fast) { 
           break;
	 }
         slow = slow.next;
         fast = fast.next.next;
       }
       
       /* If loop exists */
       if (slow == fast) {
         slow = node;
         while (slow.next != fast.next) {
           slow = slow.next;
           fast = fast.next;
         }
         
         /* since fast.next is the looping point */
         fast.next = null; /* remove loop */
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
       DetectAndRemoveLoopInALinkedList list = new DetectAndRemoveLoopInALinkedList();
       list.head = new LinkedListNode(50);
       list.head.next = new LinkedListNode(20);
       list.head.next.next = new LinkedListNode(15);
       list.head.next.next.next = new LinkedListNode(4);
       list.head.next.next.next.next = new LinkedListNode(10);
       list.head.next.next.next.next.next = list.head.next;
	  		  
       list.detectAndRemoveLoopInALinkedList(head);
	  
       System.out.print("Linked List after removing loop is: ");	 
       list.PrintElementsOfALinkedList(head);
     }
   }
