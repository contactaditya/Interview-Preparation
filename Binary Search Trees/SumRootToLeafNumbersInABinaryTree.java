import java.util.*;
import java.io.*;

  public class SumRootToLeafNumbersInABinaryTree { 	
	private static Node root;	  
	long pathSum = 0;
    
	public int sumNumbers(Node root) {
	   sumNumbersHelper(root, 0);	        
	   return (int)pathSum;	
	} 
	
	private void sumNumbersHelper(Node root, long currentSum) {
	   if (root == null) {
	      return;
	   }	
		
	   currentSum = currentSum * 10 + root.data;
	   if (root.left == null && root.right == null) {
          pathSum += currentSum;
       }
	   
	   sumNumbersHelper(root.left, currentSum);
	   sumNumbersHelper(root.right, currentSum);	
	}

	public static void main(String[] args) {    
	  SumRootToLeafNumbersInABinaryTree tree = new SumRootToLeafNumbersInABinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);

	  int sum = tree.sumNumbers(tree.root);		
	  System.out.print("The total sum of all root-to-leaf numbers is: " + sum);
	}
  }
