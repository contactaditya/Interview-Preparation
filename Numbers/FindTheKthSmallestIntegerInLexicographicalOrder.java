import java.util.*;
import java.io.*;

  public class FindTheKthSmallestIntegerInLexicographicalOrder {
	  
    public static int findKthNumber(int n, int k) {
      int current = 1;
      k = k - 1;	
	  
      while (k > 0) {
        int steps = calcuateSteps(n, current, current + 1);
	if (steps <= k) {
	  current += 1;
	  k -= steps;
	} else {
	  current *= 10;
	  k -= 1;
	}
      }
		
      return current;     
    }

    private static int calcuateSteps(int n, long current, long next) {
      int steps = 0;
      while (current <= n) {
        steps += Math.min(n + 1, next) - current;
	next *= 10;
	current *= 10;
      }
      return steps;
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter an integer: ");
      int n = input.nextInt();  

      System.out.println();	
      System.out.print("Please enter an integer in the range from 1 to n: ");
      int k = input.nextInt(); 
	  		  
      int result = findKthNumber(n, k);
		    
      System.out.println();	
      System.out.print("The lexicographically " + k + "-th smallest integer in the range from 1 to " + n + " is: " + result);
      input.close();
    }
  }
