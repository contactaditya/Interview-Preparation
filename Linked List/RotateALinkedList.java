import java.util.*;
import java.io.*;

 public class RotateALinkedList { 
     private static LinkedListNode head;
     private static int size;  

     public RotateALinkedList() {
	// this is an empty list, so the reference to the head node is set to a new node with no data				  
	head = new LinkedListNode(null);
	size = 0;
     }
	
     public static LinkedListNode rotateALinkedList(int k) {
        if (head == null || head.next == null || k == 0) {
          return head;
        }
	// Step 1: Count the length of the list	
	int length = getLengthOfList(head);
	if (k % length == 0) {
          return head;
        }
	   
	// Step 2: find the nth element from the end
	int n = k % length + 1;
	LinkedListNode slow = head;
	LinkedListNode fast = head;
	int count = 1;
	   
	while (count < n) {
          fast = fast.next;
          count++;
        }
	   
	while (fast.next != null) {
           slow = slow.next;
	   fast = fast.next;
        }
	   
	// Step 3: rotate to the head
	LinkedListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
	   
       return newHead;	
    }	
	
    public static int getLengthOfList(LinkedListNode head) {
        int length = 0;
	LinkedListNode current = head;
	while (current != null) {
	   length++;
	   current = current.getNext();
	}
		    
	return length;	
    }	
	
    public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
        LinkedListNode current = head; 
	while(current != null) {	   
	   System.out.print(current.getData() + " ");	 	
	   current = current.getNext();
        }
    } 		

    public static void main(String[] args) {   
        RotateALinkedList list = new RotateALinkedList();
	list.head = new LinkedListNode(10);
	list.head.next = new LinkedListNode(20);
	list.head.next.next = new LinkedListNode(30);
	list.head.next.next.next = new LinkedListNode(40);
	list.head.next.next.next.next = new LinkedListNode(50);
	list.head.next.next.next.next.next = new LinkedListNode(60);
	  
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the number k which will rotate the linked list to the right by k places: ");
	int k = input.nextInt();  
	  
	System.out.println();	
	System.out.print("Contents of the linked list before rotation are: ");	 
	list.PrintElementsOfALinkedList(head);
	System.out.println();	
	  
	LinkedListNode newHead = rotateALinkedList(k);
	  
	System.out.println();	
	System.out.print("Contents of the linked list after rotation are: ");	 
	list.PrintElementsOfALinkedList(newHead);
    }
 }
