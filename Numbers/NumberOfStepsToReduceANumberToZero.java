import java.util.*;
import java.io.*;

  public class NumberOfStepsToReduceANumberToZero {
	
    public static int numberOfSteps(int number) { 
      int numberOfSteps = 0;
      while(number != 0) {
        if(number % 2 == 0) {
          number = number/2;
          numberOfSteps++;
	} else {
          number = number - 1;
          numberOfSteps++;
	}
      }
      return numberOfSteps;  
    }

    public static void main(String[] args) {      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
			
      int numberOfSteps = numberOfSteps(number);

      System.out.println();	
      System.out.print("The number of steps needed to reduce a number to zero are: " + numberOfSteps);
      input.close();
    }
  }
