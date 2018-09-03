import java.util.*;
import java.io.*;

  public class LargestNumber {
	  
    public static String largestNumber(int[] array) {
      if(array == null || array.length == 0) {
	return "";
      }
      // Get input integers as strings.
      String result[] = new String[array.length];
      for(int i=0; i < array.length; i++) {
	result[i] = String.valueOf(array[i]);
      } 
      Arrays.sort(result , new Comparator<String>() {
        @Override
        public int compare(String string1, String string2) {
          String s1 = string1 + string2;
          String s2 = string2 + string1;
          return s2.compareTo(s1);
        }
      });
      
      // If, after being sorted, the largest number is `0`, the entire number is zero.
      if(result[0].charAt(0) == '0') {
    	return "0";
      }
      
      // Build largest number from sorted array.
      StringBuilder sb = new StringBuilder();
      for(String string : result) {
        sb.append(string);
      }
      
      return sb.toString();
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
		   
      String largestElement = largestNumber(array);
      System.out.println();
      System.out.println("The largest number that can be formed from the element in the array is: " + largestElement);
    }
  }
