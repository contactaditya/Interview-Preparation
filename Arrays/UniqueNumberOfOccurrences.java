import java.util.*;
import java.io.*;

 public class UniqueNumberOfOccurrences {
	 
	public static boolean uniqueOccurrences(int[] array) {
	  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int x : array) {
        map.put(x, map.getOrDefault(x, 0) + 1);
      }
      HashSet<Integer> set = new HashSet<Integer>(map.values());
      return set.size() == map.size();  
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
	  if(uniqueOccurrences(array)) {
		System.out.println("The number of occurrences of each value in the array is unique.");
	  }
	  else {
		System.out.println("The number of occurrences of each value in the array is not unique.");  
	  }
	  input.close();
	}
 }
