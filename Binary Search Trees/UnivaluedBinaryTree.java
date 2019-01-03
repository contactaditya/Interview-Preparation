import java.util.*;
import java.io.*;

  public class UnivaluedBinaryTree { 
	Node root;	    
	Node previous;
	  
	public static boolean isUnivalTree(Node root) {
	  return isUnivalTree(root, root.data);
	}	  

	private static boolean isUnivalTree(Node root, int value) {
	  if (root == null) { 
	    return true; 
	  }
	        
	  if (root.data != value) { 
		return false; 
	  }
	  
	  return isUnivalTree(root.left, value) && isUnivalTree(root.right, value);
	}

	public static void main(String[] args) { 	  
	  UnivaluedBinaryTree tree = new UnivaluedBinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(1);
	  tree.root.right = new Node(1);
	  tree.root.left.left = new Node(1);
	  tree.root.left.right = new Node(1);
	  tree.root.right.right = new Node(1);

	  boolean isUnivalTree = isUnivalTree(tree.root);
	  
	  if(isUnivalTree) {
		System.out.println("The given binary tree is univalued.");
	  } else {
        System.out.println("The given binary tree is not univalued.");
      }	  
	}
  }
