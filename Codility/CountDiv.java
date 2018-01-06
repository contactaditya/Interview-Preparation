import java.util.*;
import java.io.*;

  public class CountDiv { 
	  
    public static int countNumberOfDivisibleIntegers(int A, int B, int K) {
      int count = 0;
      for (int i = A; i <= B; i++) {
        if(i % K == 0) {
          count++;	 
        }
      }
	  
      return count;  
    }
	
    public static int countNumberOfDivisibleIntegers1(int A, int B, int K) {
      int count = 0;
      count = B/K - A/K;
      if(A % K == 0) {
    	count++;
      }
      return count; 
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first integer: ");
      int A = input.nextInt();   
		   
      System.out.println();
      System.out.print("Enter the second integer: ");
      int B = input.nextInt();   
		   
      System.out.println();
      System.out.print("Enter the third integer: ");
      int K = input.nextInt(); 

      int countNumberOfDivisibleIntegers = countNumberOfDivisibleIntegers1(A, B, K);
      System.out.println();
      System.out.print("The number of integers within the range [" + A + ".." + B + "] that are divisible by " + K + " are: " + countNumberOfDivisibleIntegers);
    }
  }
