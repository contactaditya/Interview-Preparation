import java.util.*;
import java.io.*;

  public class FindDistanceBetweenTwoNodesOfABinaryTree {
	Node root;	    
	  
	public static int findDistance(Node root, int node1, int node2) {
	  Node lca = findLowestCommonAncestor(root, node1, node2); 
	  int d1 = findLevel(lca, node1, 0); 
      int d2 = findLevel(lca, node2, 0); 
		
	  return d1 + d2;
	}
	
	public static int findLevel(Node root, int a, int level) {
      if (root == null) {
        return -1; 
      }
      if (root.data == a) { 
        return level; 
      }
      int left = findLevel(root.left, a, level + 1); 
      if (left == -1) {
        return findLevel(root.right, a, level + 1);
      }
      return left; 
	}
	
	public static Node findLowestCommonAncestor(Node root, int node1, int node2) {
	  if(root == null || root.data == node1 || root.data == node2) {
	    return root;
	  }
			    
	  Node left = findLowestCommonAncestor(root.left, node1, node2);
	  Node right = findLowestCommonAncestor(root.right, node1, node2);
	       
	  if (left !=null && right !=null) {
	    return root;
	  }
	    
	  return (left != null) ? left : right; 
    }

	public static void main(String[] args) { 	 
	  FindDistanceBetweenTwoNodesOfABinaryTree tree = new FindDistanceBetweenTwoNodesOfABinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      tree.root.right.left = new Node(6);
      tree.root.right.right = new Node(7); 
      tree.root.right.left.right = new Node(8);
      
      Node node1 = tree.root.left.left;
      Node node2 = tree.root.right.left;
      
      int distance = findDistance(tree.root, node1.data, node2.data);
      
      System.out.println("The distance between the two nodes " + node1.data  + " and " + node2.data + " is the minimum number of edges to be traversed to reach one node from other is: " + distance);
	}
  }
