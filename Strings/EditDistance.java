import java.util.*;
import java.io.*;

  public class EditDistance {
	  
    public static boolean isEditDistanceOne(String s1, String s2) { 
      int m = s1.length(), n = s2.length(); 	
	  
      // If difference between lengths is more than 1, then strings can't be at one distance 
      if (Math.abs(m - n) > 1) {
	return false; 
      }
      int count = 0; // Count of edits
      int i = 0, j = 0; 
      while (i < m && j < n) {
	if (s1.charAt(i) != s2.charAt(j)) { 
	  // If current characters don't match 
          if (count == 1) {
            return false;
	  }
          // If length of one string is more, then only possible edit is to remove a character 
          if(m > n) {
            i++;	
          } else if(m < n) {
            j++;
          } else { 
            i++;
            j++;
          }
	  // Increment count of edits
	  count++;
	} 
	else {
	  i++;
	  j++;
	}
      }
      // If last character is extra in any string 
      if (i < m || j < n) { 
	count++; 
      }
	  
      return count == 1;  
    }

    public static void main(String[] args) {  
      String string1 = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first word: ");
      string1 = input.next();  
      System.out.println();	
      String string2 = new String();	  
      System.out.print("Enter the second word: ");
      string2 = input.next();
      System.out.println();

      if(isEditDistanceOne(string1, string2)) {
    	System.out.println("Yes the two words are exactly one edit distance away.");   
      } else {
    	System.out.println("No the two words are not exactly one edit distance away. ");  
      }
      input.close();
    }
  }
