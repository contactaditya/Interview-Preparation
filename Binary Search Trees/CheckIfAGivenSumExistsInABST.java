import java.util.*;
import java.io.*;

   public class CheckIfAGivenSumExistsInABST { 
     Node root;	    
     Node previous;
	
     public boolean findTarget(Node root, int target) {
       HashSet<Integer> set = new HashSet<>();
       return dfs(root, set, target);
     }
	
     public boolean dfs(Node root, HashSet<Integer> set, int target) {
       if(root == null) {
	 return false;
       }
	  
       if(set.contains(target - root.data)) {
	 return true;
       }
       set.add(root.data);     
	  
       return dfs(root.left, set, target) || dfs(root.right, set, target);
     }
	 
     public static void main(String[] args) {
       CheckIfAGivenSumExistsInABST tree = new CheckIfAGivenSumExistsInABST();
       tree.root = new Node(5);
       tree.root.left = new Node(3);
       tree.root.left.left = new Node(2);
       tree.root.left.right = new Node(4);
       tree.root.right = new Node(6);
       tree.root.right.right = new Node(7);
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the target sum which you want to check if it exists in the BST: ");
       int target = input.nextInt();  
       System.out.println();
       if(tree.findTarget(tree.root, target)) {
	 System.out.println("There exists two numbers that such that their sum is equal to the " + target);
       }
       else {
    	 System.out.println("There are no two numbers that such that their sum is equal to the " + target);
       }
     }
   }
