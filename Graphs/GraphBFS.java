import java.io.*;
import java.util.*;

public class GraphBFS {
 private int vertices; // Number of vertices
 private LinkedList<Integer> adj[]; // Adjacency List for each vertex
 
 public GraphBFS(int v) {
  vertices = v;
  adj = new LinkedList[v];
  
  for(int i=0;i<v;i++) {
	adj[i] = new LinkedList();  
  }	 
 }
 
 void addEdge(int source, int destination) {
   adj[source].add(destination); 
 }

 void BFS(int source) {
 //	Mark all the vertices of the graph as not visited. 
  boolean visited[] = new boolean[vertices];
  
 //	Create a queue for BFS.
  LinkedList<Integer> queue = new LinkedList<Integer>();
  
  // Mark the current node as visited and enqueue it.
  visited[source] = true;
  queue.add(source);
  System.out.print("The BFS traversal of the graph is: ");
  
  while(!queue.isEmpty()) {
  // Dequeue a vertex from queue and print it.  
   source = queue.poll();
   System.out.print(source + " ");
   
  // Get all adjacent vertices of the dequeued vertex source. If the vertex has not been visited yet, then mark it visited and enqueue it.
	
   for(Integer neighbour : adj[source]) {
	if(!visited[neighbour]) {
	 visited[neighbour] = true;
	 queue.add(neighbour);
	}   
   }  
  }
 }
 
 public static void main(String[] args) {
  GraphBFS g = new GraphBFS(7);
  g.addEdge(1,2);
  g.addEdge(1,3);
  g.addEdge(2,4);
  g.addEdge(2,5);
  g.addEdge(3,5);
  g.addEdge(4,5);
  g.addEdge(4,6);
  g.addEdge(5,6);
     
  g.BFS(1);
     
 }
}
