import java.util.*;
import java.io.*;

  public class PrimePalindrome {
	  
	public static int primePalindrome(int number) {      
	  while (true) {
        if (number == reverse(number) && isPrime(number)) {
          return number;
        }
        number++;
        if (10_000_000 < number && number < 100_000_000) {
          number = 100_000_000;
        }
      }
	}	
	
	public static boolean isPrime(int number) { 	
	  if(number < 2) {
	    return false;  
	  }
	  for(int i=2; i<=Math.sqrt(number); i++) {
	    if(number % i==0) {
	      return false;
	    }
	  }
	  return true;
	}	
	
    public static int reverse(int number) {
      int answer = 0;
      while (number > 0) {
        answer = 10 * answer + (number % 10);
        number /= 10;
      }
      return answer;
    }

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();
		  
      int result = primePalindrome(number);
      System.out.println();
      System.out.println("The smallest prime palindrome greater than or equal to the " + number + " is: " + result);
	}
  }
