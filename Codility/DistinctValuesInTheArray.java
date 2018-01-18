import java.util.*;
import java.io.*;

  public class DistinctValuesInTheArray {
	  
    public static int getDistinctValuesInTheArray(int[] array) {
      Arrays.sort(array);   
      int distinctCount = 1;
      for (int i = 0; i < array.length - 1; i++) {
  	    if(array[i] != array[i + 1]) {
  	      distinctCount++;
  	    }
  	  }
  
      return distinctCount;
    }
    
    public static int getDistinctValuesInTheArray1(int[] array) {
      HashSet<Integer> set = new HashSet<Integer>();
      for (int i = 0; i < array.length; i++) {
        // If not present, then put it in hashtable and print it
        if (!set.contains(array[i])) {
          set.add(array[i]);
        }
      }
    
      return set.size();
    }

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of elements in the array: ");
      int lengthOfArray = input.nextInt();
      int[] array = new int[lengthOfArray];    
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0;i<lengthOfArray;i++) {  
        array[i] = input.nextInt();
      }   
    
      int getDistinctValuesInTheArray = getDistinctValuesInTheArray(array);
      System.out.println();	
      System.out.println("The number of distinct values in array are: " + getDistinctValuesInTheArray);	

    }
  }
