import java.util.*;
import java.io.*;

 public class SumOfTwoIntegersWithoutPlusAndMinusOperators {
	 
	public static int getSum(int a, int b) {
	  while (b != 0) {
		 // Carry now contains common set bits of a and b
		 int carry = a & b;  
		 
		 // Sum of bits of a and b where at least one of the bits is not set
		 a = a ^ b; 
		 
		 // Carry is shifted by one so that adding it to x gives the required sum
		 b = carry << 1;
	  }		
	   return a;    
	} 

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the first number: ");
      int first = input.nextInt();   
      System.out.println();
      System.out.print("Enter the first number: ");
      int second = input.nextInt();   
     
	  int sum = getSum(first, second);
	  
	  System.out.println();
	  System.out.println("The sum of the two numbers is: " + sum);
	}
  }
