import java.util.*;
import java.io.*;
  
  public class DeleteAllTheNodesWhichHaveAGreaterValueOnLeftSide { 	
    private LinkedListNode head;
    private static int size;  
	
    public void deleteAllTheNodesWhichHaveAGreaterValueOnLeftSide(LinkedListNode head) { 	 
      LinkedListNode current = head; 
    
      /* Initialise max */
      LinkedListNode maxNode = head; 
      LinkedListNode temp; 
  
      while (current != null && current.next != null) { 
        // If current is greater than max, then delete the current node
        if ((int)current.next.data >= (int)maxNode.data) { 
          current = current.next; 
          maxNode = current; 
        }  
        // If current is smaller than max, then delete the current node
        else { 
          temp = current.next; 
          current.next = temp.next; 
        }   
      }    
    }
	
    public void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
	System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    }  		

    public static void main(String[] args) { 	
      DeleteAllTheNodesWhichHaveAGreaterValueOnLeftSide list = new DeleteAllTheNodesWhichHaveAGreaterValueOnLeftSide();
      list.head = new LinkedListNode(25);
      list.head.next = new LinkedListNode(15);
      list.head.next.next = new LinkedListNode(6);
      list.head.next.next.next = new LinkedListNode(48);
      list.head.next.next.next.next = new LinkedListNode(12);
      list.head.next.next.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next.next.next = new LinkedListNode(16);
      list.head.next.next.next.next.next.next.next = new LinkedListNode(14);
	  
      System.out.print("Contents of the linked list before deleting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
      list.deleteAllTheNodesWhichHaveAGreaterValueOnLeftSide(list.head); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after deleting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
    }
  }
