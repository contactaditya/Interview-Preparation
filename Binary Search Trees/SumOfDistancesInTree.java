import java.util.*;
import java.io.*;

  public class SumOfDistancesInTree {
	static int[] ans, count;
	static List<Set<Integer>> graph;
    static int N;
	 
	public int[] sumOfDistancesInTree(int N, int[][] edges) {  
	  this.N = N;
      graph = new ArrayList<Set<Integer>>();
      ans = new int[N];
      count = new int[N];
      Arrays.fill(count, 1);
      
      for (int i = 0; i < N; i++) {
        graph.add(new HashSet<Integer>());
      }
      for (int[] edge: edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
      }
      dfs(0, -1);
      dfs2(0, -1);
      return ans;  
    } 
	
	// The first DFS traversal computes the number of children and the sum of distances to all children for each node
	private static void dfs(int node, int parent) {  
	  for (int nei : graph.get(node)) {
        if (nei != parent) {
          dfs(nei, node);
          count[node] += count[nei];
          ans[node] += ans[nei] + count[nei];
        }
	  }
	}
	
	// The second DFS travrsal computes the sum of distances for each node based on previously computed results
	private static void dfs2(int node, int parent) {
	  for (int nei: graph.get(node)) {
	    if (nei != parent) {
	      ans[nei] = ans[node] - count[nei] + N - count[nei];
	      dfs2(nei, node);
	    }
	  }
	}
	
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of nodes in the undirected connected tree: ");
	  int N = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of edges in the trees: ");
	  int x = input.nextInt();  
	  int[][] edges = new int[x][2];
	  System.out.println();
	  System.out.println("Please enter the actual values in the edges: ");
	  for(int i = 0; i < x; i++) {
        for(int j = 0; j < 2; j++) {
          edges[i][j] = input.nextInt();
        }
      }
	  
	  SumOfDistancesInTree tree = new SumOfDistancesInTree();
	  
	  int result[] = tree.sumOfDistancesInTree(N, edges);
	  System.out.println();
	  System.out.print("The sum of the distances between node i and all other nodes is: ");
	  for(int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  } 
	}
  }
