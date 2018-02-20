import java.util.*;
import java.io.*;

  public class SplitArrayLargestSum {
	  
    public static int splitArray(int[] array, int m) {
      long left = 0;
      long right = 0;        
      for (int i = 0; i < array.length; i++) {
        right += array[i];
        if (left < array[i]) {
          left = array[i];
        }
      }
      long answer = right;
      while (left <= right) {
        long mid = left + (right - left)/2;   
        long sum = 0;
        int count = 1;
        for (int i = 0; i < array.length; i++) {
          if (sum + array[i] > mid) {
            count++;
            sum = array[i];
          } else {
            sum += array[i];
          }
        }
        if (count <= m) {
          answer = Math.min(answer, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
	
      return (int) answer;  
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
      System.out.print("Enter the number of times you want to split the array into non-empty continuous subarrays: ");
      int m = input.nextInt();
	  
      int minimumLargestSum = splitArray(array, m);
      System.out.println();	
      System.out.print("The minimum largest sum among these m subarrays is: " + minimumLargestSum);
    }
  }
