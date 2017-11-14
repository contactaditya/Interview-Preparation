import java.util.*;
import java.io.*;

 public class AddTwoNumbersInALinkedList2 {
     private static LinkedListNode head; 
     private static LinkedListNode head1; 
     private static LinkedListNode head2;
     private static int size;  	 

     public AddTwoNumbersInALinkedList2() {
	 // this is an empty list, so the reference to the head node is set to a new node with no data				  
	 head = new LinkedListNode(null);
	 size = 0;
     }
		
     public static LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2) {	 
			
	 java.util.Stack<Integer> s1 = new java.util.Stack<Integer>();
	 java.util.Stack<Integer> s2 = new java.util.Stack<Integer>();
	        
	 while(list1 != null) {
	    s1.push((int) list1.data);
	    list1 = list1.next;
	  }
	  while(list2 != null) {
	    s2.push((int) list2.data);
	    list2 = list2.next;
	  }
	        
	  int sum = 0;
	  LinkedListNode list = new LinkedListNode(0);
	  while (!s1.empty() || !s2.empty()) {
	    if (!s1.empty()) { 
	      sum += s1.pop();
	    }
	    if (!s2.empty()) {
	      sum += s2.pop();  
	    } 
	    list.data = sum % 10;
	    LinkedListNode head = new LinkedListNode(sum/10);
	    head.next = list;
	    list = head;
	    sum /= 10;
	  }
	        
	  return (int)list.data == 0 ? list.next : list; 
     } 
		
     public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	 LinkedListNode current = head; 		    
	 while(current != null) {	   
            System.out.print(current.getData() + " ");	 	
	    current = current.getNext();
	 }
      }  

      public static void main(String[] args) {
	 AddTwoNumbersInALinkedList2 list = new AddTwoNumbersInALinkedList2();
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
