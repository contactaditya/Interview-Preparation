import java.util.*;
import java.io.*;

 public class LongestUnivaluePath {
	Node root;	    
	Node previous; 
	int length = 0; 
	 
	public int longestUnivaluePath(Node root) {
      if (root == null) {
		return 0;
	  }
	  length = 0;
	  getLength(root, root.data);
	  return length;	        
	}	 

	private int getLength(Node node, int value) {
	  if (node == null) {
		return 0;
	  }
      int left = getLength(node.left, node.data);
	  int right = getLength(node.right, node.data);
	  length = Math.max(length, left + right);
	  if (value == node.data) {
		return Math.max(left, right) + 1;
	  }
	  return 0;	
	}

	public static void main(String[] args) { 
	  LongestUnivaluePath tree = new LongestUnivaluePath();
	  tree.root = new Node(5);
	  tree.root.left = new Node(4);
	  tree.root.right = new Node(5);
	  tree.root.left.left = new Node(1);
	  tree.root.right.right = new Node(5);
	  tree.root.left.right = new Node(1);

	  int lengthOfLongestPath = tree.longestUnivaluePath(tree.root);
	  System.out.print("The length of the longest path where each node in the path has the same value is: " + lengthOfLongestPath);
	}
 }
