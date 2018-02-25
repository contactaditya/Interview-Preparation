import java.util.*;
import java.io.*;

  public class IsGraphBipartite { 
	  
	public static boolean isBipartite(int[][] graph) { 
	  int n = graph.length;
      int[] colors = new int[n];  // Create a colors array to store colors assigned to all veritces.
      Arrays.fill(colors, -1); // The value '-1' of colors[i] is used to indicate that no color is assigned to vertex 'i'.
      
      // For each uncolored node, we'll start the coloring process by doing a depth-first-search on that node.
      for (int start = 0; start < n; start++) {
        if (colors[start] == -1 && !validColor(graph, colors, 0, start)) {
           return false;
        }
      }
	  
	  return true;      
	}	  

	private static boolean validColor(int[][] graph, int[] colors, int color, int node) {
	  if (colors[node] != -1) {
        return colors[node] == color;
      }       
	  colors[node] = color;       
      for (int next : graph[node]) {
        if (!validColor(graph, colors, 1 - color, next)) {
           return false;
        }
      }
	
	  return true;
	}

	public static void main(String[] args) {   	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the graph: ");
	  int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the graph: ");
	  int y = input.nextInt();  
	  int[][] graph = new int[x][y];
	  System.out.println();
	  System.out.println("Please enter the actual values in the graph: ");
	  for(int i = 0; i < x; i++) {
        for(int j = 0; j < y; j++) {
          graph[i][j] = input.nextInt();
        }
      }
	  
	  boolean isGraphBipartite = isBipartite(graph);
	  System.out.println();
	  if(isGraphBipartite) {
		System.out.println("Yes the graph is bipartite and we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.");  
	  }
      else {
		System.out.println("No the graph is not bipartite and we cannot split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.");  
	  }

	}
  }
