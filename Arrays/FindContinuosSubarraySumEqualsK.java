import java.util.*;
import java.io.*;

 public class FindContinuosSubarraySumEqualsK {

   public static int subArrayWithGivenSum(int[] array, int sum) {
      int currentSum = 0;
      int count = 0;
		  
      for (int i=0; i<array.length; i++) {
	currentSum = array[i]; 
	if (currentSum == sum) {
          count++;
        }
        for(int j=i+1; j<array.length; j++){
          currentSum += array[j];
          if(currentSum == sum) {
            count++;
          }
        }
      }
     return count;
   }	

   public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for (int i = 0; i < array.length; i++) {
	 array[i] = input.nextInt();
      }
		
      System.out.println();	
      System.out.print("Enter the sum of subset that you want to check whether it is present in the array or not: ");
      int sum = input.nextInt();  
		  
      System.out.println();
      int count = subArrayWithGivenSum(array, sum); 
      System.out.println("The number of the contiguous subarray within an array which has the target sum " + sum + " is: " + count);
   }
 }
