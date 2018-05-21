import java.util.*;
import java.io.*;

  public class IntegerToRoman {
	  
	public static String intToRoman(int number) {
	  if(number <= 0) {
	    return "";
	  }
      int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	  String[] string = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	  StringBuilder sb = new StringBuilder();
	  
	  for(int i=0; i<values.length; i++) {
		int count = number/values[i];  
	    while(count > 0) {
	      sb.append(string[i]);
          count--;
	    }
	    number %= values[i];
	  }
	  
	  return sb.toString();      
	}  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
    
      String result = intToRoman(number);
      System.out.println();
      System.out.print("The integer form " + number + " in roman numeral is: " + result);
	}
  }
