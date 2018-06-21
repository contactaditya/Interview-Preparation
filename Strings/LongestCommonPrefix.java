import java.util.*;
import java.io.*;

  public class LongestCommonPrefix { 
	
    public static String commonPrefix(String[] array, int n) {
      if (array == null || array.length == 0) {
        return "";  
      }	
      int index = findMinLength(array, n);
      String prefix = null; // Our resultant string
      
      int low = 0, high = index;
      while(low <= high) {
    	int mid = low + (high - low) / 2;
    	if (isCommonPrefix(array, mid)) {
    	  low = mid + 1;
    	}
        else {
    	  high = mid - 1;	
    	}   
      }
      return array[0].substring(0, (low + high) / 2);	 
    }

    private static boolean isCommonPrefix(String[] array, int length) {
      String string = array[0].substring(0,length);
      for (int i = 1; i < array.length; i++) {
	if (!array[i].startsWith(string)) {
	  return false;
	}
      }
	 
      return true;
    }

    private static int findMinLength(String[] array, int n) {
      int minLength = Integer.MAX_VALUE;
      for (String str : array) {
	minLength = Math.min(minLength, str.length());
      }
      return minLength;
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int words = input.nextInt();   
      String[] array = new String[words];
	    
      System.out.print("\n");
      System.out.print("Please enter the actual values in the array: ");
      for(int i = 0; i < words; i++) {
	array[i] = input.next(); 
      } 
      System.out.println(); 
      String answer = commonPrefix(array, array.length); 
      if(answer.length() > 0) {
	System.out.println("The longest common prefix is: " + answer);  
      }
      else {
	System.out.println("There is no common prefix.");  
      }
    }
  }
