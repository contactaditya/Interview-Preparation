import java.util.*;
import java.io.*;

  public class LongestRepeatingCharacterReplacement {
	  
    public static int characterReplacement(String string, int k) {    
      int length = string.length();
      int[] count = new int[26];
      int start = 0, maxCount = 0, maxLength = 0;
      for (int end = 0; end < length; end++) {
    	count[string.charAt(end) - 'A']++;  
        maxCount = Math.max(maxCount, count[string.charAt(end) - 'A']);
        while (end - start + 1 - maxCount > k) {
          count[string.charAt(start) - 'A']--;
          start++;
        }
        maxLength = Math.max(maxLength, end - start + 1);
      }
	   
      return maxLength;      
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
      int lengthOfLongestSubstring = characterReplacement(string,k);
      System.out.println("The length of the longest substring containing all repeating letters is: " + lengthOfLongestSubstring);  
	
    }
  }
