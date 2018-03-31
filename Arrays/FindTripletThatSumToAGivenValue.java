import java.util.*;
import java.io.*;

 public class FindTripletThatSumToAGivenValue {   
	
   public static boolean findTripletThatSumToAGivenValue(int[] array, int sum) {
     int left, right;
     Arrays.sort(array);
	 
     /* Now fix the first element one by one and find the other two elements */
     for (int i = 0; i < array.length - 2; i++)  {
       left = i + 1;  
       right = array.length - 1; 
       while(left < right) {
	 if (array[i] + array[left] + array[right] == sum) {
	   System.out.println();	 
           System.out.print("Triplet is " + array[i] + " ," + array[left] + " ," + array[right]);
           return true;
         }
         else if (array[i] + array[left] + array[right] < sum) {
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
     int number = input.nextInt();  
     int array[] = new int[number];
			  
     System.out.println();	
     System.out.print("Please enter the actual numbers in the array: ");
     for (int i = 0; i < array.length; i++) {
       array[i] = input.nextInt();
     }
	  
     System.out.println();	
     System.out.print("Enter the sum that you want to check whether it is present in the array or not: ");
     int sum = input.nextInt();  
     boolean result = findTripletThatSumToAGivenValue(array, sum);
     System.out.println();
     System.out.println();
     if(result) {
       System.out.println("There is a Triplet in the array whose sum is equal to the given value.");  
     } 
     else {
       System.out.println("There is not a Triplet in the array whose sum is equal to the given value.");
     }  
   }
 }
