import java.util.*;
import java.io.*;

  public class PassingCars {
	  
    public static int countPassingCars(int array[]) {  
      int countOfZeros = 0, count = 0;
      for (int i = 0; i < array.length; i++) {
        if (array[i] == 0) {
    	 countOfZeros++;                    
        }
        if (array[i] == 1) {
    	 count += countOfZeros;    
        }
        if (count > 1000000000) {
    	  return -1;
        }
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
	  
       int numberOfPassingCars = countPassingCars(array);
       System.out.println();
       System.out.print("The number of pairs of passing cars are: " + numberOfPassingCars);
    }
  }
