import java.util.*;
import java.io.*;

  public class FindLargestValueInEachTreeRowInABinaryTree { 
	Node root;	    
    Node previous;	  
    
    public static List<Integer> largestValues(Node root) {
       List<Integer> result = new ArrayList<Integer>();	
       helper(root, result, 0);    	
       return result; 
    }

	private static void helper(Node root, List<Integer> result, int depth) {
	   if(root == null) {
	     return;
	   }
	   //expand list size
	   if(depth == result.size()) {
	     result.add(root.data);
	   }	
	   else {
		 result.set(depth, Math.max(result.get(depth), root.data));  
	   }
	   helper(root.left, result, depth+1);
       helper(root.right, result, depth+1);
	}

	public static void main(String[] args) { 	   
	   FindLargestValueInEachTreeRowInABinaryTree tree = new FindLargestValueInEachTreeRowInABinaryTree();
	   tree.root = new Node(1);
	   tree.root.left = new Node(3);
	   tree.root.right = new Node(2);
	   tree.root.left.left = new Node(5);
	   tree.root.left.right = new Node(3);
	   tree.root.right.right = new Node(9);
	   List<Integer> largestValues = new ArrayList<Integer>();	
	   
	   largestValues = largestValues(tree.root);		
		     
	   System.out.print("The largest value in each row of a binary tree is: " + largestValues);
	}
  }
