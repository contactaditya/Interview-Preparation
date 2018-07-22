import java.util.*;
import java.io.*;

  public class BinaryGap1 {
	  
    public static int binaryGap(int number) { 
      if (number <= 0) {
	return 0;
      }
      int max = 0, currentDistance = 0;
      boolean firstOne = true;
      while (number > 0) {
        int r = number % 2;
        if (r == 1) {
          if (firstOne) {
            firstOne = false;
          } else {
            max = Math.max(max, currentDistance);
          }
          currentDistance = 1;
        } else {
          currentDistance++;
        }
    	number = number >> 1;
      }
      return max;
    }
	
    public static int binaryGap1(int number) { 
      int last = -1, answer = 0;
      for (int i = 0; i < 32; i++) {
        if (((number >> i) & 1) > 0) {
	  if (last >= 0) {
	    answer = Math.max(answer, i - last);
	  }
	  last = i;
	}
      }
	            
      return answer;
    }
      
    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  

      int longestBinaryGap = binaryGap(number);
      System.out.println();	
      System.out.print("The length of the longest distance between two consecutive 1's is: " + longestBinaryGap);
    }
  }
