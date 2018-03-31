import java.io.*;
import java.util.*;

 public class MaximumWidthOfABinaryTree { 
    Node root;	    
    Node previous;
 
    public int getMaximumWidth(Node node) {
      int width;
      int height = height(node);
	  
      // Create an array that will store count of nodes at each level
      int count[] = new int[10];
      
      int level = 0;
      
      // Fill the count array using preorder traversal
      getMaximumWidth(node, count, level);
      
      // Return the maximum value from count array
      return getMax(count, height);
    } 
	
    public void getMaximumWidth(Node node, int count[], int level) {
      if (node != null) {
        count[level]++;
        getMaximumWidth(node.left, count, level + 1);
        getMaximumWidth(node.right, count, level + 1);
      }
    } 
	
    public int height(Node node) {
      if (node == null) {
        return 0;
      }
      else {
        /* compute the height of each subtree */
        int lHeight = height(node.left);
        int rHeight = height(node.right); 
          
        /* use the larger one */
        return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
      }
    } 
	
    public int getMax(int array[], int number) {
      int max = array[0];
      int i;
      for (i = 0; i < number; i++) {
        if (array[i] > max) {
	  max = array[i];
        }
      }
      return max;
    } 

   public static void main(String[] args) {
     MaximumWidthOfABinaryTree tree = new MaximumWidthOfABinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.right.right = new Node(8);
     tree.root.right.right.left = new Node(6);
     tree.root.right.right.right = new Node(7);
	   
     int maximumWidth = tree.getMaximumWidth(tree.root);		
     System.out.print("Maximum width of binary tree is: " + maximumWidth);   
   }
 }
