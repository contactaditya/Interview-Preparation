import java.util.*;
import java.io.*;

  public class RangeSumOfBST {
	Node root;	    
	int answer;
	  
	public int rangeSumBST(Node root, int L, int R) {
	  answer = 0;
	  dfs(root, L, R);
	  return answer;      
	}

    private void dfs(Node node, int L, int R) {
      if (node != null) {  
        if (node.data >= L && node.data <= R) {
          answer += node.data;
        }
        if (node.data > L) {
          dfs(node.left, L, R);
        }
        if (node.data < R) {
          dfs(node.right, L, R);
        }
      }
	}

	public static void main(String[] args) {      
	  RangeSumOfBST tree = new RangeSumOfBST();
      tree.root = new Node(10);
      tree.root.left = new Node(5);
      tree.root.right = new Node(50);
      tree.root.left.left = new Node(1);
      tree.root.right.left = new Node(40);
      tree.root.right.right = new Node(100);
      
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the lower value for the range: ");
	  int left = input.nextInt();  
	  System.out.println();
	  System.out.print("Enter the upper value for the range: ");
	  int right = input.nextInt();  
  	     	  
      int rangeSum = tree.rangeSumBST(tree.root, left, right);
      System.out.println();	
      System.out.print("The sum of values of all nodes with value between " + left + " and " + right + " is: " + rangeSum);
      input.close();
	}
  }
