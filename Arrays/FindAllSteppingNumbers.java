import java.util.*;
import java.io.*;

  public class FindAllSteppingNumbers {
	  
    public static ArrayList<Integer> stepNumber(int a, int b) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      for (int i = a; i <= b; i++) {
	if (validStepNumber(i)) {
	  result.add(i);  
	}
      }
	 
      return result;
    } 
	
    public static boolean validStepNumber(int number) {
      int last = number % 10;
      int current = 0;
      number /= 10;
      while (number > 0) {
	current = number % 10;
	if (Math.abs(current - last) == 1) {
	  last = current;
	  number /= 10;
	} else {
	  return false;
	}
      }
		 
      return true;
    }  

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the two numbers between which we have to find all the stepping numbers: ");
      int N = input.nextInt();  
      int M = input.nextInt();
	  
      List<Integer> result = new ArrayList<Integer>();
      result = stepNumber(N,M);
      System.out.println();
      System.out.println("All stepping numbers between " + N + " and " + M + " are: " + result);
    }
  }
