import java.util.*;
import java.io.*;

  public class Base7 {
	
	public static String convertToBase7(int number) {
	  String i = "";
      if (number < 0) {
        i = "-";
        number = Math.abs(number);
      }
      int tens = 1;
      int result = 0;
      while(number > 0) {
        result += number % 7 * tens;
        tens *= 10;
        number /= 7;
      }
	  
	  return i + Integer.toString(result);  
    }
	
	public static String convertToBase7One(int number) {
 	  return Integer.toString(number, 7);   
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  

      String result = convertToBase7(number);
      System.out.println();	
      System.out.print("The base 7 string representation of the integer " + number + " is: " + result);
	}
  }
