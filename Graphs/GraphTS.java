import java.io.*;
import java.util.*;

  public class GraphTS {  
    private int vertices; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List for each vertex

    public GraphTS(int v) {
      vertices = v;
      adj = new LinkedList[v];

      for(int i=0;i<v;i++) {
        adj[i] = new LinkedList();  
      }	 
    }

    void addEdge(int source, int destination) {
      adj[source].add(destination); 
    }
 
    public void topologicalSort() { 
    	
      java.util.Stack<Integer> stack = new java.util.Stack<Integer>();	  	
   
      // Mark all the vertices as not visited
      boolean visited[] = new boolean[vertices];
      for(int i = 0; i < vertices; i++) {  
	    visited[i] = false;
      }
     
      for (int i = 0; i < vertices; i++) {
        if (!visited[i]) {
	      topologicalSortUtil(i, visited, stack);
        }  
      }
      
      System.out.print("The topological sort of the graph is: ");
      
      while(!stack.isEmpty()) {
        // Peek a vertex from stack and print it.  
        System.out.print(stack.pop() + " ");
      }
    }
 
    public void topologicalSortUtil(int v, boolean visited[], java.util.Stack<Integer> stack) { 
      // Mark the current node as visited	
      visited[v] = true;
      Integer i;
      
      // Recurse for all the vertices adjacent to this vertex
      Iterator<Integer> it = adj[v].iterator();
      while (it.hasNext()) {  
        i = it.next();
        if(!visited[i]) {
          topologicalSortUtil(i, visited, stack);
        }  
      }
      
      // Push current vertex to stack which stores result
      stack.push(new Integer(v));
    }
	
    public static void main(String[] args) {  
      GraphTS g = new GraphTS(6);

      g.addEdge(5, 2);
      g.addEdge(5, 0);
      g.addEdge(4, 0);
      g.addEdge(4, 1);
      g.addEdge(2, 3);
      g.addEdge(3, 1);

      g.topologicalSort();

    }
  }
