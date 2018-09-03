import java.util.*;
import java.io.*;

  public class ConstructFullBinaryTreeFromPreorderAndPostorderTraversal {
    static int preindex;
	  
    public Node constructFromPrePost(int[] pre, int[] post) {
      int size = pre.length;
      return buildTree(pre, post, 0, size - 1, size);	   
    }
	
    private Node buildTree(int[] pre, int[] post, int low, int high, int size) {
      if (preindex >= size || low > high) {
        return null;
      }
    	 
      // Find out the root from the PreOrder Traversal  
      Node root = new Node(pre[preindex]);
      preindex++;
      
      // If the current subarry has only one element, no need to recurse or preIndex > size after incrementing
      if (low == high || preindex >= size) {
        return root;
      }
      int i;
      
      // Search the next element of pre[] in post[]
      for (i = low; i <= high; i++) {
        if (post[i] == pre[preindex]) {
          break;
        }
      }
      
      // Use the index of element found in postorder to divide postorder array in two parts: left subtree and right subtree
      if (i <= high) {  
    	root.left = buildTree(pre, post, low, i, size);
        root.right = buildTree(pre, post, i + 1, high, size); 
      }
      
      return root;
    }

    public void printInorderTraversal(Node node) { 
      if (node == null) {
        return;
      }
  	 
      printInorderTraversal(node.left);
      System.out.print(node.data + " ");	
      printInorderTraversal(node.right);
    }
	
    public static void main(String[] args) {      
      ConstructFullBinaryTreeFromPreorderAndPostorderTraversal tree = new ConstructFullBinaryTreeFromPreorderAndPostorderTraversal();	
      int preOrder[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
      int postOrder[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
	        
      Node node = tree.constructFromPrePost(preOrder, postOrder);
	  
      System.out.print("Inorder traversal of constructed tree is: ");
      tree.printInorderTraversal(node);	
    }
  }
