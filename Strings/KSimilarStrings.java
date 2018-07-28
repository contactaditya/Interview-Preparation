import java.util.*;
import java.io.*;

  public class KSimilarStrings {
	  
	public static int kSimilarity(String A, String B) {
	  char[] arrayA = A.toCharArray();
	  char[] arrayB = B.toCharArray();
	  int count = 0;  
	  for (int i = 0; i < arrayA.length; i++) {
	    if (arrayA[i] == arrayB[i]) {
	      continue;
	    }
	    for (int j = i + 1; j < arrayA.length; j++) {
	      if (arrayA[i] == arrayB[j] && arrayB[i] == arrayA[j]) {
	        swap(arrayA, i, j);
	        count++;
	        break;
	      }
	    }
	  }
	  count += backtrack(arrayA, arrayB, 0);
	  
	  return count;
    }	  
	
	private static int backtrack(char[] A, char[] B, int start) {
      if (start == A.length) {
		return 0;
      }
      if (A[start] == B[start]) {
		return backtrack(A, B, start + 1);
      }
      int result = Integer.MAX_VALUE;
      for (int i = start + 1; i < A.length; i++) {
        if (B[start] == A[i] && A[i] != B[i]) {
          swap(A, start, i);
          result = Math.min(result, backtrack(A, B, start + 1) + 1);
          swap(A, start, i);
        }
      }
	
	  return result;
	}
	
	public static void swap(char[] T, int i, int j) {
	  char temp = T[i];
	  T[i] = T[j];
	  T[j] = temp;
	}

	public static void main(String[] args) {  
	  String A = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      A = input.nextLine(); 
	  
      System.out.println();	
      String B = new String();	  
      System.out.print("Enter the second string: ");
      B = input.nextLine(); 
		  
      int result = kSimilarity(A, B);
      System.out.println();
      System.out.println("The smallest K for which " + A  + " and " + B + " are K-similar is: " + result);
	}
  }
