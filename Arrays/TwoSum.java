import java.io.*;
import java.util.*;

 public class TwoSum { 	
	 
   public static int[] twoSum(int[] array, int sum) {
     Map<Integer, Integer> map = new HashMap<Integer, Integer>();	   
      
     for (int i = 0; i < array.length; i++) {
       int complement = sum - array[i];
       if (map.containsKey(complement)) {
         return new int[] {map.get(complement), i};
       }
       map.put(array[i], i);
     } 
     return null;
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
     System.out.print("Enter the sum that you want to check whether it is present in the array or not: ");
     int sum = input.nextInt();  
	  
     System.out.println();
     int[] result = twoSum(array, sum);
     if(result != null) {
       System.out.print("The index of the array which have the sum: ");  
       for (int i=0; i < result.length; i++) {
	 System.out.print(result[i] + " ");
       }	  
     }
     else {
       System.out.print("There is no pair in the array with the required sum.");  
     }
   }
 }
