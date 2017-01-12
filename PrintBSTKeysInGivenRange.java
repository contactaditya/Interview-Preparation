import java.util.*;
import java.io.*;

 public class PrintBSTKeysInGivenRange {   
	Node root;	    
	Node previous;
	
	 public void printBSTKeysInGivenRange(Node node, int key1, int key2) {
		 
		if (node == null) {
		  return;
		}
		
	// If root.data is greater than key1, then only we can get the keys in left subtree */
		
		if (key1 < node.data) {
		  printBSTKeysInGivenRange(node.left, key1, key2);	
		}
		
	// If root's data lies in range, then prints root's data */	
		
		if (key1 <= node.data && key2 >= node.data) {	 
		   System.out.print(node.data + " ");	
		}
		
	// If root.data is smaller than key2, then only we can get the keys in right subtree */	
		
		if (key2 > node.data) {
		  printBSTKeysInGivenRange(node.right, key1, key2);	
		}	
	 }

	public static void main(String[] args) { 	
	  PrintBSTKeysInGivenRange tree = new PrintBSTKeysInGivenRange();
      tree.root = new Node(20);
      tree.root.left = new Node(8);
      tree.root.right = new Node(22);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(12);
	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the first key: ");
	  int key1 = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the second key: ");
	  int key2 = input.nextInt();  
	  System.out.println();
	  
	  System.out.print("The keys of tree between the first key and the second key are: ");
	  tree.printBSTKeysInGivenRange(tree.root, key1, key2);

  }
}
