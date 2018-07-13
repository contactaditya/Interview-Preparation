import java.util.*;
import java.io.*;

  public class AddTwoNumbersRepresentedByALinkedList { 
     private static LinkedListNode head;
     private static LinkedListNode head1;
     private static LinkedListNode head2;
     private static int size;  	 

     public AddTwoNumbersRepresentedByALinkedList() {
       // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
     }
	
     public static LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2, int carry) {	 	   
      if (list1 == null || list2 == null && carry == 0) {
	return null;
      }	
		  
      LinkedListNode result = new LinkedListNode(0);
	   
      /* Add value and the data from list1 and list2 */
      int value = carry;
      if(list1 != null) {
        value += (int)list1.data;   
      }
      if(list2 != null) {
	value += (int)list2.data;    
      }
	   
      result.data = value % 10; /* Second digit of a number */
	   
      /* Recurse */
      if(list1 != null || list2 != null) {
        LinkedListNode more = addLists(list1 == null ? null : list1.next, list2 == null ? null : list2.next, value >= 10 ? 1 : 0); 
        result.setNext(more);  
      }
	  
      return result;
    }
	
    public static int linkedListToInt(LinkedListNode node) {
      int value = 0;
      if (node.next != null) {
	value = 10 * linkedListToInt(node.next);
      }
      return value + (int)node.data;
    }	
	 
    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
        System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    }  		 

    public static void main(String[] args) {   
      AddTwoNumbersRepresentedByALinkedList list = new AddTwoNumbersRepresentedByALinkedList();
      list.head1 = new LinkedListNode(7);
      list.head1.next = new LinkedListNode(1);
      list.head1.next.next = new LinkedListNode(6);
	  
      list.head2 = new LinkedListNode(5);
      list.head2.next = new LinkedListNode(9);
      list.head2.next.next = new LinkedListNode(2);
	   	  
      LinkedListNode current = addLists(head1, head2, 0);
      int list1 = linkedListToInt(head1);
      int list2 = linkedListToInt(head2); 
      int list3 = linkedListToInt(current);
  
      System.out.print("Contents of the linked list which contains the sum of the two linked lists are: ");
      System.out.print(list1 + " + " + list2 + " = " + list3);	
    }
  }
