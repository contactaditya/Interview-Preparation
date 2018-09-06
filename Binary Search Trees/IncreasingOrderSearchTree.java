import java.util.*;
import java.io.*;

  public class IncreasingOrderSearchTree { 
    Node root;	
    List<Integer> list = new ArrayList<Integer>();
	  
    public Node increasingBST(Node root) {
      InorderTraversal(root);
      Node answer = new Node(0);	
      Node current = answer;
	  
      for (int v : list) {
        current.right = current = new Node(v);
      }
	  
      return answer.right;      
    }
	
    public void InorderTraversal(Node node) { 
      if (node == null) {
	return;
      }
			 
      InorderTraversal(node.left);
      list.add(node.data);
      InorderTraversal(node.right);
    }	 
    
    public void printPostorderTraversal(Node node) { 
      if (node == null) {
	return;
      }
		   
      printPostorderTraversal(node.left);
      printPostorderTraversal(node.right);
      System.out.print(node.data + " ");		
    }     
						
    public static void main(String[] args) { 	   
      IncreasingOrderSearchTree tree = new IncreasingOrderSearchTree();
      tree.root = new Node(5);
      tree.root.left = new Node(3);
      tree.root.right = new Node(6);
      tree.root.left.left = new Node(2);
      tree.root.left.right = new Node(4);
      tree.root.left.left.left = new Node(1);
      tree.root.right.right = new Node(8);
      tree.root.right.right.left = new Node(7);
      tree.root.right.right.right = new Node(9);
	  
      Node current = tree.increasingBST(tree.root);	
      System.out.print("Postorder traversal of the binary tree after rearrangement is: ");
      tree.printPostorderTraversal(current);			
    }
  }
