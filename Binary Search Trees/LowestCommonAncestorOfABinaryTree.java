import java.util.*;
import java.io.*;

public class LowestCommonAncestorOfABinaryTree { 	
  Node root;
	
  public Node findLowestCommonAncestor(Node root, Node n1, Node n2) {		 
      if(root == null || root == n1 || root == n2) {
         return root;
      }
		    
      Node left = findLowestCommonAncestor(root.left, n1, n2);
      Node right = findLowestCommonAncestor(root.right, n1, n2);
       
      if (left !=null && right !=null) {
         return root;
      }
    
      return (left != null) ? left : right; 
  }

  public static void main(String[] args) {     
      LowestCommonAncestorOfABinaryTree tree = new LowestCommonAncestorOfABinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      tree.root.right.left = new Node(6);
      tree.root.right.right = new Node(7);
            
      Node n1 = tree.root.left.left;
      Node n2 = tree.root.left.right;
    
      Node t = tree.findLowestCommonAncestor(tree.root, n1, n2);
      if (t != null) {
        System.out.println("LCA of " + n1.data + " and " + n2.data + " is " + t.data);
      }
      else {
    	System.out.println("Keys are not present.");  
      }
  }
}
