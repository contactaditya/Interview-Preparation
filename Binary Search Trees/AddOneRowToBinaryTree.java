import java.util.*;
import java.io.*;

  public class AddOneRowToBinaryTree { 
    Node root;	    
    Node previous;
	  
    public Node addOneRow(Node root, int value, int depth) {
       // If depth is one then we can put the whole current tree as a left child of the newly added node	
       if (depth == 1) {
	 Node node = new Node(value);
	 node.left = root;
	 return node;
       }
       insert(value, root, 1, depth);
       return root;		        
    }	  
	
    private void insert(int value, Node node, int depth, int currentLevelDepth) {
       if (node == null) {
	 return; 	 
       } 
       if (depth == currentLevelDepth - 1) {
         Node t = node.left;
         node.left = new Node(value);
         node.left.left = t;
         t = node.right;
         node.right = new Node(value);
         node.right.right = t;
       } else {
         insert(value, node.left, depth + 1, currentLevelDepth);
         insert(value, node.right, depth + 1, currentLevelDepth);
       }
    }

    public void printPreorderTraversal(Node node) {	 
       if (node == null) {
	  return;
       }
		    
       System.out.print(node.data + " ");		  
       printPreorderTraversal(node.left);
       printPreorderTraversal(node.right);
    }

    public static void main(String[] args) { 	  
       AddOneRowToBinaryTree tree = new AddOneRowToBinaryTree();
       tree.root = new Node(4);
       tree.root.left = new Node(2);
       tree.root.right = new Node(6);
       tree.root.left.left = new Node(3);
       tree.root.left.right = new Node(1);
       tree.root.right.left = new Node(5);
	   
       System.out.print("Preorder traversal of binary tree before the row was added is: ");
       tree.printPreorderTraversal(tree.root);		
       System.out.println();
       System.out.println(); 
       Scanner input = new Scanner(System.in);
       System.out.print("Please enter the value: ");
       int value = input.nextInt();  
       System.out.println();
       System.out.print("Please enter the depth: ");
       int depth = input.nextInt();  
	   
       tree.addOneRow(tree.root, value, depth);		
	   
       System.out.println();
       System.out.print("Preorder traversal of binary tree after the row was added is: ");
       tree.printPreorderTraversal(tree.root);		
	   
    }
  }
