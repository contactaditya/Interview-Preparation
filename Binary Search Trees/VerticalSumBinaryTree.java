import java.util.*;
import java.io.*;

 public class VerticalSumBinaryTree {
	private static Node root;	    
	private static Node previous;
	private static DoublyLinkedListNode head;
	private static int size;      
	
	public VerticalSumBinaryTree() {
	   // this is an empty list, so the reference to the head node is set to a new node with no data				  
	   head = new DoublyLinkedListNode(null);
	   size = 0;
	}
	
	public static void verticalSumDLL(Node root) {   
	   // Create a doubly linked list node to store sum of lines going through root. Vertical sum is initialized as 0.	
	   DoublyLinkedListNode doublyLinkedListNode = new DoublyLinkedListNode(0);
	   // Compute vertical sum of different lines
       verticalSumDLLUtil(root, doublyLinkedListNode);
       // doublyLinkedListNode refers to sum of vertical line going through root. Move doublyLinkedListNode to the leftmost line.
       while (doublyLinkedListNode.previous != null) {
    	  doublyLinkedListNode = doublyLinkedListNode.previous;
       }
       // Prints vertical sum of all lines starting from leftmost vertical line
       while (doublyLinkedListNode != null) {
          System.out.print(doublyLinkedListNode.data +" ");
          doublyLinkedListNode = doublyLinkedListNode.next;
       }
	}
	
	public static void verticalSumDLLUtil(Node node, DoublyLinkedListNode doublyLinkedListNode) { 
		// Add current node's data to its vertical line
		doublyLinkedListNode.data = (int)doublyLinkedListNode.data + node.data;
		// Recursively process left subtree
        if (node.left != null) {
           if (doublyLinkedListNode.previous == null) {
        	   doublyLinkedListNode.previous = new DoublyLinkedListNode(0);
        	   doublyLinkedListNode.previous.next = doublyLinkedListNode;
           }	
           verticalSumDLLUtil(node.left, doublyLinkedListNode.previous);
        }
        // Recursively process right subtree
        if (node.right != null) {
           if (doublyLinkedListNode.next == null) {
              doublyLinkedListNode.next = new DoublyLinkedListNode(0);
              doublyLinkedListNode.next.previous = doublyLinkedListNode;
           }
           verticalSumDLLUtil(node.right, doublyLinkedListNode.next);
        }
	}

	public static void main(String[] args) { 	 
	  VerticalSumBinaryTree tree = new VerticalSumBinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      tree.root.right.left = new Node(6);
      tree.root.right.right = new Node(7);
      
      System.out.print("The vertical sum of the nodes that are in same vertical line are: ");
      verticalSumDLL(root);
	}
 }
