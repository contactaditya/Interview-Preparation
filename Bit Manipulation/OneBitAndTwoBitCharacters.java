import java.util.*;
import java.io.*;

  public class OneBitAndTwoBitCharacters {
	  
    public static boolean isOneBitCharacter(int[] bits) {   
      int ones = 0; 	
      // Starting from one but last, as last one is always 0.
      for(int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
        ones++;
      }
      if(ones % 2 > 0) {
	return false;  
      }
      return true;      
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int bits[] = new int[number];
	 
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < bits.length; i++) {
        bits[i] = input.nextInt();
      }
			
      boolean result = isOneBitCharacter(bits);
      System.out.println();
      if(result) {
	System.out.println("The last character must be a one-bit character.");  
      }
      else {
	System.out.println("The last character will not be a one-bit character.");  
      }
    }
  }
