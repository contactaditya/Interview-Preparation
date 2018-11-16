import java.util.*;
import java.io.*;

  public class DeleteAllPrimeNodesFromASinglyLinkedList { 
	private LinkedListNode head;
	
	private void deletePrimeNodes(LinkedListNode head) {  
      LinkedListNode current = head; 		 
	  LinkedListNode next; 
	  
	  while (current != null) { 
        next = current.next;
        if (isPrime((int)current.data)) { 
          deleteNode(head, current);
        }
        current = next; 
      } 
	}	
	
	private void deleteNode(LinkedListNode head, LinkedListNode current) {
	  LinkedListNode temp = head; 		 
	  if(head == null || current == null) {  
	    return;
	  }
	  // If node to be deleted is head node 
	  if(head == current) {  
	    head = current.next;
	  }
	  // Traverse the Linked List till the node to be deleted is not found
	  while (temp.next != current) { 
	    temp = temp.next; 
	  } 
	  temp.next = current.next;
	}

	public static boolean isPrime(int number) { 	
	  if(number < 2) {
		return false;  
	  }
	  for(int i = 2; i <= Math.sqrt(number); i++) {
		if(number % i == 0) {
		  return false;
	    }
	  }
	  return true;
	}
	
	public void PrintElementsOfALinkedList(LinkedListNode head) {	 
	  LinkedListNode current = head; 		    
	  while(current != null) {	   
		System.out.print(current.getData() + " ");	 	
		current = current.getNext();
	  }
	}  			

	public static void main(String[] args) { 	  
	  DeleteAllPrimeNodesFromASinglyLinkedList list = new DeleteAllPrimeNodesFromASinglyLinkedList();
	  list.head = new LinkedListNode(15);
	  list.head.next = new LinkedListNode(16);
	  list.head.next.next = new LinkedListNode(6);
	  list.head.next.next.next = new LinkedListNode(7);
	  list.head.next.next.next.next = new LinkedListNode(17);
	  
	  System.out.print("Contents of the linked list before deleting are: ");	 
	  list.PrintElementsOfALinkedList(list.head);
	  list.deletePrimeNodes(list.head); 
	  System.out.println();
	  System.out.println();
	  System.out.print("Contents of the linked list after deleting are: ");	 
	  list.PrintElementsOfALinkedList(list.head);	
	}
  }  
