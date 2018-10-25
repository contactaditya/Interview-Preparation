import java.io.*;
import java.util.*;

 public class FourSumII {
	 
   public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
     Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    
     for(int i = 0; i < C.length; i++) {
       for(int j = 0; j < D.length; j++) {
         int sum = C[i] + D[j];
	 map.put(sum, map.getOrDefault(sum, 0) + 1);
       }
     }
		    
     int result = 0;
     for(int i = 0; i < A.length; i++) {
       for(int j = 0; j < B.length; j++) {
	 int sum = A[i] + B[j];  
	 result += map.getOrDefault(-1 * (A[i]+B[j]), 0);
       }
     }
	    
     return result;
   }

   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of elements in the array: ");
     int numberOfElements = input.nextInt();   
     int array1[] = new int[numberOfElements];
		    
     System.out.println();
     System.out.print("Please enter the actual values in the first array: ");
     for (int i = 0; i < numberOfElements; i++) {
       array1[i] = input.nextInt(); 
     }
		  
     int array2[] = new int[numberOfElements];
	    
     System.out.println();
     System.out.print("Please enter the actual values in the second array: ");
     for (int i = 0; i < numberOfElements; i++) {
       array2[i] = input.nextInt(); 
     }
	   
     int array3[] = new int[numberOfElements];
	    
     System.out.println();
     System.out.print("Please enter the actual values in the third array: ");
     for (int i = 0; i < numberOfElements; i++) {
       array3[i] = input.nextInt(); 
     }
	   
     int array4[] = new int[numberOfElements];
		    
     System.out.println();
     System.out.print("Please enter the actual values in the fourth array: ");
     for (int i = 0; i < numberOfElements; i++) {
       array4[i] = input.nextInt(); 
     }
   
     int result = fourSumCount(array1, array2, array3, array4); 
		   
     System.out.println();
     System.out.println("The total number of tuples such that A[i] + B[j] + C[k] + D[l] is zero are: " + result);
   }
 }
