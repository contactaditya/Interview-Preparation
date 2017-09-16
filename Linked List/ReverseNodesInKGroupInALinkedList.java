import java.util.*;
import java.io.*;

  public class ReverseNodesInKGroupInALinkedList {     
	private static LinkedListNode head;
	private static int size;  	
	
	public static LinkedListNode reverseKGroup(LinkedListNode head, int k) {
	   if (head == null || head.next == null || k == 1) {
		  return head; 
	   }
			 
	   LinkedListNode current = head;
	   LinkedListNode previous = null;
	   LinkedListNode next = null;
	   int count = 0;
	   
	   int size = calculateSize();
	   
	   if(k > size) {
		 return head;
	   }
	           	   
	   /* Reverse first k nodes of linked list */
	   while(current!=null && count < k) {
		 next = current.next;
		 current.next = previous;
		 previous = current;
		 current = next;
		 count++;
	   }  
	   
       /* next is now a pointer to (k+1)th node and recursively call for the list starting from current and make rest of the list as next of first node */
	   
	   if (next != null) {
	     head.next = reverseKGroup(next, k);
	   }
		   
	   return previous;
	}
	
	private static int calculateSize() {
	   LinkedListNode temp = head;
       int count = 0;
       while (temp != null) {
         count++;
         temp = temp.next;
       }
       return count;
	}

	public static LinkedListNode reverseKGroup1(LinkedListNode head, int k) {
	   if (head == null || head.next == null || k == 1) {
	      return head; 
	   }
		 
	   LinkedListNode current = head;
	   LinkedListNode previous = null;
	   int count = 0;
	   
	   /*1) Reverse first k nodes of the linked list  */  
	   while(current!=null && count < k) {
          current = current.next;
	      count++;
	   }
	   
	   if(count == k) {
		 current = reverseKGroup(current, k); // reverse list with k+1 node as head
		  
		 while (count-- > 0) { // reverse current k-group: 
		   LinkedListNode temp = head.next; // temp - next head in direct part
		   head.next = current; // preappending "direct" head to the reversed list 
		   current = head; // move head of reversed part to a new node
		   head = temp; // move "direct" head to the next node in direct part
	     }
		 
		 head = current;   
	   }
	   
	   return head;
	}
	
	public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
	   LinkedListNode current = head; 
	   System.out.print("Contents of the linked list are: ");	 
	   while(current != null) {	   
		 System.out.print(current.getData() + " ");	 	
		 current = current.getNext();
	   }
	} 

	public static void main(String[] args) {
	  ReverseNodesInKGroupInALinkedList list = new ReverseNodesInKGroupInALinkedList();
	  list.head = new LinkedListNode(1);
	  list.head.next = new LinkedListNode(2);
	  list.head.next.next = new LinkedListNode(3);
	  list.head.next.next.next = new LinkedListNode(4);
	  list.head.next.next.next.next = new LinkedListNode(5);
		  
	  list.PrintElementsOfALinkedList(head);
		  
	  System.out.println();
	  System.out.println();
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the kth node to reverse one at a time in the linkedlist: ");
	  int k = input.nextInt();   
		  	  
	  head = list.reverseKGroup(head, k);
		  
	  System.out.println();	
	  list.PrintElementsOfALinkedList(head);
	}
  }
