import java.util.*;
import java.io.*;

  public class NthMagicalNumber {
	  
    public static int nthMagicalNumber(int N, int A, int B) {
      int MOD = 1_000_000_007;
      int LCM = A/gcd(A, B) * B;	
      long low = 0;
      long high = (long) 1e15;
      while (low < high) {
        long mid = low + (high - low) / 2;
        // If there are not enough magic numbers below mi...
        if (mid/A + mid/B - mid/LCM < N) {
          low = mid + 1;
        }
        else { 
          high = mid;
        }
      }
		
      return (int) (low % MOD);      
    }  
	
    public static int gcd(int x, int y) {
      if (x == 0) {
    	return y;
      }
      
      return gcd(y % x, x);
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first number: ");
      int N = input.nextInt();  
      System.out.println();
      System.out.print("Enter the second number: ");
      int A = input.nextInt();  
      System.out.println();	
      System.out.print("Enter the second number: ");
      int B = input.nextInt();  
      
      int magicalNumber = nthMagicalNumber(N, A, B);
      System.out.println();	
      System.out.print("The N-th magical number is: " + magicalNumber);
    }
  }
