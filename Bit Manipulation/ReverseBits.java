import java.util.*;
import java.io.*;

  public class ReverseBits {
	  
    public static int reverseBits(int number) { 
      if (number == 0) {
	return 0;
      }
    
      int result = 0;
      for (int i = 0; i < 32; i++) {
    	result = result << 1 | number & 1;  
        number = number >> 1;  
      }
	
      return result;     
    }  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();
		  
      int result = reverseBits(number);
      System.out.println();
      System.out.println("The reverse of " + number + " in bits is: " + result);
    }
  }
