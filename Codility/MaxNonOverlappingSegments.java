import java.util.*;
import java.io.*;

  public class MaxNonOverlappingSegments {
	  
    public static int getMaxNonOverlappingSegments(int A[], int B[], int N) {      
      if (A.length == 0) {
	return 0;
      }
      int last = 0, count = 1;  
      for (int i = 1; i < A.length; i++) {
	if (A[i] > B[last]) {
	  count++;     
	  last = i;
	}
      }
      return count; 
    }  
  
    public static void main(String[] args) {      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int N = input.nextInt();  
      int A[] = new int[N];
	  
      System.out.println();	
      System.out.print("Please enter the elements in the first array: ");
      for(int i = 0; i < A.length; i++) {
	A[i] = input.nextInt();
      }
	 
      int B[] = new int[N]; 
      System.out.println();	
      System.out.print("Please enter the elements in the second array: ");
      for(int i = 0; i < B.length; i++) {
	B[i] = input.nextInt();
      }
	  	  
      int sizeOfMaximalNumberSegments = getMaxNonOverlappingSegments(A, B, N);
	  
      System.out.println();		
      System.out.print("The size of a non-overlapping set containing the maximal number of segments is: " + sizeOfMaximalNumberSegments);   
    }
  }
