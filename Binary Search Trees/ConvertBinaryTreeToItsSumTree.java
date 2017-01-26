import java.util.*;

 public class ConvertBinaryTreeToItsSumTree {  
    Node root;	    
    Node previous;

  public int toSumTree(Node node) {
		 
     if (node == null) {
	return 0;
     }
     
     int oldValue = node.data;
     node.data = toSumTree(node.left) + toSumTree(node.right);
     return node.data + oldValue;
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
    ConvertBinaryTreeToItsSumTree tree = new ConvertBinaryTreeToItsSumTree();
    tree.root = new Node(10);
    tree.root.left = new Node(-2);
    tree.root.right = new Node(6);
    tree.root.left.left = new Node(8);
    tree.root.left.right = new Node(-4);
    tree.root.right.left = new Node(7);
    tree.root.right.right = new Node(5);
      
    tree.toSumTree(tree.root);
	     
    System.out.print("Inorder Traversal of the resultant tree is: ");
    tree.printInorderTraversal(tree.root);	
	 
  }
}
