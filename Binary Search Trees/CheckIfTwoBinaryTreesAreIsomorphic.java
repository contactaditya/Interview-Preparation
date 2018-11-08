import java.util.*;
import java.io.*;

  public class CheckIfTwoBinaryTreesAreIsomorphic {    
    private Node root1;	
    private Node root2;		    
	
    public boolean isIsomorphic(Node node1, Node node2) {
      // Both roots are NULL, trees isomorphic by definition 	
      if (node1 == null && node2 == null) { 
	return true;
      }
      // Exactly one of the n1 and n2 is NULL, trees are not isomorphic 
      if (node1 == null || node2 == null) {
	return false;
      }
	  
      if (node1.data != node2.data) {
	return false;
      }

      return (isIsomorphic(node1.left, node2.left) && isIsomorphic(node1.right, node2.right)) || (isIsomorphic(node1.left, node2.right) && isIsomorphic(node1.right, node2.left));
    }

    public static void main(String[] args) {   
      CheckIfTwoBinaryTreesAreIsomorphic tree = new CheckIfTwoBinaryTreesAreIsomorphic();
      tree.root1 = new Node(1); 
      tree.root1.left = new Node(2); 
      tree.root1.right = new Node(3); 
      tree.root1.left.left = new Node(4); 
      tree.root1.left.right = new Node(5); 
      tree.root1.right.left = new Node(6); 
      tree.root1.left.right.left = new Node(7); 
      tree.root1.left.right.right = new Node(8); 
	   
      tree.root2 = new Node(1); 
      tree.root2.left = new Node(3); 
      tree.root2.right = new Node(2); 
      tree.root2.right.left = new Node(4); 
      tree.root2.right.right = new Node(5); 
      tree.root2.left.right = new Node(6); 
      tree.root2.right.right.left = new Node(8); 
      tree.root2.right.right.right = new Node(7); 
	  
      if (tree.isIsomorphic(tree.root1, tree.root2) == true) {
	System.out.println("The two trees are isomorphic.");
      }
      else {
	System.out.println("TThe two trees are not isomorphic.");
      }
    }
  }
