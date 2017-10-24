import java.util.*;
import java.io.*;

  public class IntegerReplacement {
	 
	public static int integerReplacement(int number) {
      if (number == Integer.MAX_VALUE) {
		return 32;	
	  }
	  int numberOfSteps = 0;
	  while(number > 1) {	
	    if(number%2 == 0) {
		  number = number/2;
	    }
	    else {
	      if ((number + 1) % 4 == 0 && (number - 1 != 2)) {
	    	number = number + 1;
	      }
          else {
        	number = number - 1;
          }
	    }
		numberOfSteps++;
	  }
	 
	  return numberOfSteps;     
	}	  

	public static void main(String[] args) { 	   
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the number: ");
	   int number = input.nextInt();  
	  
	   int minimumNumberOfReplacements = integerReplacement(number);
	   System.out.println();	
	   System.out.print("The minimum number of replacements needed for the number to become 1 is: " + minimumNumberOfReplacements);
	}
  }
