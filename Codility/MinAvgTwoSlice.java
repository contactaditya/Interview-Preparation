import java.util.*;
import java.io.*;

  public class MinAvgTwoSlice { 	
	  
    public static int getSliceWithMinimalAverage(int array[]) {
      int minIndex = 0;
      double minimumAverage = Double.MAX_VALUE;;
      for (int i = 0; i < array.length - 1; i++) {
	double average = (array[i] + array[i + 1]) / 2.0;  
	if(i < array.length - 2) {
	  double threeSliceAverage = (array[i] + array[i + 1] + array[i + 2]) / 3.0;  
	  average = Math.min(average, threeSliceAverage);
	}
	if (average < minimumAverage) {
	  minimumAverage = average;
	  minIndex = i;
	}
      }
      return minIndex;
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
	  
      int sliceWithMinimalAverage = getSliceWithMinimalAverage(array);
      System.out.println();
      System.out.print("The starting position of a slice whose average is minimal is: " + sliceWithMinimalAverage);
    }
  }
