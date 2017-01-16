import java.io.*;
import java.util.*;

public class FloydWarshallAlgorithm {
	private static final int INFINITE = 99999; 
	private static final int vertices = 4; // Number of vertices
	
	private static void floydWarshall(int[][] graph) {
	  int distance[][] = new int[vertices][vertices];	
	  for (int i = 0; i < vertices; i++) {
         for (int j = 0; j < vertices; j++) {
        	distance[i][j] = graph[i][j];
         }
	   }
	  
	  for (int k = 0; k < vertices; k++) {
      // Pick all vertices as source one by one
        for (int i = 0; i < vertices; i++) {
      // Pick all vertices as destination for the above picked source
          for (int j = 0; j < vertices; j++) {
      // If vertex k is on the shortest path from i to j, then update the value of distance[i][j]
             if (distance[i][k] + distance[k][j] < distance[i][j]) {
            	distance[i][j] = distance[i][k] + distance[k][j]; 
             }
           }
         }
	  } 
    }
	
	private static void printSolution(int[][] distance) {
	  System.out.println();
	  System.out.println("This matrix shows the shortest distances between every pair of vertices: "); 
	  System.out.println();
	  for (int i = 0; i < vertices; i++) {
	    for (int j = 0; j < vertices; j++) {
	      if(distance[i][j]==99999) {
	    	System.out.print("INF" + " ");  
	      }
	     else {
		    System.out.print(distance[i][j] + " ");
	      }
		}
	    System.out.println();
	  }	
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  int[][] graph = new int[4][4];
	  System.out.println("Please enter the actual values in the graph: ");
	  for(int i=0; i < vertices; i++) {
       for(int j=0; j < vertices; j++){
    	  graph[i][j] = input.nextInt();
       }
      }
	  	  
	  floydWarshall(graph); 
	  printSolution(graph);
		
  }
}
