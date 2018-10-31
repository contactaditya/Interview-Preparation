import java.util.*;
import java.io.*;

  public class BinarySubarraysWithSum {
	  
    public static int numSubarraysWithSum(int[] array, int sum) {
      int numberOfSubArrays = 0;
      int prefixSum = 0; 
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      map.put(0, 1);
      for (int i = 0; i < array.length; i++) {
	prefixSum += array[i];
	numberOfSubArrays += map.getOrDefault(prefixSum - sum, 0);
	map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
      }
	  
      return numberOfSubArrays;      
    }

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements of the array containing only 0s and 1s: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	  
      System.out.println();	
      System.out.print("Please enter the sum: ");
      int sum = input.nextInt();
	  
      int result = numSubarraysWithSum(array, sum); 
      System.out.println();	
      System.out.println("The number of non-empty subarrays that have the sum " + sum + " are: " + result);  
      input.close();
    }
  }
