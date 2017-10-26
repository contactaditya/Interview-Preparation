import java.util.*;
import java.io.*;

  public class ConvertBSTToGreaterTree {
	Node root;	    
	Node previous;

	public Node convertBST(Node node) {
	  dfs(node, 0);
	     
	  return node;
	}	
	  
	private int dfs(Node node, int value) {
	  if(node == null) {
		return value;
	  }
	  int right = dfs(node.right, value);
	  int left = dfs(node.left, node.data + right);
	  node.data = node.data + right;
	    
	  return left;	
	}

	public void printInorderTraversal(Node node) {
	   if (node == null) {
		 return;
	   }
		 
	   printInorderTraversal(node.left);
	   System.out.print(node.data + " ");	
	   printInorderTraversal(node.right);
	}  

	public static void main(String[] args) {
	  ConvertBSTToGreaterTree tree = new ConvertBSTToGreaterTree();
	  tree.root = new Node(5);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(13);
	      
	  Node node = tree.convertBST(tree.root);
		     
	  System.out.print("Inorder Traversal of the resultant tree is: ");
	  tree.printInorderTraversal(node);	
    }
  }
