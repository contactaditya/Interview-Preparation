import java.util.*;
import java.io.*;

  public class MaxCounters {
	  
    public static int[] getValuesOfTheCounters(int N, int[] array) {
      int[] counters = new int[N];
      int max = 0;
      int maxCounter = 0;
      for (int i=0; i < array.length; i++) {
         if(array[i] == N + 1) {
           maxCounter = max;
         } else {
           counters[array[i] - 1] = Math.max(counters[array[i] - 1], maxCounter) + 1;
           max = Math.max(max, counters[array[i] - 1]);
         }
      }
	   
      for(int i = 0; i < counters.length; i++) {
        counters[i] = Math.max(counters[i], maxCounter);
      }

       return counters;
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
	  
      System.out.println();
      System.out.print("Enter the number of counters: "); 
      int N = input.nextInt();   

      int valueOfCounters[] = getValuesOfTheCounters(N, array);
      System.out.println();
      System.out.print("The value of every counter after all operations is: ");
      for (int i=0; i < valueOfCounters.length; i++) {
	System.out.print(valueOfCounters[i] + " ");
      }  
    }
  }
