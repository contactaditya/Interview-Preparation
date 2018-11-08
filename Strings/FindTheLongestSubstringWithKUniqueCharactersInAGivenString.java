import java.util.*;
import java.io.*;

  public class FindTheLongestSubstringWithKUniqueCharactersInAGivenString {
    public static final int MAX_CHARS = 26; 
	
    // Returns true if number of characters are less than required 
    public static boolean isValid(int count[], int k) {
      int value = 0;
      for (int i = 0; i < MAX_CHARS; i++) {
        if (count[i] > 0) {
	  value++;   
	}  
      }
	  
      return (k >= value);  
    }  
	  
    public static String kUniques(String string, int k) {
      int numberOfUniqueCharacters = 0; // number of unique characters 
      int n = string.length(); 	
      int count[] = new int[MAX_CHARS]; 
	  
      // Since no character has been visited yet
      for (int i = 0; i < MAX_CHARS; i++) { 
        count[i] = 0; 
      } 
      // Count number of unique characters 
      for(int i = 0; i < n; i++) {
        if (count[string.charAt(i) - 'a'] == 0) { 
          numberOfUniqueCharacters++; 
        }
        count[string.charAt(i) - 'a']++; 
      }
      // If there are not enough unique characters
      if (numberOfUniqueCharacters < k) { 
        return "Not enough unique characters"; 
      } 
      
      int currentStart = 0, currentEnd = 0;
      int maxWindowSize = 1, maxWindowStart = 0; 

      // Since no character has been visited yet
      for (int i = 0; i < MAX_CHARS; i++) { 
        count[i] = 0; 
      } 
      // Mark first character as visited by storing the index of first character in visited array.
      count[string.charAt(0) - 'a']++; 
      
      for(int i = 1; i < n; i++) {
        // Add the character 's[i]' to current window 
        count[string.charAt(i) - 'a']++; 
        currentEnd++; 
        // If there are more than k unique characters in current window, remove from left side 
        while (!isValid(count, k)) {
    	  count[string.charAt(currentStart) - 'a']--; 
    	  currentStart++; 
        }
        // Update the max window size if required 
        if (currentEnd - currentStart + 1 > maxWindowSize) { 
    	  maxWindowSize = currentEnd - currentStart + 1; 
    	  maxWindowStart = currentStart; 
        } 
      }
      
      return string.substring(maxWindowStart, maxWindowStart + maxWindowSize);
    }

    public static void main(String[] args) { 
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next(); 
      System.out.println();	
      System.out.print("Enter the number of unique characters in the longest substring: ");
      int k = input.nextInt(); 
	  
      String longestSubstring = kUniques(string, k);
	
      System.out.println();	
      System.out.println("The longest possible substring that has exactly " + k + " unique characters is: " + longestSubstring);	
      input.close();
    }
  }
