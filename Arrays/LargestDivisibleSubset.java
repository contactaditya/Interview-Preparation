import java.util.*;
import java.io.*;

  public class LargestDivisibleSubset {
	  
	public static List<Integer> largestDivisibleSubset(int[] array) {
	  List<Integer> result = new ArrayList<Integer>();
	  if (array == null || array.length == 0) {
		return result;
	  }
	  Arrays.sort(array);
	  int[] dp = new int[array.length];
	  for(int i = 0; i < dp.length; i++){
		Arrays.fill(dp, 1);
      }
	  // For each element in the array, find the length of largest subset it has.
	  for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < i; j++) {
          if (array[i] % array[j] == 0) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
      }
	  // Pick the index of the largest element in the dp.
	  int maxIndex = 0;
      for (int i = 1; i < array.length; i++) {
        if (dp[i] > dp[maxIndex]) {
          maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
      }
      // From array[maxIndex] to 0, add every element belongs to the largest subset.
      int number = array[maxIndex];
      for (int i = maxIndex; i >= 0; i--) {
    	if (number % array[i] == 0 && dp[maxIndex] - dp[i] <= 1) {
    	  result.add(array[i]);
          number = array[i];
          maxIndex = i;
    	}
      }
      Collections.sort(result);
      return result;	
	}	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
      }
	  
	  List<Integer> result = new ArrayList<Integer>();
      result = largestDivisibleSubset(array);
      System.out.println();
	  System.out.println("The largest subset such that every pair (Si, Sj) of elements in this subset satisfies Si % Sj = 0 or Sj % Si = 0: " + result); 
	}
  }
