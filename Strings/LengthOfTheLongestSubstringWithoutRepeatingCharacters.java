import java.util.*;
import java.io.*;

  public class LengthOfTheLongestSubstringWithoutRepeatingCharacters {
	public static final int NO_OF_CHARS = 256; 

	public static int longestUniqueSubstring(String string) {
	  int n = string.length();
	  int currentLength = 1;
	  int maxLength = 1;
	  int previousIndex; 
	  int i; 
      int visited[] = new int[NO_OF_CHARS]; 
      // Since no character has been visited yet
      for (i = 0; i < NO_OF_CHARS; i++) { 
        visited[i] = -1; 
      } 
      // Mark first character as visited by storing the index of first character in visited array.
      visited[string.charAt(0)] = 0; 
      for(i = 1; i < n; i++) {
        previousIndex = visited[string.charAt(i)];  
        // If the current character is not present in the already processed substring or it is not 
        if(previousIndex == -1 || i - currentLength > previousIndex) {
          currentLength++; 
        } else {
          if(currentLength > maxLength) {
            maxLength = currentLength;  
          }
          currentLength = i - previousIndex; 
        }
        visited[string.charAt(i)] = i;  
      }
      
      if(currentLength > maxLength) {
    	maxLength = currentLength;  
      }
		
	  return maxLength;  
	}
	  
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      String string = input.nextLine();  
			  
      int result = longestUniqueSubstring(string); 
      System.out.println();
      System.out.println("The length of the longest non repeating character is: " + result);
      input.close();
	}
  }
