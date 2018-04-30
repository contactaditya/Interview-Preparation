import java.util.*;
import java.io.*;

  public class SecondMinimumNodeInABinaryTree { 	
    Node root;	 
    int minimumElement = 0;
    long secondMinimumElement = Long.MAX_VALUE;

    public int findSecondMinimumValue(Node root) {       	   
      minimumElement = root.data;
      dfs(root);
	   
      return secondMinimumElement < Long.MAX_VALUE ? (int)secondMinimumElement : -1;
    }	

    private void dfs(Node root) {
      if (root != null) {
	if (minimumElement < root.data && root.data < secondMinimumElement) {
	  secondMinimumElement = root.data;
	} else if (minimumElement == root.data) {
	  dfs(root.left);
	  dfs(root.right);
	}
      }	
    }

    public static void main(String[] args) {   
      SecondMinimumNodeInABinaryTree tree = new SecondMinimumNodeInABinaryTree();
      tree.root = new Node(2);
      tree.root.left = new Node(2);
      tree.root.right = new Node(5);
      tree.root.right.left = new Node(5);
      tree.root.right.right = new Node(7);
      Scanner input = new Scanner(System.in);
      int secondMinimumElement = tree.findSecondMinimumValue(tree.root);		
      System.out.println("The second minimum element in the binary search tree is: " + secondMinimumElement);	
    }
  }
