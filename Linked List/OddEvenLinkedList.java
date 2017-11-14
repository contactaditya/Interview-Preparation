import java.util.*;
import java.io.*;

 public class OddEvenLinkedList { 	
   private static LinkedListNode head;
   private static int size;  

   public OddEvenLinkedList() {
     // this is an empty list, so the reference to the head node is set to a new node with no data				  
     head = new LinkedListNode(null);
     size = 0;
   }
    
   public static LinkedListNode oddEvenLinkedList(LinkedListNode head) {	 
      LinkedListNode odd = head; 		
      LinkedListNode even = head.next; 	 
      LinkedListNode connectNode = head.next;
	  
      while(even != null && even.next != null) {    
	odd.next = even.next; 
        odd = odd.next; 
        even.next = odd.next; 
        even = even.next; 
      }
	   
      odd.next = connectNode; 
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
      OddEvenLinkedList list = new OddEvenLinkedList(); 
      list.head = new LinkedListNode(1);
      list.head.next = new LinkedListNode(2);
      list.head.next.next = new LinkedListNode(3);
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(5);	  
      list.head.next.next.next.next.next = new LinkedListNode(6);	
      list.head.next.next.next.next.next.next = new LinkedListNode(7);	
	 
      System.out.print("Contents of the linked list before odd even sorting is: ");	 
      list.PrintElementsOfALinkedList(head);
      LinkedListNode oddEvenLinkedList = list.oddEvenLinkedList(head); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after odd even sorting is: ");	 
      list.PrintElementsOfALinkedList(head);
   }
}
