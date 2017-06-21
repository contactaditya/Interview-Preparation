import java.util.*;
import java.io.*;
  
  class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;
     BinaryTreeNode nextRight;
	   
     public BinaryTreeNode(int item) {
	data = item;
	left = right = nextRight = null;
     } 
  }

  public class ConnectNodesAtSameLevelInABinaryTree {
      BinaryTreeNode root;	    
      BinaryTreeNode previous;
	 
      public static void connect(BinaryTreeNode node) {
	// Set the nextRight for root
	node.nextRight = null;
	  
        // Set the next right for rest of the nodes (other than root)
	connectRecursion(node);
      }
	 
      public static void connectRecursion(BinaryTreeNode node) {
	 // Base case
	 if (node == null) {
	   return;
	 }
	    
	 if (node.left != null) {
           node.left.nextRight = node.right;
	 }
		  
	 if(node.right != null) {
	    node.right.nextRight = (node.nextRight != null) ? node.nextRight.left : null;
	 }
		
	 connectRecursion(node.left);
	 connectRecursion(node.right);
     }	 
	 
  public static void main(String[] args) { 
      ConnectNodesAtSameLevelInABinaryTree tree = new ConnectNodesAtSameLevelInABinaryTree();
      tree.root = new BinaryTreeNode(10);
      tree.root.left = new BinaryTreeNode(8);
      tree.root.right = new BinaryTreeNode(2);
      tree.root.left.left = new BinaryTreeNode(3);
      
      tree.connect(tree.root);
		
      System.out.println("Following are populated nextRight pointers in " + "the tree" + "(-1 is printed if there is no nextRight): ");
      int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
      System.out.println();
      System.out.println("nextRight of " + tree.root.data + " is " + a);
      int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
      System.out.println();
      System.out.println("nextRight of " + tree.root.left.data + " is " + b);
      int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
      System.out.println();
      System.out.println("nextRight of " + tree.root.right.data + " is " + c);
      int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
      System.out.println();
      System.out.println("nextRight of " + tree.root.left.left.data + " is " + d);
  }
}
