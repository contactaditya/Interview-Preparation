import java.util.*;
import java.io.*;

  public class LengthOfTheLastWordInTheString {
	  
    public static int lengthOfLastWord(final String string) {
      if (string.length() == 0) {
	return 0;	
      }
      String array[] = string.trim().split("\\s");
      String lengthOfLastWord = array[array.length - 1];		 		
      return lengthOfLastWord.length();
    }

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      String string = input.nextLine();  
			  
      int result = lengthOfLastWord(string); 
      System.out.println();
      System.out.println("The length of last word in the string " + string + " is: " + result);
    }
  }
