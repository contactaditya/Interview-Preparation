import java.util.*;
import java.io.*;

  public class NumberOfLongestIncreasingSubsequence {
	 
	public static int findNumberOfLIS(int[] array) {
	   if (array == null || array.length == 0) {
		  return 0;	  
	   }
	   int n = array.length, result = 0, maxLength = 0;
       int length[] =  new int[n], count[] = new int[n];
       for(int i = 0; i<n; i++) {
         length[i] = count[i] = 1;
         for(int j = 0; j<i; j++) {
           if(array[i] > array[j]) {
        	 if(length[i] == length[j] + 1) {
        	   count[i] += count[j];   
        	 }
             if(length[i] < length[j] + 1) {
        	   length[i] = length[j] + 1;
        	   count[i] = count[j];
             }   
           }
         }
         if(maxLength == length[i]) {
           result += count[i];
         }
         if(maxLength < length[i]) {
           maxLength = length[i];
           result = count[i];
         } 
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
       for(int i = 0; i < numbers; i++) {
         array[i] = input.nextInt(); 
       }
      
       int numberOfLIS = findNumberOfLIS(array);
      
       System.out.println();	
       System.out.println("The number of longest increasing subsequence are: " + numberOfLIS);	
	}
  }
