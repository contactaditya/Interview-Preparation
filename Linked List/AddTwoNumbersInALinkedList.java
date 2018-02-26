import java.util.*;
import java.io.*;

  public class AddTwoNumbersInALinkedList { 	
     private static LinkedListNode head;
     private static LinkedListNode head1;
     private static LinkedListNode head2;
     private static int size;  	 

     public AddTwoNumbersInALinkedList() {
	// this is an empty list, so the reference to the head node is set to a new node with no data				  
	head = new LinkedListNode(null);
	size = 0;
     }
	
     public static LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2) {	 	
	int carry = 0;   
	LinkedListNode head = new LinkedListNode(0);  
	LinkedListNode p = new LinkedListNode(0);    
	p = head;  
	        
        if (list1 == null || list2 == null) {
	   return null;
	}	
			
	while(list1 != null || list2 != null || carry != 0) {
		   
	  /* Add value and the data from list1 and list2 */      
          if(list1 != null) {
	     carry += (int)list1.data;
	     list1 = list1.next;
	  }
	  if(list2 != null) {
	     carry += (int)list2.data;
	     list2 = list2.next;    
	  }
	  p.next = new LinkedListNode(carry%10);
	  carry /= 10;
	  p = p.next;  
	}
		  
	return head.next;
     } 
	
     public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
        LinkedListNode current = head; 		    
	while(current != null) {	   
	  System.out.print(current.getData() + " ");	 	
          current = current.getNext();
	}
     } 
	
     public static void main(String[] args) {   
        AddTwoNumbersInALinkedList list = new AddTwoNumbersInALinkedList();
	list.head1 = new LinkedListNode(7);
	list.head1.next = new LinkedListNode(1);
	list.head1.next.next = new LinkedListNode(6);
	  
	list.head2 = new LinkedListNode(5);
	list.head2.next = new LinkedListNode(9);
	list.head2.next.next = new LinkedListNode(2);
	   	  
	LinkedListNode current = addLists(head1, head2);
	  
	System.out.print("Contents of the linked list which contains the sum of the two linked lists are: ");
	PrintElementsOfALinkedList(current);	
     }
  }
