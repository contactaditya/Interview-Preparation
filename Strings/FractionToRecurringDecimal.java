import java.util.*;
import java.io.*;

 public class FractionToRecurringDecimal { 
	  
	public static String fractionToDecimal(int numerator, int denominator) {
	   if (numerator == 0) {
		 return "0";
	   }
	   if (denominator == 0) {
		 return "";	
	   }
	   
	   String result = "";
	   // Is result is negative
	   if ((numerator < 0) ^ (denominator < 0)) {
		  result += "-";
	   }
	   
	   // convert int to long
	   long num = numerator, den = denominator;
	   num = Math.abs(num);
	   den = Math.abs(den);
	   
	   // quotient 
	   long res = num / den;
	   result += String.valueOf(res);
	   
	   // if remainder is 0, return result
	   long remainder = (num % den) * 10;
	   if (remainder == 0) {
		  return result;
	   }
	   
	   // Right-hand side of decimal point
	   HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	   result += ".";
	   while (remainder != 0) {
		 // if digits repeat
		 if (map.containsKey(remainder)) {
			int beg = map.get(remainder); 
			String part1 = result.substring(0, beg);
			String part2 = result.substring(beg, result.length());
			result = part1 + "(" + part2 + ")";
			return result;
		 }
		 // continue
		 map.put(remainder, result.length());
		 res = remainder / den;
		 result += String.valueOf(res);
		 remainder = (remainder % den) * 10;  
	   }
	 
	   return result;
	}	

	public static void main(String[] args) {    
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the numerator in the fraction: ");
	   int numerator = input.nextInt();   
	   
	   System.out.println();
	   System.out.print("Enter the denominator in the fraction: ");
	   int denominator = input.nextInt();   
	   
	   System.out.println();
	   String result = fractionToDecimal(numerator, denominator);
	   if (result == "") {
		  System.out.println("The fraction cannot be represented in string format.");
	   }
	   else {
		  System.out.println("The fraction in string format is: " + result);
	   }
	}
 }
