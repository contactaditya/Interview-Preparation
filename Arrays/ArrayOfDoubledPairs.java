import java.util.*;
import java.io.*;

  public class ArrayOfDoubledPairs {
	  
    public static boolean canReorderDoubled(int[] array) {
      Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
      for (int a : array) {
	count.put(a, count.getOrDefault(a, 0) + 1);
      }
      for (int x : count.keySet()) {
	if (count.get(x) == 0) {
	  continue;
	}
        int want = x < 0 ? x / 2 : x * 2;
        if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0)) {
          return false;
        }
        count.put(want, count.get(want) - count.get(x));
      }
	  
      return true;      
    }  

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array(even length): ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
	    
      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt(); 
      }
	  
      System.out.println();
      if(canReorderDoubled(array)) {
	System.out.println("It is possible to reorder the array such that array[2 * i + 1] = 2 * array[2 * i]");  
      }
      else {
	System.out.println("It is not possible to reorder the array such that array[2 * i + 1] = 2 * array[2 * i]");   
      }
      input.close();
    }
  }
