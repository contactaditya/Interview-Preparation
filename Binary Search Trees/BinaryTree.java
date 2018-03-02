import java.util.*;
import java.io.*;

  class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;
    public BSTNode parent;
    
    //Node constructor
    
    public BSTNode(int value) {
      data = value;
      left = null;
      right = null;
      parent = null;
    }
    
    public BSTNode(int value, BSTNode left, BSTNode right, BSTNode parent) {
      data = value;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
    
    public int getData() {
      return data;
    }
	
    public void setData(int data) {
      this.data = data;
    }
	
    public BSTNode getLeft() {
      return left;
    }
	
    public void setLeft(BSTNode left) {
      this.left = left;
      if (left != null) {
	left.parent = this;
      }
    }
	
    public BSTNode getParent() {
      return parent;
    }
		
    public void setParent(BSTNode parent) {
      this.parent = parent;
    }
	
    public BSTNode getRight() {
      return right;
    }
			
    public void setRight(BSTNode right) {
      this.right = right;
      if (right != null) {
	right.parent = this;
      }
    }
  }

  public class BinaryTree {
	
   public static BSTNode root;
	  
   public BinaryTree() {
      root = null;
   }
   
   public static void add(int data) {
      root = add(root, data);
   }
				  
   public static BSTNode add(BSTNode root, int data) {
     /**
      * Add an specified item in the binary search tree.	
      */
			  
      if(root == null) {
    	root = new BSTNode(data);
        return root;
      }
    
      // Now check if the value of the root is greater or less than the value of the node to be deleted.
	  
      if(root.data > data) {
    	root.left = add(root.left, data);
      } 
	  
      else if(root.data < data) {
    	root.right = add(root.right, data);
      }  
      return root;	  
    }
		 
    public static BSTNode removeMaximum(BSTNode node) {
     /**
      * Removes the maximum item from the binary search tree.	 
      */	 

      if(root == null) {	 
        System.out.println();    
        System.out.println("The binary search tree is currently empty and has no elements.");	 	
	return null;  
      }
	  
      if(node.right != null) {
	node.right = removeMaximum(node.right);
	return node;  
      }
	  
      else {
        return node.left;
      }
    }
	  
    public static BSTNode removeMinimum(BSTNode node) {
     /**
      * Removes the minimum item from the binary search tree.	 	 
      */	 
  
      if(root == null) {
    	System.out.println();	 
        System.out.println("The binary search tree is currently empty and has no elements.");	 	
	return null;  
      }
  
      if(node.left != null) {
	node.left = removeMinimum(node.left);
        return node;  
      } 
  
      else {
        return node.right;
      }
    }
	  
    public static BSTNode remove(BSTNode root, int data) {
     /**
      * Removes the specified item from the binary search tree.	 
      */	 
		    
      if(root == null) {	   
    	System.out.println();	    	  
        System.out.println("The binary search tree is currently empty and has no elements.");	 	
        return root;
      }  
      // Now check if the value of the root is greater or less than the value of the node to be deleted.
      if ((root.data) > (data)) {
        root.left = remove(root.left, data);
      } 
      
      else if ((data) > (root.data)) {
        root.right = remove(root.right, data);
      }  
  
      // Now if the value is same as the value of the root node then it is the node that needs to be deleted.
  
      else {
        // node with only one child or no child
        if (root.left == null) { 
          return root.right;
        } 
        
        else if (root.right == null) {
          return root.left;
        }
        // node with two children: Get the inorder successor (smallest in the right subtree)
        BSTNode minimum = findMinimum(root.right);
        root.data = minimum.data;

        // Delete the inorder successor
        root.right = remove(root.right, root.data);
      }
      return root;
    }

    public static boolean isEmpty() {
     /**
      * Test if the Binary Search Tree is empty.
      */	
		  
      System.out.println();	 	  
      if(root == null) {	   
        System.out.println("The binary search tree is currently empty and has no elements.");	 	  	   
      } 
       
      else { 
        System.out.println("The binary search tree is currently not empty.");	 		   
      } 	
      return root == null;  
    }
			 
    public static int size(BSTNode root) {
     /**
      * Returns the number of items currently in the Binary Search Tree.
      */
	  	  	  
      if(root == null) {	   
        return 0;
      } 
       
      else { 
        return (size(root.left) + 1 + size(root.right));   
      }
    }
			 
    public static void displayPreOrder(BSTNode node) {
     /**
      * Displays all the contents of the binary search tree in preorder traversal.
      */
		    
      if(node == null) {	 		    
        return; 	  	   
      } 
       
      else {
	System.out.print(node.data + " ");	 		  
        displayPreOrder(node.left);
        displayPreOrder(node.right);
      }
    }
	  
    public static void displayInOrder(BSTNode root) {
     /**
      * Displays all the contents of the binary search tree in inorder traversal.
      */
  
      if(root == null) {
	return;
      }
	   
      if(root != null) {	   	  
        displayInOrder(root.left);
        System.out.print(root.data + " ");	 	 
        displayInOrder(root.right);
      }
    }
	  
    public static void displayPostOrder(BSTNode root) {
     /**
      * Displays all the contents of the binary search tree in postorder traversal.
      */
		   
      if(root == null) {	   
	return; 	  	   
      }
			   
      else {
        displayPostOrder(root.left);
        displayPostOrder(root.right);
        System.out.print(root.data + " ");	 
      }
    }
    
    public static boolean search(BSTNode root, int data) {
     /**
      * Searching all the contents of the binary search tree in postorder traversal.
      */
	 	    
      if(root == null) {	   
        return false;
      }
   
      if(root.data == data) { 
        return true;
      }
   
      else if ((root.data) > (data)) {
	return(search(root.left, data));     
      }
			   
      else {
	return(search(root.right, data));  	      
      }
    }  
     
    public static int maximumDepth(BSTNode root) {
     /**
      * Searching all the contents of the binary search tree in postorder traversal.
      */
		 	    
      if(root == null) {	   
	return 0;
      }
	   
      else {
    	return Math.max(maximumDepth(root.left), maximumDepth(root.right)) + 1;     	
      }
    }  
  
    public static BSTNode findMaximum(BSTNode node) {
     /**
      * Finding the maximum value in the binary search tree.
      */
	  
      if(root == null) {	   
    	System.out.println("The binary search tree is currently empty and has no elements.");
    	return null;
      }	  
		 	    	   
      if(node.right == null) {
    	return node;
      }
      else {
        return findMaximum(node.right);
      }  
    }
  
    public static BSTNode findMinimum(BSTNode node) {
     /**
      * Finding the minimum value in the binary search tree.
      */
		 	    
      if(root == null) {	   
        System.out.println("The binary search tree is currently empty and has no elements.");
	return null;
      }
  
      if(node.left == null) {
    	return node;
      }

      else {
        return findMinimum(node.left);
      }  
    } 
  
    public static int checkHeight(BSTNode node) {
     /**
      * Finding out the height of the binary search tree.
      */
		 		 	    
      if(node == null) {	   
        return 0;
      }
  
      else {
        return Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;    
      }
    }    
  
    public static boolean isBalanced(BSTNode node) {
     /**
      * Finding whether the binary search tree is balanced or not.
      */
      if(node == null) {	   
        return true;
      } 	
      
      // Checking if left is balanced. 
      int leftHeight = checkHeight(node.left);		   
  
      // Checking if right is balanced. 
      int rightHeight = checkHeight(node.right);
      
      System.out.println();  
      int heightDifference = leftHeight - rightHeight;	
      if(Math.abs(heightDifference) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
  	System.out.println("The binary search tree is balanced.");  
        return true;
      }
      
      System.out.println("The binary search tree is not balanced.");
      return false;
    }
  
    public static BSTNode inorderPredecessor(BSTNode node) {
     /**
      * Finding the inorder predecessor of the binary search tree.
      */
		 		 	    
      if(root == null) {	   
	System.out.println("The binary search tree is currently empty and has no elements.");
	return null;
      }
		  
      if(node.getLeft() != null) {	   
    	return findMinimum(node.left);
      }
				  
      else {
    	BSTNode p = node.parent;
    	while (p != null && node == p.left) {
    	  node = p;
    	  p = p.parent;
    	}
        return p;
      }   
    }   
  
    public static BSTNode inorderSuccessor(BSTNode node) {
     /**
      * Finding the inorder successor of the binary search tree.
      */
			 		 	    
      if(root == null) {	   
        System.out.println("The binary search tree is currently empty and has no elements.");
        return null;
      }
  
      if(node.getRight() != null) {	   
	return findMinimum(node.right);
      }
		  
      BSTNode p = node.parent;
      while (p != null && node == p.right) {
    	node = p;
    	p = p.parent;
      }
        
      return p;
    }     

    public static void main(String[] args) throws NumberFormatException, IOException {
      int choice = 0;
      BinaryTree tree = new BinaryTree();
	    
      do{	
	  System.out.println("1. For inserting an element at the first position in the binary search tree.");
	  System.out.println("2. For deleting the maximum element from the binary search tree.");
	  System.out.println("3. For deleting the minimum element from the binary search tree.");
	  System.out.println("4. For deleting an element from the binary search tree if it is present.");
	  System.out.println("5. For displaying the binary search tree in preorder traversal.");
	  System.out.println("6. For displaying the binary search tree in inorder traversal.");
	  System.out.println("7. For displaying the binary search tree in postorder traversal.");
	  System.out.println("8. For checking if the contents of the binary search tree are empty or not.");
	  System.out.println("9. For checking the size of the binary search tree.");
	  System.out.println("10. For searching the binary search tree.");
	  System.out.println("11. For finding the maximum depth of the binary search tree.");
	  System.out.println("12. For finding the smallest item of the binary search tree.");
	  System.out.println("13. For finding the largest item of the binary search tree.");
	  System.out.println("14. For checking if binary search tree is balanced or not.");
	  System.out.println("15. For exiting from the program.");
	 
	  System.out.println();	
	  System.out.print("Enter your choice: ");
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	  choice = Integer.parseInt(br.readLine());
	  switch (choice) {
	      case 1:  System.out.println();	
	     	       System.out.print("Enter a element to insert in the binary search tree: ");
	     	       int element = Integer.parseInt(br.readLine());
	     	       add(element);
	     	       break;
	      case 2:  removeMaximum(tree.root);
	               break;
	      case 3:  removeMinimum(tree.root);
	               break;  
	      case 4:  System.out.println();	
		       System.out.print("Enter the value of the element in the binary search tree which needs to be deleted: ");
		       int index2 = Integer.parseInt(br.readLine());
		       remove(tree.root, index2);
		       break;    		 
	      case 5:  System.out.println();
		       System.out.print("Preorder traversal of binary tree is: ");
		       displayPreOrder(tree.root);
		       System.out.println();	 
		       break;  
	      case 6:  System.out.println();
		       System.out.print("Inorder traversal of binary tree is: ");
		       displayInOrder(tree.root);
		       System.out.println();	 
		       break;       		 
	      case 7:  System.out.println();
		       System.out.print("Postorder traversal of binary tree is: ");
		       displayPostOrder(tree.root);
		       System.out.println();	 
		       break; 
	      case 8:  isEmpty();
		       break;  
	      case 9:  int size = size(tree.root);
		       System.out.println();  
		       System.out.println("The size of the binary search tree is: " + size); 
		       break;  
	     case 10:  System.out.println();	
                       System.out.print("Enter a element to search in the binary search tree: ");
		       int element5 = Integer.parseInt(br.readLine());
		       boolean search = search(tree.root, element5);
		       System.out.println();		
		       if(search) {
			 System.out.println("The element " + element5 + " is present in binary search tree.");		 
		       }
		       else {	 
                         System.out.println("The element " + element5 + " is not present in binary search tree."); 
		       }
		       break;   
	     case 11:  int maximumDepth = maximumDepth(tree.root);
	               System.out.println();	
	               if(maximumDepth == 0) {
	                 System.out.println("The binary search tree is currently empty and has no elements.");	 
	               } else {
	         	 System.out.println("The maximum depth of the binary search tree is " + maximumDepth);
	               }
	               break;
	     case 12:  BSTNode minimum = findMinimum(tree.root);
		       System.out.println();  
		       System.out.println("The smallest item of the binary search tree is: " + minimum.data); 
		       break;
	     case 13:  BSTNode maximum = findMaximum(tree.root);
	 	       System.out.println();  
	 	       System.out.println("The largest item of the binary search tree is: " + maximum.data); 
	 	       break;   
	     case 14:  isBalanced(tree.root);
	 	       break; 
	  }
	  System.out.print("\n");
        } while(choice!=15);
     }
   }
