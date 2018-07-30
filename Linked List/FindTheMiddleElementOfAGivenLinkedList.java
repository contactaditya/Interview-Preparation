import java.util.*;
import java.io.*;

  public class FindTheMiddleElementOfAGivenLinkedList {  
    private static LinkedListNode head;
    private static int size;  

    public FindTheMiddleElementOfAGivenLinkedList() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }   
	   
    public LinkedListNode getMiddleElement() {     
      LinkedListNode fast = head;
      LinkedListNode slow = head;
      
      if (head != null) {
        while(fast != null && fast.next != null) {
    	  fast = fast.next.next;   
  	  slow = slow.next;
        }
      }
      return slow;
    }       

    public static void main(String[] args) { 	  
      FindTheMiddleElementOfAGivenLinkedList list = new FindTheMiddleElementOfAGivenLinkedList();
      list.head = new LinkedListNode(1);
      list.head.next = new LinkedListNode(2);
      list.head.next.next = new LinkedListNode(3);
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(5);
	  
      LinkedListNode middleElement = list.getMiddleElement();
      System.out.print("The middle element in the linked list is: " + middleElement.data);	 	
    }
  }
