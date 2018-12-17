import java.util.*;
import java.io.*;

  public class SumOfSubsequenceWidths {
	  
	public static int sumSubseqWidths(int array[]) {
	  Arrays.sort(array);
	  long c = 1, result = 0, mod = (long)1e9 + 7;
	  for (int i = 0; i < array.length; i++, c = (c << 1) % mod) {
		result = (result + array[i] * c - array[array.length - i - 1] * c) % mod;
	  }
	        
	  return (int)((result + mod) % mod);      
	}

	public static int sumSubseqWidths1(int array[]) {
	  Arrays.sort(array);
	  int left = 0, right = array.length - 1;
      int lsum = 0, rsum = 0;
      long d = 1, result = 0, mod = 1000000007;
      while(left < array.length) {
        lsum += array[left++];
        rsum += array[right--];
        result += (rsum-lsum)*d;
        result %= mod;
        d = d * 2 % mod;
      }
		        
	  return (int) result;      
	}
	
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];

	  System.out.println();	
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt();
	  }
		  
	  input.close();
	  int sumOfWidthsOfAllSubsequences = sumSubseqWidths1(array); 
	  System.out.println();	
	  System.out.print("The sum of the widths of all subsequences of the array is: " + sumOfWidthsOfAllSubsequences);  
	}
  }
