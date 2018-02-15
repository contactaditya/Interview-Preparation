import java.util.*;
import java.io.*;

  public class NthDigit {
	  
    public static int findNthDigit(int number) {
      int length = 1;
      long count = 9;
      int start = 1;	
	  
      // Find the length of the number where the nth digit is from
      while (number > length * count) {
	number -= length * count;
	length += 1;
        count *= 10;
        start *= 10;
      }
		
      // Find the actual number where the nth digit is from
      start += (number - 1)/length;
		
      return Integer.toString(start).charAt((number-1) % length) - '0';
    }  

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
		 		
      int NthDigit = findNthDigit(number);

      System.out.println();	
      System.out.print("The nth digit of the infinite integer sequence is: " + NthDigit);
    }
  }
