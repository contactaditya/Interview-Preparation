import java.util.*;
import java.io.*;

  public class DeleteNodesWhichHaveAGreaterValueOnRightSide { 	
    private LinkedListNode head;
    private static int size;  
	
    public void deleteGreaterValueOnRightSide() {     
      reverseList(); 
      _deleteGreaterValueOnRightSide();
      reverseList(); 
    }
	
    private void _deleteGreaterValueOnRightSide() {
      LinkedListNode current = head; 
        
      /* Initialise max */
      LinkedListNode maxNode = head; 
      LinkedListNode temp; 
	  
      while (current != null && current.next != null) { 
	// If current is smaller than max, then delete the current node
	if ((int)current.next.data < (int)maxNode.data) { 
          temp = current.next; 
          current.next = temp.next; 
          temp = null; 
        } 
	// If current is greater than max, then update max and move current 
	else { 
          current = current.next; 
          maxNode = current; 
        }   
      }
    }

    public void reverseList() {
     /**
      * Sorts the elements of the linked list in an ascending order.
      */
      LinkedListNode current = head;	  
      LinkedListNode previous = null;
	    
      while(current!=null) {
        LinkedListNode next = current.next;
	current.next = previous;
	previous = current;
	current = next;
      }	
      head = previous;
    }	
		
    public void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
	System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    }  			

    public static void main(String[] args) {   
      DeleteNodesWhichHaveAGreaterValueOnRightSide list = new DeleteNodesWhichHaveAGreaterValueOnRightSide();
      list.head = new LinkedListNode(12);
      list.head.next = new LinkedListNode(15);
      list.head.next.next = new LinkedListNode(10);
      list.head.next.next.next = new LinkedListNode(11);
      list.head.next.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next.next = new LinkedListNode(6);
      list.head.next.next.next.next.next.next = new LinkedListNode(2);
      list.head.next.next.next.next.next.next.next = new LinkedListNode(3);
	  
      System.out.print("Contents of the linked list before deleting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
      list.deleteGreaterValueOnRightSide(); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after deleting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
    }
  }
