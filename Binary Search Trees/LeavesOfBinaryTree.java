import java.util.*;
import java.io.*;

 public class LeavesOfBinaryTree {
     Node root;	    
     Node previous;
	
   public Node leavesOfBinaryTree(Node node, List<Integer> leaves) {
		 
       if (node == null) {
	  return null;
       }
	
       if (node.left == null && node.right == null) {
          leaves.add(node.data);
          return null;
       }	 
       node.left = leavesOfBinaryTree(node.left, leaves);
       node.right = leavesOfBinaryTree(node.right, leaves);
	
     return node;    
   }
   
   public List<List<Integer>> findLeaves(Node node) {
		 
      if (node == null) {
	 return Collections.EMPTY_LIST;
      }
	 
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> leaves = new ArrayList<>();
	
      while (leavesOfBinaryTree(root, leaves) != null) {
         result.add(leaves);
         leaves = new ArrayList<>();
      }
       result.add(leaves);
     return result;
   }	

   public static void main(String[] args) {  
      LeavesOfBinaryTree tree = new LeavesOfBinaryTree();
      tree.root = new Node(20);
      tree.root.left = new Node(8);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(12);
      tree.root.left.right.left = new Node(10);
      tree.root.left.right.right = new Node(14);
      tree.root.right = new Node(22);
      tree.root.right.right = new Node(25);
   
      List<List<Integer>> leaves = new ArrayList<>();
     
      leaves = tree.findLeaves(tree.root);
     
      System.out.print("The leaves of the binary tree until the tree is empty are: "); 
     
      for (List<Integer> list : leaves) {
    	 System.out.print(list + " "); 
      }
    	
     System.out.println();
        
   }
}
