import java.util.*;
import java.io.*;

 public class PowerOfFour {
	
	public static boolean isPowerOfFour(int number) {
	   if(number == 0){
		 return false;  
	   }
	   while(number != 1) {    
	     if(number%4 != 0) {
	       return false;
	     }
	     number = number/4;      
	   }
	   return true;
	}  
	
	public static boolean isPowerOfFour1(int number) {
	   return number > 0 && (number&(number-1)) == 0 && (number & 0x55555555) != 0;	
	}  
	 
	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
		  
	  boolean result = isPowerOfFour(number); 
      System.out.println();
	  if(result) {
		System.out.println("The given number " + number + " can be expressed as a power of 4.");  
	  }
	  else {
		System.out.println("The given number " + number + " cannot be expressed as a power of 4.");  
	  }
	}
 }
