import java.util.*;
import java.io.*;

  public class SumOfSubarrayMinimums {

    public static int sumSubarrayMins(int[] array) {    	
      int result = 0, MOD = 1000000007, k = 0;
      int index[] = new int[array.length + 1];
      int value[] = new int[array.length + 1];
      index[0] = -1;
      for (int i = 0; i < array.length; i++) {
        int n = array[i];
        while (k > 0 && array[index[k]] >= n) {
          k--;
        }
        int m = (n * (i - index[k]) + value[k]) % MOD;
        result = (result + m) % MOD;
        index[++k] = i;
        value[k] = m;
      }
   
      return result;  
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
      int result = sumSubarrayMins(array); 
      System.out.println();	
      System.out.print("The sum of subarray minimums is: " + result);  
    }
  }
