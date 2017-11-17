import java.util.*;
import java.io.*;

  public class BinaryTreeRightSideView {  
	Node root;	    
	Node previous;

	public List<Integer> rightSideView(Node root) { 
	   List<Integer> result = new ArrayList<Integer>();
	   rightView(root, result, 0);
 
	   return result; 
	}

	private void rightView(Node current, List<Integer> result, int currentDepth) {
	   if(current == null) {
         return;
       }
	   
	   if(currentDepth == result.size()) {
         result.add(current.data);
       }
	   
	   rightView(current.right, result, currentDepth + 1);
       rightView(current.left, result, currentDepth + 1);
	}

	public static void main(String[] args) { 	   
	   BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
	   tree.root = new Node(1);
	   tree.root.left = new Node(2);
	   tree.root.right = new Node(3);
	   tree.root.right.right = new Node(4);
	   tree.root.left.right = new Node(5);
	   List<Integer> result = new ArrayList<Integer>();
	   result = tree.rightSideView(tree.root);		
		     
	   System.out.print("The values of the nodes you can see ordered from top to bottom on the right side of the binary tree are: " + result);
	}
  }
