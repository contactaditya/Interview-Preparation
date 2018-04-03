import java.util.*;
import java.io.*;

  public class FactorialTrailingZeroes {
	  
    public static int trailingZeroes(int number) {
      return number == 0 ? 0 : number/5 + trailingZeroes(number/5); 
    }	  
	
    public static int trailingZeroes1(int number) {
      int count = 0;
      while(number > 0) {
	number /= 5;
	count += number;
      }
      return count;
    }	

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
      
      int numberOfTrailingZeroes = trailingZeroes(number);
      System.out.println();
      System.out.print("The number of trailing zeroes in " + number + "! are: " + numberOfTrailingZeroes);      
    }
  }
