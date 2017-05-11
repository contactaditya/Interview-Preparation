import java.util.*;
import java.io.*;

public class LongestPalindromicSubstring {
	
  public static String longestPalindromicSubstring(String string) {
     if(string == null || string.length()<=1) {
        return string;
     }
	    
     int length = string.length();
     int maxLength = 1;
     boolean [][] dp = new boolean[length][length];
	  
     String longest = null;
     for(int k=0; k<length; k++) {
       for(int i=0; i<length-k; i++) {
	  int j = i + k;	
	  if(string.charAt(i)==string.charAt(j) && (j-i<=2||dp[i+1][j-1])) {
             dp[i][j]=true;
	  
	     if(j-i+1 > maxLength) {
	    	maxLength = j-i+1; 
                longest = string.substring(i, j+1);
             }
	  }
       }
     }	
   return longest;
  }
	
  public static String longestPalindromicSubstring1(String string) {
      if(string.isEmpty()) {
	 return null;
      }
		  
      if(string.length() == 1) {
	 return string;
      }
	   
      int length = string.length();
      String longest = string.substring(0, 1);
		  
      for(int i=0; i<length; i++) { 
       // get longest palindrome with center of i
         String temp = helper(string, i, i);
	 if (temp.length() > longest.length()) {
	    longest = temp;
	 }
		 
	 // get longest palindrome with center of i, i+1
	 temp = helper(string, i, i + 1);
         if (temp.length() > longest.length()) {
	    longest = temp;
	 }	 
       }	
    return longest;
   }
	
   public static String helper(String string, int begin, int end) {
       while (begin >= 0 && end <= string.length() - 1 && string.charAt(begin) == string.charAt(end)) {
	  begin--;
	  end++;
       }
     return string.substring(begin + 1, end);
   }

  public static void main(String[] args) {  
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next(); 
	  
      String palindrome = longestPalindromicSubstring(string);
	 
      System.out.println();	
      System.out.println("The longest palindromic substring is: " + palindrome);	
  }
}
