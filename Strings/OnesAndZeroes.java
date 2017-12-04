import java.util.*;
import java.io.*;

  public class OnesAndZeroes {
	 
    public static int findMaxForm(String[] string, int m, int n) {
       int[][] dp = new int[m+1][n+1];
       for (String s : string) {
	 int[] count = count(s);
	 for (int i=m; i>=count[0]; i--) { 
	   for (int j=n; j>=count[1]; j--) {
	     dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
	   }
	 }
       }
       return dp[m][n];	  
    }	  

    private static int[] count(String string) {
      int[] result = new int[2];
      for (int i=0; i<string.length(); i++) {
	result[string.charAt(i) - '0']++;
      }
      return result;
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the string array: ");
      int number = input.nextInt();  
      String string[] = new String[number];
				
      System.out.println();	
      input.nextLine();
      System.out.println("Please enter the actual values in the array constiting of only 0 and 1: ");
      for (int i = 0; i < number; i++) {
	string[i] = input.nextLine(); 
      }
	   
      System.out.println();	
      System.out.print("Please enter the number of 0's: ");
      int m = input.nextInt();  
	   
      System.out.println();	
      System.out.print("Please enter the number of 1's: ");
      int n = input.nextInt();  
					
      int maximumNumberOfStrings = findMaxForm(string, m , n);
      System.out.println();	
      System.out.print("The maximum number of strings that you can form with given " + m + " 0s and " + n + " 1s are: " + maximumNumberOfStrings);

    }
  }
