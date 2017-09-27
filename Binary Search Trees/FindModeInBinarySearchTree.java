import java.util.*;
import java.io.*;

  public class FindModeInBinarySearchTree {
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private int max = 0;
	Node root;	 

	public int[] findMode(Node root) {
	   if(root==null) {
		  return new int[0];	
	   }
	   
	   helper(root);
	   
	   List<Integer> list = new LinkedList<>();
	   for(int key: map.keySet()) {
         if(map.get(key) == max) {
           list.add(key);
         }
       }
	   
	   int[] result = new int[list.size()];
	   for(int i = 0; i < result.length; i++) {
		  result[i] = list.get(i);
	   }
		
	   return result;       	      
	}	

	private void helper(Node node) {
	   map.put(node.data, map.getOrDefault(node.data, 0) + 1);
	   max = Math.max(map.get(node.data), max);	
	   
	   if(node.left!=null) {
          helper(node.left);
       }
       
       if(node.right!=null) {
          helper(node.right);
       }
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
