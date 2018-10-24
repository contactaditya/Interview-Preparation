import java.util.*;
import java.io.*;

  public class SortTheLinkedListWhichIsAlreadySortedOnAbsoluteValues { 	
	private LinkedListNode head;
	
	private static LinkedListNode sortlist(LinkedListNode head) {
	  LinkedListNode previous = head; 
	  LinkedListNode current = head.next; 
	  while(current != null) {	   
	    if((int)current.data < (int)previous.data) { 
          // Detach current from the linked list 
          previous.next = current.next; 
          // Move current node to beginning 
          current.next = head; 
          head = current;  
          // Update current 
          current = previous; 
        } else {
          previous = current;
        }
	    current = current.next;
	  }
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
      SortTheLinkedListWhichIsAlreadySortedOnAbsoluteValues list = new SortTheLinkedListWhichIsAlreadySortedOnAbsoluteValues();	
	  list.head = new LinkedListNode(0);
	  list.head.next = new LinkedListNode(1);
	  list.head.next.next = new LinkedListNode(-2);
	  list.head.next.next.next = new LinkedListNode(3);
	  list.head.next.next.next.next = new LinkedListNode(4);
	  list.head.next.next.next.next.next = new LinkedListNode(5);
	  list.head.next.next.next.next.next.next = new LinkedListNode(-5);
	  
	  System.out.print("Contents of the linked list before sorting are: ");	 
	  PrintElementsOfALinkedList(list.head);
	  System.out.println();	
	  
	  list.head = sortlist(list.head);  
	  
	  System.out.println();	
	  System.out.print("Contents of the linked list after sorting are: ");	 
	  PrintElementsOfALinkedList(list.head);
	}
  }
