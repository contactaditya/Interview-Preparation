import java.io.*;
import java.util.*;

public class DijkstrasAlgorithm {
  public static final int vertices=9;	
  
  // A function to find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tre
  public int minimumDistance(int distance[], Boolean shortestPathTreeSet[]) {
    int minimum = Integer.MAX_VALUE;
    int minimumIndex = -1;
	
    for (int v = 0; v < vertices; v++) {
      if (shortestPathTreeSet[v] == false && distance[v] <= minimum) {
	minimum = distance[v];
	minimumIndex = v;
      }			
    }
	  
    return minimumIndex;	  
  }
  
  public void printSolution(int distance[], int n) {
    System.out.println("Vertex   Distance from Source");
    for (int i = 0; i < vertices; i++) {
      System.out.println("  " + i +" \t\t "+ distance[i]);
    }
  }
  
  public void dijkstra(int graph[][], int source) {
    int distance[] = new int[vertices];
    Boolean shortestPathTreeSet[] = new Boolean[vertices];
    
    // Initialize all distances as INFINITE and shortestPathTreeSet[] as false  
    for (int i = 0; i < vertices; i++) {
      distance[i] = Integer.MAX_VALUE;
      shortestPathTreeSet[i] = false;
    }
    
    // Distance of source vertex from itself is always 0
    distance[source] = 0;
     
    for (int count = 0; count < vertices-1; count++) {
      // Pick the minimum distance vertex from the set of vertices not yet processed. u is always equal to source in first iteration.	
      int u = minimumDistance(distance, shortestPathTreeSet);	
      // Mark the picked vertex as processed
      shortestPathTreeSet[u] = true;
      
      // Update distance[v] only if is not in shortestPathTreeSet, there is an edge from u to v, and total weight of path from source to v through u is smaller than current value of distance[v] 
      
      for (int v = 0; v < vertices; v++) {
        if (!shortestPathTreeSet[v] && graph[u][v]!=0 && distance[u] != Integer.MAX_VALUE && distance[u]+graph[u][v] < distance[v])
    	  distance[v] = distance[u] + graph[u][v]; 
      }	
    }  
    printSolution(distance, vertices);
  }
  
  public static void main(String[] args) {
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    
    DijkstrasAlgorithm d = new DijkstrasAlgorithm();
    d.dijkstra(graph, 0);
  }
}
