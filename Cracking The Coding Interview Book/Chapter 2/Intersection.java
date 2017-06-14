import java.util.*;

 public class Intersection { 
     private static LinkedListNode head1;
     private static LinkedListNode head2;
     private static LinkedListNode head;
     private static int size;  

     public Intersection() {
    // this is an empty list, so the reference to the head node is set to a new node with no data				  
        head = new LinkedListNode(null);
	size = 0; 
     }
	
    public static int getCount(LinkedListNode node) {
    	LinkedListNode current = node;
        int count = 0;
 
        while (current != null) {
           count++;
           current = current.next;
        }
 
      return count;
    }
	
   public static int getNode(int d, LinkedListNode headA, LinkedListNode headB) {
	LinkedListNode current1 = headA;
	LinkedListNode current2 = headB;
	 	         		     
	for(int i = 0; i < d; i++) {
	   if (current1 == null) {
	      return -1;
	   }
          current1 = current1.next;
	}
				     
	while (current1 != null && current2 != null) {
	   if (current1.data == current2.data) {
	      return (int) current1.data;
	   }
	   current1 = current1.next;
	   current2 = current2.next;
	 } 
     return -1;   
   }
	
  public static int findIntersection(LinkedListNode headA, LinkedListNode headB) {
       if(headA == null || headB == null) {
         return -1;
       }
	   
       // Get the sizes of the two linked lists.
		
       int current1 = getCount(headA);
       int current2 = getCount(headB);
       int d;
	   
       if(current1 > current2) {
          d = current1 - current2;
          return getNode(d, headA, headB); 
       } else {
	  d = current2 - current1;
          return getNode(d, headA, headB); 
       }
  }

  public static void main(String[] args) {  
     Intersection list = new Intersection();	
     list.head1 = new LinkedListNode(3);
     list.head1.next = new LinkedListNode(6);
     list.head1.next.next = new LinkedListNode(15);
     list.head1.next.next.next = new LinkedListNode(15);
     list.head1.next.next.next.next = new LinkedListNode(30);
	  
     list.head2 = new LinkedListNode(10);
     list.head2.next = new LinkedListNode(15);
     list.head2.next.next = new LinkedListNode(30);
	     	     
     int intersection = findIntersection(list.head1, list.head2);
	  
     if(intersection != -1) {
       System.out.println("The value of the node where the two lists merge is: " + intersection);
     }
     else {
       System.out.println("The linkedlist do not intersect.");  
     }
   }
  }
