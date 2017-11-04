import java.util.*;
import java.io.*;

  public class BinaryTreePaths { 	
	Node root;	    
	Node previous;
	
	public List<String> binaryTreePaths(Node root) {
	   List<String> answer = new ArrayList<String>();
	   if (root != null) {
		 searchBT(root, "", answer);
	   }
	   return answer;	     
	}

	private void searchBT(Node root, String path, List<String> answer) {
	   if (root.left == null && root.right == null) {
		 answer.add(path + root.data);	
	   }
	   if (root.left != null) {
		 searchBT(root.left, path + root.data + "->", answer);
	   }
	   if (root.right != null) {
		 searchBT(root.right, path + root.data + "->", answer);
	   }			
	}

	public static void main(String[] args) {    
	   BinaryTreePaths tree = new BinaryTreePaths();
	   tree.root = new Node(1);
	   tree.root.left = new Node(2);
	   tree.root.right = new Node(3);
	   tree.root.left.right = new Node(5);
	   List<String> result = new ArrayList<String>();
	   result = tree.binaryTreePaths(tree.root);		
		     
	   System.out.print("All root to leaf paths are: " + result);
	}

  }
