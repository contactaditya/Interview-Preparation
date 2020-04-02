import java.util.*;
import java.io.*;

 public class RemovePalindromicSubsequences {
	 
	public static int removePalindromeSubsequences(String string) { 	  
	  if (string.isEmpty()) {
		return 0;
      }
	  
	  if(isPalindrome(string)) {
		return 1;
	  }
	  
	  return 2;      
	}

	private static boolean isPalindrome(String string) {
	  int left = 0, right = string.length() - 1;
	  while(left < right) {
	    if(string.charAt(left) != string.charAt(right)) {
	      return false;
	    }
	    left++;
	    right--;
	  }
	  return true;
	}

	public static void main(String[] args) { 	  
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);

	  System.out.print("Enter the string: ");
	  string = input.nextLine();
		  
	  int minimumNumberOfSteps = removePalindromeSubsequences(string);
	  System.out.println();
	  System.out.println("The minimum number of steps to make the given string empty is: " + minimumNumberOfSteps);  
      input.close();
	}
 }
