import java.util.*;
import java.io.*;

  public class SumOfNodesAtMaximumDepthOfABinaryTree { 
    Node root;	    
    Node previous;
    
    public static int maximumDepth(Node root) {
      if (root == null) {
	return 0;
      }
		    
      return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;     	
    }  
    
    private static int sumMaxLevel(Node root) {
      int maxDepth = maximumDepth(root);    
      return sumMaxLevelRec(root, maxDepth); 
    }

    private static int sumMaxLevelRec(Node node, int maxDepth) {
      if (node == null)  {
        return 0;      
      }
      if (maxDepth == 1) { 
        return node.data;
      }
		
      return sumMaxLevelRec(node.left, maxDepth - 1) + sumMaxLevelRec(node.right, maxDepth - 1); 
    }

    public void printInorderTraversal(Node node) {	 
      if (node == null) {
        return;
      }

      printInorderTraversal(node.left);
      System.out.print(node.data + " ");	
      printInorderTraversal(node.right);
    }

    public static void main(String[] args) {  
      SumOfNodesAtMaximumDepthOfABinaryTree tree = new SumOfNodesAtMaximumDepthOfABinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.right = new Node(5);
      tree.root.left.left = new Node(4);
      tree.root.right.left = new Node(6);
      tree.root.right.right = new Node(7);
      
      int sum = sumMaxLevel(tree.root);
      System.out.print("The sum of all the leaf nodes which are at maximum depth from root node is: " + sum);
    }
  }
