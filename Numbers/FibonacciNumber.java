import java.util.*;
import java.io.*;

 public class FibonacciNumber {
	 
   public static int fibonacci(int number) {
      if(number == 0) {
	return 0; 
      } 
      else if(number <= 2) {
	return 1; 
      } 
      int current = 0;
      int previous1 = 1;
      int previous2 = 1;
	         
      for (int i = 3; i <= number; i++) {
        current = previous1 + previous2;
	previous2 = previous1;
	previous1 = current;
      }
	         
      return current; 
   } 

   public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
 
      int result = fibonacci(number);
      System.out.println();	
      System.out.print("The fibonacci sequence for " + number + " such that each number is the sum of the two preceding ones starting from 0 and 1 is: " + result);
   }
 }
