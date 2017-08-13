import java.util.*;
import java.io.*;

 public class DetectACycleInALinkedList {  
	private static LinkedListNode head;
    private static int size;
	  
    public DetectACycleInALinkedList() {
      // this is an empty list, so the reference to the head node is set to a new node with no data
		  
      head = new LinkedListNode(null);
      size = 0;
    }
    
    public LinkedListNode detectACycleInALinkedList(LinkedListNode head) {	 
	    
       LinkedListNode fast = head;
       LinkedListNode slow = head;
       
       if(head == null) {
    	  return null; 
       }
    			    
       while(fast != null && fast.next != null && slow != null) {
    	 slow = slow.next;
    	 fast = fast.next.next; 
    			     
    	 if(slow == fast) {
    	   break; 
    	 }
       }
       
       // check if the list has no cycle
       if (fast == null || fast.next == null) {
          return null;
       }
       
       // find the entrance of the cycle
       slow = head;
       while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
       }
       
	   return slow;  
    }
    
    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
 	   LinkedListNode current = head; 
 	   while(current != null) {	   
 		  System.out.print(current.getData() + " ");	 	
 		  current = current.getNext();
 	   }
  	} 		

	public static void main(String[] args) {    
	   DetectACycleInALinkedList list = new DetectACycleInALinkedList();
	   list.head = new LinkedListNode(50);
	   list.head.next = new LinkedListNode(20);
	   list.head.next.next = new LinkedListNode(15);
	   list.head.next.next.next = new LinkedListNode(4);
	   list.head.next.next.next.next = new LinkedListNode(10);
	      
	   head.next.next.next.next.next = head.next.next;
	      
	   LinkedListNode current = list.detectACycleInALinkedList(head);
	   
	   System.out.print("The value of the node where the cycle begins is: " + current.data);	 
	   	 
	}
 }
