import java.util.*;
import java.io.*;

 public class FindAllRootToLeafPathsWhereEachPathSumEqualsTheGivenSum { 	
   static Node root;	    
   static Node previous;
	
   public static List<List<Integer>> hasPathSum(Node node, int sum) {
     List<List<Integer>> result = new ArrayList<List<Integer>>();	
     if (node == null) {
       return result;
     }
     List<Integer> temp = new ArrayList<Integer>();
     hasPathSum(node, sum, result, temp);
     return result;
   }
	
   public static void hasPathSum(Node node, int sum, List<List<Integer>> result, List<Integer> temp) {
     if(node == null) {
       return;
     }
	    
     temp.add(new Integer(node.data));
		
     //search path of left node and search path of right node
     if(node.left == null && node.right == null && sum == node.data) {
       result.add(new ArrayList<Integer>(temp));	
       temp.remove(temp.size() - 1);
       return;
     }
     else {	
       hasPathSum(node.left, sum - node.data, result, temp);
       hasPathSum(node.right, sum - node.data, result, temp);
     }
	    
     temp.remove(temp.size() - 1);
   }
	
   public static void main(String[] args) { 	  
     FindAllRootToLeafPathsWhereEachPathSumEqualsTheGivenSum tree = new FindAllRootToLeafPathsWhereEachPathSumEqualsTheGivenSum();
     tree.root = new Node(5);
     tree.root.left = new Node(4);
     tree.root.right = new Node(8);
     tree.root.left.left = new Node(11);
     tree.root.right.left = new Node(13);
     tree.root.right.right = new Node(4);
     tree.root.left.left.left = new Node(7);
     tree.root.left.left.right = new Node(2);
     tree.root.right.right.left = new Node(5);
     tree.root.right.right.right = new Node(1);
	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the sum for which you want to calculate the number of paths: ");
     int targetSum = input.nextInt();  
	      
     System.out.println();
     List<List<Integer>> result = new ArrayList<List<Integer>>();
     result = hasPathSum(tree.root, targetSum);
     System.out.println("All root to leaf paths where each path's sum equals the given sum are: ");
     for (List<Integer> list : result) {
       System.out.print("[");
       for (Integer i : list) {
	 System.out.print(" " + i + " ");
       }
       System.out.print("]");
       System.out.println();
     }
   }
 }
