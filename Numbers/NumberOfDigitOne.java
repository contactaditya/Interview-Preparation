import java.util.*;
import java.io.*;

  public class NumberOfDigitOne {
	  
	public static int countDigitOne(int number) {   
	  int counter = 0;
	  for (long i = 1; i <= number; i *= 10) {
	    long divider = i * 10;
	    counter += (number/divider) * i + Math.min(Math.max(number % divider - i + 1, 0L), i);
	  }
	  return counter;
	}  
	
	public static int countDigitOne1(int number) {   
   	  if(number <= 0) {
		return 0;
	  }
	  if(number < 10) {
		return 1;
	  }
      int count = 1;
      while(number/count > 9) {
    	count *= 10;
      }
      if(number/count == 1) {
    	return number % count + 1 + countDigitOne(number % count) + countDigitOne(count - 1);
      } else {
    	return countDigitOne(number % count) + count + (number/count) * countDigitOne(count-1);
      }
    } 

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  

      int result = countDigitOne(number);
      System.out.println();	
      System.out.print("The total number of digit 1 appearing in all non-negative integers less than or equal to " + number + " is: " + result);
	}
  }
