import java.util.*;
import java.io.*;

  public class AllPathsFromSourceToTarget {
	static List<List<Integer>> result;  
	  
	public static List<List<Integer>> allPathsSourceTarget(int graph[][]) {
	  result = new ArrayList<List<Integer>>(); 
	  dfs(0, graph, new ArrayList<Integer>());
	  return result;
	}	  

	private static void dfs(int node, int[][] graph, ArrayList<Integer> list) {  
	  list.add(node);
	  if(node == graph.length - 1) {
        result.add(new ArrayList<>(list));
        list.remove(list.size() - 1);
        return;
      }
	  for(int n : graph[node]) {
        dfs(n, graph, list);
	  }
	  
	  list.remove(list.size() - 1);
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
	  
	  List<List<Integer>> result = new ArrayList<List<Integer>>();
	  result = allPathsSourceTarget(graph);
	  System.out.println();
	  System.out.println("All possible paths from source to target are: ");
	  System.out.print('[');
	  for(List<Integer> innerList : result) {
	    System.out.println(" " + innerList);
	  }
	  System.out.print(']');
	}
  }
