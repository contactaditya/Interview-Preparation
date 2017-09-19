import java.util.*;
import java.io.*;

 public class ReverseALinkedListII {  
    private static LinkedListNode head;
    private static int size;  

    public ReverseALinkedListII() {
       // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
    } 
    
    public static LinkedListNode reverseBetween(LinkedListNode head, int m, int n) { 
       if (head == null || head.next == null) {
	  return head;	 
       }
       LinkedListNode dummy = new LinkedListNode(0); // create a dummy node to mark the head of this list
       dummy.next = head;
       LinkedListNode previous = dummy; // Make a pointer previous as a marker for the node before reversing
       for(int i = 0; i<m-1; i++) {
	  previous = previous.next; 
       }
	   
       LinkedListNode start = previous.next; // a pointer to the beginning of a sub-list that will be reversed
       LinkedListNode end = start.next; // a pointer to a node that will be reversed 
	   
       for(int i = 0; i<n-m; i++) {
	  start.next = end.next;
	  end.next = previous.next;
	  previous.next = end;
	  end = start.next;
       }
		    
       return dummy.next;
    }       

    public static LinkedListNode reverseBetween1(LinkedListNode head, int m, int n) { 
       if (head == null || head.next == null) {
	  return head;	 
       }
       LinkedListNode dummy = new LinkedListNode(0);
       dummy.next = head;
       LinkedListNode previous = dummy, current = head;
       int k = 1;
       while(current.next != null && k != m) {
          current = current.next;
          previous = previous.next;
          k++;
       }
       
       while(current.next != null && k != n) {
   	 LinkedListNode preNext = previous.next;
         previous.next = current.next;
         LinkedListNode next = current.next;
         current.next = next.next;
         next.next = preNext;
         k++;
       }
	    
       return dummy.next;
    }   
	 	 
    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
       LinkedListNode current = head; 		    
       while(current != null) {	   
	  System.out.print(current.getData() + " ");	 	
          current = current.getNext();
       }
    } 	 

    public static void main(String[] args) {
      ReverseALinkedListII list = new ReverseALinkedListII();
      list.head = new LinkedListNode(1);
      list.head.next = new LinkedListNode(2);
      list.head.next.next = new LinkedListNode(3);
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(5);
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the starting point from where you want to reverse in the linkedlist: ");
      int m = input.nextInt();   
      System.out.println();
      System.out.print("Enter the end point till where you want to reverse in the linkedlist: ");
      int n = input.nextInt();  
	  
      head = list.reverseBetween(head, m , n); 
      System.out.println();
      System.out.print("Contents of the linked list after sorting are: ");	 
      list.PrintElementsOfALinkedList(head);		
	}
 }
