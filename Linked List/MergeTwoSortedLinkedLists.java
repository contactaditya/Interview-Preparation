import java.util.*;
import java.io.*;

 public class MergeTwoSortedLinkedLists { 	
    private static LinkedListNode head;
    private static LinkedListNode head1;
    private static LinkedListNode head2;
    private static int size;  	
	
    public MergeTwoSortedLinkedLists() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
    }
	
    public static LinkedListNode MergeLists(LinkedListNode headA, LinkedListNode headB) { 
       LinkedListNode list = headA;
       LinkedListNode list1 = headB;
	       
       if (list == null && list1 == null) {
	 return null; 
       }
	      
       if (list == null) {
	 return list1; 
       }
	    	   
       if (list1 == null) {
	 return list;
       }

       if ((int)list.data < (int)list1.data) {
	  list.next = MergeLists(list.next, list1);
	  return list;
       } else {
	  list1.next = MergeLists(list1.next, list);
	  return list1;
       }
    }

    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
       LinkedListNode current = head; 
       while(current != null) {	   
	  System.out.print(current.getData() + " ");	 	
	  current = current.getNext();
       }
    } 		

    public static void main(String[] args) { 
       MergeTwoSortedLinkedLists list = new MergeTwoSortedLinkedLists();
       list.head1 = new LinkedListNode(5);
       list.head1.next = new LinkedListNode(10);
       list.head1.next.next = new LinkedListNode(15);
	  
       list.head2 = new LinkedListNode(2);
       list.head2.next = new LinkedListNode(3);
       list.head2.next.next = new LinkedListNode(20);
	  
       System.out.print("Contents of the first linked list are: ");	 
       list.PrintElementsOfALinkedList(head1);
       System.out.println();	
	  
       System.out.println();	
       System.out.print("Contents of the second linked list are: ");	 
       list.PrintElementsOfALinkedList(head2);
       System.out.println();	
	  	  
       LinkedListNode current = MergeLists(list.head1, list.head2);
	  
       System.out.println();	
       System.out.print("Merge linked list is: ");	 
       list.PrintElementsOfALinkedList(current);
    }
 }
