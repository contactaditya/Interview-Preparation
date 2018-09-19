import java.util.*;
import java.io.*;

  public class PrintAllAPTriplets {
	  
    public static void printAllAPTriplets(int array[]) {
      List<Integer> list = new ArrayList<Integer>(); 
      Arrays.sort(array);
      System.out.println();
      System.out.println("All the triplets that form the AP are: ");	
      for (int i = 0; i < array.length - 1; i++) {
        for (int j = i + 1; j < array.length; j++) {
          int difference = array[j] - array[i];  // Use hash to find if there is a previous element with difference
          boolean exists = list.contains(array[i] - difference);    
          if (exists) {
            System.out.println(array[i] - difference + " " + array[i] + " " + array[j]);
          }
        }
        list.add(array[i]);
      }
    }
	
    public static void printAllAPTriplets1(int array[]) {
      List<Integer> list = new ArrayList<Integer>(); 
      Arrays.sort(array);
      System.out.println();
      System.out.println("All the triplets that form the AP are: ");	
      for (int i = 1; i < array.length - 1; i++) {
        for (int j = i - 1, k = i + 1; j >= 0 && k < array.length;) {
	  // If a triplet is found	
	  if (array[j] + array[k] == 2 * array[i]) {
	    System.out.println(array[j] + " " + array[i] + " " + array[k]);	
	    k++;
	    j--;
          }
          // If middle element is more move to higher side, else move lower side.
	  else if (array[j] + array[k] < 2 * array[i]) {
	    k++;  
	  }
	  else {
	    j--;  
	  }
	}
      }
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
	  
      input.close();
      printAllAPTriplets1(array); 
    }
  }
