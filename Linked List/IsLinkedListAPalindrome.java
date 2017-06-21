import java.util.*;
import java.io.*;

 public class IsLinkedListAPalindrome { 
	private static LinkedListNode head;
	private static int size;  

	public IsLinkedListAPalindrome() {
	 // this is an empty list, so the reference to the head node is set to a new node with no data				  
	  head = new LinkedListNode(null);
      size = 0;
    }
	
	public static boolean isPalindrome(LinkedListNode node) {
	   LinkedListNode fast = head; 
	   LinkedListNode slow = head;   
	   
	   java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
	   
	   while(fast != null && fast.next != null) {
		  stack.push((Integer) slow.data);
		  slow = slow.next;
		  fast = fast.next.next;		   
	   }
	   
	   // Has odd numbers of elements, so skip the middle elements
	   
	   if(fast != null) {
		  slow = slow.next;
	   }
	   
	   while(slow != null) {
		 int top = stack.pop().intValue(); 
		
	   // If values are different, then it's not a palindrome
		 
		 if(top != (int)slow.data) {
	        return false;
		 }
		 slow = slow.next;  
	   }
	   
	  return true;   
	}	

	public static void main(String[] args) {
	  IsLinkedListAPalindrome list = new IsLinkedListAPalindrome();	
	  list.head = new LinkedListNode(0);
	  list.head.next = new LinkedListNode(1);
	  list.head.next.next = new LinkedListNode(2);
	  list.head.next.next.next = new LinkedListNode(1);
	  list.head.next.next.next.next = new LinkedListNode(0);
		     	     
	  boolean IsAPalindrome = list.isPalindrome(head);
		  
	  if(IsAPalindrome) {
		System.out.println("The linkedlist is a palindrome.");  
	  }
	  else {
		System.out.println("The linkedlist is not a palindrome.");    
	  }	

	}
 }
