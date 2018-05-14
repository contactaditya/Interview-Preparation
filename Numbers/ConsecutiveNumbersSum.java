import java.util.*;
import java.io.*;

  public class ConsecutiveNumbersSum {
	  
    public static int consecutiveNumbersSum(int number) {
      int count = 0, result = 1;
      while(number % 2 == 0) {
	number /= 2;
      }
      for(int i = 3; i * i <= number; i += 2) {	  
        for (count = 0; number % i == 0; count++) {
	  number /= i;
	}
	result *= count + 1;
      }
		
      return number == 1 ? result : result * 2;  
    }
 
    public static void main(String[] args) {      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
   
      int result = consecutiveNumbersSum(number);
      System.out.println();	
      System.out.print("The number of ways we can write the number " + number + " as a sum of consecutive positive integers are: " + result);
    }
  }
