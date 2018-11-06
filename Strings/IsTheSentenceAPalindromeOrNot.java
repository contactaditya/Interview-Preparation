import java.util.*;
import java.io.*;

  public class IsTheSentenceAPalindromeOrNot {
	  
    public static boolean sentencePalindrome(String string) {
      int low = 0; 
      int high = string.length() - 1;
      string = string.toLowerCase(); 
      // Compares character until they are equal 
      while(low <= high) {
	char getAtLow = string.charAt(low); 
        char getAtHigh = string.charAt(high);  
        // If there is another symbol in left of sentence 
        if (!(getAtLow >= 'a' && getAtLow <= 'z')) {
          low++; 
        }
        // If there is another symbol in right of sentence 
        else if(!(getAtHigh >= 'a' && getAtHigh <= 'z')) {
          high--; 
        }
        // If characters are equal
        else if(getAtLow == getAtHigh) {
          low++;
          high--;
        }
        else {
          return false;
        }
      }
		
      return true;  
    }

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      String string = input.nextLine();  
			  
      boolean result = sentencePalindrome(string); 
      System.out.println();
      if(result) {
 	System.out.println("Yes this sentence is a palindrome.");
      }
      else {
 	System.out.println("No this sentence is not a palindrome.");  
      }
      input.close();
    }
  }
