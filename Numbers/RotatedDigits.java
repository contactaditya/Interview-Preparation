import java.util.*;
import java.io.*;

  public class RotatedDigits {
	  
    public static int rotatedDigits(int N) {
      // Count how many n in [1, N] are good.
      int answer = 0;
      for (int n = 1; n <= N; n++) {
        if (good(n, false)) {
          answer++;
        }
      }
        
      return answer;  
    }	  

    private static boolean good(int n, boolean flag) {
      if (n == 0) {
	return flag;
      }
		
      int d = n % 10;
      // If the number has a digit that does not have a valid rotation (3, 4, or 7), then it can't be good.
      if (d == 3 || d == 4 || d == 7) {
	return false;
      }
      // If the number doesn't have a digit that rotates to a different digit (2, 5, 6, or 9), it can't be good because the number will be the same after rotation.
      if (d == 0 || d == 1 || d == 8) {
	return good(n / 10, flag);
      }
	  
      return good(n / 10, true);
    }

    public static void main(String[] args) {     
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();   
		    	   
      int goodNumbers = rotatedDigits(number); 
		   
      System.out.println();
      System.out.println("The good numbers in the range are: " + goodNumbers);  
  
    }
  }
