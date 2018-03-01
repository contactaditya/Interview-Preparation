import java.io.*;
import java.util.*;

  public class DetectCycleInAnUndirectedGraph {  
    private static int vertices; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List for each vertex
	
    public DetectCycleInAnUndirectedGraph(int v) {
      vertices = v;
      adj = new LinkedList[v];
		  
      for(int i=0;i<v;i++) {
	adj[i] = new LinkedList();  
      }	 
    }
  
    void addEdge(int source, int destination) {
      adj[source].add(destination); 
      adj[destination].add(source); 
    }
  
    public boolean isCyclic() {    
      // Mark all the vertices as not visited and not part of recursion stack
      boolean visited[] = new boolean[vertices];
      for (int i = 0; i < vertices; i++) {
        visited[i] = false;
      }

      // Call the recursive helper function to detect cycle in different DFS trees
      for (int u = 0; u < vertices; u++) {
        if (!visited[u]) { // Don't recurse for u if already visited
          if (isCyclicUtil(u, visited, -1)) {
            return true;
          }
        }
      }    
      return false;
    }
  
    public boolean isCyclicUtil(int vertices, boolean visited[], int parent) {    
      // Mark the current node as visited
      visited[vertices] = true;
      Integer i;
	
      // Recur for all the vertices adjacent to this vertex
      Iterator<Integer> it = adj[vertices].iterator();
      while (it.hasNext()) {   
        i = it.next();
 
        // If an adjacent is not visited, then recur for that adjacent
        if (!visited[i]) { // Don't recurse for u if already visited
          if (isCyclicUtil(i, visited, vertices)) {
            return true;
          }
        }
        // If an adjacent is visited and not parent of current vertex, then there is a cycle.
        else if(i != parent) {
          return true;	
        }
      }
   
      return false;
    }

    public static void main(String[] args) {  
      DetectCycleInAnUndirectedGraph g = new DetectCycleInAnUndirectedGraph(5);
      g.addEdge(1,0);
      g.addEdge(0,2);
      g.addEdge(2,0);
      g.addEdge(0,3);
      g.addEdge(3,4);
	  
      boolean IsACycle = g.isCyclic();
	  	  
      if(IsACycle) {
	System.out.println("There is a cycle in the graph.");  
      }
      else {
	System.out.println("There is no cycle in the graph.");    
      }
   }
 }
