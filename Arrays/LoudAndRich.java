import java.util.*;
import java.io.*;

  public class LoudAndRich {
    ArrayList<Integer>[] graph;
    int[] answer;
    int[] quiet;  
	  
    public int[] loudAndRich(int[][] richer, int[] quiet) {
      int N = quiet.length;
      graph = new ArrayList[N];
      answer = new int[N];
      this.quiet = quiet;
		
      for(int node = 0; node < N; node++) {
        graph[node] = new ArrayList<Integer>();
      }
	  
      for (int[] edge : richer) {
        graph[edge[1]].add(edge[0]);
      }
	  
      Arrays.fill(answer, -1);
	  
      for (int node = 0; node < N; node++) {
        dfs(node);
      }
	  
      return answer;      
    }	  
	
    public int dfs(int node) {
      if (answer[node] == -1) {
        answer[node] = node;
	for (int child : graph[node]) {
	  int candidate = dfs(child);
	  if (quiet[candidate] < quiet[answer[node]]) {
	    answer[node] = candidate;
	  }
	}
      }
	  
      return answer[node];
    }
 
    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of people: ");
      int number = input.nextInt(); 
      int[][] richer = new int[number][number];
      System.out.println();
      System.out.println("Please enter the actual different amounts of money: ");
      for(int i = 0; i < number; i++) {
        for(int j = 0; j < 2; j++) {
          richer[i][j] = input.nextInt();
        }
      }
	   
      System.out.println();
      System.out.print("Enter number of levels of quietness: ");
      int numbers = input.nextInt();   
      int quiet[] = new int[numbers];

      System.out.println(); 
      System.out.print("Please enter the actual different values of quietness: ");
      for (int i = 0; i < numbers; i++) {
	quiet[i] = input.nextInt();
      }
	  
      LoudAndRich loud = new LoudAndRich();
	  
      int result[] = loud.loudAndRich(richer, quiet); 
      System.out.println();
      System.out.print("The least quiet person among all people who definitely have equal to or more money than person x is: ");	
      for (int i = 0; i < numbers; i++) {
	System.out.print(result[i] + " ");	
      }
    }
  }
