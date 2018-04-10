import java.util.*;
import java.io.*;

  public class ConstructBinaryTreeFromPostorderAndInorder { 
     Node root;	    
     Node previous;
	 
     public Node buildTree(int inOrder[], int postOrder[], int inStart, int inEnd, int postStart, int postEnd) {
       if (inStart > inEnd || postStart > postEnd) {
	 return null;  
       }
	    	    	    
       // Pick current node from Preorder traversal using postIndex and decrement postIndex 
       Node node = new Node(postOrder[postEnd]);
		 
       // If this node has no children then return    
       if (inStart == inEnd) {
         return node;  
       } 
	   
       // Else find the index of this node in Inorder traversal    
       int inOrderIndex = search(inOrder, inStart, inEnd, node.data);
	   
       // Using index in Inorder traversal, construct left and right subtress 
       node.left = buildTree(inOrder, postOrder, inStart, inOrderIndex - 1, postStart, postStart + inOrderIndex - (inStart + 1));
       node.right = buildTree(inOrder, postOrder, inOrderIndex + 1, inEnd, postStart + inOrderIndex- inStart, postEnd - 1);
	    
       return node;
     }
	 
     public int search(int array[], int start, int end, int data) {
       int i;
       for(i = start; i <= end; i++) {
	 if (array[i] == data) {
           return i;  
	 }
       }
       return -1;
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
       ConstructBinaryTreeFromPostorderAndInorder tree = new ConstructBinaryTreeFromPostorderAndInorder();	
       int inOrder[] = {4, 8, 2, 5, 1, 6, 3, 7};
       int postOrder[] = {8, 4, 5, 2, 6, 7, 3, 1};
	        
       Node node = tree.buildTree(inOrder, postOrder, 0, inOrder.length-1, 0, postOrder.length-1);
	  
       System.out.print("Preorder traversal of constructed tree is: ");
       tree.printPreorderTraversal(node);		
     }
  }
