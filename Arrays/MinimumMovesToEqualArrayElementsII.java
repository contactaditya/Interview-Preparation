import java.util.*;
import java.io.*;

  public class MinimumMovesToEqualArrayElementsII {
	  
	public static int minMoves2(int[] array) { 
 	  if (array == null || array.length <= 1) {
		return 0;
	  }
	  Arrays.sort(array);
	  int i = 0, j = array.length-1;
      int count = 0;
      while(i < j) {
        count += array[j] - array[i];
        i++;
        j--;
      }
      return count;
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
	  
	  int minimumNumberOfMoves = minMoves2(array);
	
	  System.out.println();
	  System.out.print("The minimum number of moves required to make all array elements equal are: " + minimumNumberOfMoves);
	}
  }
