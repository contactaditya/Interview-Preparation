import java.util.*;
import java.io.*;

  public class CheckCompletenessOfABinaryTree { 
	Node root;	    
	Node previous;
	
	public boolean isCompleteTree(Node root) {
	  return isCompleteTree(root, 0, getNodeCount(root));
	}	
	  
	public boolean isCompleteTree(Node root, int index, int nodeCount) {
	  if (root == null) {
		return true;
	  }
	  
	  // If index assigned to current node is more than number of nodes in tree, then tree is not complete
	  if (index >= nodeCount) {
	    return false;
	  }
	        
	  return (isCompleteTree(root.left, 2 * index + 1, nodeCount) && isCompleteTree(root.right, 2 * index + 2, nodeCount));  
    }

	private int getNodeCount(Node node) {
	  if (node == null) {
		return 0;
	  }
			 
	  return (1 + getNodeCount(node.left) + getNodeCount(node.right));   
	}

	public static void main(String[] args) {   
	  CheckCompletenessOfABinaryTree tree = new CheckCompletenessOfABinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.left = new Node(4);
	  tree.root.left.right = new Node(5);
	  tree.root.right.left = new Node(6);
	  
	  boolean isCompleteTree = tree.isCompleteTree(tree.root);
	  if(isCompleteTree) {
       System.out.println("The binary tree is complete tree.");
	  } else {
       System.out.println("The binary tree is not a complete tree.");
      }	  
	}
  }
