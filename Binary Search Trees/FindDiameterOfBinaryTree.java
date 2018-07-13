import java.util.*;
import java.io.*;

  public class FindDiameterOfBinaryTree {
    Node root;	    
    Node previous;	  
    int max = 0;
	  
    public int diameterOfBinaryTree(Node root) {
      if (root == null) {
	return 0;
      }	
      maxDepth(root);
      return max;
    }	  

    private int maxDepth(Node root) {
      if (root == null) {
	return 0;
      }
	        
      int left = maxDepth(root.left);
      int right = maxDepth(root.right);
	        
      max = Math.max(max, left + right);
	        
      return Math.max(left, right) + 1;
    }

    public static void main(String[] args) { 	   
      FindDiameterOfBinaryTree tree = new FindDiameterOfBinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      int lengthOfDiameter = tree.diameterOfBinaryTree(tree.root);		
		     
      System.out.print("The length of the diameter of the binary tree is: " + lengthOfDiameter);
    }
  }
