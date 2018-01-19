import java.util.*;
import java.io.*;

  public class CountFactors {
	  
    public static int getNumberOfFactors(int number) {
      int numberOfFactors = 0;
      
      for(int i = 1; i <= (double) Math.sqrt(number); i++) {
    	if(number % i == 0) {
    	  if (i * i != number) {
            numberOfFactors = numberOfFactors + 2;
          } else if (i * i == number) {
	    numberOfFactors = numberOfFactors + 1;
	  }	
    	}
      }
		
      return numberOfFactors;
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  

      int getNumberOfFactors = getNumberOfFactors(number);
      System.out.println();	
      System.out.print("The number of factors of the positive integer " + number  + " are: " + getNumberOfFactors);

    }
  }
