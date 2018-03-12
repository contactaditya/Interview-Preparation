import java.util.*;
import java.io.*;

  public class CountNumberOfSubstringsWithExactlykDistinctCharacters { 
	
    public static int countNumberOfSubstringsWithExactlykDistinctCharacters(String string, int k) {
      int result = 0;
      // To store count of characters from 'a' to 'z'
      int count[] = new int[26];
      
      // Consider all substrings beginning with string[i]
      for (int i = 0; i < string.length(); i++) {
        int distinctCount = 0;
          
        // Initializing count array with 0
        Arrays.fill(count, 0);  
        
        // Consider all substrings between string[i..j]
        for (int j = i; j < string.length(); j++) {
          // If this is a new character for this substring, increment distinct count.
          if (count[string.charAt(j) - 'a'] == 0) {
        	distinctCount++;
          } 
          // Increment count of current character
          count[string.charAt(j) - 'a']++;
          
          // If distinct character count becomes k then add it to the result.
          if (distinctCount == k) {
        	result++;
          }
        }
      }
	  
      return result;
    }

    public static void main(String[] args) {    
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next();  
  
      System.out.println();
      System.out.print("Enter a positive integer k: ");
      int k = input.nextInt();  
		   
      int result = countNumberOfSubstringsWithExactlykDistinctCharacters(string, k);
      System.out.println();
      System.out.print("The total substrings with exactly " + k + " distinct characters are: " + result);
    }
  }
