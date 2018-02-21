import java.util.*;
import java.io.*;

  public class NumberComplement {
	  
    public static int findComplement(int number) {
       return ~number & (Integer.highestOneBit(number) - 1); 
    } 

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
		 		
      int complementNumber = findComplement(number);

      System.out.println();	
      System.out.print("The complement number of the given integer is: " + complementNumber);
    }
  }
