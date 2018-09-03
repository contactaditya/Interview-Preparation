import java.util.*;
import java.io.*;

  public class ReorderedPowerOf2 {
	  
    public static boolean reorderedPowerOf2(int number) {
      int[] array = count(number);
      for (int i = 0; i < 31; i++) {
	// The left-shift of 1 by i is equivalent to 2 raised to power i. 
	if (Arrays.equals(array, count(1 << i))) {
	  return true;
	}
      }
      return false;     
    }
	
    public static int[] count(int number) {
      int[] ans = new int[10];
      while (number > 0) {
	ans[number % 10]++;
	number /= 10;
      }
      return ans;
    }	

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  

      boolean result = reorderedPowerOf2(number);
      System.out.println();
      if(result) {
	 System.out.println("Yes we can reorder the digits in a way such that the resulting number is a power of 2.");  
      }
      else {
	 System.out.println("No we cannot reorder the digits in a way such that the resulting number is a power of 2. ");  
      }
    }
  }
