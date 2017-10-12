import java.util.*;
import java.io.*;

 public class LongestPalindromicSubsequence {
	
   public static int LongestPalindromicSubsequence(String string) {
     int n = string.length();
     // Create a table to store the results of subproblems 
     int LPS[][] = new int[n][n];
  
     // Strings of length 1 are palindrome of length 1.
     for (int i = 0; i < n; i++) {
       LPS[i][i] = 1;	  
     }
  
     for(int substringLength = 2;substringLength<=n;substringLength++) {
       for (int i=0; i <=n-substringLength; i++) {
         int j = i + substringLength - 1;
	
         if(string.charAt(i) == string.charAt(j) && substringLength == 2) {
           LPS[i][j] = 2;
         }   
         else if(string.charAt(i) == string.charAt(j)) {
           LPS[i][j] = LPS[i+1][j-1] + 2;	
         }
         else {
           LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);	
         }
       }  
     }
    	   
     return LPS[0][n-1];
   }
   
   public static int LongestPalindromicSubsequence1(String string) {
	 int n = string.length(), result = 0;
     int[] dp = new int[n];
     char[] array = string.toCharArray();
     Arrays.fill(dp,1);
     for (int i = 1; i < n; i++) {
       int length = 0;
       for (int j = i - 1; j >= 0; j--) {
         int temp = dp[j];
         if (array[j] == array[i]) {
           dp[j] = length + 2;
         }
         length = Math.max(length,temp);
       }
     }
     for (int i : dp){
       result = Math.max(result, i); 
     }

     return result;
   }

   public static String LongestPalindromicSubsequence(String string1, String string2) {
	   
     int lengths[][] = new int[string1.length() + 1][string2.length() + 1]; 
			  
     if (string1 == null || string2 == null || string1.length() == 0 || string2.length() == 0) {
       return "";  
     }
		      
     for(int i = 0; i <= string1.length(); i++) {
       for(int j = 0; j <= string2.length(); j++) {
         if(i == 0 || j == 0) {
           lengths[i][j] = 0;
         }
   	     else if(string1.charAt(i-1) == string2.charAt(j-1)) {
      	   lengths[i][j] = lengths[i-1][j-1] + 1; 
         }
         else {
           lengths[i][j] = Math.max(lengths[i-1][j], lengths[i][j-1]); 
         }	
       }
     }
		   
     int i = string1.length();
     int j = string2.length();
		   
     StringBuffer sb = new StringBuffer();
     while(i > 0 && j > 0) {
       if(string1.charAt(i-1) == string2.charAt(j-1)) {
         // Put current character in the string
         sb.append(string1.charAt(i-1));
         i--;
         j--;
       }
       // If the characters are not same, then find the larger of two and go in the direction of larger value
       else if (lengths[i - 1][j] > lengths[i][j - 1]) {
         i--;
       }
       else {
         j--;
       }
     }
	 
     return sb.reverse().toString(); 
   } 

   public static void main(String[] args) {    
     String string = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string: ");
     string = input.next(); 
  
     int length = LongestPalindromicSubsequence(string);
 
     String string1 = new StringBuilder(string).reverse().toString();  
     String subsequence = LongestPalindromicSubsequence(string, string1);
  
     System.out.println();	
     System.out.println("The length of the longest palindromic subsequence is: " + length);	
     System.out.println();	
  
     System.out.println("The longest palindromic subsequence is: " + subsequence);	
     System.out.println();	
	 
   }
 }