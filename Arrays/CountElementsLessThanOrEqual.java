import java.util.*;
import java.io.*;

 public class CountElementsLessThanOrEqual {  
	 
	public static void countElementsLessThanOrEqual(int[] array1, int[] array2) {
	   Arrays.sort(array2);
	   
	   System.out.println();	
	   System.out.print("The number of elements in the 2nd array that are less than or equal to the current element in the 1st array: ");
	   for (int i=0; i < array1.length; i++) {
		 int index = binarySearch(array2, 0, array2.length-1, array1[i]);
		 System.out.print((index+1) + " ");
	   }
	}	
 
	private static int binarySearch(int[] array2, int low, int high, int element) {
	   while(low <= high) {
		 int mid = (low + high)/2;  
		 if(array2[mid] <= element) {
		    low = mid + 1; 
		 }
		 else {
			high = mid - 1;     
		 }		   
	   }
		
	   return high;
	}

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the first array: ");
	   int number1 = input.nextInt();  
	   int array1[] = new int[number1];
		
	   System.out.println();	
	   System.out.print("Please enter the elements in the first array: ");
	   for (int i = 0; i < array1.length; i++) {
		 array1[i] = input.nextInt();
	   }
	   
	   System.out.println();	
	   System.out.print("Enter number of elements in the second array: ");
	   int number2 = input.nextInt();  
	   int array2[] = new int[number2];
		
	   System.out.println();	
	   System.out.print("Please enter the elements in the second array: ");
	   for (int i = 0; i < array2.length; i++) {
		 array2[i] = input.nextInt();
	   }	
	   
	   countElementsLessThanOrEqual(array1, array2);
	}
 }
