import java.util.*;
import java.io.*;

  public class VerifyingAnAlienDictionary {
	  
	public static boolean isAlienSorted(String[] words, String order) {
	  int[] map = new int[26];	
	  for (int i = 0; i < 26; i++) { 
	    map[order.charAt(i) - 'a'] = i; // construct mapping with the given order. 
	  } 
	  for (int i = 1; i < words.length; i++) { 
		// Verify the order of the adjacent words 
        if (compare(words[i - 1], words[i], map) > 0) { 
          return false; 
        } 
      }
		
	  return true;      
	}

	private static int compare(String string1, String string2, int[] map) {
	  int m = string1.length(), n = string2.length();
	  for (int i = 0; i < m && i < n; i++) {
		int compare = map[string1.charAt(i) - 'a'] - map[string2.charAt(i) - 'a']; // compare according to the given order.  
		if (compare != 0) { 
		  return compare; 
	    }
	  }
	  return m - n; // when one word is the prefix of the other, compare their sizes.
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of words written in the alien language: ");
      int numbers = input.nextInt();   
      String words[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual words: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	    words[i] = input.nextLine(); 
      }
      System.out.println();
      String order = new String();	  
      System.out.print("Enter the order of the alphabet: ");
      order = input.nextLine();
     
      if(isAlienSorted(words, order)) {
        System.out.println("The given words are sorted lexicographicaly in the alien language.");  
      }
      else {
        System.out.println("The given words are not sorted lexicographicaly in the alien language.");   
      }
      input.close();
	}
  }
