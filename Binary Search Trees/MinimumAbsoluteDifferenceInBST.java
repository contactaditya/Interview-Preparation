import java.util.*;
import java.io.*;

  public class MinimumAbsoluteDifferenceInBST {
    Node root;	     
    int min = Integer.MAX_VALUE;
    Integer previous = null;

    public int getMinimumDifference(Node root) {		 
      if (root == null) {
	return min;
      }
	   
      getMinimumDifference(root.left);
       
      if (previous != null) {
        min = Math.min(min, root.data - previous);
      } 
      previous = root.data;
       
      getMinimumDifference(root.right);
		
      return min;
    } 

    public static void main(String[] args) {
      MinimumAbsoluteDifferenceInBST tree = new MinimumAbsoluteDifferenceInBST();
      tree.root = new Node(1);
      tree.root.right = new Node(3);
      tree.root.right.left = new Node(2);
		  
      System.out.println("The minimum absolute difference between values of any two nodes of the binary search tree is : " + tree.getMinimumDifference(tree.root));		
    }
  }
