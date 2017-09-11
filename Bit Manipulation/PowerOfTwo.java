import java.util.*;
import java.io.*;

  public class PowerOfTwo {
	
    public static boolean isPowerOfTwo(int number) {
       return ((number & (number-1))==0 && number>0);
	}  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
	  
	  boolean result = isPowerOfTwo(number); 
	  System.out.println();
	  if(result) {
		System.out.println("The given number " + number + " can be expressed as a power of 2.");  
	  }
	  else {
		System.out.println("The given number " + number + " cannot be expressed as a power of 2.");  
	  }
	}
  }
