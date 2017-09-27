import java.util.*;
import java.io.*;

 public class FindModeInBinarySearchTree1 { 	
	private int count = 1;
	private int max = 0;
	Integer previous = null;

	public int[] findMode(Node root) {
	  if(root==null) {
		return new int[0];	
	  }
	  List<Integer> list = new ArrayList<>();
	  traverse(root, list);
	  int[] result = new int[list.size()];
		   	   
	  for(int i = 0; i < list.size(); i++) {
		result[i] = list.get(i);
	  }
			
	  return result;       	      
	}	

	private void traverse(Node root, List<Integer> list) {
	   if (root == null) {
		 return;
	   }
	   traverse(root.left, list);
	   if (previous != null) {
	     if (root.data == previous) {
	       count++;	
	     }
	     else {
	       count = 1;
	     }
	   }
	   if (count > max) {
	     max = count;
	     list.clear();
	     list.add(root.data);
	   } else if (count == max) {
	     list.add(root.data);
	   }
	   previous = root.data;
	   traverse(root.right, list);
	}

	public static void main(String[] args) { 	 
	  FindModeInBinarySearchTree  tree = new FindModeInBinarySearchTree ();
	  tree.root = new Node(1);
	  tree.root.right = new Node(2);
	  tree.root.right.left = new Node(2);
	  Scanner input = new Scanner(System.in);
	  int result[] = tree.findMode(tree.root);		
	  System.out.print("The value of the mode of the BST is: ");
	  for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  }
	}
 }
