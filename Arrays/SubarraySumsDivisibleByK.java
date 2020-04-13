import java.util.*;
import java.io.*;

  public class SubarraySumsDivisibleByK {
	  
    public static int subarraysDivByK(int[] array, int K) {
      int sum = 0;
      int count = 0;
      int map[] = new int[K];
      map[0] = 1;
      for (int i = 0; i < array.length; i++) {
	sum = (sum + array[i]) % K;
	if(sum < 0) {
	  sum += K;	
	}
        count += map[sum];
	map[sum]++;
      }
      return count;      
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
      System.out.print("Enter a number between 2 and 10000: ");
      int k = input.nextInt();  
	   	   
      int result = subarraysDivByK(array, k);
      System.out.println();
      System.out.print("The number of contiguous subarrays that have a sum divisible by k are: " + result);
      input.close();
    }
  }
