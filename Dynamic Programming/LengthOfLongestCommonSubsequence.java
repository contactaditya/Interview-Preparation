import java.util.*;
import java.io.*;

  public class LengthOfLongestCommonSubsequence {
	  
	private static int LongestCommonSubsequence(String string1, String string2) {
	  int m = string1.length();
	  int n = string2.length();
	  int LCS[][] = new int[m + 1][n + 1];
	
	  for (int i = 0; i <= m; i++) { 
	    for (int j = 0; j <= n; j++) {
	      if (i == 0 || j == 0) { 
	        LCS[i][j] = 0; 
	      } 
	      // If the current character of the string1 and string2 matches
	      else if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
	    	LCS[i][j] = LCS[i - 1][j - 1] + 1;  
	      } 
	      // If the current characters of the string1 and string2 don't match
	      else {
	    	LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);   
	      }
	    }
	  }
		  
	  return LCS[m][n];
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
		  
	  int lengthOfLongestSubsequence = LongestCommonSubsequence(string1, string2);
		  
	  System.out.println();	
	  System.out.println("The length of the longest common subsequence of the two strings is: " + lengthOfLongestSubsequence);	
      input.close();
	}
  }