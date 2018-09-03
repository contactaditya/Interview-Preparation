import java.util.*;
import java.io.*;

  public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {   
	
	public static Node constructFromPrePost(int[] pre, int[] post) {
      int n = pre.length;
	  return buildTree(pre, 0, n - 1, post, 0, n - 1);	   
	}
	
    private static Node buildTree(int[] pre, int l1, int r1, int[] post, int l2, int r2) {
      if (l1 > r1) {
        return null;
      }
      
      if (l1 == r1) {
        return new Node(pre[l1]);
      }
      
      Node root = new Node(pre[l1]);
      int i = l2;
      for (; i <= r2 && post[i] != pre[l1 + 1]; i++);
      
      Node left = buildTree(pre, l1 + 1, l1 + 1 + i - l2, post, l2, i);
      Node right = buildTree(pre, l1 + 2 + i - l2, r1, post, i + 1, r2 - 1);
     
      root.left = left;
      root.right = right;
      return root;
	}

	public static void main(String[] args) { 	  
	  ConstructFullBinaryTreeFromPreorderAndPostorderTraversal tree = new ConstructFullBinaryTreeFromPreorderAndPostorderTraversal();	
      int preOrder[] = {1, 2, 4, 5, 3, 6, 7};
      int postOrder[] = {4, 5, 2, 6, 7, 3, 1};
	        
      Node node = tree.constructFromPrePost(preOrder, postOrder);
	  
      System.out.print("Inorder traversal of constructed tree is: ");
      tree.printInorderTraversal(node);	
	}
  }
