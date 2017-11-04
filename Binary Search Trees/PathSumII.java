import java.util.*;
import java.io.*;

 public class PathSumII { 	
	Node root;	    
	Node previous;
	
	public List<List<Integer>> pathSum(Node root, int sum) {
	  List<List<Integer>> result = new ArrayList<List<Integer>>();
	  List<Integer> current = new ArrayList<Integer>(); 
	  pathSum(root, sum, current, result);
	  return result;	     
	}	 
	
	private void pathSum(Node root, int sum, List<Integer> current, List<List<Integer>> result) {
	  if (root == null) {
		return; 
	  }
	  current.add(root.data);
	  if (root.left == null && root.right == null && root.data == sum) {
	    result.add(new ArrayList(current));
	  } else {
	    pathSum(root.left, sum - root.data, current, result);
	    pathSum(root.right, sum - root.data, current, result);
	  }
	    
	  current.remove(current.size()-1);
	}
	
	public static void main(String[] args) { 	   		
	  PathSumII tree = new PathSumII();
	  tree.root = new Node(5);
	  tree.root.left = new Node(4);
	  tree.root.right = new Node(8);
	  tree.root.left.left = new Node(11);
	  tree.root.left.right = new Node(5);
	  tree.root.left.left.left = new Node(7);
	  tree.root.left.left.right = new Node(2);
	  tree.root.right.left = new Node(13);
	  tree.root.right.right = new Node(4);
	  tree.root.right.right.right = new Node(1);
	  tree.root.right.right.left = new Node(5);
	  List<List<Integer>> result = new ArrayList<List<Integer>>();
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the value of the target you want to check in the binary tree: ");
	  int sum = input.nextInt();  
	  
	  result = tree.pathSum(tree.root, sum);		
	  System.out.println();   
	  System.out.print("All root to leaf paths where each path's sum equals " + sum + " are: " + result);
	}
 }
