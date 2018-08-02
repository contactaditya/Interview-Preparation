import java.util.*;
import java.io.*;

  public class BinaryTreePruning {
	Node root;
	
    public Node pruneTree(Node root) {
      return containsOne(root) ? root : null;  
    }
    
    private boolean containsOne(Node node) {
      if (node == null) {
    	return false;
      }
      boolean a1 = containsOne(node.left);
      boolean a2 = containsOne(node.right);
      if (!a1) {
    	node.left = null;
      }
      if (!a2) {
    	node.right = null;
      }
		
      return node.data == 1 || a1 || a2;
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
	  BinaryTreePruning tree = new BinaryTreePruning();
	  tree.root = new Node(1);
	  tree.root.left = new Node(1);
	  tree.root.right = new Node(0);
	  tree.root.left.left = new Node(1);
	  tree.root.left.left.left = new Node(0);
	  tree.root.left.right = new Node(1);   
	  tree.root.right.left = new Node(0);
	  tree.root.right.right = new Node(1);
	  
	  tree.root = tree.pruneTree(tree.root);
	  System.out.print("The tree where every subtree (of the given tree) not containing a 1 has been removed in pre order form is: ");
	  tree.printPreorderTraversal(tree.root);		
	}
  }
