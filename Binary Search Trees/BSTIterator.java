import java.util.*;
import java.io.*;

  public class BSTIterator { 
     static Node root;
     private Stack<Node> stack = new Stack<Node>();
	  
     public BSTIterator(Node root) {
       this.root = root;   
       while(root != null) {
         stack.push(root);
         root = root.left;
       }   
     }

     /** @return whether we have a next smallest number */
     public boolean hasNext() {
        return !stack.isEmpty() || root != null;       
     }

     /** @return the next smallest number */
     public int next() { 
       root = stack.pop();
       int result = root.data;
       root = root.right;	
       while (root != null) {
         stack.push(root);
         root = root.left;
       }
     
       return result;      
     }	  

     public static void main(String[] args) {
       BSTIterator tree = new BSTIterator(root);
       tree.root = new Node(4);
       tree.root.left = new Node(2);
       tree.root.right = new Node(6);
       tree.root.left.left = new Node(1);
       tree.root.left.right = new Node(3);
       tree.root.right.left = new Node(5);
       tree.root.right.right = new Node(7);
	   
       BSTIterator i = new BSTIterator(root);
 
       while (i.hasNext()) {
	  System.out.print(i.next() + " ");
       }
     }
  }
