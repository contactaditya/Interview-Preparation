import java.util.*;
import java.io.*;

  public class GenerateAllUniqueBST {
	  
    public static List<Node> generateTrees(int n) {  
      if(n==0) {
        return new ArrayList<Node>();
      }  
      return generate(1, n);
    }   
    
    public static List<Node> generate(int min, int max) { 
       List<Node> result = new ArrayList<Node>();
       if(min > max) {
   	 result.add(null);
         return result;    
       }
       for(int i=min; i<=max; i++) {
        List<Node> left = generate(min, i-1);
        List<Node> right = generate(i+1, max);
        for(Node l: left) {
         for(Node r: right) {
           Node root = new Node(i);  
           root.left = l;
           root.right = r;
           result.add(root);
         }
        }
       }
      return result;
    }
    
    public static void printPreorderTraversal(Node node) {
		 
      if (node == null) {
    	return;
      }
        
      System.out.print(node.data + " ");		  
      printPreorderTraversal(node.left);
      printPreorderTraversal(node.right);
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int n = input.nextInt();
      List<Node> result = new ArrayList<Node>();
      result = generateTrees(n);
      System.out.println();  
      System.out.println("The unique BST's which are possible are: ");
      for(int i = 0; i < result.size(); i++) {
	printPreorderTraversal(result.get(i));
	System.out.println();
      }
    }
  }
