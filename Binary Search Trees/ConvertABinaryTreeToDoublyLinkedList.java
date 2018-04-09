import java.io.*;
import java.util.*;

  public class ConvertABinaryTreeToDoublyLinkedList { 	
    private static Node head;
    private static Node root;	
    private static Node previous = null;	
  	
    public static void ConvertABinaryTreeToDoublyLinkedList(Node node) {  
      if (node == null) {
	return;
      }
	 
      // Recursively convert left subtree
      ConvertABinaryTreeToDoublyLinkedList(node.left);
	 
      if (previous == null) {
        head = node; 
      }
      else {
        node.left = previous;
        previous.right = node;
      }
      previous = node;
         
      ConvertABinaryTreeToDoublyLinkedList(node.right); 
    }	
  
    public static void printInorderTraversal(Node node) {	 
      if (node == null) {
        return;
      }
	 
      printInorderTraversal(node.left);
      System.out.print(node.data + " ");	
      printInorderTraversal(node.right);
    }
	
    public static void PrintElementsOfALinkedList(Node node) {	 
      System.out.print("Contents of the doubly linked list are: ");	 
      while(node != null) {	   
        System.out.print(node.data + " ");	 	
        node = node.right;
      }
    } 

    public static void main(String[] args) {   
      ConvertABinaryTreeToDoublyLinkedList tree = new ConvertABinaryTreeToDoublyLinkedList();
      tree.root = new Node(8);
      tree.root.left = new Node(5);
      tree.root.right = new Node(9);
      tree.root.left.left = new Node(2);
      tree.root.left.right = new Node(7);
      tree.root.left.left.left = new Node(1);
      
      System.out.print("Inorder traversal of binary tree is: ");
      printInorderTraversal(tree.root);		
      
      ConvertABinaryTreeToDoublyLinkedList(tree.root);
	   
      System.out.println();
      System.out.println();
      PrintElementsOfALinkedList(head);
    }
  }
