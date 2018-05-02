import java.util.*;
import java.io.*;

  public class HouseRobberIII { 	
    private static Node root;	    
    private static Node previous; 
	  
    public static int rob(Node root) {
      if (root == null) {
	return 0;	
      }
	  
      int[] value = robSum(root);
      return Math.max(value[0], value[1]); 
    }	  

    private static int[] robSum(Node root) { 
      int[] result = new int[2];
      if (root == null) {
    	return result;
      }
      
      int[] left = robSum(root.left);
      int[] right = robSum(root.right);
      
      result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
      result[1] = root.data + left[0] + right[0];
	
      return result;
    }

    public static void main(String[] args) { 	 	  
      HouseRobberIII tree = new HouseRobberIII();
      tree.root = new Node(3);
      tree.root.left = new Node(2); 
      tree.root.right = new Node(3);
      tree.root.left.right = new Node(3);
      tree.root.right.right = new Node(1);
		  
      System.out.println("The maximum amount of money the thief can rob tonight without alerting the police is: " + tree.rob(tree.root));
    }
  }
