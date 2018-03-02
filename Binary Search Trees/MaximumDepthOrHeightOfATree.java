import java.util.*;
import java.io.*;

  public class MaximumDepthOrHeightOfATree {
    Node root;	    
    Node previous;  
	  
    public int maximumDepth(Node root) {
       // called on root = NULL
       if (root == null) {
	 return 0;
       }
	    
       return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;     	
    }  
	  
    public static void main(String[] args) {
       MaximumDepthOrHeightOfATree tree = new MaximumDepthOrHeightOfATree();
       tree.root = new Node(1);
       tree.root.left = new Node(2);
       tree.root.right = new Node(3);
       tree.root.left.left = new Node(4);
       tree.root.left.right = new Node(5);
		  
       System.out.println("The maximum depth of binary tree is : " + tree.maximumDepth(tree.root));
    }
  }
