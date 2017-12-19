import java.util.*;
import java.io.*;

 public class MinimumHeightTrees { 	
	Node root;	    
    Node previous; 
    
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
      List<Integer> result = new ArrayList<>();	
      if (n <= 0) {
    	return result;
      }
      // Corner case: there is a single node and no edge at all
      if (n == 1 && edges.length == 0) {
        result.add(0);
        return result;
      }	
      
      // Step 1: construct the graph
      List<Set<Integer>> adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
    	adjList.add(new HashSet<>());
      }
      
      for (int[] edge : edges) {
        int from = edge[0];
        int to = edge[1];
        adjList.get(from).add(to);
        adjList.get(to).add(from);
      }
      
      // Remove leaf nodes
      List<Integer> leaves = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (adjList.get(i).size() == 1) {
          leaves.add(i);
        }
      }
      
      int count = n;
      while (count > 2) {
       count -= leaves.size();
       List<Integer> newLeaves = new ArrayList<>();
       for (int leaf : leaves) {
         int neighbor = adjList.get(leaf).iterator().next();
         adjList.get(neighbor).remove(leaf);
         if (adjList.get(neighbor).size() == 1) {
           newLeaves.add(neighbor);
         }
       }
       leaves = newLeaves;
      }
      return leaves;        
    }

	public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of nodes in the graph: ");
	  int n = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of rows in the list of undirected edges: ");
	  int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the list of undirected edges: ");
	  int y = input.nextInt();  
	  int[][] edges = new int[x][y];
	  System.out.println();
	  System.out.println("Please enter the actual values in the matrix: ");
	  for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++) {
          edges[i][j] = input.nextInt();
        }
      }
	  
	  List<Integer> result = new ArrayList<Integer>();
	  System.out.println();
	  result = findMinHeightTrees(n, edges); 
	  System.out.println("A list of the root labels of all the minimum height trees is as follows: " + result);
	}
 }
