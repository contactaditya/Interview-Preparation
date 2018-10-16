import java.util.*;
import java.io.*;

  public class MinimumPathSum1 {
	  
    public static int minPathSum(ArrayList<ArrayList<Integer>> list) {
      if(list == null || list.size() == 0 || list.get(0).size() == 0) {
	return 0;	
      }
	  
      int m = list.size();
      int n = list.get(0).size();
      int dp[][] = new int[m][n];
      dp[0][0] = list.get(0).get(0); 
	  
      // update the first row
      for(int i = 1; i < n; i++) {
	dp[0][i] = dp[0][i-1] + list.get(0).get(i);
      }
      
      // update the first column
      for(int j = 1; j < m; j++) {
	dp[j][0] = dp[j-1][0] + list.get(j).get(0);
      }
	  
      for (int i = 1; i < m; i++) {
	for (int j = 1; j < n; j++) {
	  dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + list.get(i).get(j);
	}
      }
	  
      return dp[m-1][n-1];   	
    }

    public static void main(String[] args) {      
      Scanner input = new Scanner(System.in);
      ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();	
      System.out.print("Please enter the number of lists: ");
      int numberofLists = input.nextInt();  
      for (int i = 0; i < numberofLists; i++) {
	System.out.println();	
	System.out.print("Enter number of elements in this list: ");
	int number = input.nextInt();  
	ArrayList<Integer> numbers = new ArrayList<>();	
			
	System.out.println();	
	System.out.print("Please enter the elements of the list: ");
        for (int j = 0; j < number; j++) {
          numbers.add(input.nextInt());
	}
        list.add(numbers);
      }
	    
      int minPathSum = minPathSum(list); 
      System.out.println();
      System.out.println("The sum of the path from top left to bottom right which minimizes the sum of all numbers along its path is: " + minPathSum);
      input.close();
    }
  }
