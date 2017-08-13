import java.util.*;
import java.io.*;
 
 public class FindTheDuplicateNumber {
	 
    public static int findDuplicates(int array[]) {
        int low = 1;
	int high = array.length - 1;
	int mid = 0;
	  
	while(low < high) {
	   mid = low + ((high - low) / 2);  
	   int count = 0;
		 
           for(int i: array) {
	     if(i <= mid) {
	       count++;
	     }
	   }
		  
	   if(count > mid) {
	      high = mid;
	   } else {
	      low = mid + 1;
	   }
	}
	  
      return high;
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
	   
       int duplicate = findDuplicates(array); 
       System.out.println();
       System.out.print("The following number is duplicate in the array: " + duplicate);
	
    }
 }
