import java.util.*;
import java.io.*;

  public class ReachANumber {
	  
    public static int reachNumber(int target) {
      target = Math.abs(target);
      int k = 0;	
	  
      while (target > 0) {
        target -= ++k;
      }
		
      return target % 2 == 0 ? k : k + 1 + k%2;      
    }	  

    public static void main(String[] args) {    
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();
		  
      int minimumNumberOfSteps = reachNumber(number);
      System.out.println();
      System.out.println("The minimum number of steps required to reach the destination are: " + minimumNumberOfSteps);

    }
  }
