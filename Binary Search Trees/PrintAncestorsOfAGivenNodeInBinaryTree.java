import java.io.*;
import java.util.*;

 public class PrintAncestorsOfAGivenNodeInBinaryTree {   
	Node root;	    
	Node previous;

 public boolean printAncestors(Node node, int target) {
		 
	if (node == null) {
	  return false;
	}
	 
	if (node.data == target) {
      return true;	 
	}
	 
	if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
      System.out.print(node.data + " ");
      return true;
    }

	return false;
 } 

	public static void main(String[] args) {   	
	  PrintAncestorsOfAGivenNodeInBinaryTree tree = new PrintAncestorsOfAGivenNodeInBinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      tree.root.left.left.left = new Node(7);
      
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the key of the binary tree whose ancestor you want to find: ");
	  int key = input.nextInt();   
	  System.out.println();   
	  System.out.print("The Ancestors of the key " + key + " of the binary tree are: ");
	  tree.printAncestors(tree.root, key);			
		
	}
  }
