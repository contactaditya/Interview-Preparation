import java.util.*;
import java.io.*;

  public class KnapsackProblem {
	 
    public static int KnapsackProblem(int capacity, int[] weight, int[] values, int length) {
       int K[][] = new int[length+1][capacity+1];	
	 
       // Build table K[][] in bottom up manner
       for (int i = 0; i <= length; i++) {
	  for (int w = 0; w <= capacity; w++) {
	    if(i == 0 || w == 0) {
	       K[i][w] = 0;
	    }	
	    else if(weight[i-1] <= w) {
	      //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight is greater than the value without the current item itself
	      K[i][w] = Math.max(values[i-1] + K[i-1][w-weight[i-1]], K[i-1][w]);  
	    }
	    else {
	      // If the current item's weight is more than the running weight, just carry forward the value without the current item
	      K[i][w] = K[i-1][w];	
	    }
	  }
       }
		
       return K[length][capacity];
    }

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of elements in the array: ");
       int numbers = input.nextInt();   
       int weight[] = new int[numbers];
       int values[] = new int[numbers];
	    
       System.out.print("\n");
       System.out.print("Please enter the weights of the different elements: ");
       for (int i = 0; i < numbers; i++) {
         weight[i] = input.nextInt();
       }
       System.out.println();
       System.out.print("Please enter the value associated with different weights: ");
       for (int i = 0; i < numbers; i++) {
         values[i] = input.nextInt();
       }
       System.out.println();
       System.out.print("Please enter the maximum total value in the knapsack: ");
       int capacity = input.nextInt();   
	  
       int knapsack = KnapsackProblem(capacity, weight, values, numbers);
       System.out.println();
       System.out.println("The maximum total value in the knapsack is: " + knapsack);  
   }
 }
