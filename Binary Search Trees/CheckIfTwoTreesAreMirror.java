import java.util.*;
import java.io.*;

  public class CheckIfTwoTreesAreMirror { 	 
     private static Node root1;	
	 private static Node root2;		    
	 private static Node previous = null;	
 
	 public boolean areMirror(Node t1, Node t2) {
	   if (t1 == null && t2 == null) { 
		 return true;
	   }
	   if (t1 == null || t2 == null) {
		 return false;
	   }
   
	   return (t1.data == t2.data) && areMirror(t1.right, t2.left) && areMirror(t1.left, t2.right);
	 }

	public static void main(String[] args) {
	   CheckIfTwoTreesAreMirror tree = new CheckIfTwoTreesAreMirror();
	   tree.root1 = new Node(1);
	   tree.root1.left = new Node(2);
	   tree.root1.right = new Node(3);
	   tree.root1.left.left = new Node(4);
	   tree.root1.left.right = new Node(5);
	   
	   tree.root2 = new Node(1);
	   tree.root2.left = new Node(3);
	   tree.root2.right = new Node(2);
	   tree.root2.right.left = new Node(5);
	   tree.root2.right.right = new Node(4);
	 
	   if (tree.areMirror(tree.root1, tree.root2) == true) {
	     System.out.println("The two trees are mirrors of each other.");
	   }
	   else {
	      System.out.println("The two trees are not mirrors of each other.");
	   }
	}
  }
