import java.util.*;
import java.io.*;

 public class MostFrequentSubtreeSum {
    Node root;	    
    Node previous; 
    static int max = 0;
   
    public static int[] findFrequentTreeSum(Node root) {
      if(root==null) {
    	return new int[0];
      }
      Map<Integer, Integer> map = new HashMap<>();
      helper(root, map);
      List<Integer> result = new ArrayList<>();
      for(Map.Entry<Integer, Integer> me: map.entrySet()) {
	if(me.getValue() == max) {
	  result.add(me.getKey());
	}
      }
	        
      return result.stream().mapToInt(i->i).toArray();
    } 

    private static int helper(Node root, Map<Integer, Integer> map) {
      if (root == null) {
	return 0;	
      }
      int sum = root.data + helper(root.left, map) + helper(root.right, map);
      map.put(sum, map.getOrDefault(sum,0)+1);
      max = Math.max(max, map.get(sum));
      return sum;
    }

    public static void main(String[] args) { 
      MostFrequentSubtreeSum tree = new MostFrequentSubtreeSum();
      tree.root = new Node(5);
      tree.root.left = new Node(2);
      tree.root.right = new Node(-3);

      int mostFrequentSubtreeSum[] = findFrequentTreeSum(tree.root);
      System.out.print("The most frequent subtree sum with all the values with the highest frequency is: ");
      for(int i = 0; i < mostFrequentSubtreeSum.length; i++) {
	System.out.print(mostFrequentSubtreeSum[i] + " ");
      }
    }
 }
