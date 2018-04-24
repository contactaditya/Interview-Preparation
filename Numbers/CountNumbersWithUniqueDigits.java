import java.util.*;
import java.io.*;

  public class CountNumbersWithUniqueDigits {
	  
	public static int countNumbersWithUniqueDigits(int number) {
	  if (number == 0) {
		return 1; 
	  }
	        
	  int result = 10;
	  int uniqueDigits = 9; 
	  int availableNumber = 9;
	  while (number > 1 && availableNumber > 0) {
	    uniqueDigits = uniqueDigits * availableNumber;
	    result += uniqueDigits;
	    availableNumber--;
	    number--;
	  }
	        
	  return result;	 
	}  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
		 		
	  int numbersWithUniqueDigits = countNumbersWithUniqueDigits(number);

	  System.out.println();	
	  System.out.print("The total number of numbers with unique digits are: " +  numbersWithUniqueDigits);
	}
  }
