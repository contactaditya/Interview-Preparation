import java.util.*;
import java.io.*;

  public class ConvertBSTToGreaterTree {
    Node root;	    
    Node previous;
    int sum = 0;

    public Node convertBST(Node root) {
      if (root != null) {
        convertBST(root.right);
        sum += root.data;
        root.data = sum;
        convertBST(root.left);     
      }
      return root;
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
