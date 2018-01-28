import java.util.*;
import java.io.*;
 
  public class LongestPalindrome {
	  
	public static int longestPalindrome(String string) {
	  int[] dictionary = new int[255];
	  char[] ch = string.toCharArray();
	  for (char c: ch) {
		dictionary[c]++;
	  }
	  int count = 0;
	  boolean hasOdd = false;
	  for (int i : dictionary) {
	    if (i%2 == 1) {
	      hasOdd=true;
	    } 
	    count += (i/2)*2;
	  }
	  
	  return count + (hasOdd ? 1 : 0);  
	} 

	public static void main(String[] args) {  
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.next(); 
	  
	  int lengthOfLongestPalindrome = longestPalindrome(string);
	
	  System.out.println();	
	  System.out.println("The length of the longest palindromes that can be built with the letters of the string is: " + lengthOfLongestPalindrome);	

	}
  }
