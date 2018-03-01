import java.util.*;
import java.io.*;

  public class DetectCycleInADirectedGraph {    
	private static int vertices; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List for each vertex
	
    public DetectCycleInADirectedGraph(int v) {
      vertices = v;
      adj = new LinkedList[v];
		  
      for(int i=0;i<v;i++) {
	    adj[i] = new LinkedList();  
      }	 
    }

    void addEdge(int source, int destination) {
      adj[source].add(destination); 
    }

    public boolean isCyclic() {    
      // Mark all the vertices as not visited and not part of recursion stack
      boolean visited[] = new boolean[vertices];
      boolean explored[] = new boolean[vertices];
      for (int i = 0; i < vertices; i++) {
        visited[i] = false;
        explored[i] = false;
      }

      // Call the recursive helper function to detect cycle in different DFS trees
      for (int i = 0; i < vertices; i++) {
        if (isCyclicUtil(i, visited, explored)) {
          return true;
        }
      }    
      return false;
    }

    public boolean isCyclicUtil(int vertices, boolean visited[], boolean explored[]) { 
      Integer i;	
      if(visited[vertices] == false) {   
    	// Mark the current node as visited and part of recursion stack
        visited[vertices] = true;
        explored[vertices] = true;
        
        // Recurse for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[vertices].iterator();
        while (it.hasNext()) {
          i = it.next();  	
          if(!visited[i] && isCyclicUtil(i, visited, explored)) {
            return true;
          }
          else if(explored[i]) {
            return true;
          }
        }
      }
      explored[vertices] = false;  // remove the vertex from recursion stack
      return false;
    }

	public static void main(String[] args) {    
	  DetectCycleInAnUndirectedGraph g = new DetectCycleInAnUndirectedGraph(5);
	  g.addEdge(0, 1);
	  g.addEdge(0, 2);
	  g.addEdge(1, 2);
	  g.addEdge(2, 0);
	  g.addEdge(2, 3);
	  g.addEdge(3, 3);
	 
      boolean IsACycle = g.isCyclic();
	  	  
      if(IsACycle) {
  	    System.out.println("There is a cycle in the graph.");  
      } 
      else {
  	    System.out.println("There is no cycle in the graph.");    
      }
	}
  }
