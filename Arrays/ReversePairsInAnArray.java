import java.util.*;
import java.io.*;

  public class ReversePairsInAnArray {
	  
    public static int reversePairs(int[] array) {
       if (array == null || array.length == 0) {
	  return 0;
       }
	      
       return mergeSort(array, 0, array.length-1);
    }	  

    private static int mergeSort(int[] array, int low, int high) {
       if (low >= high) {
	 return 0;
       }
	   
       int mid = low + (high - low)/2;
       int count = mergeSort(array, low, mid) + mergeSort(array, mid+1, high);
       int j = mid + 1;	
       for(int i=low; i<=mid; i++) {
         while(j <= high && array[i]/2.0 > array[j]) {
           j++; 
         }
         count += j-(mid+1); 
       }
       Arrays.sort(array, low, high+1);  
       return count;
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
	  
       int numberOfReversePairs = reversePairs(array);
       System.out.println();	
       System.out.print("The number of reverse pairs in the array are: " + numberOfReversePairs);

    }
  }
