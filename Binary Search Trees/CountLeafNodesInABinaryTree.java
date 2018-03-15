import java.io.*;
import java.util.*;

 public class CountLeafNodesInABinaryTree { 
    Node root;	    
    Node previous;
    
    public int getLeafCount(Node node) {	 
      if (node == null) {
        return 0;
      }
   	
      if (node.left == null && node.right == null) {    
        return 1;
      }	 
      else {
        return getLeafCount(node.left) + getLeafCount(node.right);
      }    	
    }

    public static void main(String[] args) {
      CountLeafNodesInABinaryTree tree = new CountLeafNodesInABinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
	         
      System.out.println("The leaf count of binary tree is : " + tree.getLeafCount(tree.root));
    }
 }
