import java.util.*;
import java.io.*;

  public class SubarrayProductLessThanK {
	  
     public static int numSubarrayProductLessThanK(int[] array, int k) {
	if (k <= 1) {
	  return 0;
	}
	int product = 1, ans = 0, left = 0;
	for (int right = 0; right < array.length; right++) {
          product *= array[right];
          while (product >= k) {
            product /= array[left++];
          }
          ans += right - left + 1;
        }
	  
	return ans;     
     }  

     public static void main(String[] args) { 	  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of elements in the array: ");
       int numbers = input.nextInt();   
       int array[] = new int[numbers];
		    
       System.out.print("\n");
       System.out.print("Please enter the actual values in the array: ");
       for (int i = 0; i < numbers; i++) {
	 array[i] = input.nextInt(); 
       }
       System.out.println();
       System.out.print("Enter the number for which you want to check the product of all the elements in the subarray is less than that number: ");
       int k = input.nextInt();  
	   	   
       int result = numSubarrayProductLessThanK(array, k);
       System.out.println();
       System.out.print("The number of contiguous subarrays where the product of all the elements in the subarray is less than k are: " + result);
	   
     }
  }
