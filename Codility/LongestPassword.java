import java.util.*;
import java.io.*;

  public class LongestPassword {
	  
	public static int getLengthLongestPassword(String password) {
	  String[] words = password.replaceAll("\\s+", " ").split(" ");
	  int maxLength = -1;
	  for (String word : words) {
	    if (word.matches("^[0-9a-zA-Z]*$") && word.replaceAll("[0-9]+", "").length() % 2 == 0 && word.replaceAll("[a-zA-Z]+", "").length() % 2 == 1) {
	      maxLength = Math.max(maxLength, word.length());
	    }
	  }
	  return maxLength;        
	}	  

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.next(); 
	  
	  int longestPassword = getLengthLongestPassword(string);
	
	  System.out.println();	
	  System.out.println("The length of the longest word from the string that is a valid password is: " + longestPassword);	

	}
  }
