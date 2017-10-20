import java.io.*;
import java.util.*;

public class PalindromeNumbers {
	
    public static boolean isPalindrome(int number) { 
       if(number < 0 || (number % 10 == 0 && number != 0)) {
    	 return false;
       }
       int reverse = 0;
       while (number > reverse) {
    	 reverse = reverse*10 + number%10;
    	 number = number/10;
       }  
       return (number==reverse || number==reverse/10); 
	}	
	
	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();
		  
	  System.out.println();
	  if(isPalindrome(number)) {
	    System.out.println(number + " is a palindrome number.");
	  }
	  else {
		System.out.println(number + " is not a palindrome number.");
	  }
	}
  }
