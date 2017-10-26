import java.util.*;
import java.io.*;

  public class ConstructStringFromBinaryTree {
    Node root;	    
	Node previous;  
	  
	public static String tree2str(Node node) {
	   if (node == null) {
		  return "";
	   }
	   
	   if (node.left == null && node.right == null) {
		  return node.data + "";
	   }
	   
	   if (node.right == null) {
		  return node.data + "(" + tree2str(node.left) + ")";  
	   }
	        
	   return node.data + "("+ tree2str(node.left) +")("+ tree2str(node.right) +")";     
	}  

	public static void main(String[] args) {  
	  ConstructStringFromBinaryTree tree = new ConstructStringFromBinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.left = new Node(4);
	    
	  String result = tree.tree2str(tree.root);		
	  System.out.print("A string consisting of parenthesis and integers from a binary tree with the preorder traversing way is: " + result);
	}
  }
