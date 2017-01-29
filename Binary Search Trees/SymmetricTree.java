import java.util.*;

 public class SymmetricTree { 
    Node root;	    
    Node previous;

 public boolean isSymmetric(Node node) {	  
    return isMirror(root, root);
 }
    
 public boolean isMirror(Node t1, Node t2) {
    if (t1 == null && t2 == null) { 
      return true;
    }
    if (t1 == null || t2 == null) {
      return false;
    }
      
   return (t1.data == t2.data) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
 }

 public static void main(String[] args) {  
     SymmetricTree tree = new SymmetricTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(2);
     tree.root.left.left = new Node(3);
     tree.root.left.right = new Node(4);
     tree.root.right.right = new Node(3);
     tree.root.right.left = new Node(4);
	  
     if(tree.isSymmetric(tree.root)) {
	System.out.println("The Binary Tree is symmetric around its center and is a mirror of itself.");  
     } 
     else {
	System.out.println("The Binary Tree is not symmetric around its center and is not a mirror of itself.");
     }	  
   }
 }
