import java.util.*;
import java.io.*;

  public class CheckWhetherTwoStringsAreAnagramOfEachOther {
	static int NO_OF_CHARS = 256; 
	  
	private static boolean areAnagram(String string1, String string2) {
      int count1[] = new int [NO_OF_CHARS]; 
	  Arrays.fill(count1, 0); 
	  int count2[] = new int [NO_OF_CHARS]; 
	  Arrays.fill(count2, 0); 
	  int i; 
	  
	  char str1[] = string1.toCharArray(); 
      char str2[] = string2.toCharArray(); 
      
      for (i = 0; i < str1.length && i < str2.length; i++) { 
    	count1[str1[i]]++; 
    	count2[str2[i]]++; 
      } 

      // If both strings are of different length. Removing this condition will make the program fail for strings like "aaca" and "aca" 
	  if (string1.length() != string2.length()) {
		return false;   
	  }
	  // Compare count arrays 
	  for (i = 0; i < NO_OF_CHARS; i++) {
	    if (count1[i] != count2[i]) { 
	      return false; 
	    }
	  }
	   
	  return true;
	}	  

	public static void main(String[] args) { 	 
	  String string1 = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string1 = input.nextLine(); 
	  
	  System.out.println();
	  
	  String string2 = new String();	  
	  System.out.print("Enter the string: ");
	  string2 = input.nextLine(); 
	  	  
	  System.out.println();
	  if(areAnagram(string1, string2)) {
	    System.out.println("The two strings are anagram of each other.");
	  } else {
		System.out.println("The two strings are not anagram of each other.");  
	  }
	  input.close();
	}
  }
