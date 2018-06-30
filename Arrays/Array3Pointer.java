import java.util.*;
import java.io.*;

  public class Array3Pointer {
	  
    public static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {  
      int difference = Integer.MAX_VALUE; // Initialize min difference
     
      // Initialize result
      int resultI = 0, resultJ = 0, resultK = 0;
      // Traverse arrays
      int i = 0, j = 0, k = 0;
      while (i < A.size() && j < B.size() && k < C.size()) {
    	// Find minimum and maximum of current three elements
        int minimum = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
        int maximum = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
        // Update result if current difference is less than the min difference so far
        if (maximum - minimum < difference) {
          resultI = i;
          resultJ = j;
          resultK = k;
          difference = maximum - minimum;
        }
        // We can't get less than 0 as values are absolute
        if (difference == 0) {
          break;
        }
        // Increment index of array with smallest value
        if (A.get(i) == minimum) {
          i++;
        }
        else if (B.get(j) == minimum) {
          j++;
        }
        else {
          k++;
        }
      }
	    
      return difference;
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first list: ");
      int number = input.nextInt();  
      ArrayList<Integer> A = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the first list: ");
      for (int i = 0; i < number; i++) {
	A.add(input.nextInt());
      }
      
      System.out.println();	
      System.out.print("Enter number of elements in the second list: ");
      int number1 = input.nextInt();  
      ArrayList<Integer> B = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the second list: ");
      for (int i = 0; i < number1; i++) {
	B.add(input.nextInt());
      }
      
      System.out.println();	
      System.out.print("Enter number of elements in the third list: ");
      int number2 = input.nextInt();  
      ArrayList<Integer> C = new ArrayList<Integer>();	
			
      System.out.println();	
      System.out.print("Please enter the elements of the third list: ");
      for (int i = 0; i < number2; i++) {
	C.add(input.nextInt());
      }
      
      int result = minimize(A, B, C);
      System.out.println();	
      System.out.print("The minimum value of max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is: " + result);
    }
  }
