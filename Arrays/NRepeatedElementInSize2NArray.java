import java.util.*;
import java.io.*;

  public class NRepeatedElementInSize2NArray {
	  
    public static int repeatedNTimes(int[] array) {
      Map<Integer, Integer> count = new HashMap<Integer, Integer>();

      for (int x : array) {
        count.put(x, count.getOrDefault(x, 0) + 1);
      }
	  
      for (int k : count.keySet()) {
        if (count.get(k) > 1) {
          return k;
        }
      }
	  
      throw null;
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
	
      int result = repeatedNTimes(array); 
      System.out.println();	
      System.out.println("The element repeated " + numbers/2 + " times is: " + result); 
      input.close();
    }
  }
