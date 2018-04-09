import java.io.*;
import java.util.*;

  public class SortedArrayToBalancedBST { 
    static Node root;	    
    static Node previous;
 
    public static Node sortedArrayToBST(int array[], int start, int end) {
      if (start > end) {
        return null;
      }
	
      /* Get the middle element and make it root */
      int mid = (start + end) / 2;
      Node node = new Node(array[mid]);
	 
      /* Recursively construct the left subtree and make it left child of root */
      node.left = sortedArrayToBST(array, start, mid - 1);
    
      /* Recursively construct the right subtree and make it right child of root */
      node.right = sortedArrayToBST(array, mid + 1, end);
    
      return node; 
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
      SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int n = input.nextInt();
      int array[] = new int[n];
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0; i < n; i++) {
        array[i] = input.nextInt();
      }
	  
      root = sortedArrayToBST(array, 0, n - 1);
	  
      System.out.println();
      System.out.print("Preorder traversal of binary tree is: ");
      tree.printPreorderTraversal(root);		
    }
  }
