import java.io.*;
import java.util.*;

public class PalindromeNumbers {
	
  public static boolean isPalindrome(int number) { 
       int palindrome = number; // copied number into variable
       int reverse = 0;

       while (palindrome != 0) {
          int remainder = palindrome % 10;
          reverse = reverse * 10 + remainder;
          palindrome = palindrome / 10;
       }
      
       if (number == reverse) {
         return true;
       }

    return false;
  }	
	
  public static void main(String[] args) { 	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the number: ");
     int number = input.nextInt();
		  
     System.out.println();
     if(isPalindrome(number)) {
       System.out.println(number + " is a palindrome number.");
     }  else {
       System.out.println(number + " is not a palindrome number.");
     }
   }
  }
