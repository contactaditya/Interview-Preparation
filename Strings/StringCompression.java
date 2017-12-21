import java.util.*;
import java.io.*;

 public class StringCompression {
	 
	public static int compress(char[] chars) {  
	  int start = 0;
      for (int end = 0, count = 0; end < chars.length; end++) {
    	count++;  
        if (end == chars.length - 1 || chars[end] != chars[end + 1]) {
          // We have found a difference or we are at the end of array	
          chars[start] = chars[end]; // Update the character at start pointer
          start++;
          if (count != 1) {
        	// Copy over the character count to the array
            char[] array = String.valueOf(count).toCharArray();
            for(int i=0; i < array.length; i++,start++) {
              chars[start] = array[i];
            }
          }
          // Reset the counter    
          count = 0;
        }
      }
      return start;      
	}

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of characters in the array: ");
	  int number = input.nextInt();  
	  char array[] = new char[number];
		  
	  System.out.println();	
	  System.out.print("Please enter the actual characters: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.next().charAt(0);
	  }
		    	   	
	  int newLengthOfArray = compress(array);
	  System.out.println();	
	  System.out.print("The new length of the array after compression will be: " + newLengthOfArray);
	  
	}
 }
