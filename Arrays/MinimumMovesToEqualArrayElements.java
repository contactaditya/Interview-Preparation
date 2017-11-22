import java.util.*;
import java.io.*;

 public class MinimumMovesToEqualArrayElements {
	  
   public static int minMoves(int[] array) {
      int min = array[0], sum = 0;
      for (int n : array) {
    	sum += n;
    	if (n < min) {
    	  min = n;
    	}
      }
		
      return sum - array.length * min;     
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
	  
      int minimumNumberOfMoves = minMoves(array);
	
      System.out.println();
      System.out.print("The minimum number of moves required to make all array elements equal are: " + minimumNumberOfMoves);
   }
 }
