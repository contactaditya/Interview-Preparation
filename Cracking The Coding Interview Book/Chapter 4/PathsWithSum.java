import java.io.*;
import java.util.*;

 public class PathsWithSum {  
    Node root;	    
    Node previous;

    public static int countPathsWithSum(Node root, int targetSum) {   
      return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }
  
    public static int countPathsWithSum(Node node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {   
      if (node == null) {
        return 0;
      }
	  
      // Count paths with sum ending at current node   
      runningSum += node.data;
      int sum = runningSum - targetSum; 
      int totalPaths = pathCount.getOrDefault(sum, 0); 
 
      if(runningSum == targetSum) {
	totalPaths++;
      }
	 
      // Add runningSum to pathCounts. 
      incrementHashTable(pathCount, runningSum, 1);
      totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
      totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
      incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
	 	  
      return totalPaths;
    }
  
    public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) { 
      int newCount = hashTable.getOrDefault(key, 0) + delta;
      if(newCount == 0) {
	hashTable.remove(key);
      } else {
	hashTable.put(key, newCount); 
      }
    }
  
    public static void main(String[] args) { 	
      PathsWithSum tree = new PathsWithSum();
      tree.root = new Node(10); 
      tree.root.left = new Node(5);
      tree.root.right = new Node(-3);
      tree.root.left.left = new Node(3);
      tree.root.left.left.left = new Node(3);
      tree.root.left.left.right = new Node(-2);
      tree.root.left.right = new Node(2);
      tree.root.left.right.right = new Node(1);
      tree.root.right.right = new Node(11);
      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the sum for which you want to calculate the number of paths: ");
      int targetSum = input.nextInt();  
      
      System.out.println();
      int PathsWithSum = countPathsWithSum(tree.root, targetSum);
      System.out.print("The number of paths that sum to " + targetSum + " are: " + PathsWithSum);  
    }
 }
