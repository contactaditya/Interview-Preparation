import java.io.*;
import java.util.*;

public class GraphDFS {  
   private int vertices; // Number of vertices
   private LinkedList<Integer> adj[]; // Adjacency List for each vertex

   public GraphDFS(int v) {
     vertices = v;
     adj = new LinkedList[v];
 
     for(int i=0;i<v;i++) {
       adj[i] = new LinkedList();  
     }	 
   }

   void addEdge(int source, int destination) {
      adj[source].add(destination); 
   }
 
   public void DFS(int source) { 
     // Mark all the vertices of the graph as not visited. 
     boolean visited[] = new boolean[vertices];
  
     for(int i = 0; i < vertices; i++) {  
        visited[i] = false;
     }
  
     System.out.print("The DFS traversal of the graph is: ");
  
     for (int i = 0; i < vertices; i++) {
       if (!visited[i]) {
         DFSUtil(i, visited);
       }  
     }
   }
  
   public void DFSUtil(int source, boolean visited[]) { 
     // Create a stack for DFS.  
    java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
    visited[source] = true;	   
    stack.push(source);
	    
    while(!stack.isEmpty()) {
      // Peek a vertex from stack and print it.  
      int v = stack.peek();
      System.out.print(v + " ");     
      stack.pop();
	 	
      for(Integer neighbour : adj[v]) {
        if(!visited[neighbour]) {
          visited[neighbour] = true;
          stack.push(neighbour);
        }  
      }
    }
   }

   public void DFS1(int source) {
		
      java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
      List<Integer> list = new ArrayList<Integer>();
      stack.push(source);
      list.add(source);
  
      System.out.println();
      System.out.println();
      System.out.print("The DFS traversal of the graph is: ");
   
      while(!stack.empty()) {
        int temp = stack.pop();
        System.out.print(temp + " "); //Printing the root
        for(Integer i : adj[temp]) {
          if(!list.contains(i)) {
            list.add(i);
            stack.push(i);						
          }
        }
      }
   }
		
   public static void main(String[] args) {
      GraphDFS g = new GraphDFS(5);
	 
      g.addEdge(1, 0);
      g.addEdge(0, 2);
      g.addEdge(2, 1);
      g.addEdge(0, 3);
      g.addEdge(3, 4);
      g.addEdge(4, 0);
  
      g.DFS(0);
  
      g.DFS1(0);
   }
}
