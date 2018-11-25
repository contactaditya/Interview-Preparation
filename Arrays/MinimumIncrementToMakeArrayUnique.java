import java.util.*;
import java.io.*;

  public class MinimumIncrementToMakeArrayUnique {
	  
    public static int minIncrementForUnique(int[] array) {
      Arrays.sort(array);
      int result = 0, need = 0;	
      for (int a : array) {
        result += Math.max(need - a, 0);
        need = Math.max(a, need) + 1;
      }
		
      return result;       
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];

      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt();
      }
	  
      int minimumNumberOfMoves = minIncrementForUnique(array);
      System.out.println();
      System.out.print("The least number of moves to make every value in array unique are: " + minimumNumberOfMoves);
    }
  }
