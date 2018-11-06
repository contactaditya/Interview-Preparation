import java.util.*;
import java.io.*;

  public class RearrangeAStringInSortedOrderFollowedByTheIntegerSum {
    public static final int MAX_CHAR = 26; 
	  
    public static String arrangeString(String string) {
      int charCount[] = new int[MAX_CHAR]; 
      int sum = 0; 
      
      for (int i = 0; i < string.length(); i++) {
        if (Character.isUpperCase(string.charAt(i))) {
          charCount[string.charAt(i) - 'A']++;   
        } else {
          sum = sum + (string.charAt(i) - '0'); 
        }
      }
      
      StringBuffer result = new StringBuffer();  
      // Traverse for all characters A to Z 
      for (int i = 0; i < MAX_CHAR; i++) { 
        char ch = (char)('A' + i); 
        // Append the current character in the string no. of times it occurs in the given string 
        while (charCount[i]-- != 0) {
          result.append(ch); 
        }
      } 
 
      if (sum > 0) { 
        result.append(sum);
      }
      
      return result.toString();	  
    }

    public static void main(String[] args) {  
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      String result = arrangeString(string);
      System.out.println();
      System.out.println("The string rearranged in which we print the alphabets followed by the sum of digits is: " + result);  
      input.close();
    }
  }
