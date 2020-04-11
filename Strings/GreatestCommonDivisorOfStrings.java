import java.util.*;
import java.io.*;

  public class GreatestCommonDivisorOfStrings {
	
    public static String gcdOfStrings(String string1, String string2) {
      if(string2.length() == 0) {
    	return string1;
      }
		
      if(string1.length() < string2.length()) {
	return gcdOfStrings(string2, string1);
      } 
	  
      if(string1.startsWith(string2)) {
	string1 = string1.substring(string2.length());
	return gcdOfStrings(string1, string2);
      }
      return "";
    }

    public static void main(String[] args) { 	 
      String string1 = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      string1 = input.nextLine();  
      System.out.println();	
      String string2 = new String();	  
      System.out.print("Enter the second string: ");
      string2 = input.nextLine();
		  
      String result = gcdOfStrings(string1, string2);
      System.out.println();
      System.out.print("The greatest common divisor of strings " + string1 + " and " + string2 + " is: " + result);
      input.close();
    }
  }
