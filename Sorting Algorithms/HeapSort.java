import java.util.*;
import java.io.*;

 public class HeapSort {
	
   public static void heapsort(int[] array) {
     int n = array.length;
	 
     // Build heap (rearrange array)
     for (int i = n/2 - 1; i >= 0; i--) {
        heapify(array, n, i);
     }
     
     for (int i=n-1; i>=0; i--) {
       // Move current root to end
       int temp = array[0];
       array[0] = array[i];
       array[i] = temp;

       // call max heapify on the reduced heap
       heapify(array, i, 0);
     }
   }
   
   public static void heapify(int[] array, int n, int i) {
     int largest = i;
     int left = 2*i + 1;
     int right = 2*i + 2;
	 
     // If left child is larger than root	 
     if(left < n && array[left] > array[largest]) {
       largest = left;
     }
	
     // If right child is larger than largest so far	 
     if(right < n && array[right] > array[largest]) {
       largest = right;
     }
	
     if (largest != i) {
       int swap = array[i];
       array[i] = array[largest];
       array[largest] = swap;

       // Recursively heapify the affected sub-tree
       heapify(array, n, largest);
     }    
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
		
     System.out.print("\n");
     heapsort(array);
     System.out.print("The Sorted Array is: ");
     for (int i=0; i < array.length; i++) {
       System.out.print(array[i] + " ");
     }
   }
 }
