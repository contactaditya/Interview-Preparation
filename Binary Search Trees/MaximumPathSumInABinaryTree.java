import java.util.*;
import java.io.*;

  public class MaximumPathSumInABinaryTree {
	Node root;
	int maxValue;
	
    public int findMaximumSum(Node node) {
      maxValue = Integer.MIN_VALUE;
      maxPathDown(node);
      return maxValue;
    } 
	
    public int maxPathDown(Node node) {
      if (node == null) {
	    return 0;
      } 
      int left = Math.max(0, maxPathDown(node.left));
      int right = Math.max(0, maxPathDown(node.right));
      maxValue = Math.max(maxValue, left + right + node.data);
      return Math.max(left, right) + node.data;
    } 

    public static void main(String[] args) {
      MaximumPathSumInABinaryTree tree = new MaximumPathSumInABinaryTree();
      tree.root = new Node(10);
      tree.root.left = new Node(2);
      tree.root.right = new Node(10);
      tree.root.left.left = new Node(20);
      tree.root.left.right = new Node(1);
      tree.root.right.right = new Node(-25);
      tree.root.right.right.left = new Node(3);
      tree.root.right.right.right = new Node(4);
      
      int maximumSum = tree.findMaximumSum(tree.root);		
      System.out.print("Maximum path sum in a binary tree is: " + maximumSum);
    }
  }