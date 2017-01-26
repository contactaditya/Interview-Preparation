import java.util.*;

 public class PrintAllNodesWithoutSiblings {    
     Node root;	    
     Node previous;

 public void printSingles(Node node) {	
		 
    if (node == null) {
       return;
    }
	
    if (node.left != null && node.right != null) {
        printSingles(node.left);
	printSingles(node.right);
    }
	
    else if (node.right != null) {
        System.out.print(node.right.data + " ");
        printSingles(node.right);
    }
	
    else if (node.left != null) {
       System.out.print( node.left.data + " ");
       printSingles(node.left);
    }	
 }

  public static void main(String[] args) { 	
    PrintAllNodesWithoutSiblings tree = new PrintAllNodesWithoutSiblings();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.right = new Node(4);
    tree.root.right.left = new Node(5);
    tree.root.right.left.right = new Node(6);
	     
    System.out.print("The nodes that don't have siblings: ");
    tree.printSingles(tree.root);		
  }
}
