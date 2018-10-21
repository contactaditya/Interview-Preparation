import java.io.*;
import java.util.*;

  public class ThreeSumWithMultiplicity {
	
	public static int threeSumMulti(int[] array, int target) {
	  int MOD = 1_000_000_007;
	  long[] count = new long[101];
	  for (int x : array) {
		count[x]++;
	  }
	  long result = 0;
	  
	  for (int i = 0; i <= 100; i++) {
	    for (int j = i; j <= 100; j++) {	  
	      int k = target - i - j;
	      if (k > 100 || k < 0) {
	    	continue;
	      }
	      if (i == j && j == k) {
	    	result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
          } else if (i == j && j != k) {
        	result += count[i] * (count[i] - 1) / 2 * count[k];  
          } else if (j < k) {
        	result += count[i] * count[j] * count[k];
          }
		}  
	  }

	  return (int) (result % MOD);     
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
	  System.out.println();
	  System.out.print("Enter the target sum: ");
	  int target = input.nextInt();   
	   
	  int result = threeSumMulti(array, target);
	  System.out.println();
	  System.out.print("The number of tuples i, j, k such that i < j < k and array[i] + array[j] + array[k] == target are: " + result);
	}
  }
