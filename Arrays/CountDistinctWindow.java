import java.util.*;
import java.io.*;

public class CountDistinctWindow { 
	
  public static void countDistinctWindow(int array[], int k) {
     HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	   
     // initialize distinct element  count for current window
     int distinctCount = 0; 
     // Traverse the first window and store count of every element in hash map
     for (int i = 0; i < k; i++) {
       if (hashMap.get(array[i]) == null) {
         hashMap.put(array[i], 1);
         distinctCount++;
       }
       else {
         int count = hashMap.get(array[i]);
         hashMap.put(array[i], count+1);
       }
     }
     System.out.println();	
     System.out.print("The count of distinct numbers in all windows of size k is: ");	
     // Traverse through the remaining array
     for (int i = k; i < array.length; i++) {
      // Remove first element of previous window If there was only one occurrence, then reduce distinct count.
      if (hashMap.get(array[i-k]) == 1) {
         hashMap.remove(array[i-k]);
         distinctCount--;
      }
      // Reduce count of the removed element
      else {
          int count = hashMap.get(array[i-k]);
          hashMap.put(array[i-k], count-1);
      }
      // Add new element of current window. If this element appears first time, increment distinct element count 
      if (hashMap.get(array[i]) == null) {
         hashMap.put(array[i], 1);
         distinctCount++;
      }
      // Increment distinct element count
      else  {
         int count = hashMap.get(array[i]);
         hashMap.put(array[i], count+1);
      }
	   
       // Print count of first window
       System.out.print(distinctCount + " ");
    }
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
      System.out.print("Enter the size of the sliding window: ");
      int sizeOfSlidingWindow = input.nextInt();      
      countDistinctWindow(array, sizeOfSlidingWindow);

   }
 }
