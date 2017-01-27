import java.util.*;

 public class TreeLevelOrderTraversalSpiral { 	
   Node root;	    
   Node previous;

 public void printLevelOrderTraversalSpiral(Node node) {
	 
   if (node == null) {
      return;
   } 
   
   Stack<Node> currentLevel = new Stack<Node>();
   Stack<Node> nextLevel = new Stack<Node>();
   boolean leftToRight = true;
   currentLevel.push(root);
   
   while (!currentLevel.empty() || !nextLevel.empty()) {
 
   while (!currentLevel.empty()) {  
      Node temp = currentLevel.peek();
      currentLevel.pop();
      System.out.print(temp.data + " ");
	 
   // Note that is right is pushed before left
     if (temp.right != null) {
        nextLevel.push(temp.right);
     }
      
     if (temp.left != null) {
       nextLevel.push(temp.left);	
     }
   }	
  
   while (!nextLevel.empty()) {  
     Node temp = nextLevel.peek();
     nextLevel.pop();
     System.out.print(temp.data + " ");
		 
   // Note that is left is pushed before right
     if (temp.left != null) {
       currentLevel.push(temp.left);
     }
	      
     if (temp.right != null) {
       currentLevel.push(temp.right);	
     }
   }
 }
}

public static void main(String[] args) {  
    TreeLevelOrderTraversalSpiral tree = new TreeLevelOrderTraversalSpiral();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(7);
    tree.root.left.right = new Node(6);
    tree.root.right.left = new Node(5);
    tree.root.right.right = new Node(4);
	     
    System.out.print("Spiral Order traversal of Binary Tree is: ");
    tree.printLevelOrderTraversalSpiral(tree.root);		

  }
}
