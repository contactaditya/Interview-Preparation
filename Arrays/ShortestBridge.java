import java.util.*;
import java.io.*;

  public class ShortestBridge {
	  
    public static int shortestBridge(int[][] array) {
      int m = array.length, n = array[0].length;
      boolean[][] visited = new boolean[m][n];
      int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
      java.util.Queue<int[]> queue = new LinkedList<int[]>(); 
      boolean found = false;
      // DFS to find an island, mark it in `visited`
      for (int i = 0; i < m; i++) {
        if (found) {
          break;
        }
        for (int j = 0; j < n; j++) {
          if (array[i][j] == 1) {
            dfs(array, visited, queue, i, j, dirs);
            found = true;
            break;
          }
        }
      }
      // BFS to expand this island
      int step = 0;
      while (!queue.isEmpty()) {
    	int size = queue.size();
        while (size-- > 0) { 
          int current[] = queue.poll();
          for (int[] dir : dirs) {
            int i = current[0] + dir[0];
            int j = current[1] + dir[1];  
            if (i >= 0 && j >= 0 && i < m && j < n && !visited[i][j]) {
              if (array[i][j] == 1) {
                return step;
              }
              queue.offer(new int[]{i, j});
              visited[i][j] = true;
            }
          }
        }
        step++;
      }
    
      return -1;
    }
	
    private static void dfs(int array[][], boolean visited[][], java.util.Queue<int[]> q, int i, int j, int[][] dirs) {
      if (i < 0 || j < 0 || i >= array.length || j >= array[0].length || visited[i][j] || array[i][j] == 0) {
	return;
      }
      visited[i][j] = true;
      q.offer(new int[]{i, j});
      for (int[] dir : dirs) {
	dfs(array, visited, q, i + dir[0], j + dir[1], dirs);
      }
    }

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of rows in the array: ");
      int x = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of columns in the array: ");
      int y = input.nextInt();   
      int[][] array = new int[x][y];
      System.out.println();
      System.out.println("Please enter the actual values in the array: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++) {
	  array[i][j] = input.nextInt();
	}
      }
      int result = shortestBridge(array);
      System.out.println();
      System.out.println("The smallest number of 0s that must be flipped are: " + result);
      input.close();
    }
  }
