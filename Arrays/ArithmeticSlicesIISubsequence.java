import java.util.*;
import java.io.*;

  public class ArithmeticSlicesIISubsequence {
	
    public static int numberOfArithmeticSlices(int[] array) {
      int n = array.length;
      long numberOfArithmeticSlices = 0;
      Map<Integer, Integer> count[] = new Map[n];
      for (int i = 0; i < n; i++) {
        count[i] = new HashMap<>(i);
        for (int j = 0; j < i; j++) {
          long delta = (long)array[i] - (long)array[j];
          if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
            continue;
          }
          int difference = (int)delta;
          int sum = count[j].getOrDefault(difference, 0);
          int origin = count[i].getOrDefault(difference, 0);
          count[i].put(difference, origin + sum + 1);
          numberOfArithmeticSlices += sum;
        }
      }
		
      return (int)numberOfArithmeticSlices;     
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	  
      int result = numberOfArithmeticSlices(array);
      System.out.println();	
      System.out.print("The number of arithmetic subsequence slices in the array are: " + result);
    }
  }
