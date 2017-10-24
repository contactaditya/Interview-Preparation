import java.util.*;
import java.io.*;

  public class MaximumSwap {
	
    public static int maximumSwap(int number) {
       char[] A = Integer.toString(number).toCharArray();
       int[] last = new int[10];
       for (int i = 0; i < A.length; i++) {
         last[A[i] - '0'] = i;
       }	
		
       for (int i = 0; i < A.length; i++) {
        for (int d = 9; d > A[i] - '0'; d--) {
          if (last[d] > i) {
            char temp = A[i];
            A[i] = A[last[d]];
            A[last[d]] = temp;
            return Integer.valueOf(new String(A));
          }
        }
       }
  
       return number; 
    }

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
		   
	  int maximumValuedNumber = maximumSwap(number);
	  System.out.println();	
	  System.out.print("The maximum valued number you could get after swapping two digits at most once is: " + maximumValuedNumber);
	}
  }
