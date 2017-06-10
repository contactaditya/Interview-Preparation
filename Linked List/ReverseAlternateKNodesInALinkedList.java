import java.util.*;
import java.io.*;

 public class ReverseAlternateKNodesInALinkedList {
    private static LinkedListNode head;
	private static int size;  	
	
	public static LinkedListNode ReverseAlternateKNodesInALinkedList(LinkedListNode node, int k) {
	   LinkedListNode current = node;
	   LinkedListNode previous = null;
	   int count = 0;
	   
	   /*1) Reverse first k nodes of the linked list  */  
	   while(current!=null && count < k) {
	      LinkedListNode next = current.next;
	      current.next = previous;
	      previous = current;
	      current = next;
	      count++;
	   }
	   
	   /*2) Now head points to the kth node. So change next of head to (k+1)th node  */
	   if(node != null) {
		  node.next = current;
	   }
	   
	   /* 3) We do not want to reverse next k nodes. So move the current pointer to skip next k nodes */
       count = 0;
       while (count < k - 1 && current != null) {
          current = current.next;
          count++;
       }
       
       /* 4) Recursively call for the list starting from current->next and make rest of the list as next of first node */
       if (current != null) {
          current.next = ReverseAlternateKNodesInALinkedList(current.next, k);
       }

	  return previous;
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
	  ReverseAlternateKNodesInALinkedList list = new ReverseAlternateKNodesInALinkedList();
	  list.head = new LinkedListNode(1);
	  list.head.next = new LinkedListNode(2);
	  list.head.next.next = new LinkedListNode(3);
	  list.head.next.next.next = new LinkedListNode(4);
	  list.head.next.next.next.next = new LinkedListNode(5);
	  list.head.next.next.next.next.next = new LinkedListNode(6);
	  list.head.next.next.next.next.next.next = new LinkedListNode(7);
	  list.head.next.next.next.next.next.next.next = new LinkedListNode(8);
	  list.head.next.next.next.next.next.next.next.next = new LinkedListNode(9);
	  list.head.next.next.next.next.next.next.next.next.next = new LinkedListNode(10);
	  
	  list.PrintElementsOfALinkedList(head);
	  
	  System.out.println();
	  System.out.println();
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the alternate kth node to reverse in the linkedlist: ");
	  int k = input.nextInt();   
	  	  
	  head = list.ReverseAlternateKNodesInALinkedList(head, k);
	  
	  System.out.println();	
	  list.PrintElementsOfALinkedList(head);
	  
	}
 }
