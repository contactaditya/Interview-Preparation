import java.io.*;
import java.util.*;

 public class HIndexII {
	 
	public static int hIndex(int[] citations) {
	   if(citations == null || citations.length == 0) {
		 return 0;	  
	   }
	   int length = citations.length;
       int low = 0, high = length - 1;
       while(low <= high) {
    	 int mid = low + ((high - low)/2);  
  		 if (citations[mid] == length - mid) {
  		   return length - mid;
  		 } else if (citations[mid] < length - mid) {
  		   low = mid + 1;
  	     } else {
  	       high = mid - 1;	 
  	     }
       }
	   return length - low;     
    }	 

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int citations[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < citations.length; i++) {
	    citations[i] = input.nextInt();
	  }
		  
	  int hIndex = hIndex(citations);
	  
	  System.out.println();
	  System.out.print("The researcher's h-index is: " + hIndex);
	}
 }
