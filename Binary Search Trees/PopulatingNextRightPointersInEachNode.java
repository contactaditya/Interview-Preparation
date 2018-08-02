import java.util.*;
import java.io.*;

  class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    int data;
       
    public TreeLinkNode(int data) {
      this.data = data;
    }
  }

  public class PopulatingNextRightPointersInEachNode {
	TreeLinkNode root;
	  
	public void connect(TreeLinkNode root) {
	  if(root == null) {
	    return;
      }
	        
	  if(root.left != null) {
	    root.left.next = root.right;
	    if(root.next != null) {
	      root.right.next = root.next.left;
	    }
	  }
	    
	  connect(root.left);
	  connect(root.right);      
    }
	
    public void printPreorderTraversal(TreeLinkNode node) {	 
      if (node == null) {
  	    return;
      }
      
      System.out.print(node.data + " ");		  
      printPreorderTraversal(node.left);
      printPreorderTraversal(node.right);
    }

	public static void main(String[] args) {  
	  PopulatingNextRightPointersInEachNode tree = new PopulatingNextRightPointersInEachNode();
	  tree.root = new TreeLinkNode(1);
	  tree.root.left = new TreeLinkNode(2);
	  tree.root.right = new TreeLinkNode(3);
	  tree.root.left.left = new TreeLinkNode(4);
	  tree.root.left.right = new TreeLinkNode(5);   
	  tree.root.right.left = new TreeLinkNode(6);
	  tree.root.right.right = new TreeLinkNode(7);
	  
	  tree.connect(tree.root);
	  System.out.print("The tree after its pointer points to its next right node is: ");		  
	  tree.printPreorderTraversal(tree.root);		
	}
  }
