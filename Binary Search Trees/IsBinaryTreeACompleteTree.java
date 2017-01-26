import java.io.*;
import java.util.*;

 public class IsBinaryTreeACompleteTree { 
    Node root;	    
    Node previous;
	
    public int getNodeCount(Node node) {
		 
       if (node == null) {
	  return 0;
       }
	 
       return (1 + getNodeCount(node.left) + getNodeCount(node.right));   	
    }
	
    public boolean isComplete(Node node, int index, int nodeCount) {
		 
       if (node == null) {
	  return true;
       }
       
       // If index assigned to current node is more than number of nodes in tree, then tree is not complete
       if (index >= nodeCount) {
          return false;
       }
        
      return (isComplete(root.left, 2 * index + 1, nodeCount) && isComplete(root.right, 2 * index + 2, nodeCount));  	
    }

 public static void main(String[] args) {   
      IsBinaryTreeACompleteTree tree = new IsBinaryTreeACompleteTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.right = new Node(5);
      tree.root.left.left = new Node(4);
      tree.root.right.right = new Node(6);
      
      int index = 0;  
      int nodeCount = tree.getNodeCount(tree.root);
      
      if(tree.isComplete(tree.root, index, nodeCount)) {
    	System.out.println("The binary tree is complete.");  
      }
      else {
    	System.out.println("The binary tree is not complete.");    
      }
      
   }
 }
