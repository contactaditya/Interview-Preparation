import java.util.*;
import java.io.*;

  public class RemoveEveryKthNodeOfTheLinkedList { 	
    private LinkedListNode head;
    private static int size;  
		  
    public static LinkedListNode removeKthNode(LinkedListNode head, int k) { 
      if(head == null || k == 1) {
	return null;  
      }
	  
      LinkedListNode current = head;
      LinkedListNode previous = null;  	
      int count = 0;
      while(current.next != null) {
	 count++;    
	// Check if count is equal to k then delete the current node
	if (k == count) { 
          // Put the next of current node in the next of previous node  
          previous.next = current.next; 
          // Set count = 0 so that the remaining kth nodes can be reached 
          count = 0; 
        } 
	// Update previous if count is not 0 
	if (count != 0) {
          previous = current; 
	}
        current = previous.next; 
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
      RemoveEveryKthNodeOfTheLinkedList list = new RemoveEveryKthNodeOfTheLinkedList();
      list.head = new LinkedListNode(1);
      list.head.next = new LinkedListNode(2);
      list.head.next.next = new LinkedListNode(3);
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next.next = new LinkedListNode(6);
      list.head.next.next.next.next.next.next = new LinkedListNode(7);
      list.head.next.next.next.next.next.next.next = new LinkedListNode(8);
	   
      size = 8;
	   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the index of every kth node in the linked list that you want to remove: ");
      int index = input.nextInt(); 
      System.out.println();
	 
      System.out.print("Contents of the linked list before removing every kth node are: ");	 
      list.PrintElementsOfALinkedList(list.head);
      LinkedListNode current = removeKthNode(list.head, index); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after removing every kth node are: ");	 
      list.PrintElementsOfALinkedList(current);
      input.close();
    }
  }
