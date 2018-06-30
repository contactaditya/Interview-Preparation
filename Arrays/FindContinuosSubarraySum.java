import java.util.*;
import java.io.*;

 public class FindContinuosSubarraySum {
	  
   public static boolean checkSubarraySum(int[] array, int sum) {
     Map<Integer, Integer> map = new HashMap<Integer, Integer>();	
     map.put(0, -1);
     int runningSum = 0;
     for(int i = 0; i < array.length; i++) {
       runningSum += array[i];  
       if(sum != 0) {
	 runningSum %= sum;	
       }
       if(map.containsKey(runningSum)) {
         if(i - map.get(runningSum) > 1) {
	   return true;	 
         }
	 else {
	   map.put(runningSum, i);
	 }
       }
     }  
     return false;
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
     System.out.print("Enter the sum that you want to check whether it is present in the continuos subarray or not: ");
     int sum = input.nextInt();  
		  
     System.out.println();
     boolean continuosSubarraySum = checkSubarraySum(array, sum); 
     if(continuosSubarraySum) {
       System.out.println("The array has a continuous subarray of size at least 2 that sums up to the multiple of " + sum + ", that is, sums up to n*k where n is also an integer.");  
     }
     else { 
       System.out.println("The array does not have a continuous subarray of size at least 2 that sums up to the multiple of " + sum + ", that is, sums up to n*k where n is also an integer.");    
     }
   }
 }
