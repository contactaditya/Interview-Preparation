import java.io.*;
import java.util.*;

  public class MinimumAddToMakeParenthesesValid {
	  
    public static int minAddToMakeValid(String string) {
      if (string == null || string.length() == 0) {
        return 0;
      }
      int changes = 0;
      int count = 0;
      for (int i = 0; i < string.length(); i++) {
        char c = string.charAt(i);
        if (c == '(') {
          count++;
        } else {
          if (count > 0) {
            count--;
          } else {
            changes++;
          }	
        }
      }
      return changes + count;
    }
 
    public static void main(String[] args) { 
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine();
		  
      int result = minAddToMakeValid(string);
      System.out.println();
      System.out.println("The minimum number of parentheses we must add to make the resulting string valid are: " + result);
      input.close();
    }
  }
