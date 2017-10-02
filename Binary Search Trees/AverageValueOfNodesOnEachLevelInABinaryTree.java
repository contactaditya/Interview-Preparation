import java.util.*;
import java.io.*;

 public class AverageValueOfNodesOnEachLevelInABinaryTree { 	
    Node root;	    
    Node previous;
	
    public List<Double> averageOfLevels(Node root) {
      List<Double> average = new ArrayList<Double>();
      // list counter for count number of node in same level
      List<Integer> count = new ArrayList<Integer>();
      dfs(0, root, average, count);
      for (int level = 0; level < average.size(); level++) {
    	average.set(level, average.get(level)/count.get(level));
      }
      return average;
    }
	
    public void dfs(int level, Node root, List<Double> average, List<Integer> count) {
       if (root == null) {
	 return;
       }
       if (level >= average.size()) {
	  average.add(0.0);
	  count.add(0);
       }
       average.set(level, average.get(level) + root.data);
       count.set(level, count.get(level) + 1);
	  
       dfs(level+1, root.left, average, count);
       dfs(level+1, root.right, average, count);
    }	

    public static void main(String[] args) {
       AverageValueOfNodesOnEachLevelInABinaryTree tree = new AverageValueOfNodesOnEachLevelInABinaryTree();
       tree.root = new Node(3);
       tree.root.left = new Node(9);
       tree.root.right = new Node(20);
       tree.root.right.left = new Node(15);
       tree.root.right.right = new Node(7);
       List<Double> result = new ArrayList<Double>();
       result = tree.averageOfLevels(tree.root);		
			     
       System.out.print("The average value of the nodes on each level of the binary tree is: " + result);
    }
 }
