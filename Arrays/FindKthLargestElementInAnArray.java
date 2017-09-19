import java.util.*;
import java.io.*;

 public class FindKthLargestElementInAnArray {
	
   public static int findKthLargest(int[] array, int k) {
      if (array == null || array.length == 0) {
	 return 0;
      }
	        
      java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(array.length, Collections.reverseOrder());	
		
      for (int number : array) {
        maxHeap.offer(number);
      }
		
      int result = 0;
      for (int i = 0; i < k; i++) {
        result = maxHeap.poll();
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
      System.out.print("Enter the number of most frequent elements that you want the program to return: ");
      int k = input.nextInt();  
	   
      int result = findKthLargest(array, k);
      System.out.println();
      System.out.print("The " + k + " largest element in the sorted order is: " + result);

   }
 }
