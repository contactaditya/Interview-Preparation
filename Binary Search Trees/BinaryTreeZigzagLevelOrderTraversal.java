import java.util.*;
import java.io.*;

 public class BinaryTreeZigzagLevelOrderTraversal {    
    Node root;	    
    Node previous;

    public List<List<Integer>> levelOrder(Node root) { 
       if (root == null) {
	  return null;
       }
	   
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       zigzagLevelOrder(root, result, 1); 
       return result; 
    }

    private void zigzagLevelOrder(Node root, List<List<Integer>> result, int level) {
       if (root == null) {
	  return;
       }
	   
       if (result.size() < level) {
         ArrayList<Integer> levelList = new ArrayList<Integer>();
         if ((level % 2) == 1) {
           levelList.add(root.data);
         } else {
           levelList.add(0, root.data);
         }
         result.add(levelList);
       } else {
    	 if ((level % 2) == 1) {
           result.get(level - 1).add(root.data);
         } else {
           result.get(level - 1).add(0, root.data);
         }	
       }
       zigzagLevelOrder(root.left, result, level+1); 
       zigzagLevelOrder(root.right, result, level+1); 
    }

    public static void main(String[] args) { 	 
       BinaryTreeZigzagLevelOrderTraversal tree = new BinaryTreeZigzagLevelOrderTraversal();
       tree.root = new Node(3);
       tree.root.left = new Node(9);
       tree.root.right = new Node(20);
       tree.root.right.left = new Node(15);
       tree.root.right.right = new Node(7);
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       result = tree.levelOrder(tree.root);
       System.out.print("The zigzag level order traversal of the Binary Tree is: " + result);
	  		
    }
 }
