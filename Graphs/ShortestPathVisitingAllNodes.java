import java.util.*;
import java.io.*;

  class State {
    int cover; // The set of nodes visited by a path so far 
    int head; // The current node
    State(int c, int h) {
      cover = c;
      head = h;
    }
  }

  public class ShortestPathVisitingAllNodes {
	  
	public static int shortestPathLength(int[][] graph) {
	  int N = graph.length;
	  java.util.Queue<State> queue = new LinkedList<State>();
	  int[][] distance = new int[1<<N][N];
      for (int[] row : distance) {
    	Arrays.fill(row, N*N);
      }
      for (int x = 0; x < N; x++) {
        queue.offer(new State(1<<x, x));
        distance[1 << x][x] = 0;
      }
      while (!queue.isEmpty()) {
    	State node = queue.poll();
        int d = distance[node.cover][node.head];  
        if (node.cover == (1<<N) - 1) {
          return d;
        }
        for (int child: graph[node.head]) {
          int cover2 = node.cover | (1 << child); // We can perform a breadth-first search on the states where state = (cover, head)
          if (d + 1 < distance[cover2][child]) {
        	distance[cover2][child] = d + 1;
            queue.offer(new State(cover2, child));
          }
        }
      }  
    	  
	  throw null;     
	}	    

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of nodes in the graph: ");
      int numberOfNodes = input.nextInt();  
      int[][] graph = new int[numberOfNodes][numberOfNodes];
      for(int i = 0; i < numberOfNodes; i++) {
        System.out.println();
        System.out.print("Please enter the number of elements that are directly connected with the node: ");
        int numberOfElements = input.nextInt();  
        System.out.println();
        System.out.print("Please enter the actual values of the elements that are directly connected with the node in the graph: ");
        for(int j = 0; j < numberOfElements; j++) {
          graph[i][j] = input.nextInt();
        }
      }
	  
      int lengthOfTheShortestPath = shortestPathLength(graph);
      System.out.println();
      System.out.println("The length of the shortest path that visits every node in an undirected, connected graph of N nodes is: " + lengthOfTheShortestPath); 
	}
  }
