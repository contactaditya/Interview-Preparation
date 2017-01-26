import java.util.*;
import java.io.*;

 public class CountBSTNodesInAGivenRange { 
    Node root;	    
    Node previous;
    
 public int countBSTKeysInGivenRange(Node node, int low, int high) {
		 
    if (node == null) {
       return 0;
    }
			
    if (node.data == high && node.data == low) {
       return 1;
    }
		
  // If current node is in range, then include it in count and recurse for left and right children of it
		
    if (node.data <= high && node.data >= low) {	 
       return 1 + countBSTKeysInGivenRange(node.left, low, high) + countBSTKeysInGivenRange(node.right, low, high);
    }
		
 // If current node is smaller than low then recurse for the right child	
		
    else if (node.data < low) {
       return countBSTKeysInGivenRange(node.right, low, high);	
    }	
	  
    else {
       return countBSTKeysInGivenRange(node.left, low, high);	  
    }
 }    

public static void main(String[] args) { 	  
   CountBSTNodesInAGivenRange tree = new CountBSTNodesInAGivenRange();
   tree.root = new Node(10);
   tree.root.left = new Node(5);
   tree.root.right = new Node(50);
   tree.root.left.left = new Node(1);
   tree.root.right.right = new Node(100);
   tree.root.right.left = new Node(40);
	  
   Scanner input = new Scanner(System.in);
   System.out.print("Please enter the first key: ");
   int low = input.nextInt();  
   System.out.println();
   System.out.print("Please enter the second key: "); 
   int high = input.nextInt();  
   System.out.println();
	  
   int count = tree.countBSTKeysInGivenRange(tree.root, low, high);
   System.out.print("Count of nodes between the first key and the second key are: " + count);
  }
}
