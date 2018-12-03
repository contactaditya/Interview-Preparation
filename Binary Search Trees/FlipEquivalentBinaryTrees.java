import java.util.*;
import java.io.*;

  public class FlipEquivalentBinaryTrees { 	
	private Node root1;	
    private Node root2;		    
	  
	public boolean flipEquivalent(Node root1, Node root2) {   
	  if (root1 == root2) { 
		return true;
	  }
	  if (root1 == null || root2 == null || root1.data != root2.data) {
		return false;
	  }
		
	  return flipEquivalent(root1.left, root2.left) && flipEquivalent(root1.right, root2.right) || flipEquivalent(root1.left, root2.right) && flipEquivalent(root1.right, root2.left);         
	}

	public static void main(String[] args) { 	   
	  FlipEquivalentBinaryTrees tree = new FlipEquivalentBinaryTrees();
	  tree.root1 = new Node(1);
	  tree.root1.left = new Node(2);
	  tree.root1.right = new Node(3);
	  tree.root1.left.left = new Node(4);
	  tree.root1.left.right = new Node(5);
	  tree.root1.right.left = new Node(6);
	  tree.root1.left.right.left = new Node(7);
	  tree.root1.left.right.right = new Node(8);
	  
	  tree.root2 = new Node(1);
	  tree.root2.left = new Node(3);
	  tree.root2.right = new Node(2);
	  tree.root2.right.left = new Node(4);
	  tree.root2.right.right = new Node(5);
	  tree.root2.left.right = new Node(6);
	  tree.root2.right.right.left = new Node(8);
	  tree.root2.right.right.right = new Node(7);
	 
	  if (tree.flipEquivalent(tree.root1, tree.root2)) {
	    System.out.println("The two binary trees are flip equivalent.");
	  }
	  else {
	    System.out.println("The two binary trees are not flip equivalent.");
	  }
	}
  }
