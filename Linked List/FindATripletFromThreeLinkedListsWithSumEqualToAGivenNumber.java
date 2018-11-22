import java.util.*;
import java.io.*;

  public class FindATripletFromThreeLinkedListsWithSumEqualToAGivenNumber { 	
    private LinkedListNode headA;
    private LinkedListNode headB;
    private LinkedListNode headC;
    private static int size;
	
    public void isSumSorted(LinkedListNode headA, LinkedListNode headB, LinkedListNode headC, int givenSum) { 
      if (headA == null || headB == null || headC == null) { 
        return;
      }
	  
      SortLinkedList list = new SortLinkedList();
      LinkedListNode sortedListHeadB = list.sortLinkedList(headB);
      LinkedListNode sortedListHeadC = list.sortLinkedList(headC); 
      LinkedListNode newHeadC = reverseLL(sortedListHeadC);
     
      while(headA != null) {
        int sum = givenSum - (int)headA.data;
	LinkedListNode tempHead2 = sortedListHeadB;
	LinkedListNode tempHead3 = newHeadC;
	while(tempHead2 != null && tempHead3 != null) {
	  if((int)tempHead2.data + (int)tempHead3.data == sum) {
	    System.out.print("Triplet is: ");
            System.out.println((int)headA.data + " " + (int)tempHead2.data + " " + (int)tempHead3.data);
            return;
          }	
	  else if((int)tempHead2.data + (int)tempHead3.data < sum) {
            tempHead2 = tempHead2.next;
          } else {
            tempHead3 = tempHead3.next;
          }
	}
	headA = headA.next; 
      }
      System.out.println("No Triplet found"); 
    }
	
    private LinkedListNode reverseLL(LinkedListNode head) {
     /**
      * Reverses a linked list.
      */ 
      LinkedListNode current = head;	  
      LinkedListNode previous = null;
   	 	   
      while(current!=null) {
    	LinkedListNode next = current.next;
   	current.next = previous;
   	previous = current;
   	current = next;
      }	
   	   
      head = previous;

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
      FindATripletFromThreeLinkedListsWithSumEqualToAGivenNumber list = new FindATripletFromThreeLinkedListsWithSumEqualToAGivenNumber();	
	
      list.headA = new LinkedListNode(1);
      list.headA.next = new LinkedListNode(8);
      list.headA.next.next = new LinkedListNode(-3);
      list.headA.next.next.next = new LinkedListNode(14);
	    
      list.headB = new LinkedListNode(-1);
      list.headB.next = new LinkedListNode(22);
      list.headB.next.next = new LinkedListNode(31);
      list.headB.next.next.next = new LinkedListNode(11);
	  
      list.headC = new LinkedListNode(5);
      list.headC.next = new LinkedListNode(7);
      list.headC.next.next = new LinkedListNode(3);
      list.headC.next.next.next = new LinkedListNode(1);
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the sum: ");
      int givenSum = input.nextInt(); 
      System.out.println();
	  	  
      list.isSumSorted(list.headA, list.headB, list.headC, givenSum);  
      input.close();
    }
  }
