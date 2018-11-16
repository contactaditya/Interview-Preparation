import java.util.*;
import java.io.*;

  public class DeleteAllTheNodesFromTheListThatAreGreaterThanX { 
	private LinkedListNode head;
	private static int size;  
	
	public LinkedListNode deleteGreaterNodes(LinkedListNode head, int value) {     
	  while (head != null && (int)head.data > value) {
	    head = head.next;
	  }
	  LinkedListNode current = head; 		 
	  while(current != null && current.getNext() != null) {
	    if((int)current.next.data > value) {
	      current.next = current.next.next; 
	    }
	    else {
	      current = current.next; 	
	    }
	  }
	  return head;
	}
	
	public void PrintElementsOfALinkedList(LinkedListNode head) {	 
	  LinkedListNode current = head; 		    
	  while(current != null) {	   
		System.out.print(current.getData() + " ");	 	
		current = current.getNext();
	  }
	}  			

	public static void main(String[] args) { 	 
	  DeleteAllTheNodesFromTheListThatAreGreaterThanX list = new DeleteAllTheNodesFromTheListThatAreGreaterThanX();
	  list.head = new LinkedListNode(7);
	  list.head.next = new LinkedListNode(3);
	  list.head.next.next = new LinkedListNode(4);
	  list.head.next.next.next = new LinkedListNode(8);
	  list.head.next.next.next.next = new LinkedListNode(5);
	  list.head.next.next.next.next.next = new LinkedListNode(1);
	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the value: ");
	  int value = input.nextInt();   
	  System.out.println();
	  System.out.print("Contents of the linked list before deleting are: ");	 
	  list.PrintElementsOfALinkedList(list.head);
	  LinkedListNode current = list.deleteGreaterNodes(list.head, value); 
	  System.out.println();
	  System.out.println();
	  System.out.print("Contents of the linked list after deleting are: ");	 
	  list.PrintElementsOfALinkedList(current);
	  input.close();
	}
  }
