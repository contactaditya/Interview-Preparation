import java.util.*;
import java.io.*;

 public class RemoveLinkedListElements { 	
    private static LinkedListNode head;
    private static int size;  

    public RemoveLinkedListElements() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
	 
    public LinkedListNode removeElements(LinkedListNode head, int value) {
      while (head != null && (int)head.data == value) {
	 head = head.next;
      }
      LinkedListNode current = head; 		 
      while(current != null && current.getNext() != null) {
	if((int)current.next.data == value) {
	  current.next = current.next.next; 
	}
	else {
	  current = current.next; 	
	}
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
       Scanner input = new Scanner(System.in);	
       RemoveLinkedListElements list = new RemoveLinkedListElements();	
       list.head = new LinkedListNode(1);
       list.head.next = new LinkedListNode(2);
       list.head.next.next = new LinkedListNode(6);
       list.head.next.next.next = new LinkedListNode(3);
       list.head.next.next.next.next = new LinkedListNode(4);
       list.head.next.next.next.next.next = new LinkedListNode(5);
       list.head.next.next.next.next.next.next = new LinkedListNode(6);
	  
       System.out.print("Enter a value which remove all the instances of that place in the linked list: ");
       int value = input.nextInt();  
		     	     
       LinkedListNode current = list.removeElements(head, value);
       System.out.println();		  
       System.out.print("Contents of the linked list after removing all instances of " + value + " from the linked list are: ");
       PrintElementsOfALinkedList(current);	
    }
 }
