import java.util.*;
import java.io.*;

  public class PrimeNumberOfSetBitsInBinaryRepresentation {
	  
	public static int countPrimeSetBits(int L, int R) {  
	  int ans = 0;
      for (int x = L; x <= R; x++) {
        if (isSmallPrime(Integer.bitCount(x))) {
          ans++;
        }
      }
      
      return ans;     
	}	  

	private static boolean isSmallPrime(int x) {
	  return (x == 2 || x == 3 || x == 5 || x == 7 || x == 11 || x == 13 || x == 17 || x == 19);
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the matrix: ");
	  int L = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the matrix: ");
	  int R = input.nextInt();  
	  
	  int countPrimeSetBits = countPrimeSetBits(L, R);
	  System.out.println();
	  System.out.println("The count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation is: " + countPrimeSetBits);	
	}
  }
