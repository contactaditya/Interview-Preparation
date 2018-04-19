import java.util.*;
import java.io.*;

   public class FlattenBinaryTreeToLinkedList { 
     static Node root;	    
     static Node previous;
	 
     public static void getFlatten(Node root) {
       if(root == null) {
	 return; 
       }
		  
       Node left = root.left;
       Node right = root.right;
        
       root.left = null;
       getFlatten(left);
       getFlatten(right);
        
       root.right=left;
       Node current = root;
       while(current.right !=null) {
         current = current.right;
       }
        
       current.right = right;
     }
	 
     public static void getFlatten1(Node root) {
       if(root == null) {
	 return; 
       }
			  
       Stack<Node> stack = new Stack<Node>();
       stack.push(root);
        
       while (!stack.empty()) {
         Node node = stack.pop();
         if (node.right != null) {
           stack.push(node.right);
         }
         if (node.left != null) {
           stack.push(node.left);
         }
          
         node.left = null;
         if (stack.empty()) {
           node.right = null;
         } else {
           node.right = stack.peek();
         } 
       }
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
       FlattenBinaryTreeToLinkedList tree = new FlattenBinaryTreeToLinkedList();
       tree.root = new Node(1);
       tree.root.left = new Node(2);
       tree.root.right = new Node(5);
       tree.root.left.left = new Node(3);
       tree.root.left.right = new Node(4);
       tree.root.right.right = new Node(6);
		     
       tree.getFlatten(tree.root);	
       System.out.print("Inorder traversal of binary tree is: ");
       tree.printInorderTraversal(tree.root);		
     }
   }
