import java.io.*;
import java.util.*;

  public class MaximumSumCircularSubarray {
	  
    public static int maxSubarraySumCircular(int[] array) {
      int sum = 0;
      for (int x : array) {
        sum += x;
      }
	  
      int ans1 = kadane(array, 0, array.length-1, 1);
      int ans2 = sum + kadane(array, 1, array.length-1, -1);
      int ans3 = sum + kadane(array, 0, array.length-2, -1);
      
      return Math.max(ans1, Math.max(ans2, ans3));
    }	  

    private static int kadane(int[] array, int i, int j, int sign) {
      int answer = Integer.MIN_VALUE;
      int current = Integer.MIN_VALUE;
      
      for (int k = i; k <= j; k++) {
    	current = sign * array[k] + Math.max(current, 0);
        answer = Math.max(answer, current);  
      }
        
      return answer;
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
		
      int maxPossibleSum = maxSubarraySumCircular(array);
      System.out.println();
      System.out.println("The maximum possible sum of a non-empty subarray of the circular array is: " + maxPossibleSum);
    }
  }
