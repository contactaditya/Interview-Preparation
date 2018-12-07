import java.util.*;
import java.io.*;

  public class SortALinkedListThatIsSortedInAlternatingAscendingAndDescendingOrder { 	
    private LinkedListNode head;
    private static int size;  

    public SortALinkedListThatIsSortedInAlternatingAscendingAndDescendingOrder() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
	
    public void sortLinkedList() {	 
      LinkedListNode Ahead = new LinkedListNode(0); 
      LinkedListNode Dhead = new LinkedListNode(0); 
	  
      // Split the list into lists 
      splitList(Ahead, Dhead); 
      
      Ahead = Ahead.next; 
      Dhead = Dhead.next; 

      // reverse the descending list 
      Dhead = reverseLL(Dhead); 

      // merge the 2 linked lists 
      head = MergeLists(Ahead, Dhead); 
    } 
	
    private LinkedListNode reverseLL(LinkedListNode head) {
     /**
      * Reverses a linked list.
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

      return head;
    }
    
    public LinkedListNode MergeLists(LinkedListNode headA, LinkedListNode headB) { 
      LinkedListNode list1 = headA;
      LinkedListNode list2 = headB;
  	       
      if (list1 == null && list2 == null) {
  	return null; 
      } 
      if (list1 == null) {
  	return list2; 
      }   
      if (list2 == null) {
  	return list1;
      }

      if ((int)list1.data < (int)list2.data) {
  	list1.next = MergeLists(list1.next, list2);
  	return list1;
      } else {
  	list2.next = MergeLists(list1, list2.next);
  	return list2;
      }
    }
    
    public void splitList(LinkedListNode Ahead, LinkedListNode Dhead) { 
      LinkedListNode ascending = Ahead; 
      LinkedListNode descending = Dhead; 
      LinkedListNode current = head; 
  
      // Link alternate nodes 
      while (current != null) { 
        // Link alternate nodes in ascending order 
    	ascending.next = current; 
    	ascending = ascending.next; 
        current = current.next; 
  
        if (current != null) { 
          descending.next = current; 
          descending = descending .next; 
          current = current.next; 
        } 
      } 
  
      ascending.next = null; 
      descending.next = null; 
    }     

    public void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
	System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    } 

    public static void main(String[] args) { 	  
      SortALinkedListThatIsSortedInAlternatingAscendingAndDescendingOrder list = new SortALinkedListThatIsSortedInAlternatingAscendingAndDescendingOrder();
      list.head = new LinkedListNode(10);
      list.head.next = new LinkedListNode(40);
      list.head.next.next = new LinkedListNode(53);
      list.head.next.next.next = new LinkedListNode(30);
      list.head.next.next.next.next = new LinkedListNode(67);	  
      list.head.next.next.next.next.next = new LinkedListNode(12);
      list.head.next.next.next.next.next.next = new LinkedListNode(89);

      System.out.print("Contents of the linked list before sorting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
      list.sortLinkedList(); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after sorting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
    }
  }
