import java.util.*;
import java.io.*;

 public class RemoveNthNodeFromEndofList { 
   private static LinkedListNode head;
   private static int size;  

  public RemoveNthNodeFromEndofList() {
  // this is an empty list, so the reference to the head node is set to a new node with no data				  
    head = new LinkedListNode(null);
    size = 0;
  }

  public static LinkedListNode removeNthNodeFromEndofList(LinkedListNode head, int n) {	 
	 LinkedListNode p1 = head;
	 LinkedListNode p2 = head;
	 
	 System.out.println();
	 System.out.println();		  	  
	 
	 if(n <= 0) {  
	   System.out.println("Index entered by the user is either negative or null.");
	   System.out.println();
	   return null;
	 }
			  
	 if(n > size) {  
	   System.out.println("Index entered by the user is greater than size.");
	   System.out.println();
	   return null;
	 }
			  
	 if(size==0) {	   
	   System.out.println("The linked list is currently empty and has no elements.");	 
	   System.out.println();
	 }
		  
	 // Move p2 forward k nodes into the list.
			  
	 else {		
	  for(int i = 0; i < n; i++) {
		if(p2 == null) {
		  System.out.println("The linked list has ended before reaching the index.");	
		  return null;
	    }
	    p2 = p2.getNext();
	  }
		  
	// Now, move p1 and p2 at the same speed. When p2 hits the end, p1 will be at the right element.
	   while(p2.next != null) {
		  p1 = p1.getNext();
		  p2 = p2.getNext();	  
	   }	  
	 }
    p1.next = p1.next.next;
    return p1;
  }  

  public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
   LinkedListNode current = head; 		    
   while(current != null) {	   
     System.out.print(current.getData() + " ");	 	
     current = current.getNext();
   }
 } 

 public static void main(String[] args) {
   RemoveNthNodeFromEndofList list = new RemoveNthNodeFromEndofList();
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
   LinkedListNode oddEvenLinkedList = list.removeNthNodeFromEndofList(head, index); 
   System.out.print("Contents of the linked list after removing the node is: ");	 
   list.PrintElementsOfALinkedList(head);
 }
}
