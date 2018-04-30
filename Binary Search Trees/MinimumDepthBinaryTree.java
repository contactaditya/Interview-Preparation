import java.util.*;
import java.io.*;

  public class MinimumDepthBinaryTree {   
    Node root;	    
    Node previous;

    public int minimumDepth(Node node) {	 
      if (node == null) {
	 return 0;
      }
	
      LinkedList<Node> nodes = new LinkedList<Node>();
      LinkedList<Integer> depths = new LinkedList<Integer>();
    
      nodes.add(node);
      depths.add(1);
    
      while(!nodes.isEmpty()) {
        Node current = nodes.remove();
        int depth = depths.remove();	
      
        if(current.left == null && current.right == null) {
          return depth;
        }
      
        if(current.left != null) {
          nodes.add(current.left);
          depths.add(depth + 1);
        }
      
        if(current.right != null) {
          nodes.add(current.right);
          depths.add(depth + 1);
        }	
      }

      return 0;
    }
  
    public int minimumDepth1(Node root) {
      // called on root = NULL
      if (root == null) {
         return 0;
      }

      // Base case : Leaf Node. This accounts for height = 1.
      if (root.left == null && root.right == null) {
         return 1;
      }

      // If left subtree is NULL, recur for right subtree
      if (root.left == null) {
         return minimumDepth1(root.right) + 1;
      }

      // If right subtree is NULL, recur for right subtree
      if (root.right == null) {
         return minimumDepth1(root.left) + 1;
      }

      return Math.min(minimumDepth1(root.left), minimumDepth1(root.right)) + 1;     	
    }  

    public static void main(String[] args) { 
      MinimumDepthBinaryTree tree = new MinimumDepthBinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
	  
      System.out.println("The minimum depth of "+ "binary tree is : " + tree.minimumDepth(tree.root));
    }
  }
