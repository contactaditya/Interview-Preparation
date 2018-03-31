import java.util.*;
import java.io.*;

 public class FindPairsEqualsToSum { 
	 
   public static int findPairsEqualsToSum(int array[], int sum) {
     HashMap<Integer, Integer> elementIndexMap = new HashMap<Integer, Integer>();
     int count = 0;
     for (int i = 0; i < array.length; i++) {
       elementIndexMap.put(array[i], i);
     }
     System.out.println();
     System.out.print("The pairs which equals the sum " + sum + " are: ");
     for (int i = 0; i < array.length; i++) {
       if (elementIndexMap.get(sum - array[i]) != null && elementIndexMap.get(sum - array[i]) != i) {
    	 System.out.print("{" + array[i] + "," + (sum - array[i]) + "}");	
    	 System.out.print(" ");
     	 count++;
       }
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
     System.out.print("Please enter the sum: ");
     int sum = input.nextInt();   
	  
     int count = findPairsEqualsToSum(array, sum);
     System.out.println();	
     System.out.println();	
     System.out.print("The number of pairs of integers in the array whose sum is equal to " + sum + " is: " + count);
   }
 }
