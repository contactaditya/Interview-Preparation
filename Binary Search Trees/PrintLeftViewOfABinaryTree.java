import java.util.*;
import java.io.*;

 public class PrintLeftViewOfABinaryTree { 	
     static Node root;	    
     static Node previous;
     static int  maxLevel = 0;	
	
    public static void leftView() {
       leftViewUtil(root, 1);
    }
	
    public static void leftViewUtil(Node node, int level) {
	   
       if(node == null) {
	  return;
       }	
	   
       // If this is the first node of its level
	   
       if (maxLevel < level) {
          System.out.print(node.data + " ");
          maxLevel = level;
       }
	   
       leftViewUtil(node.left, level+1);
       leftViewUtil(node.right, level+1);
   }

   public static void main(String[] args) { 
      PrintLeftViewOfABinaryTree tree = new PrintLeftViewOfABinaryTree();
      tree.root = new Node(12);
      tree.root.left = new Node(10);
      tree.root.right = new Node(30);
      tree.root.right.left = new Node(25);
      tree.root.right.right = new Node(40);
	
	     
      System.out.print("Left view of the Binary Tree is: ");
      tree.leftView();		
   }
 }
