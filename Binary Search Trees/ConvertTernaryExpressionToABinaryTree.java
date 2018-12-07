import java.util.*;
import java.io.*;

  class Node1 {
    char data;
    Node1 left;
    Node1 right;
	   
    public Node1(char item) {
      data = item;
      left = right = null;
    }
  }

  public class ConvertTernaryExpressionToABinaryTree {  
    Node1 root;	    
    Node1 previous;
    
	private Node1 convertExpression(char[] expression, int i) {
	  if (i >= expression.length) {
		return null;
	  }
	  // Store current character of expression string['a' to 'z'] 
	  Node1 root = new Node1(expression[i]); 
	  ++i;
	  // If current character of ternary expression is '?' then we add next character as a left child of current node 
	  if (i < expression.length && expression[i] == '?') { 
        root.left = convertExpression(expression, i+1); 
	  } else if(i < expression.length) {
		root.right = convertExpression(expression, i+1);  
	  }
	  
	  return root;
	}    
	  
	public void printPreorderTraversal(Node1 node) {	 
      if (node == null) {
		return;
	  }
      
	  System.out.print(node.data + " ");
	  printPreorderTraversal(node.left);
	  printPreorderTraversal(node.right);
    }

	public static void main(String[] args) {
	  String string = "a?b?c:d:e"; 
	  ConvertTernaryExpressionToABinaryTree tree = new ConvertTernaryExpressionToABinaryTree(); 
	  char[] expression = string.toCharArray();  
	  Node1 root = tree.convertExpression(expression, 0); 
	  tree.printPreorderTraversal(root); 
	}
  }
