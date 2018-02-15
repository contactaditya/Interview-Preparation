import java.util.*;
import java.io.*;

  public class MinimumDistanceBetweenBSTNodes {
    Node root;	    
    Integer previous, answer;
	 
    public int minDiffInBST(Node root) {
      previous = null;
      answer = Integer.MAX_VALUE;
      dfs(root);
      return answer;    
    }  

    private void dfs(Node node) {
      if (node == null) {
	return;
      }
      dfs(node.left);
      if (previous != null) {
	answer = Math.min(answer, node.data - previous);
      }
      previous = node.data;
      dfs(node.right);
    }

    public static void main(String[] args) { 	 
      MinimumDistanceBetweenBSTNodes tree = new MinimumDistanceBetweenBSTNodes();
      tree.root = new Node(4);
      tree.root.right = new Node(6);
      tree.root.left = new Node(2);
      tree.root.left.left = new Node(1);
      tree.root.left.right = new Node(3);
	  
      System.out.println("The minimum difference between the values of any two different nodes in the tree is: " + tree.minDiffInBST(tree.root));		
    }
  }
