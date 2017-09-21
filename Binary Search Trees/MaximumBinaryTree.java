import java.util.*;
import java.io.*;

 public class MaximumBinaryTree {
	Node root;	    
	Node previous; 
	 
	public Node constructMaximumBinaryTree(int[] array) {
	   return construct(array, 0, array.length);    
	}
	
	private Node construct(int[] array, int left, int right) {
	   if(left == right) {
		 return null;
	   } 
	   
	   int currentMax = max(array, left, right);
       Node root = new Node(array[currentMax]);
       root.left = construct(array, left, currentMax);
       root.right = construct(array, currentMax + 1, right);
      
	   return root;
	}

	private int max(int[] array, int left, int right) {
	   int currentMax = left;
	   for (int i = left; i < right; i++) {
	     if (array[i] > array[currentMax]) {
	        currentMax = i;
	     }
	   }
	   return currentMax;
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
	   MaximumBinaryTree tree = new MaximumBinaryTree();
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int number = input.nextInt();  
       int array[] = new int[number];
		  
	   System.out.println();	
	   System.out.print("Please enter number: ");
	   for (int i = 0; i < array.length; i++) {
		 array[i] = input.nextInt();
	   }
		   
	   Node current = tree.constructMaximumBinaryTree(array);
	   System.out.println();
	   System.out.print("Inorder traversal of the constructed maximum binary tree is: ");
	   tree.printInorderTraversal(current);		
	   System.out.println();
	   System.out.println();
	   System.out.print("Preorder traversal of the constructed maximum binary tree is: ");
	   tree.printPreorderTraversal(current);	
	}
 }
