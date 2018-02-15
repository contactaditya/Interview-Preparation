import java.util.*;
import java.io.*;

  public class SummaryRanges { 
	    
    public static List<String> summaryRanges(int[] array) {
      List<String> list = new ArrayList<String>();
      if(array.length == 1) {
  	list.add(array[0] + "");
  	return list;
      }
      for (int i = 0; i < array.length; i++) {
        int number = array[i];
        while (i < array.length - 1 && array[i] + 1 == array[i + 1]) {
          i++;
        }
        if (number != array[i]) {
          list.add(number + "->" + array[i]);
        } else {
          list.add(number + "");
        }
      }
    	
      return list;
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

      List<String> result = new ArrayList<String>();
      result = summaryRanges(array); 
      System.out.println();
      System.out.println("The summary of the range of the sorted integer array is: " + result);
    }
  }
