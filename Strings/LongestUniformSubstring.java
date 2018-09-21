import java.util.*;
import java.io.*;

  public class LongestUniformSubstring {
	  
    public static int lengthOfUniformSubstring(String string) {
      char result[] = string.toCharArray();
      int count = 1;
      int maxCount = 0;
      
      for(int i = 0; i < result.length - 1; i++) {
    	if(result[i] == result[i+1]) {
    	  count++;	
    	}
    	else {
    	  count = 1;	
    	}
    	if(count > maxCount) {
    	  maxCount = count;	
    	}
      }

      return maxCount;
    }
	
    public static void main(String[] args) {   
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next(); 
      int length = lengthOfUniformSubstring(string);
      System.out.println();
      System.out.print("The length of the maximum consecutive repeating character in string is: " + length);
    }
  }
