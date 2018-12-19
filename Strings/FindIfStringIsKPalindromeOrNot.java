import java.util.*;
import java.io.*;

 public class FindIfStringIsKPalindromeOrNot {
	 
   public static int LongestCommonSubsequence(String string1, String string2, int m, int n) {	   
     int lengths[][] = new int[string1.length() + 1][string2.length() + 1]; 
				 
     if(string1 == null || string2 == null || string1.length() == 0 || string2.length() == 0) {
       return 0;  
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
	
     return lengths[m][n];
   }
	 
   public static boolean isKPalindrome(String string, int k) {
     int n = string.length();
     String reverse = new StringBuffer(string).reverse().toString();
       
     // find longest palindromic subsequence of given string
     int lps = LongestCommonSubsequence(string, reverse, n, n);
	  
     return (n - lps <= k);
   }

   public static void main(String[] args) {
     String string = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string: ");
     string = input.next(); 
     System.out.println();	
     System.out.print("Enter the number of characters you want to remove so as to check whether the resulting string is palindrome or not: ");
     int k = input.nextInt(); 
     System.out.println();	  
     if(isKPalindrome(string,k)) {
       System.out.println("The given string can become a palindrome by removing " + k + " characters.");
     }
     else {
       System.out.println("The given string cannot become a palindrome by removing " + k + " characters.");  
     }	
   }
 }
