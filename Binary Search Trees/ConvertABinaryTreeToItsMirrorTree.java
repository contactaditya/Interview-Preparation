import java.util.*;
import java.io.*;

 public class ConvertABinaryTreeToItsMirrorTree {   
   static Node root;	    
	 
   public Node mirror(Node node) {	  	
      if (node == null) {
	 return node;
      }
	   
      /* do the subtrees */
      Node left = mirror(node.left);
      Node right = mirror(node.right);
		      
      /* swap the left and right pointers */
      node.left = right;
      node.right = left;
       
      return node;
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
      ConvertABinaryTreeToItsMirrorTree tree = new ConvertABinaryTreeToItsMirrorTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
	  
      System.out.print("Inorder traversal of binary tree is: ");
      tree.printInorderTraversal(tree.root);		
      System.out.println();	
	  
      tree.mirror(root);
	  
      System.out.println();	
      System.out.print("Inorder traversal of binary tree is: ");
      tree.printInorderTraversal(tree.root);		
	  
   }
 }
