import java.util.*;
import java.io.*;

  public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {
      int j = 0;
      for (char c : name.toCharArray()) {
	if (j == typed.length()) {
          return false; 
	}
	// If mismatch...
        if (typed.charAt(j) != c) {
          // If it's the first char of the block, ans is false.
          if (j == 0 || typed.charAt(j-1) != typed.charAt(j)) {
            return false;
          }
          // Discard all similar characters
          char current = typed.charAt(j);
          while (j < typed.length() && typed.charAt(j) == current) {
            j++;
          }
          // If next isn't a match, ans is false.
          if (j == typed.length() || typed.charAt(j) != c) {
            return false;
          }
        }
        j++;
      }
    	
      return true;  
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);	
      String name = new String();	  
      System.out.print("Enter the name: ");
      name = input.next();  
	  
      System.out.println();	
      String typed = new String();	  
      System.out.print("Enter the typed string: ");
      typed = input.next();
	  
      boolean isLongPressedName = isLongPressedName(name, typed);
      System.out.println();
      if(isLongPressedName) {
 	System.out.println("Yes it is possible that it was my friends name, with some characters (possibly none) being long pressed.");
      }
      else {
 	System.out.println("No it is not possible that it was my friends name, with some characters (possibly none) being long pressed.");  
      }
      input.close();
    }
  }
