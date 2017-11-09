import java.util.*;
import java.io.*;

 public class FindBottomLeftTreeValue { 
	Node root;
	 
	public int findBottomLeftValue(Node root) {
	   return findBottomLeftValue(root, 1, new int[]{0,0});     
	}	 

	private int findBottomLeftValue(Node root, int depth, int result[]) {
	   if (result[1]<depth) {
	     result[0] = root.data;
	     result[1] = depth;
	   }
	   if (root.left != null) {
		 findBottomLeftValue(root.left, depth+1, result);
	   }
	   if (root.right!=null) {
		 findBottomLeftValue(root.right, depth+1, result);
	   }
	   return result[0];	
	}

	public static void main(String[] args) {       
	  FindBottomLeftTreeValue tree = new FindBottomLeftTreeValue();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.left = new Node(4);
	  tree.root.right.left = new Node(5);
	  tree.root.right.right = new Node(6);
	  tree.root.right.left.left = new Node(7);
    
	  int bottomLeftValue = tree.findBottomLeftValue(tree.root);
	  System.out.println("The leftmost value in the last row of the tree is " + bottomLeftValue);

	}
 }
