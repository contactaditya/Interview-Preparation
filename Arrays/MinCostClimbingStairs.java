import java.util.*;
import java.io.*;

  public class MinCostClimbingStairs {
	  
	public static int minCostClimbingStairs(int[] cost) {
	  for (int i = 2; i < cost.length; i++) {
		cost[i] += Math.min(cost[i-1],cost[i-2]);    
	  }		
		
	  return Math.min(cost[cost.length-1],cost[cost.length-2]);      
	}	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
		    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }
		   
	  System.out.println();
	  int minimumCost = minCostClimbingStairs(array);
			  
	  System.out.println("The minimum cost to reach the top of the floor is: " + minimumCost);
	}
  }
