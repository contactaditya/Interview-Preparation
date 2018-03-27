import java.util.*;
import java.io.*;

  public class AdditiveNumber {
	  
    public static boolean isAdditiveNumber(String number) { 
      int n = number.length();
      for (int i = 1; i <= n / 2; i++) {
        for (int j = 1; Math.max(j, i) <= n - i - j; j++)
          if (isValid(i, j, number)) {
            return true;
          }
      }
	  
      return false;      
    }	
  
    private static boolean isValid(int i, int j, String number) {
      if (number.charAt(0) == '0' && i > 1) {
    	return false;
      }
      if (number.charAt(i) == '0' && j > 1) {
    	return false;	
      }
      String sum;
      Long x1 = Long.parseLong(number.substring(0, i));
      Long x2 = Long.parseLong(number.substring(i, i + j));
      for (int start = i + j; start != number.length(); start += sum.length()) {
        x2 = x2 + x1;
        x1 = x2 - x1;
        sum = x2.toString();
        if (!number.startsWith(sum, start)) {
          return false;
        }
      }
      
      return true;
    }

    public static void main(String[] args) {   
      String number = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      number = input.next();  
	  	  
      boolean isAdditiveNumber = isAdditiveNumber(number);
	  
      System.out.println(); 
      if(isAdditiveNumber) {
	System.out.println("The number " + number + " is an additive number.");  
      }
      else {
    	System.out.println("The number " + number + " is not an additive number.");  
      }
    }
  }
