import java.util.*;
import java.io.*;

  public class PrintCornerNodesAtEachLevelInABinaryTree {
     Node root;	    
     Node previous;
	  
     public void printCornerNodesAtEachLevelInABinaryTree(Node node) {
			 
	Queue<Node> queue = new LinkedList<Node>();
	queue.add(root);
	queue.add(null);
	   
	// if isFirst = true then left most node of that level will be printed
	boolean isFirst = false;
	   
	// if isOne = true then that level has only one node
        boolean isOne = false;
       
        // last will store right most node of that level
        int last = 0;
	   
	while (!queue.isEmpty()) {
	  Node tempNode = queue.peek();
	  queue.poll();
		 
	  if (isFirst) {
	    System.out.print(tempNode.data + " ");
			   
	    if (tempNode.left != null) {
	      queue.add(tempNode.left);
            }

	    /*Enqueue right child */
	    if (tempNode.right != null) {
	      queue.add(tempNode.right);
	    }
		   
           // make isFirst as false and one = 1
           isFirst = false;
           isOne = true;		   
	}
	else if (tempNode == null) {
           // Insert new separator if there are items in queue
           if (queue.size() >= 1) {
             queue.add(null);
           }
           // Making isFirst as true because next node will be leftmost node of that level
           isFirst = true;

           // Printing last node, only if that level doesn't contain single node otherwise that single node will be printed twice              
           if (!isOne) {
              System.out.print(last + " ");    
           }
        } 
	else {
           // Store current data as last
           last = tempNode.data; 
           
           // Here we are making isOne = false to signify that level has more than one node
           isOne = false;
           
           if (tempNode.left != null) {
             queue.add(tempNode.left);
           }
           if (tempNode.right != null) {
             queue.add(tempNode.right);   
           } 
	} 
      }
    }
	 
    public static void main(String[] args) { 	 
        PrintCornerNodesAtEachLevelInABinaryTree tree = new PrintCornerNodesAtEachLevelInABinaryTree();
	tree.root = new Node(15);
	tree.root.left = new Node(10);
	tree.root.right = new Node(20);
	tree.root.left.left = new Node(8);
	tree.root.left.right = new Node(12);
	tree.root.right.left = new Node(16);
	tree.root.right.right = new Node(25);
	     
	System.out.print("The corner nodes of Binary Tree at each level are: ");
	tree.printCornerNodesAtEachLevelInABinaryTree(tree.root);		

    }
  }
