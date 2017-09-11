import java.util.*;
import java.io.*;

  public class PowerOfThree { 
	  
	public static boolean isPowerOfThree(int number) {
	   if(number == 0){
		 return false;  
	   }
	   while(number != 1) {    
	     if(number%3 != 0) {
	       return false;
	     }
	     number = number/3;      
	   }
	   return true;
	}  

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
			  
	  boolean result = isPowerOfThree(number); 
	  System.out.println();
	  if(result) {
		System.out.println("The given number " + number + " can be expressed as a power of 3.");  
	  }
	  else {
		System.out.println("The given number " + number + " cannot be expressed as a power of 3.");  
	  }

	}
  }
