import java.util.*;
import java.io.*;

  public class CountSubtreesThatSumUpToAGivenValueX { 	
    Node root;	    
	  	
    private static int countSubtreesWithSumX(Node root, int x) {
      if (root == null) {
	return 0;
      }
	  
      int answer = 0;
      if(sum(root) == x) {
        answer = 1;
      }
	  
      return answer + countSubtreesWithSumX(root.left, x) + countSubtreesWithSumX(root.right, x);
    }	

    private static int sum(Node root) {
      if (root == null) {
	return 0;
      }
		
      return root.data + sum(root.left) + sum(root.right);
    }

    public static void main(String[] args) {  
      CountSubtreesThatSumUpToAGivenValueX tree = new CountSubtreesThatSumUpToAGivenValueX();
      tree.root = new Node(5);
      tree.root.left = new Node(-10);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(9);
      tree.root.left.right = new Node(8);
      tree.root.right.right = new Node(7);
      tree.root.right.left = new Node(-4);
	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the sum: "); 
      int x = input.nextInt();  
      System.out.println();
      int countSubtreesWithSumX = countSubtreesWithSumX(tree.root, x);
      System.out.print("The number of subtress having total node’s data sum equal to a given value " + x + " are: " + countSubtreesWithSumX);
      input.close();
    }
  }
