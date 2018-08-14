import java.util.*;
import java.io.*;

  public class SmallestSubtreeWithAllTheDeepestNodes { 	
    Map<Node, Integer> depth;
    int max_depth;
    Node root;
	  
    public Node subtreeWithAllDeepest(Node root) {
      depth = new HashMap<Node, Integer>();
      depth.put(null, -1);
      dfs(root, null);
      max_depth = -1;	
      for (Integer d : depth.values()) {
        max_depth = Math.max(max_depth, d);
      }
	
      return answer(root);       
    }

    private Node answer(Node node) {
      if (node == null || depth.get(node) == max_depth) {
	return node;
      }
      Node L = answer(node.left), R = answer(node.right);
      if (L != null && R != null) {
	return node;
      }
      if (L != null) {
    	return L;
      }
      if (R != null) {
    	return R;
      }
		
      return null;
    }

    private void dfs(Node node, Node parent) {
      if (node != null) {
	depth.put(node, depth.get(parent) + 1);
	dfs(node.left, node);
	dfs(node.right, node);
      }
    }
	
    public void printPreorderTraversal(Node node) {	 
      if (node == null) {
  	return;
      }
      
      System.out.print(node.data + " ");		  
      printPreorderTraversal(node.left);
      printPreorderTraversal(node.right);
    }	

    public static void main(String[] args) { 	 
      SmallestSubtreeWithAllTheDeepestNodes tree = new SmallestSubtreeWithAllTheDeepestNodes();
      tree.root = new Node(3);
      tree.root.left = new Node(5); 
      tree.root.left.left = new Node(6);
      tree.root.left.right = new Node(2);
      tree.root.left.right.left = new Node(7);
      tree.root.left.right.right = new Node(4);
      tree.root.right = new Node(1);
      tree.root.right.right = new Node(8);
      tree.root.right.left = new Node(0);
      
      Node result = tree.subtreeWithAllDeepest(tree.root);
      
      System.out.print("The node with the largest depth such that it contains all the deepest nodes in its subtree is: ");
      tree.printPreorderTraversal(result);
    }
  }
