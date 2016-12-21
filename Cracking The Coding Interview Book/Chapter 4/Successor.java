import java.util.*;

 class TreeNode {
	 
    int data;
    TreeNode left, right, parent;
 
    TreeNode(int d) {
        data = d;
        left = right = parent = null;
    }
  }

 public class Successor { 
	static TreeNode root;	    
	static TreeNode previous;
	
	TreeNode insert(TreeNode node, int data) {
		 
	 /* 1. If the tree is empty, return a new, single node */
	   if (node == null) {
	      return (new TreeNode(data));
	   } else {
	 
	     TreeNode temp = null;
	             
	 /* 2. Otherwise, recurse down the tree */
	   if (data <= node.data) {
	      temp = insert(node.left, data);
	      node.left = temp;
	      temp.parent = node;
	 
	   } else {
	      temp = insert(node.right, data);
	      node.right = temp;
	      temp.parent = node;
	   }
	 
	 /* return the (unchanged) node pointer */
	  return node;
	 }
   }
	
	public static TreeNode inorderSuccessor(TreeNode node) {
	   if(node == null) {
		  return null;
       }
	   
	   if(node.right != null) {
		  return leftMostChild(node.right);
	   } else {
		  TreeNode x = node.parent;
		   
		  while(x != null && x.left != node) {
			node = x;
			x = x.parent;
		  }
		 
	     return x;    		   
	   }	 	   
	}	
	
	public static TreeNode leftMostChild(TreeNode node) {
	   if(node == null) {
		  return null;
	   }
		   
	   if(node.left != null) {
		  node = node.left;
	   }  
	  return node; 
	}

	public static void main(String[] args) {  
	  Successor tree = new Successor();
	  TreeNode root = null, temp = null, suc = null, min = null;
      root = tree.insert(root, 20);
      root = tree.insert(root, 8);
      root = tree.insert(root, 22);
      root = tree.insert(root, 4);
      root = tree.insert(root, 12);
      root = tree.insert(root, 10);
      root = tree.insert(root, 14);
      temp = root.left.right.left;
	  
	  TreeNode next = inorderSuccessor(temp);	
	  if(next != null) {
	    System.out.println("Inorder successor of " + temp.data  + " the node is: " + next.data);
	  } else {
	    System.out.println("Inorder successor does not exist.");
	  }	  
	}
  }
