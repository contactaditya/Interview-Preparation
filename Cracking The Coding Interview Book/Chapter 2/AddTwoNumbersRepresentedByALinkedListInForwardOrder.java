import java.util.*;
import java.io.*;

 class PartialSum { 	
    public LinkedListNode sum = null; 
    public int carry = 0;
 }

 public class AddTwoNumbersRepresentedByALinkedListInForwardOrder { 	
    private static LinkedListNode head;
    private static LinkedListNode head1;
    private static LinkedListNode head2;
    private static int size;  	 

    public AddTwoNumbersRepresentedByALinkedListInForwardOrder() {
       // this is an empty list, so the reference to the head node is set to a new node with no data				  
       head = new LinkedListNode(null);
       size = 0;
    }
	
    public static LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2) {	 	   
       int length1 = length(list1);
       int length2 = length(list2);
	   
       // Pad the shorter list with zeroes
       if(length1 < length2) {
	 list1 = padList(list1, length2 - length1);  
       } else {
	 list2 = padList(list2, length1 - length2);  
       }
	   
       /* Add lists */
       PartialSum sum = addListsHelper(list1, list2);
	   
       /* If there was a carry value left over, insert this at the front of the list. */
       if(sum.carry == 0) {
	 return sum.sum; 
       } else {
	 LinkedListNode result = insertBefore(sum.sum, sum.carry); 
	 return result;
       }
    }
	
    private static LinkedListNode padList(LinkedListNode list, int padding) {
       LinkedListNode head = list; 
       for(int i = 0; i < padding; i++) {
         head = insertBefore(head, 0);
       }
	   
       return head;
    }
	
    private static int length(LinkedListNode list1) {
       if (list1 == null) {
	 return 0;
       } else {
	 return 1 + length(list1.next);
       }
    }

   private static PartialSum addListsHelper(LinkedListNode list1, LinkedListNode list2) {
      if (list1 == null && list2 == null) {
	 PartialSum sum = new PartialSum();
	 return sum;
      } 
      /* Add smaller digits recursively */
      PartialSum sum = addListsHelper(list1.next, list2.next);
	   
      /* Add carry to current data */
      int value = sum.carry + (int)list1.data + (int)list2.data;
	   
      /* Insert sum of current digits */
      LinkedListNode full_result = insertBefore(sum.sum, value % 10);
	   
      /* Return sum so far and the carry value */
      sum.sum = full_result;
      sum.carry = value/10;
      return sum;
   }

   private static LinkedListNode insertBefore(LinkedListNode list, int data) {
      LinkedListNode node = new LinkedListNode(data);
      if(list != null) { 
	 node.next = list;  
      }
      return node;
   }

   public static int linkedListToInt(LinkedListNode node) {
      int value = 0;
      while (node != null) {
	value = value * 10 + (int)node.data;
	node = node.next;
      }
     return value;
   }	
	 
   public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
	 System.out.print(current.getData() + " ");	 	
	 current = current.getNext();
      }
   }  		

   public static void main(String[] args) { 
      AddTwoNumbersRepresentedByALinkedListInForwardOrder list = new AddTwoNumbersRepresentedByALinkedListInForwardOrder();
      list.head1 = new LinkedListNode(3);
      list.head1.next = new LinkedListNode(1);
	  
      list.head2 = new LinkedListNode(5);
      list.head2.next = new LinkedListNode(9);
      list.head2.next.next = new LinkedListNode(1);
	   	  
      LinkedListNode current = addLists(head1, head2);
      int list1 = linkedListToInt(head1);
      int list2 = linkedListToInt(head2);
      int list3 = linkedListToInt(current);
	  
      System.out.print("Contents of the linked list which contains the sum of the two linked lists are: ");
      System.out.print(list1 + " + " + list2 + " = " + list3);	
   }
 }
