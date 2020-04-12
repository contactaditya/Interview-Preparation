import java.util.*;
import java.io.*;

  public class BalanceABinarySearchTree { 	
    Node root;	    
    Node previous;
	  
    public Node balanceBST(Node root) {
      List<Integer> list = new ArrayList<Integer>();
      inorderTraversal(root, list);
      return generateBST(list, 0, list.size() - 1); 
    }
	
    private Node generateBST(List<Integer> list, int left, int right) {
      if(right < left) {
        return null;
      }
      int middle = (left + right)/2;
      Node root = new Node(list.get(middle));
      root.left = generateBST(list, left, middle - 1);
      root.right = generateBST(list, middle + 1, right);
		
      return root;
    }

    private void inorderTraversal(Node root, List<Integer> list) {	 
      if (root == null) {
	return;
      }
		 
      inorderTraversal(root.left, list);
      list.add(root.data);	
      inorderTraversal(root.right, list);
    }
	
    private void printPreorderTraversal(Node node) {	 
      if (node == null) {
  	return;
      }
      
      System.out.print(node.data + " ");		  
      printPreorderTraversal(node.left);
      printPreorderTraversal(node.right);
    }	

    public static void main(String[] args) { 
      BalanceABinarySearchTree tree = new BalanceABinarySearchTree();
      tree.root = new Node(1);
      tree.root.right = new Node(2);
      tree.root.right.right = new Node(3);
      tree.root.right.right.right = new Node(4);
	  	  
      tree.root = tree.balanceBST(tree.root);
	  
      System.out.print("Preorder traversal of binary tree is: ");
      tree.printPreorderTraversal(tree.root);		
    }
  }
