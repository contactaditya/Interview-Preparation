import java.util.*;
import java.io.*;

  public class SmallestWindowThatContainsAllCharactersOfStringItself { 	  
    static final int MAX_CHARS = 256; 
	  
    public static String findSubString(String string) {  
      int n = string.length(); 
      int distinctCount = 0; 
      boolean[] visited = new boolean[MAX_CHARS]; 
      Arrays.fill(visited, false); 
      for(int i = 0; i < n; i++) { 
        if (visited[string.charAt(i)] == false) { 
          visited[string.charAt(i)] = true; 
          distinctCount++; 
        } 
      } 
      int start = 0, startIndex = -1; 
      int minLength = Integer.MAX_VALUE; 
      int count = 0;
      int[] currentCount =  new int[MAX_CHARS]; 
      for (int j = 0; j < n; j++) {
        // Count occurrence of characters of string 
        currentCount[string.charAt(j)]++;   
        // If any distinct character matched, then increment count
        if (currentCount[string.charAt(j)] == 1) { 
          count++; 
        }
        // If all the characters match
        if (count == distinctCount) {
          // If any character is occurring more number of times than it's occurence in the pattern then remove the character
          while (currentCount[string.charAt(start)] > 1) {
            if (currentCount[string.charAt(start)] > 1) { 
              currentCount[string.charAt(start)]--; 
            }
            start++;   
          }
          // Update window size 
          int lengthWindow = j - start + 1; 
          if (minLength > lengthWindow) { 
            minLength = lengthWindow; 
            startIndex = start; 
          } 
        }
      }
      
      return string.substring(startIndex, startIndex + minLength);   
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      String smallestWindow = findSubString(string); 
      System.out.println();
      System.out.println("Smallest window containing all distinct characters is: " + smallestWindow);
      input.close();
    }
  }
