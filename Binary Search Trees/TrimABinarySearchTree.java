import java.util.*;
import java.io.*;

  public class TrimABinarySearchTree {
    Node root;	    
    Node previous;
		    
    public Node trimBST(Node root, int left, int right) {       
      if(root == null) {
	return null;
      }
       
      if (root.data < left) {
    	return trimBST(root.right, left, right);
      }
      if (root.data > right) {
    	return trimBST(root.left, left, right);
      }
       
      root.left = trimBST(root.left, left, right);
      root.right = trimBST(root.right, left, right);
	        
      return root;
    }
	
    public void printInorderTraversal(Node node) {		 
      if(node == null) {
	return;
      }
			 
      printInorderTraversal(node.left);
      System.out.print(node.data + " ");	
      printInorderTraversal(node.right);
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
      TrimABinarySearchTree tree = new TrimABinarySearchTree();
      tree.root = new Node(3);
      tree.root.left = new Node(0);
      tree.root.right = new Node(4);
      tree.root.left.right = new Node(2);
      tree.root.left.right.left = new Node(1);
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the lowest boundary of the binary search tree: ");
      int left = input.nextInt();  
      System.out.println();
      System.out.print("Enter the highest boundary of the binary search tree: ");
      int right = input.nextInt();  
      Node newRoot = tree.trimBST(tree.root, left, right);		
      System.out.println();	     
      System.out.println("The new root of the trimmed binary search tree is: " + newRoot.data);	
      System.out.println();	  
      System.out.print("Inorder traversal of the trimmed binary search tree is: ");
      tree.printInorderTraversal(newRoot);		
      System.out.println();
      System.out.println();
      System.out.print("Preorder traversal of the trimmed binary search tree is: ");
      tree.printPreorderTraversal(newRoot);	  
    }
  }
