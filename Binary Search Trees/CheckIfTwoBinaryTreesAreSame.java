import java.util.*;
import java.io.*;

 public class CheckIfTwoBinaryTreesAreSame {     
	private static Node root1;	
    private static Node root2;		    
    private static Node previous = null;	

    public boolean isSameTree(Node t1, Node t2) {
       if (t1 == null && t2 == null) { 
    	 return true;
       }
       if (t1 == null || t2 == null) {
	     return false;
       }
       
       return (t1.data == t2.data) && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

	public static void main(String[] args) {
	  CheckIfTwoBinaryTreesAreSame tree = new CheckIfTwoBinaryTreesAreSame();
	  tree.root1 = new Node(1);
	  tree.root1.left = new Node(2);
      tree.root1.right = new Node(3);
	  tree.root1.left.left = new Node(4);
	  tree.root1.left.right = new Node(5);
		   
	  tree.root2 = new Node(1);
	  tree.root2.left = new Node(2);
	  tree.root2.right = new Node(3);
	  tree.root2.left.left = new Node(4);
	  tree.root2.left.right = new Node(5);
		 
	  if (tree.isSameTree(tree.root1, tree.root2) == true) {
		System.out.println("The two binary trees are equal.");
	  }
	  else {
		System.out.println("The two binary trees are not equal.");
	  }
	}
 }
