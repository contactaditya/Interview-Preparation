import java.util.*;
import java.io.*;

  public class BackspaceStringCompare {
	  
	public static boolean backspaceCompare(String string1, String string2) {
	  int i = string1.length() - 1, j = string2.length() - 1;
	  int skipString1 = 0, skipString2 = 0;
	  
	  // While there may be chars in build(string1) or build (string2)
	  while (i >= 0 || j >= 0) { 
	    // Find position of next possible char in build(string1)
        while (i >= 0) { 
          if (string1.charAt(i) == '#') {
        	skipString1++;
        	i--;
          }
          else if (skipString1 > 0) {
            skipString1--; 
            i--;
          }
          else {
            break;
          }
        }
        // Find position of next possible char in build(string2)
        while (j >= 0) { 
          if (string2.charAt(j) == '#') {
        	skipString2++;
        	j--;
          }
          else if (skipString2 > 0) {
            skipString2--; 
            j--;
          }
          else {
            break;
          }
        }
        // If two actual characters are different
        if (i >= 0 && j >= 0 && string1.charAt(i) != string2.charAt(j)) {
          return false;
        }
        // If expecting to compare char vs nothing
        if ((i >= 0) != (j >= 0)) {
          return false;
        }
        i--;
        j--;
	  }
	  
      return true;     
	}  

	public static void main(String[] args) {   
	  String string1 = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      string1 = input.nextLine();  
      System.out.println();	
      String string2 = new String();	  
      System.out.print("Enter the second string: ");
      string2 = input.nextLine();
		  
      boolean areTheyEqual = backspaceCompare(string1, string2);
      System.out.println();
      if(areTheyEqual) {
        System.out.println("The string " + string1 + " and the string " + string2 + " are equal when both are typed into empty text editors.");  
      }
      else {
        System.out.println("The string " + string1 + " and the string " + string2 + " are not equal when both are typed into empty text editors.");  
      }
	}
  }
