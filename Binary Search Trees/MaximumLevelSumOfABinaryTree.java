import java.util.*;
import java.io.*;

  public class MaximumLevelSumOfABinaryTree { 	
	Node root;	    
	Node previous;
	int maxDepth = 0;
	
	public int maxLevelSum(Node root) {
	  int[] sum = new int[10001];
	  calculateLevelSum(root, 0, sum);
	  int depth = 0, max = root.data;
	  
	  for (int i = 1; i < maxDepth; i++) {
        if (sum[i] > max) {
          max = sum[i];
          depth = i;
        }
      }
     
	  return depth + 1;      
	}
	
	private void calculateLevelSum(Node root, int depth, int sum[]) {    
      if(root == null) {
        return;
      }
      
      sum[depth] += root.data;
      
      if (depth > maxDepth) {
        maxDepth = depth;
      }
         
      calculateLevelSum(root.left, depth + 1, sum); 
      calculateLevelSum(root.right, depth + 1, sum);
    }

	public static void main(String[] args) {   
	  MaximumLevelSumOfABinaryTree tree = new MaximumLevelSumOfABinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(7);
	  tree.root.right = new Node(0);
	  tree.root.left.left = new Node(7);
      tree.root.left.right = new Node(-8);
        
	  int maxLevelSum = tree.maxLevelSum(tree.root);		
      System.out.print("The level with the maximum sum is: " + maxLevelSum);
	}
  }
