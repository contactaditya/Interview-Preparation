import java.util.*;
import java.io.*;

 public class PartitionListInALinkedList {
   private static LinkedListNode head;
   private static int size;  

   public PartitionListInALinkedList() {
     // this is an empty list, so the reference to the head node is set to a new node with no data				  
     head = new LinkedListNode(null);
     size = 0;
   }
		 
   public static LinkedListNode partition(LinkedListNode head, int x) {
     if (head == null || head.next == null) {
       return head; 
     }
     LinkedListNode dummy1 = new LinkedListNode(0);
     LinkedListNode dummy2 = new LinkedListNode(0);
        
     LinkedListNode current1 = dummy1, current2 = dummy2;  //current tails of the two queues;
				     
     while(head != null) {    
       if((int)head.data < x) {
	 // Insert node at head
	 current1.next = head;
	 current1 = head;
       } else {
	 // Insert node at tail
	 current2.next = head;
	 current2 = head;   	 
       }
       head = head.next;
     }
		   
     current2.next = null;
     current1.next = dummy2.next;  
     return dummy1.next;
   }
	  
   public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
     LinkedListNode current = head; 		    
     while(current != null) {	   
       System.out.print(current.getData() + " ");	 	
       current = current.getNext();
     }
   }  			 

   public static void main(String[] args) {
     PartitionListInALinkedList list = new PartitionListInALinkedList();
     list.head = new LinkedListNode(1);
     list.head.next = new LinkedListNode(4);
     list.head.next.next = new LinkedListNode(3);
     list.head.next.next.next = new LinkedListNode(2);
     list.head.next.next.next.next = new LinkedListNode(5);
     list.head.next.next.next.next.next = new LinkedListNode(2);
		  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the value of the partition in the linked list: ");
     int value = input.nextInt();  
		     	     
     LinkedListNode current = list.partition(head, value);
		  
     System.out.println();	
     System.out.print("Contents of the linked list after partition is: ");
     PrintElementsOfALinkedList(current);
   }
 }
