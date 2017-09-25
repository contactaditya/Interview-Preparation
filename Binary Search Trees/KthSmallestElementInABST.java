import java.util.*;
import java.io.*;

 public class KthSmallestElementInABST {
    Node root;	    
    Node previous; 

    public int kthSmallest(Node root, int k) {       
       if(root == null) {
         return 0;
       }
	   
       int count = countNodes(root.left);
       if (k <= count) {
         return kthSmallest(root.left, k);
       } else if (k > count + 1) {
         return kthSmallest(root.right, k-1-count); // 1 is counted as current node
       }
	               
       return root.data;
    }	
	
    private int countNodes(Node root) {
       if(root == null) {
         return 0;
       }
       
       return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) { 	  
       KthSmallestElementInABST tree = new KthSmallestElementInABST();
       tree.root = new Node(3);
       tree.root.left = new Node(0);
       tree.root.right = new Node(4);
       tree.root.left.right = new Node(2);
       tree.root.left.right.left = new Node(1);
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the kth smallest element of the binary search tree: ");
       int k = input.nextInt();  
       int kthSmallestElement = tree.kthSmallest(tree.root, k);		
       System.out.println();	     
       System.out.println("The kth smallest element in the binary search tree is: " + kthSmallestElement);	
    }
 }
