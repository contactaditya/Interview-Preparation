import java.util.*;
import java.io.*;

   public class CountTreeNodesInACompleteBinaryTree {
      Node root;	    
      Node previous;
	    
      public int countNodes(Node root) {	 
	if (root == null) {
	  return 0;
	}
	   
	int leftHeight = findLeftHeight(root);
	int rightHeight = findRightHeight(root);
	   
	if (leftHeight == rightHeight) {
          return (2 << (leftHeight-1)) - 1;
        }
	
	return countNodes(root.left) + countNodes(root.right) + 1;
      }
 
      private int findLeftHeight(Node root) {
	 if (root == null) {
	   return 0;
	 }
	        
	 int height = 1;
	        
	 while (root.left != null) {
	    height++;
	    root = root.left;
	 }
	        
	 return height;
      }

      private int findRightHeight(Node root) { 	   
	 if (root == null) {
	   return 0;
	 }
	        
	 int height = 1;
	        
	 while (root.right != null) {
	   height++;
	   root = root.right;
	 }
	        
	 return height;
      } 

      public static void main(String[] args) {   
	CountTreeNodesInACompleteBinaryTree tree = new CountTreeNodesInACompleteBinaryTree();
	tree.root = new Node(1);
	tree.root.left = new Node(2);
	tree.root.right = new Node(3);
	tree.root.left.left = new Node(4);
	tree.root.left.right = new Node(5);
	         
        System.out.println("The number of nodes in the complete binary tree are: " + tree.countNodes(tree.root));
      }
   }
