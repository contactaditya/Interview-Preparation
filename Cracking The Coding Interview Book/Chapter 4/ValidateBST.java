import java.util.*;

 public class ValidateBST {
   static Node root;	    
   static Node previous;
	 
   public static boolean checkBST(Node node) {
      return checkBST(node, null, null); 
   }
   
   public static boolean checkBST(Node node, Integer min, Integer max) {
      if(node == null) {
	return true; 
      }
	  
      if((min != null && node.data <= min) || (max != null && node.data > max)) {
	return false;
      }
	  
      if(!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)) {
	return false;
      }   
      return true;
   }

   public static void main(String[] args) { 	  
     ValidateBST tree = new ValidateBST();
     tree.root = new Node(4);
     tree.root.left = new Node(2); 
     tree.root.right = new Node(5);
     tree.root.left.left = new Node(1);
     tree.root.left.right = new Node(3);
  
     boolean checkBST = checkBST(tree.root);
	  
     if(checkBST) {
       System.out.println("Tree is a binary search tree.");
     } else {
       System.out.println("Tree is not a binary search tree.");
     }	  
   }
 }
