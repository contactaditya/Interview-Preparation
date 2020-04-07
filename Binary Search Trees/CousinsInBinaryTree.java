import java.util.*;
import java.io.*;

 public class CousinsInBinaryTree { 
	private static Node root;	
    int parent1 = -1;
    int parent2 = -1;
    int depth1 = 0;
    int depth2 = 0;

	public boolean isCousins(Node root, int x, int y) {
      bfs(root, 0, -1, x, 0);
      bfs(root, 0, -1, y, 1);
      if(parent1 != parent2 && parent1 != -1 && depth1 == depth2) {
    	return true;
      }

	  return false;
	}

	private void bfs(Node node, int depth, int parent, int expected, int value) {
	  if(node == null) {
		return;
	  }
	  if(node.data == expected) {
	    if(value == 0) {
	      depth1 = depth;
	      parent1 = parent;
	    }
	    else {
	      depth2 = depth;
	      parent2 = parent;
	    }
	    return;
	  }
	  bfs(node.left, depth + 1, node.data, expected, value);
      bfs(node.right, depth + 1, node.data, expected, value);
	}

	public static void main(String[] args) { 	  
	  CousinsInBinaryTree tree = new CousinsInBinaryTree();
	  tree.root = new Node(1);
	  tree.root.left = new Node(2);
	  tree.root.right = new Node(3);
	  tree.root.left.right = new Node(4);
	  tree.root.right.right = new Node(5);
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the value of a node in the binary tree: ");
      int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Enter the value of a node in the binary tree: ");
	  int y = input.nextInt();  
	  System.out.println();
	  if (tree.isCousins(tree.root, x, y) == true) {
	    System.out.println("The nodes corresponding to the values " + x + " and " + y + " are cousins.");
	  }
	  else {
	    System.out.println("The nodes corresponding to the values " + x + " and " + y + " are not cousins.");
	  }
	  input.close();
	}
 }
