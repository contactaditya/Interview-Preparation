import java.util.*;
import java.io.*;

  public class MaximumLengthOfRepeatedSubarray {
	 
    public static int findLength(int[] A, int[] B) {
      if(A == null||B == null) {
    	return 0;
      }
      int m = A.length;
      int n = B.length;
      int max = 0;
      int[][] dp = new int[m + 1][n + 1];
      for(int i = 0; i <= m; i++) {
        for(int j = 0; j <= n; j++) {
          if(i == 0 || j == 0) {
            dp[i][j] = 0;
          } 
          else {
            if(A[i - 1] == B[j - 1]) {
              dp[i][j] = 1 + dp[i - 1][j - 1];
              max = Math.max(max,dp[i][j]);
            }
          }   
        }
      }
       
      return max;     
    }	 

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number1 = input.nextInt();  
      int array1[] = new int[number1];
		
      System.out.println();	
      System.out.print("Please enter the elements of the first array: ");
      for (int i = 0; i < array1.length; i++) {
	array1[i] = input.nextInt();
      }
	  
      System.out.println();	
      System.out.print("Enter number of elements in the second array: ");
      int number2 = input.nextInt();  
      int array2[] = new int[number2];
		
      System.out.println();	
      System.out.print("Please enter the elements of the second array: ");
      for (int i = 0; i < array2.length; i++) {
	array2[i] = input.nextInt();
      }
			
      int maxLength = findLength(array1, array2);
      System.out.println();	   
      System.out.println("The maximum length of an subarray that appears in both arrays is: " + maxLength);
    }
  }
