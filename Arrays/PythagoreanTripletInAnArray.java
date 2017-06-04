import java.io.*;
import java.util.*;

 public class PythagoreanTripletInAnArray {
	 
   private static boolean pythagoreanTriplet(int[] array, int length) {
	 // Square array elements
     for (int i=0; i<length; i++) {
        array[i] = array[i] * array[i];
     }
       
     // Sort array elements
     Arrays.sort(array);
     
     // Now fix one element one by one and find the other two elements
     for (int i = length - 1; i >= 2; i--) {
       int left = 0;
       int right = i - 1;
       
       while(left < right) {
      // A triplet found
    	 if(array[left] + array[right] == array[i]) {
    	    return true; 
    	 }
    	 if(array[left] + array[right] < array[i]) {
            left++;
    	 }
         else {
            right--;
         }   
       } 
     }
    return false;
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
	   
      boolean isTriplet = pythagoreanTriplet(array, array.length); 
	   
      System.out.println();
      if(isTriplet) {
	 System.out.println("There is a Pythagorean Triplet");  
      }
      else {
	 System.out.println("There is no Pythagorean Triplet");    
      }
   }
 }
