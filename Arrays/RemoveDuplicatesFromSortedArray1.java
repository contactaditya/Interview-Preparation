import java.util.*;
import java.io.*;

 public class RemoveDuplicatesFromSortedArray1 { 
	 
   public static int removeDuplicates(int array[]) {
     if (array.length == 0) {
       return 0;  
     }
     int i = 0;
     for (int j = 1; j < array.length; j++) {
       if (array[j] != array[i]) {
         i++;
         array[i] = array[j];
       }  
     }  
     return i+1;  
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
	  
     Arrays.sort(array);
	  
     int length = removeDuplicates(array); 
     System.out.println();	
     System.out.print("The new length of the array without any duplicates is: " + length);
   }
 }
