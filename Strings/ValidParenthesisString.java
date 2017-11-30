import java.util.*;
import java.io.*;

 public class ValidParenthesisString {
	 
   public static boolean checkValidString(String string) {
      int low = 0, high = 0;	
      for (char c: string.toCharArray()) {
        low += c == '(' ? 1 : -1;
        high += c != ')' ? 1 : -1;
        if (high < 0) {
          break;
        }
        low = Math.max(low, 0);
      }
      return low == 0;   
   }	 

   public static void main(String[] args) {    
      String string = new String();	  	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine(); 
		  
      System.out.println();
      if(checkValidString(string)) {
	System.out.println("The string " + string + " is a valid string.");
      }
      else {
	System.out.println("The string " + string + " is not a valid string.");  
      }
   }
 }
