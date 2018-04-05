import java.io.*;
import java.util.*;

 public class FindSubArrayWithGivenSum {  
	
   public static int subArrayWithGivenSum(int[] array, int number, int sum) {
     int currentSum = array[0];
     int start = 0;
	  
     for (int i = 1; i <= number; i++) {
       // If current sum exceeds the sum, then remove the starting elements
       while (currentSum > sum && start < i-1) {
         currentSum = currentSum - array[start];
         start++;
       }  
       // If current sum becomes equal to sum, then return true
       if (currentSum == sum) {
         int p = i-1;
         System.out.println("Sum found between indexes " + start + " and " + p);
         return 1;
       }
        
       // Add this element to current sum
       if (i < number) {
         currentSum = currentSum + array[i];
       }      
     }
     System.out.println("No subarray found");
     return 0;
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
     subArrayWithGivenSum(array, number, sum);
   }
 }
