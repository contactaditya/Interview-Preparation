import java.util.*;
import java.io.*;

 public class LargestPalindromeProduct {
	 
    public static int largestPalindrome(int number) {
      if (number < 1 || number > 8) {
        return 0;
      }
      int max = (int) Math.pow(10, number) - 1;
      int min = (int) Math.pow(10, number - 1);
      for (int a = max; a > max / 10; a--) {
        long palindrome = makePalindrome(a);
        if (isFactorable(palindrome, max, min)) {
          return (int)(palindrome % 1337);
        }
      }
    
      return max;
    }
   
    private static long makePalindrome(int number) {
      long result = number;
      while (number != 0) {
        result = result * 10 + number % 10;
        number /= 10;
      }
      return result;
    }    
	 
	private static boolean isFactorable(long number, int max, int min) {  
	  long low = (int)Math.sqrt(number);
      long high = (int)Math.sqrt(number); 

      long product = low * high;
      while(product != number) {
       if (product < number) {
         high++;
         if (high > max) {
           return false;
         }
       } else {
         low--;
         if (low < min) {
           return false;
         }
       }
       product = low * high;
      }

      return true;
	}

	public static int largestPalindrome1(int number) {
	  long max = (long)Math.pow(10, number) - 1;
	  long min = max / 10;
	        
	  for (long h = max; h > min; h--) {
	   long left = h, right = 0;
	   for (long i = h; i != 0; right = right * 10 + i % 10, i /= 10, left *= 10);
	    long palindrome = left + right; // construct the palindrome        
	    for (long i = max; i > min; i--) {
	     long j = palindrome/i;
	     if (j > i || j <= min) {
	       break; // terminate if the other number is greater than current number or is not an n-digit number
	     }
	     if (palindrome % i == 0) {
	       return (int)(palindrome % 1337); // found if current number is a factor
	     }
	    }
	  }

	  return 9; // account for case n = 1
    }	 

	public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();   
 
      int largestPalindrome = largestPalindrome(number);

      System.out.println();	
      System.out.println("The largest palindrome that can be made from the product of two n-digit numbers is: " + largestPalindrome);	
	}
 }
