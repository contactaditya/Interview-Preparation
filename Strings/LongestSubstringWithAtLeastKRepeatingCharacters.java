import java.util.*;
import java.io.*;

  public class LongestSubstringWithAtLeastKRepeatingCharacters {
	  
	public static int longestSubstring(String string, int k) {       
      if (string == null || string.length() == 0 || k == 0) {
		return 0;
	  }
	  int length = string.length();
	  int[] counts = new int[26];

	  for(char c : string.toCharArray()) {
	    counts[c - 'a']++;
	  }
	  
	  int result = 0, left = 0, right = 0;
	  
	  while (right < string.length()) { 
	    while (left < string.length() && counts[string.charAt(left) - 'a'] < k) {
          left++;
        }
        right = left;
        while (right < string.length() && counts[string.charAt(right) - 'a'] >= k) {
          right++;
        }
        if (left == 0 && right == string.length()) {
          return string.length();
        }
        if (left < string.length()) {
          result = Math.max(result, longestSubstring(string.substring(left, right), k));
        }
        left = right;
	  }
		
      return result;      
    }	  

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.next(); 
	  System.out.println();	
	  System.out.print("Enter the maximum number of times that every character in the substring can appear: ");
	  int k = input.nextInt(); 
	  System.out.println();	  
	  int lengthOfLongestSubstring = longestSubstring(string, k);
	  System.out.println("The length of the longest substring such that every character in the substring appears no less than " + k + " times is: " + lengthOfLongestSubstring);  
	}
  }
