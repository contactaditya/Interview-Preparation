import java.util.*;

 class LinkedListNode {
   public Object data;  
   public LinkedListNode next;

   //Node constructor
		    
   public LinkedListNode(Object data) {
      this.data = data;
      next = null;
   }
		    
   public LinkedListNode(Object data, LinkedListNode next) {
      this.data = data;
      this.next = next;
   }
	 
   public Object getData() {
      return data;
   }
			
   public void setData(Object data) {
      this.data = data; 
   }
			
   public LinkedListNode getNext() {
      return next;
   }
			
   public void setNext(LinkedListNode next) {
      this.next = next;
   }
 }

 public class LoopDetection { 
    private static LinkedListNode head;
    private static int size;  
	
    public LoopDetection() {
       // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
    }

    public static LinkedListNode findBeginning(LinkedListNode head) {
       LinkedListNode slow = head;
       LinkedListNode fast = head;
		     
       while(fast != null && fast.next != null) {    
	 slow = slow.next;
	 fast = fast.next.next;
	 if(slow == fast) {
	   break; 
	 }
       }
	   
       // If there is no meeting point then there is no loop
	   
       if(fast == null || fast.next == null) {
	 return null;
       }
	   
      slow = head;
	   
      while(slow != fast) {
	slow = slow.next;
	fast = fast.next;
      }
	  
      return fast;
    }
	  
    public static void main(String[] args) {  
      LoopDetection list = new LoopDetection();
      list.head = new LinkedListNode(50);
      list.head.next = new LinkedListNode(20);
      list.head.next.next = new LinkedListNode(15); 
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(10);
      list.head.next.next.next.next.next = list.head.next;
	     	     
      LinkedListNode IsALoop = list.findBeginning(head);
	  
      if(IsALoop == null) {
        System.out.println("There is no loop in the linkedlist.");  
      }
      else {
        System.out.println("There is a loop in the linkedlist and data where the loop is present is: " + IsALoop.data);    
      }
    }
 }
