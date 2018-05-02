import java.util.*;
import java.io.*;

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
      parent = new int[size];
      for (int i = 0; i < size; i++) {
    	parent[i] = i;
      }
      rank = new int[size];
    }

    public int find(int x) {
      if (parent[x] != x) {
    	parent[x] = find(parent[x]);
      }
      return parent[x];
    }

    public boolean union(int x, int y) {
      int xr = find(x), yr = find(y);
      if (xr == yr) {
        return false;
      } else if (rank[xr] < rank[yr]) {
        parent[xr] = yr;
      } else if (rank[xr] > rank[yr]) {
        parent[yr] = xr;
      } else {
        parent[yr] = xr;
        rank[xr]++;
      }
      return true;
    }
  }

  public class RedundantConnection {
    static int MAX_EDGE_VAL = 1000;
   
    public static int[] findRedundantConnection(int[][] edges) {  
      DSU dsu = new DSU(MAX_EDGE_VAL + 1);
      for (int[] edge: edges) {
        if (!dsu.union(edge[0], edge[1])) {
          return edge;
        }
      }
		
      throw new AssertionError();
    }	  

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of rows of the graph: ");
      int x = input.nextInt();  
      System.out.println();
      int[][] edges = new int[x][2];
      System.out.println("Please enter the actual values of the edges in the graph: ");
      for(int i = 0; i < x; i++) {
        for(int j = 0; j < 2; j++) {
          edges[i][j] = input.nextInt();
        }
      }
	  
      int result[] = findRedundantConnection(edges); 
      System.out.println();
      System.out.print("An edge that can be removed so that the resulting graph is a tree of N nodes: ");
      for(int i = 0; i < result.length; i++) {
	System.out.print(result[i] + " ");
      }
    }
  }
