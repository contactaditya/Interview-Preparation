import java.util.*;
import java.io.*;

  public class BinaryTreeTilt {
    Node root;	    
    Node previous; 
    static int tilt = 0;
	  
    public static int findTilt(Node root) {
       traverse(root);
       return tilt;     
    }  
 
    private static int traverse(Node root) {
       if(root==null) {
         return 0;
       }
       int left = traverse(root.left);
       int right = traverse(root.right);
       tilt += Math.abs(left-right);
       return left + right + root.data;
    }

    public static void main(String[] args) {   
       BinaryTreeTilt tree = new BinaryTreeTilt();
       tree.root = new Node(1);
       tree.root.left = new Node(2);
       tree.root.right = new Node(3);
	
       int tilt = findTilt(tree.root); 
       System.out.println("The tilt of the whole binary tree is: " + tilt);
	  
    }
  }
