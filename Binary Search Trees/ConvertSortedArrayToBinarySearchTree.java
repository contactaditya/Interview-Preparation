import java.util.*;
import java.io.*;

  public class ConvertSortedArrayToBinarySearchTree {
	Node root;	    
	Node previous;
	  
	public static Node sortedArrayToBST(int[] array) {
	   if (array.length == 0) {
		  return null;
	   }	
		
	   return sortedArrayToBST(array, 0, array.length - 1);    
	}	  
 
	private static Node sortedArrayToBST(int[] array, int start, int end) {
	  if (start > end) {
	    return null;
	  }
 
	  int mid = (start + end) / 2;
	  Node root = new Node(array[mid]);
	  root.left = sortedArrayToBST(array, start, mid - 1);
	  root.right = sortedArrayToBST(array, mid + 1, end);
 
	  return root;
	}
	
	public static void printInorderTraversal(Node node) { 
	  if (node == null) {
		return;
	  }
			 
	  printInorderTraversal(node.left);
	  System.out.print(node.data + " ");	
	  printInorderTraversal(node.right);
	}

	public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int number = input.nextInt();  
	   int array[] = new int[number];
			
	   System.out.println();	
	   System.out.print("Please enter the elements of the array: ");
	   for (int i = 0; i < array.length; i++) {
		 array[i] = input.nextInt();
	   }
	   
	   Arrays.sort(array);
			  
	   Node node = sortedArrayToBST(array);
	   System.out.println();	
	   System.out.print("Inorder traversal of constructed tree is: ");
	   printInorderTraversal(node);		
	}
  }
