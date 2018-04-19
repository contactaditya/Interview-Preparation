import java.util.*;
import java.io.*;

   public class RootToLeafPathSumEqualToAGivenNumber { 
     static Node root;	    
     static Node previous;
	
     public static boolean hasPathSum(Node node, int sum) {
       if(node == null) {
	 return (sum == 0);
       }
       else {
         boolean answer = false;   
         /* otherwise check both subtrees */
         int subsum = sum - node.data;
         if (subsum == 0 && node.left == null && node.right == null) {
           return true;
         }
         if (node.left != null) {
           answer = answer || hasPathSum(node.left, subsum);
         }  
         if (node.right != null) {
           answer = answer || hasPathSum(node.right, subsum);
         }    
         return answer;
       }
     }

     public static void main(String[] args) {   
       RootToLeafPathSumEqualToAGivenNumber tree = new RootToLeafPathSumEqualToAGivenNumber();
       tree.root = new Node(10);
       tree.root.left = new Node(8);
       tree.root.right = new Node(2);
       tree.root.left.left = new Node(3);
       tree.root.left.right = new Node(5);
       tree.root.right.left = new Node(2);
	  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the sum for which you want to calculate the number of paths: ");
       int targetSum = input.nextInt();  
	      
       System.out.println();
       boolean hasPathSum = hasPathSum(tree.root, targetSum);
	  
       if(hasPathSum) {
	 System.out.println("There is a root to leaf path with sum " + targetSum);
       } else {
         System.out.println("There is no root to leaf path with sum " + targetSum);
       }	  	
     }
   }
