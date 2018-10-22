import java.io.*;
import java.util.*;

  public class LongestConsecutiveSequenceInABinaryTree {
    Node root;	    
    Node previous;
	
    public int longestConsecutiveUtil(Node node, int currentLength, int target) {
      if (node == null) {
	return 0;
      }
      // If root data has one more than its parent then increase current length
      if (node.data == target) {
	currentLength++;  
      }
      else {
	currentLength = 1; 
      }
	   
      int left = longestConsecutiveUtil(node.left, currentLength, node.data + 1);
      int right = longestConsecutiveUtil(node.right, currentLength, node.data + 1);
       
      return Math.max(currentLength, Math.max(left, right));
    }

    public int longestConsecutiveSequence(Node node) {
      if (node == null) {
	return 0;
      }
	   
      return longestConsecutiveUtil(node, 0, node.data + 1);
    }

    public static void main(String[] args) {
      LongestConsecutiveSequenceInABinaryTree tree = new LongestConsecutiveSequenceInABinaryTree();
      tree.root = new Node(6);
      tree.root.left = new Node(7);
      tree.root.right = new Node(9);
      tree.root.right.right = new Node(10);
      tree.root.right.right.right = new Node(11);
	  
      int length = tree.longestConsecutiveSequence(tree.root);  
      System.out.print("The length of the longest path which comprises of nodes with consecutive values in increasing order is: " + length);
    }
  }
