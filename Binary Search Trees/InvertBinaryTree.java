import java.util.*;
import java.io.*;

  public class InvertBinaryTree { 	 
    Node root;	     
    Node previous;
   
    public Node invertTree(Node root) {
      if (root == null) { 
	return null;
      }
	   
      Node right = invertTree(root.right);
      Node left = invertTree(root.left);
      root.left = right;
      root.right = left;
	      
      return root;
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
      InvertBinaryTree tree = new InvertBinaryTree();
      tree.root = new Node(4);
      tree.root.left = new Node(2);
      tree.root.right = new Node(7);
      tree.root.left.left = new Node(1);
      tree.root.left.right = new Node(3);
      tree.root.right.right = new Node(9);
      tree.root.right.left = new Node(6);
	  
      Node current = tree.invertTree(tree.root);
      System.out.print("Inorder traversal of the inverted binary tree is: ");
      tree.printInorderTraversal(current);			  
    }
  }
