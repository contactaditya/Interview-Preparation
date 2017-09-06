import java.util.*;
import java.io.*;

 public class ThreeSumClosest {     
	
   public static int threeSumClosest(int[] array, int target) {
     int result = 0;
     int min = Integer.MAX_VALUE;
     if(array == null || array.length<0) {
       return result;
     }
     Arrays.sort(array);
     for(int i=0; i<array.length; i++) {
       int j = i + 1;
       int k = array.length - 1;	 
       while (j < k) {
 	 int sum = array[i] + array[j] + array[k];  
 	 int difference = Math.abs(sum - target);
 	 if(difference == 0) {
 	   return sum;
 	 }
 	 if (difference < min) {
	   min = difference;
	   result = sum;
	 }
 	 if (sum <= target) {
	   j++;
	 } else {
	   k--;
	 }	   
       }
     }	 
     return result;
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
     System.out.print("Enter the target sum: ");
     int target = input.nextInt();   
	  
     int result = 0;
	   
     result = threeSumClosest(array, target); 
     System.out.println();
     System.out.println("The sum that is closest to the target " + target + " is: " + result);
   }
 }
