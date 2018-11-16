import java.util.*;
import java.io.*;

  public class DeleteAllTheNodesFromTheListThatAreLessThanX { 
    private LinkedListNode head;
    private static int size;  
		
    public LinkedListNode deleteLesserNodes(LinkedListNode head, int value) {     
      while (head != null && (int)head.data < value) {
	head = head.next;
      }
      LinkedListNode current = head; 		 
      while(current != null && current.getNext() != null) {
	if((int)current.next.data < value) {
	  current.next = current.next.next; 
	}
        else {
	  current = current.next; 	
        }
      }
      return head;
    }
		
    public void PrintElementsOfALinkedList(LinkedListNode head) {	 
      LinkedListNode current = head; 		    
      while(current != null) {	   
	System.out.print(current.getData() + " ");	 	
	current = current.getNext();
      }
    }  			

    public static void main(String[] args) {   
      DeleteAllTheNodesFromTheListThatAreLessThanX list = new DeleteAllTheNodesFromTheListThatAreLessThanX();
      list.head = new LinkedListNode(12);
      list.head.next = new LinkedListNode(15);
      list.head.next.next = new LinkedListNode(9);
      list.head.next.next.next = new LinkedListNode(11);
      list.head.next.next.next.next = new LinkedListNode(5);
      list.head.next.next.next.next.next = new LinkedListNode(6);
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the value: ");
      int value = input.nextInt();   
      System.out.println();
      System.out.print("Contents of the linked list before deleting are: ");	 
      list.PrintElementsOfALinkedList(list.head);
      LinkedListNode current = list.deleteLesserNodes(list.head, value); 
      System.out.println();
      System.out.println();
      System.out.print("Contents of the linked list after deleting are: ");	 
      list.PrintElementsOfALinkedList(current);
      input.close();
    }
  }
