import java.util.*;
import java.io.*;
 
 public class SearchInsertPosition {
	 
   public static int searchInsert(int[] array, int target) {
      int low = 0, high = array.length-1;
      while(low <= high) {
        int mid = low + (high-low)/2;
        if(array[mid] == target) {
          return mid;
        }
        else if(array[mid] > target) {
          high = mid-1;
        }
        else {
          low = mid+1;
        }
      }
      return low;	
   }	 

   public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
					
      System.out.println();	
      System.out.print("Please enter the elements in the array: "); 
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
      System.out.println();
      System.out.print("Please enter the target value that needs to searched in the array: ");
      int target = input.nextInt();  
      int index = searchInsert(array, target);
      System.out.println();
      System.out.print("The index where the target is found or where it would be if it were inserted in order is: " + index);  
   }
 }
