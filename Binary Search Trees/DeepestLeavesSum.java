import java.util.*;
import java.io.*;

  public class DeepestLeavesSum {
	private Node root;
	private int maxLevel = 0;
    private int sum = 0;
	  
	public int deepestLeavesSum(Node root) {
	  if (root == null) {
		return 0;
	  }
	  calculateSumAtLevel(root, 0);
	  return sum;
	}

	private void calculateSumAtLevel(Node root, int level) {
	  if (root == null) {
		return;
	  }
	  if(level > maxLevel) {
        sum = 0;
        maxLevel = level;
      }
	  if(level == maxLevel) {
	    sum = sum + root.data;
	  }
      calculateSumAtLevel(root.left, level + 1);
      calculateSumAtLevel(root.right, level + 1);
	}

	public static void main(String[] args) {   
	  DeepestLeavesSum tree = new DeepestLeavesSum();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      tree.root.right.right = new Node(6);
      tree.root.right.right.right = new Node(8);
      tree.root.left.left.left = new Node(7);
      
      int deepestLeavesSum = tree.deepestLeavesSum(tree.root);
	  System.out.println("The sum values of the deepest leaves of a binary tree is: " + deepestLeavesSum);
	}
  }
