import java.util.*;
import java.io.*;

  public class InsertionSortInALinkedList { 
    private static LinkedListNode head; 
    private static int size;  

    public InsertionSortInALinkedList() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    } 
	 
    public static LinkedListNode insertionSortList(LinkedListNode head) {
      if (head == null || head.next == null) {
	return head;	 
      }
		
      LinkedListNode sortedHeadDummy = new LinkedListNode(0);
      LinkedListNode current = head;
      while (current != null) {
        LinkedListNode next = current.next;
        insert(sortedHeadDummy, current);
        current = next;
      }
        
      return sortedHeadDummy.next;	     
    }	 
	 	 
    private static void insert(LinkedListNode sortedHeadDummy, LinkedListNode target) {
      // left to right scan to insert the target node
      LinkedListNode current = sortedHeadDummy;
      while (current.next != null && (int)current.next.data < (int)target.data) {
        current = current.next;
      }
      target.next = current.next;
      current.next = target;
    }

    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
        System.out.print(current.getData() + " ");	 	
        current = current.getNext();
      }
    } 	 	  

    public static void main(String[] args) {  
      InsertionSortInALinkedList list = new InsertionSortInALinkedList();
      list.head = new LinkedListNode(2);
      list.head.next = new LinkedListNode(3);
      list.head.next.next = new LinkedListNode(4);
      list.head.next.next.next = new LinkedListNode(3);
      list.head.next.next.next.next = new LinkedListNode(4);	  
      list.head.next.next.next.next.next = new LinkedListNode(5);

      System.out.print("Contents of the linked list before sorting are: ");	 
      list.PrintElementsOfALinkedList(head);
      list.insertionSortList(head); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after sorting are: ");	 
      list.PrintElementsOfALinkedList(head);		
    }
  }
