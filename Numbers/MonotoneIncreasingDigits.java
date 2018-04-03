import java.util.*;
import java.io.*;

  public class MonotoneIncreasingDigits {
	  
	public static int monotoneIncreasingDigits(int number) {
	  char S[] = String.valueOf(number).toCharArray();
      int i = 1;
      // Find the index at which leftmost digit is greater than the right digit
      while (i < S.length && S[i-1] <= S[i]) {
    	i++;
      }
      // Decrement the appropriate digit and move i back
      while (i > 0 && i < S.length && S[i-1] > S[i]) {
    	S[--i]--;
      }
      // All the digits right to the index will be set to 9
      for (int j = i+1; j < S.length; j++) {
    	S[j] = '9';
      }
      
	  return Integer.parseInt(String.valueOf(S));
	}

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter a number: ");
      int number = input.nextInt();  
		    
      int result = monotoneIncreasingDigits(number);
      System.out.println();
      System.out.println("The largest number that is less than or equal to " + number + " with monotone increasing digits is: " + result);  
	}
  }
