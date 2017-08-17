import java.util.*;
import java.io.*;

 public class Numberof1Bits {
	 
    public static int hammingWeight(int number) {
	   int sum = 0;
	   while(number != 0) {
	     sum++;
	     number &= (number - 1);
	   }
	 		
	   return sum;     
	}
	 
    public static int hammingWeight1(int number) {
       int result = 0;	
       // Each time we get the least significant bit and check if it is 1. Then shift the number to the right by 1 until 32 times. 
       for (int i = 0; i < 32; i++) {
         result += number & 1;
         number = number >> 1;
       }	
    	
       return result;     
	}
    
    public static int hammingWeight2(int number) {
       int count = 0;	
       while (number > 0) {
	     if ((number & 1) != 0) {
	       count++;
	     }
	      number >>= 1;
	   }
      return count; 
 	}
    
  
	public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
	   System.out.print("Enter a number: ");
	   int number = input.nextInt();  
		
	   int numberof1Bits = hammingWeight(number);

	   System.out.println();	
	   System.out.println("The number of 1 Bits that the number has: " + numberof1Bits);
	}
 }
