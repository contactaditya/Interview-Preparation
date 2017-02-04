import java.io.*;
import java.util.*;

 public class DeleteANodeInABST { 	
    Node root;	    
    Node previous;

  public Node deleteNode(Node node, int key) {
	  
   /* Base Case: If the tree is empty */  
	 
    if (node == null) {
       return node;
    }
    if(key < node.data) {
      node.left = deleteNode(node.left, key);
    } else if(key > node.data) {
      node.right = deleteNode(node.right, key);
    } 
    // If key is same as root's key, then this is the node to be deleted.
    
    else {
      // node with only one child or no child	
      if (node.left == null) { 
    	 return node.right;
      } else if (node.right == null) {
    	 return node.left;
      }
      
      // Node with two children: Get the inorder successor (smallest in the right subtree)
      node.data = minimumValue(node.right);
      
      // Delete the inorder successor
      node.right = deleteNode(node.right, node.data);      
    }
 
    return node;   	
  }
  
  public int minimumValue(Node node) {
		 
    int minimumValue = node.data;
    while (node.left != null) {
       minimumValue = node.left.data;
       node = node.left;
    }
    return minimumValue;		
  }
  
  public void printInorderTraversal(Node node) {
		 
    if (node == null) {
       return;
    }
		 
    printInorderTraversal(node.left);
    System.out.print(node.data + " ");	
    printInorderTraversal(node.right);
  }

  public static void main(String[] args) {   
    DeleteANodeInABST tree = new DeleteANodeInABST();
    tree.root = new Node(50);
    tree.root.left = new Node(30);
    tree.root.right = new Node(70);
    tree.root.left.right = new Node(40);
    tree.root.left.left = new Node(20);
    tree.root.right.right = new Node(80);
    tree.root.right.left = new Node(60);
    
    System.out.print("Inorder traversal of binary tree is: ");
    tree.printInorderTraversal(tree.root);		
	
    System.out.println();
    System.out.println();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the value of the node you want to delete in the tree: ");
    int value = input.nextInt();  
	   
    tree.deleteNode(tree.root, value);		
	
    System.out.println();
    System.out.print("Inorder traversal of binary tree is: ");
    tree.printInorderTraversal(tree.root);		
	
  }
}
