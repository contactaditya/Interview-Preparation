import java.util.*;
import java.io.*;

  public class StringToIntegerAtoi {
	  
    public static int myAtoi(String string) {
      if (string == null || string.length() == 0) {
	return 0;	
      }

      int i = 0;
      while(i < string.length() && string.charAt(i) == ' ') {
        i++;
      }
      int sign = 1;
      if(i < string.length() && string.charAt(i) == '+') {
        i++;
      } else if(i < string.length() && string.charAt(i) == '-') {
        sign = -1;
        i++;
      }
      long result = 0;
	  
      while(i < string.length() && string.charAt(i)-'0' >= 0 && '9'-string.charAt(i) >= 0) {
        result = result * 10 + (string.charAt(i) - '0');
        if(result > (long)Integer.MAX_VALUE + 1) {
          break;
        }
        i++;
      }
      result = sign * result;
      // If integer is out of the range of a 32-bit signed integer then we return Integer.MAX_VALUE and Integer.MIN_VALUE respectively
      if(result > (long)Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if(result < (long)Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
	 
      return (int) result;     
    }	  

    public static void main(String[] args) { 	 
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next();  
	  	  
      int atoi = myAtoi(string);
      System.out.println();
      System.out.println("The string " + string + " can be represented in integer form as: " + atoi);  
    }
  }
