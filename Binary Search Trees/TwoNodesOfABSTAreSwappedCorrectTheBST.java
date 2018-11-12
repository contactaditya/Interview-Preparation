import java.util.*;
import java.io.*;

  public class TwoNodesOfABSTAreSwappedCorrectTheBST { 
	Node root;	    
	Node first, middle, last, previous;
	  
	public void correctBST(Node root) {
	  first = middle = last = previous = null; 	  
	  correctBSTUtil(root);
	  if(first != null && last != null) {
		int temp = first.data; 
        first.data = last.data; 
        last.data = temp;    
	  } else if(first != null && middle != null) { 
	  	int temp = first.data; 
	    first.data = middle.data; 
		middle.data = temp; 
	  } 
	}
	
	private void correctBSTUtil(Node root) {
      if(root != null) {
    	correctBSTUtil(root.left); 	
    	if (previous != null && root.data < previous.data) { 
    	  if (first == null) { 
            first = previous; 
            middle = root; 
          } 	
    	  else {
    		last = root;
    	  }
    	}
    	previous = root; 
    	correctBSTUtil(root.right); 	
      }	
	}

	public void printInorderTraversal(Node node) {		 
	  if(node == null) {
		return;
	  }
				 
	  printInorderTraversal(node.left);
	  System.out.print(node.data + " ");	
	  printInorderTraversal(node.right);
	}
	
	public static void main(String[] args) { 	  
	  TwoNodesOfABSTAreSwappedCorrectTheBST tree = new TwoNodesOfABSTAreSwappedCorrectTheBST();
	  tree.root = new Node(6);
	  tree.root.left = new Node(10);
	  tree.root.right = new Node(2);
	  tree.root.left.left = new Node(1);
	  tree.root.left.right = new Node(3);
	  tree.root.right.right = new Node(12);
	  tree.root.right.left = new Node(7);
	  
	  System.out.print("Inorder traversal of the original binary search tree is: ");
	  tree.printInorderTraversal(tree.root);		
	  System.out.println();	  

	  tree.correctBST(tree.root);		
	  
	  System.out.println();	  
	  System.out.print("Inorder traversal of the fixed binary search tree is: ");
	  tree.printInorderTraversal(tree.root);		
	}
  }
