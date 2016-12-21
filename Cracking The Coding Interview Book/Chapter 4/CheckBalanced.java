import java.util.*;

 public class CheckBalanced {    
     static Node root;	    
     static Node previous;
	
   public static int checkHeight(Node root) {
      if(root == null) {
	return -1;
      }
	  
      int leftHeight = checkHeight(root.left);
	 
      if(leftHeight == Integer.MIN_VALUE) {
	 return Integer.MIN_VALUE;	 
      }
	 
      int rightHeight = checkHeight(root.right);
	 
      if(rightHeight == Integer.MIN_VALUE) {
	 return Integer.MIN_VALUE;	 
      }
	 
      int heightDifference = leftHeight - rightHeight;
	 
      if(Math.abs(heightDifference) > 1) {
	 return Integer.MIN_VALUE;	 
      } else {
	 return Math.max(leftHeight, rightHeight) + 1;	  
      }
   }	
   
   static boolean isBalanced(Node root) {
       return checkHeight(root) != Integer.MIN_VALUE; 
   }
	 
    public static void main(String[] args) { 
        CheckBalanced tree = new CheckBalanced();
	tree.root = new Node(3);
	tree.root.left = new Node(5);
	tree.root.right = new Node(2);
	tree.root.left.left = new Node(1);
	tree.root.left.right = new Node(4);
	tree.root.right.left = new Node(6);
	  
	boolean isBalanced = isBalanced(tree.root);
	if(isBalanced) {
          System.out.println("Tree is balanced");
	} else {
          System.out.println("Tree is not balanced");
        } 	  
     }
 } 
