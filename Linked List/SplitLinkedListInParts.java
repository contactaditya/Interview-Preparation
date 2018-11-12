import java.util.*;
import java.io.*;

  public class SplitLinkedListInParts {
    private static LinkedListNode head;
    private static int size;  	  
	  
    public LinkedListNode[] splitListToParts(LinkedListNode root, int k) {
      LinkedListNode current = root;
      int N = 0;
      while (current != null) {
        current = current.next;
        N++;
      }	
      
      int width = N / k, rem = N % k;
      LinkedListNode[] answer = new LinkedListNode[k];
      current = root;
      for (int i = 0; i < k; i++) {
        LinkedListNode head = current;
        // Now for each part, we have calculated how many nodes that part will have: width + (i < remainder ? 1 : 0). We create a new list and write the part to that list.
        for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
          if (current != null) {
            current = current.next;
          }
        }
        if (current != null) {
          LinkedListNode previous = current;
          current = current.next;
          previous.next = null;
        }
        answer[i] = head;
      }
		
      return answer;      
    }	  

    public static void main(String[] args) { 	  
      SplitLinkedListInParts list = new SplitLinkedListInParts();	
      list.head = new LinkedListNode(1);
      list.head.next = new LinkedListNode(2);
      list.head.next.next = new LinkedListNode(3);
      list.head.next.next.next = new LinkedListNode(4);
      list.head.next.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next.next = new LinkedListNode(6);
      list.head.next.next.next.next.next.next = new LinkedListNode(7); 
      list.head.next.next.next.next.next.next.next = new LinkedListNode(8);
      list.head.next.next.next.next.next.next.next.next = new LinkedListNode(9);
      list.head.next.next.next.next.next.next.next.next.next = new LinkedListNode(10);
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of consecutive linked list parts that you want to split the linked list into: ");
      int k = input.nextInt();   
	  		    
      LinkedListNode splitListToParts[] = list.splitListToParts(head, k);
      System.out.println();
      System.out.print("A list of LinkedList Node's representing the linked list parts that are formed are: ");
      for (int i = 0; i < splitListToParts.length; i++) {
        System.out.print(splitListToParts[i].data  + " ");
      }
	  
      input.close();
    }
  }
