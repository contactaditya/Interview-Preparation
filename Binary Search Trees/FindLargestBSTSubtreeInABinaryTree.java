import java.io.*;
import java.util.*;

 class Value {
     int maximumSize = 0;	  
     int minimum = Integer.MAX_VALUE; // For minimum value in right subtree
     int maximum = Integer.MIN_VALUE; // For maximum value in left subtree
     boolean isBST = false;
 }

 public class FindLargestBSTSubtreeInABinaryTree {
    private static Node root;	
    private static int max = 0;
	
    public static int largestBSTSubtree(Node node) {
       if (node == null) {
	 return 0;
       }	 
       largestBSTSubtreeUtil(node);
       return max;	   
    }	
	 
    public static Value largestBSTSubtreeUtil(Node node) {
       Value current = new Value();	 
       if (node == null) {
	  current.isBST = true;  
	  return current;  
       }		 
	   
       Value left = largestBSTSubtreeUtil(node.left);
       Value right = largestBSTSubtreeUtil(node.right);
	   
       // Current Subtree's Boundaries
       current.minimum = Math.min(node.data, Math.max(left.minimum, right.minimum));
       current.maximum = Math.max(node.data, Math.min(left.maximum, right.maximum));
       
       //Check left and right subtrees are BST or not
       if (left.isBST && node.data > left.maximum && right.isBST && node.data < right.minimum) {
    	 current.maximumSize = left.maximumSize + right.maximumSize + 1;
    	 current.isBST = true;
         max = Math.max(max, current.maximumSize);
       } else {
    	 current.maximumSize = 0;
       }
		  
      return current;  
    }	

    public static void main(String[] args) {
       FindLargestBSTSubtreeInABinaryTree tree = new FindLargestBSTSubtreeInABinaryTree();
       tree.root = new Node(10);
       tree.root.left = new Node(5);
       tree.root.right = new Node(15);
       tree.root.left.left = new Node(1);
       tree.root.left.right = new Node(8);
       tree.root.right.right = new Node(7);
	  
       int size = tree.largestBSTSubtree(tree.root);
       System.out.println("Size of largest BST is " + size);
    }
  }
