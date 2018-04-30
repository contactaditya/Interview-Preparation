import java.util.*;
import java.io.*;

  public class MergeTwoBinaryTrees {
    private static Node root1;	
    private static Node root2;	
    private static Node previous = null;	 
		
    public Node mergeTrees(Node t1, Node t2) {
      if (t1 == null) {
	return t2;
      }
      if (t2 == null) {
	return t1;
      }
	   
      t1.data += t2.data;
      t1.left = mergeTrees(t1.left, t2.left);
      t1.right = mergeTrees(t1.right, t2.right);
      return t1;     
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
      MergeTwoBinaryTrees tree = new MergeTwoBinaryTrees();
      tree.root1 = new Node(1);
      tree.root1.left = new Node(3);
      tree.root1.right = new Node(2);
      tree.root1.left.left = new Node(5);

      tree.root2 = new Node(2);
      tree.root2.left = new Node(1);
      tree.root2.right = new Node(3);

      Node current = tree.mergeTrees(tree.root1, tree.root2);
      System.out.print("Inorder traversal of the constructed maximum binary tree is: ");
      tree.printInorderTraversal(current);		
      System.out.println();
      System.out.println();
      System.out.print("Preorder traversal of the constructed maximum binary tree is: ");
      tree.printPreorderTraversal(current);	
    }
  }
