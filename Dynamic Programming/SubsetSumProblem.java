import java.util.*;
import java.io.*;

  public class SubsetSumProblem {
	static boolean dp[][]; 
	  
	private static void printAllSubsets(int[] array, int sum) {
	  if (array.length == 0 || sum < 0) {
	    return; 
	  }
	  // Sum 0 can always be achieved with 0 elements 
      dp = new boolean[array.length][sum + 1]; 
      for(int i = 0; i < array.length; i++) { 
        dp[i][0] = true;   
      } 
      // Sum array[0] can be achieved with single element 
      if (array[0] <= sum) {
        dp[0][array[0]] = true;
      }     
      // Fill rest of the entries in dp[][] 
      for (int i = 1; i < array.length; i++) {
        for (int j = 0; j < sum + 1; j++) {
          dp[i][j] = (array[i] <= j) ? (dp[i - 1][j] || dp[i - 1][j - array[i]]) : dp[i - 1][j]; 
        }
      }
      if (dp[array.length - 1][sum] == false) { 
        System.out.println("There are no subsets with" + " sum " + sum); 
        return; 
      } 
      System.out.println();
	  System.out.println("All subsets of given array with sum equal to given " + sum + " are: "); 
      ArrayList<Integer> p = new ArrayList<Integer>(); 
      printSubsetsRec(array, array.length - 1, sum, p); 
	}

	private static void printSubsetsRec(int[] array, int i, int sum, ArrayList<Integer> p) {
      // We print p[] only if array[0] is equal to sum OR dp[0][sum] is true. 
	  if (i == 0 && sum != 0 && dp[0][sum]) { 
	    p.add(array[i]); 
	    System.out.println(p); 
	    p.clear(); 
	    return; 
	  } 
	  // If sum becomes 0 
	  if (i == 0 && sum == 0) { 
		System.out.println(p); 
        p.clear(); 
        return; 
      } 
	  // If given sum can be achieved after ignoring current element. 
	  if (dp[i-1][sum]) {
		ArrayList<Integer> b = new ArrayList<Integer>(); 
        b.addAll(p); 
        printSubsetsRec(array, i-1, sum, b);    
	  }
	  // If given sum can be achieved after considering current element. 
	  if (sum >= array[i] && dp[i - 1][sum - array[i]]) {
		p.add(array[i]); 
        printSubsetsRec(array, i-1, sum - array[i], p); 
	  }
	}
	
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	 
      System.out.println();	
      System.out.print("Please enter the number: ");
      for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();
      }
	
      System.out.println();	
      System.out.print("Enter the sum of subset that you want to check whether it is present in the array or not: ");
      int sum = input.nextInt(); 
      
      printAllSubsets(array, sum); 
      input.close();
	}
  }
