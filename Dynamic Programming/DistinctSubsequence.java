import java.io.*;
import java.util.*;

  public class DistinctSubsequence {
	  
    public static int numDistinct(String string1, String string2) {
      int m = string2.length(); 
      int n = string1.length(); 
      // T can't appear as a subsequence in S   
      if(m > n) {
	return 0; 
      }
      int dp[][] = new int[m + 1][n + 1];
      // Initializing first column with zeros as an empty string can't have another string as subsequence
      for (int i = 1; i <= m; i++) {
	dp[i][0] = 0; 	
      }
      // Initializing first row with all 1s. An empty string is subsequence of all     
      for (int j = 0; j <= n; j++) {
	dp[0][j] = 1; 	
      }
      // Fill dp in an bottom up manner
      for (int i = 1; i <= m; i++) { 
        for (int j = 1; j <= n; j++) { 
          // If last characters don't match, then value is same as the value without last character in string1. 	
          if(string2.charAt(i - 1) != string1.charAt(j - 1)) {
            dp[i][j] = dp[i][j - 1];  
          }
          // Else value is obtained considering two cases: a) All substrings without last character in string1 b) All substrings without last characters in both. 
          else {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]; 
          }
        }
      }
	  
      return dp[m][n];
    }

    public static void main(String[] args) { 	
      String string1 = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      string1 = input.next();  
      System.out.println();	
      String string2 = new String();	  
      System.out.print("Enter the second string: ");
      string2 = input.next();

      int numDistinct = numDistinct(string1, string2);
      System.out.println();
      System.out.println("The number of unique ways in which sequence " + string1 + " to form a subsequence that is identical to the sequence " + string2  + " are: " + numDistinct); 
    }
  }
