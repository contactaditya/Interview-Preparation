import java.util.*;
import java.io.*;

  public class RemoveNthNodeFromEndofLinkedList { 	
    private static LinkedListNode head;
    private static int size;  

    public RemoveNthNodeFromEndofLinkedList() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
 
    public static LinkedListNode removeNthFromEnd(LinkedListNode head, int n) { 
      LinkedListNode p1 = head;
      LinkedListNode p2 = head;  	
    
      if(head == null || head.next == null) {
        return null;  
      }
    
      int size = 1;
      LinkedListNode current = head;
      while(current.next != null){
        current = current.next;
        size++;     
      }
    
      if(n > size) {
        head = head.next;   
        return head;  
      }
	 
      for(int i = 0; i < n; i++) {
	p2 = p2.next;
      }
		  
      // Now, move p1 and p2 at the same speed. When p2 hits the end, p1 will be at the right element.
      while(p2 != null && p2.next != null) {
	p1 = p1.next;
	p2 = p2.next;	  
      }
      
      if (p2 == null) {
        head = head.next;
      } else {
        p1.next = p1.next.next;
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
      RemoveNthNodeFromEndofLinkedList list = new RemoveNthNodeFromEndofLinkedList();
      list.head = new LinkedListNode(3);
      list.head.next = new LinkedListNode(5);
      list.head.next.next = new LinkedListNode(8);
      list.head.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next = new LinkedListNode(10);
      list.head.next.next.next.next.next = new LinkedListNode(2);
      list.head.next.next.next.next.next.next = new LinkedListNode(1);
	   
      size = 7;
	   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the index of the nth to last element in the linkedlist that you want to remove: ");
      int index = input.nextInt(); 
      System.out.println();
	 
      System.out.print("Contents of the linked list before removing the node is: ");	 
      list.PrintElementsOfALinkedList(head);
      LinkedListNode newLinkedList = removeNthFromEnd(head, index); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after removing the node is: ");	 
      list.PrintElementsOfALinkedList(head);
    }
  }
