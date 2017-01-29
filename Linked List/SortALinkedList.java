import java.util.*;
import java.io.*;

 public class SortALinkedList { 	
    private static LinkedListNode head;
    private static int size;  

    public SortALinkedList() {
   // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new LinkedListNode(null);
      size = 0;
    }
	
    public static void sortLinkedList() {	 
       LinkedListNode current = head; 		
       int count[] = {0,0,0};
	   
   // count[0] will store total number of '0's, count[1] will store total number of '1's, count[2] will store total number of '2's  */
	   
       while(current != null) {	   
	  count[(int)current.data]++;
	  current = current.next;
       }
 
       int i = 0;
       current = head;
	  
   /* Let say count[0] = n1, count[1] = n2 and count[2] = n3 now start traversing list from head node, 
    * 1) fill the list with 0, till n1 > 0 
    * 2) fill the list with 1, till n2 > 0
    * 3) fill the list with 2, till n3 > 0  */
	  
       while (current != null) {
          if (count[i] == 0) {
             i++;
          }
          else {
            current.data = i;
            count[i]--;
            current = current.next;
          }
       }
    }   

public static void PrintElementsOfALinkedList(LinkedListNode head) {	 
    LinkedListNode current = head; 		    
    while(current != null) {	   
       System.out.print(current.getData() + " ");	 	
       current = current.getNext();
    }
 } 

public static void main(String[] args) {  
   SortALinkedList list = new SortALinkedList();
   list.head = new LinkedListNode(2);
   list.head.next = new LinkedListNode(1);
   list.head.next.next = new LinkedListNode(2);
   list.head.next.next.next = new LinkedListNode(1);
   list.head.next.next.next.next = new LinkedListNode(1);	  
   list.head.next.next.next.next.next = new LinkedListNode(2);
   list.head.next.next.next.next.next.next = new LinkedListNode(0);
   list.head.next.next.next.next.next.next.next = new LinkedListNode(1);
   list.head.next.next.next.next.next.next.next.next = new LinkedListNode(0);

   System.out.print("Contents of the linked list before sorting are: ");	 
   list.PrintElementsOfALinkedList(head);
   list.sortLinkedList(); 
   System.out.println();
   System.out.println();
   System.out.print("Contents of the linked list after sorting are: ");	 
   list.PrintElementsOfALinkedList(head);
  }
}
