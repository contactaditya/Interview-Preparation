import java.util.*;
import java.io.*;

 public class SearchInRotatedSortedArray {
	 
	public static int search(int[] array, int target) {
	   int low = 0, high = array.length - 1;
       // find the index of the smallest value using binary search.
		
       while(low < high) {
    	 int mid = low + (high - low)/2;
         if(array[mid] > array[high]) {
           low = mid+1;
         }
         else {
           high = mid;
         }
       }
       
       int numberOfRotations = low;
       low = 0; high = array.length - 1;
       // The usual binary search and accounting for rotation.
       while(low <= high){
         int mid = (low + high)/2;
         int realmid = (mid + numberOfRotations)%array.length;
         if(array[realmid]==target) {
           return realmid;
         }
         if(array[realmid]<target) {
           low = mid+1;
         }
         else {
           high = mid-1;
         }
       }
       
	   return -1;     
	} 

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int lengthOfArray = input.nextInt();  
	  int array[] = new int[lengthOfArray];
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0; i<lengthOfArray; i++) {  
        array[i] = input.nextInt();
      }
      Arrays.sort(array);
	  System.out.println();	
	  System.out.print("Enter the number of rotations in the array: ");
      int k = input.nextInt();
      if(k > array.length) {
	    k = k % array.length;
	  }
	  int[] result = new int[array.length];   
		    
	  for(int i=0; i<array.length; i++) {
	    result[(i+array.length-k)%array.length] = array[i];  
	  }
	  System.out.println();	
	  System.out.print("The contents of the array after rotation are: ");
	    
	  for(int i=0; i<array.length; i++) {
		System.out.print(result[i] + " "); 
	  }
	  System.out.println();	
	  System.out.print("Enter the number of rotations in the array: ");
      int target = input.nextInt();
	  System.out.println();	
	  int search = search(result, target);
	  System.out.println();	
	  if(search == -1) {
	    System.out.print("The target value " + target + " is not present in the array.");
	  }
	  else {
		System.out.print("The target value " + target + " is present in the array."); 
	  }
	}
  }
