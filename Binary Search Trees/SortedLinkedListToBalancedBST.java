import java.io.*;
import java.util.*;

  public class SortedLinkedListToBalancedBST { 
    private static DoublyLinkedListNode head;
    private static int size;  
    private static Node root;	    
    private static Node previous;
	
    public SortedLinkedListToBalancedBST() {
      // this is an empty list, so the reference to the head node is set to a new node with no data				  
      head = new DoublyLinkedListNode(null);
      size = 0;
    }
	
    public static Node sortedLinkedListToBST() {
      int number = getCount(head); 
      return sortedLinkedListToBSTRecurion(number);
    }
	
    public static Node sortedLinkedListToBSTRecurion(int number) {
      if (number <= 0) {
        return null;
      }
	  
      /* Recursively construct the left subtree */
      Node left = sortedLinkedListToBSTRecurion(number / 2);
      
      /* Make middle node as root of BST */
      Node root = new Node((int)head.data);
      
      // Set pointer to left subtree
      root.left = left;
      
      head = head.next;
      root.right = sortedLinkedListToBSTRecurion(number - number/2 - 1);
	  
      return root;
    }

    public static int getCount(DoublyLinkedListNode node) {
      DoublyLinkedListNode current = node;
      int count = 0;
 
      while (current != null) {
        count++;
        current = current.next;
      }
 
      return count;
    }
			 
    public static void PrintElementsOfALinkedList(DoublyLinkedListNode head) {	 
      DoublyLinkedListNode current = head; 
      System.out.print("Contents of the linked list are: ");	 
      while(current != null) {	   
        System.out.print(current.getData() + " ");	 	
        current = current.getNext();
      }
    } 
	
    public void printPreorderTraversal(Node node) {		 
      if (node == null) {
        return;
      }
		    
      System.out.print(node.data + " ");		  
      printPreorderTraversal(node.left);
      printPreorderTraversal(node.right);
    }

    public static void main(String[] args) {       
      SortedLinkedListToBalancedBST list = new SortedLinkedListToBalancedBST(); 
      list.head = new DoublyLinkedListNode(1);
      list.head.next = new DoublyLinkedListNode(2);
      list.head.next.next = new DoublyLinkedListNode(3);
      list.head.next.next.next = new DoublyLinkedListNode(4);
      list.head.next.next.next.next = new DoublyLinkedListNode(5);
      list.head.next.next.next.next.next = new DoublyLinkedListNode(6);
      list.head.next.next.next.next.next.next = new DoublyLinkedListNode(7);
	  
      list.PrintElementsOfALinkedList(head);
	  
      root = list.sortedLinkedListToBST();
	  
      System.out.println();
      System.out.println();
      System.out.print("Preorder traversal of binary tree is: ");
      list.printPreorderTraversal(root);		
    }
  }
