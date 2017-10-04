import java.util.*;
import java.io.*;

 public class ValidPalindrome {
	
	public static boolean isPalindrome(String string) {
	   if (string.isEmpty()) {
	     return true;
	   }
	   
	   String actual = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
       String reverse = new StringBuffer(actual).reverse().toString();
       return actual.equals(reverse);     
    } 

	public static void main(String[] args) { 	  
	  String string = new String();	  	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  
	  System.out.println();
	  if(isPalindrome(string)) {
	    System.out.println("The string is a valid palindrome.");
      }
	  else {
	    System.out.println("The string is not a valid palindrome.");  
	  }
	}
 }
