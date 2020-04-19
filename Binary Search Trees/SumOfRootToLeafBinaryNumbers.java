import java.util.*;
import java.io.*;

  public class SumOfRootToLeafBinaryNumbers {
    private Node root;	
	  
    public static int sumRootToLeaf(Node root) {
      return dfs(root, 0);  
    }	  

    private static int dfs(Node root, int value) {
      if (root == null) {
	return 0;
      }
      value = value * 2 + root.data;
      return root.left == root.right ? value : dfs(root.left, value) + dfs(root.right, value);
    }

    public static void main(String[] args) {   
      SumOfRootToLeafBinaryNumbers tree = new SumOfRootToLeafBinaryNumbers();
      tree.root = new Node(1);
      tree.root.left = new Node(0);
      tree.root.right = new Node(1);
      tree.root.left.left = new Node(0);
      tree.root.left.right = new Node(1);
      tree.root.right.right = new Node(1);
      tree.root.right.left = new Node(0);
	    
      int sumRootToLeaf = sumRootToLeaf(tree.root);
      System.out.println("The sum of the numbers represented by the path from the root to that leaf is: " + sumRootToLeaf);
    }
  }
