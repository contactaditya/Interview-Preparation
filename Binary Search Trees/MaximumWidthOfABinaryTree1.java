import java.io.*;
import java.util.*;

 public class MaximumWidthOfABinaryTree1 { 	
    Node root;	    
    private int max = 1;
	
    public int getMaximumWidth(Node root) {
       List<Integer> startOfLevel = new ArrayList<Integer>(); // left most nodes at each level;
       dfs(root, 0, 1, startOfLevel);
       return max;
    } 
		
    private void dfs(Node root, int level, int index, List<Integer> list) {
       if (root == null) {
	  return;
       }
       if (level == list.size()) {
	  list.add(index); // add left most node
       }
       max = Integer.max(max, index + 1 - list.get(level));
       dfs(root.left, level + 1, index * 2, list);
       dfs(root.right, level + 1, index * 2 + 1, list);
    }	

    public static void main(String[] args) {
       MaximumWidthOfABinaryTree1 tree = new MaximumWidthOfABinaryTree1();
       tree.root = new Node(1);
       tree.root.left = new Node(2);
       tree.root.right = new Node(3);
       tree.root.left.left = new Node(4);
       tree.root.left.right = new Node(5);
       tree.root.right.right = new Node(8);
       tree.root.right.right.left = new Node(6);
       tree.root.right.right.right = new Node(7);
		   
       int maximumWidth = tree.getMaximumWidth(tree.root);		
       System.out.print("Maximum width of binary tree is: " + maximumWidth);
    }
 }
