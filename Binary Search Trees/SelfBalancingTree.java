import java.util.*;
import java.io.*;

 class AVLNode {
   int data;
   int height;
   AVLNode left;
   AVLNode right;
		   
   public AVLNode(int item) {
     data = item;
     int height = 1;
     left = right = null;
   }
 }

 public class SelfBalancingTree {
   AVLNode root;	    
   AVLNode previous;
   
   public int getBalance(AVLNode node) {
     if(node == null) {	   
	return 0;   
     }    	            
	 
     return height(node.left) - height(node.right);  
   }
   
   public int height(AVLNode node) {
     if(node == null) {	   
       return 0;   
     }    	            
	
     return node.height;  
   }   
   
   public AVLNode rightRotate(AVLNode y) {
     AVLNode x = y.left;
     AVLNode T2 = x.right;

     // Perform rotation
     x.right = y;
     y.left = T2;

     // Update heights
     y.height = Math.max(height(y.left), height(y.right)) + 1;
     x.height = Math.max(height(x.left), height(x.right)) + 1;

     return x;  
   }   
   
   public AVLNode leftRotate(AVLNode x) {
     AVLNode y = x.right;
     AVLNode T2 = y.left;

     // Perform rotation
     y.left = x;
     x.right = T2;

     // Update heights
     x.height = Math.max(height(x.left), height(x.right)) + 1;
     y.height = Math.max(height(y.left), height(y.right)) + 1;

     return y;     
   }  
   
   public AVLNode insert(AVLNode root, int value) {
     if(root == null) {	   
       AVLNode node = new AVLNode(value);
       root = node;
     }    	          
     if (root.data > value) {    
       root.left = insert(root.left, value);
     }
     else if (root.data < value) { 
       root.right = insert(root.right, value);
     } 
     else {
       return root;	 
     }
	 
     /* Update height of this ancestor node */
     root.height = 1 + Math.max(height(root.left), height(root.right));
	 
     /* Get the balance factor of this ancestor node to check whether this node became unbalanced */
     int balance = getBalance(root);
	 
     // If this node becomes unbalanced, then there are 4 cases:
	 
     // Left Left Case y is left child of z and x is left child of y 
     if (balance > 1 && value < root.left.data) {
       return rightRotate(root); 
     }
	 
     // Right Right Case y is right child of z and x is right child of y 
     if (balance < -1 && value > root.right.data) {
       return leftRotate(root); 
     }
	 
     // Left Right Case  y is left child of z and x is right child of y
     if (balance > 1 && value > root.left.data) {
       root.left = leftRotate(root.left); 
       return rightRotate(root); 
     }
	 
     // Right Left Case y is right child of z and x is left child of y
     if (balance < -1 && value < root.right.data) {
       root.right = rightRotate(root.right);  
       return leftRotate(root); 
     }
	 
     return root;   
   }
   
   public void printInorderTraversal(AVLNode node) {		 
     if (node == null) {
       return;
     }
	 
     printInorderTraversal(node.left);
     System.out.print(node.data + " ");	
     printInorderTraversal(node.right);
   }
				
   public static void main(String[] args) {  
     SelfBalancingTree tree = new SelfBalancingTree();
     tree.root = tree.insert(tree.root, 3);
     tree.root = tree.insert(tree.root, 2);
     tree.root = tree.insert(tree.root, 4);
     tree.root = tree.insert(tree.root, 5);
	     
     System.out.print("Inorder traversal of binary tree is: ");
     tree.printInorderTraversal(tree.root);	
   }
 }
