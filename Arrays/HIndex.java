import java.io.*;
import java.util.*;

 public class HIndex { 	
	 
  public static int hIndex(int[] citations) {
     if(citations == null || citations.length == 0) {
	return 0;	 
     }
	 
     Arrays.sort(citations);
     int result = 0;
     for(int i=0; i<citations.length; i++){
	int smaller = Math.min(citations[i], citations.length-i);
	result = Math.max(result, smaller);
     }
	  
    return result;
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
