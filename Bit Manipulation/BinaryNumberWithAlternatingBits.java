import java.util.*;
import java.io.*;

  public class BinaryNumberWithAlternatingBits {   
	
	public static boolean hasAlternatingBits(int number) {   
	  String bits = Integer.toBinaryString(number);
      for (int i = 0; i < bits.length() - 1; i++) {
        if (bits.charAt(i) == bits.charAt(i+1)) {
          return false;
        }
      }
      return true;
    }
	
	public static boolean hasAlternatingBits1(int number) {   
	  int current = number % 2;
	  number = number / 2;
	  while (number > 0) {
        if (current == number % 2) {
          return false;
        }
        current = number % 2;
        number /= 2;
      }
	 	  
	  return true;
	}	

	public static void main(String[] args) { 	   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
	  
	  boolean hasAlternatingBits = hasAlternatingBits(number);
		  
	  System.out.println();
		  
      if(hasAlternatingBits) {
		System.out.print("Yes the number has alternating bits.");  
	  } else {
		System.out.print("No the number does not have alternating bits.");    
	  }
	}
  }
