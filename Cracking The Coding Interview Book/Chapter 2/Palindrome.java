import java.util.*;

 public class Palindrome { 	 
    private static LinkedListNode head;
    private static int size;  

    public Palindrome() {
    // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
    
    public static boolean isPalindrome(LinkedListNode node) {
      LinkedListNode reversed = reverseAndClone(head);   	         		           
      return isEqual(head, reversed);   
    }
    
    public static LinkedListNode reverseAndClone(LinkedListNode node) {
       LinkedListNode head = null;
       
       while(node != null) {
         LinkedListNode n = new LinkedListNode(node.data);
         n.next = head;
         head = n;
         node = node.next;
       }	  
     return head;   
    }
    
    public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
       while (one != null && two != null) {
    	 if(one.data != two.data) {
    	   return false;	
    	 }
    	 one = one.next;
    	 two = two.next;
       }
    	
     return one == null && two == null;   
   }

  public static void main(String[] args) { 
	 
      Palindrome list = new Palindrome();	
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
