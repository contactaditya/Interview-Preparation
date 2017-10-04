import java.util.*;
import java.io.*;

 public class ValidPalindromeII {	
	 
	public static boolean validPalindrome(String string) {
	   for (int i=0; i < string.length()/2; i++) {
	     if (string.charAt(i) != string.charAt(string.length()-1-i)) {
	       int j = string.length()-1-i;
	       return (isPalindromeRange(string, i+1, j) || isPalindromeRange(string, i, j-1));
	     }
	   } 
	  return true; 
	} 

	private static boolean isPalindromeRange(String string, int i, int j) {
      for (int k = i; k <= i + (j-i)/ 2; k++) {
	    if (string.charAt(k) != string.charAt(j-k+i)) {
	      return false;
	    }
	  }
	  return true;	
	}

	public static void main(String[] args) { 	  
	   String string = new String();	  	
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the string: ");
	   string = input.nextLine(); 
		  
	   System.out.println();
	   if(validPalindrome(string)) {
		 System.out.println("The string " + string + " can be made a valid palindrome if can delete at most one character from the string.");
	   }
	   else {
		 System.out.println("The string " + string + " cannot be made a valid palindrome if can delete at most one character from the string.");  
	   }
	 }
  }
