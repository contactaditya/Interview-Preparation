import java.util.*;

  public class RemoveHalfNodesInABinaryTree { 
    Node root;	    
    Node previous;
	
    public Node RemoveHalfNodes(Node node) {
      if (node == null) {
        return null;
      }
		
      node.left = RemoveHalfNodes(node.left);
      node.right = RemoveHalfNodes(node.right);
	  
      if (node.left == null && node.right == null) {
        return node;
      }
	    
      // If current nodes is a half node with left child NULL left, then it's right child is returned and replaces it in the given tree.  
      if (node.left == null) {
        Node newRoot = node.right;
        return newRoot;
      }
	    
      // If current nodes is a half node with right child NULL right, then it's left child is returned and replaces it in the given tree.
      if (node.right == null) {
	Node newRoot = node.left;
        return newRoot;
      }
 		
      return node;
    }

    public void printInorderTraversal(Node node) {	 
      if (node == null) {
	return;
      }
		 
      printInorderTraversal(node.left);
      System.out.print(node.data + " ");	
      printInorderTraversal(node.right);
    }

    public static void main(String[] args) { 	
      RemoveHalfNodesInABinaryTree tree = new RemoveHalfNodesInABinaryTree();
      tree.root = new Node(2);
      tree.root.left = new Node(7);
      tree.root.right = new Node(5);
      tree.root.left.right = new Node(6);
      tree.root.left.right.left = new Node(1);
      tree.root.left.right.right = new Node(11);
      tree.root.right.right = new Node(9);
      tree.root.right.right.left = new Node(4);
      
      System.out.print("Inorder traversal of binary tree is: ");
      tree.printInorderTraversal(tree.root);		
      
      Node newRoot = tree.RemoveHalfNodes(tree.root);
      
      System.out.println();    
      System.out.println();   
      System.out.print("Inorder traversal of binary tree is: ");
      tree.printInorderTraversal(tree.root);		
    }
  }
