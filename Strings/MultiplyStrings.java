import java.util.*;
import java.io.*;

 public class MultiplyStrings { 
	 
    public static String multiplyStrings(String number1, String number2) {
      int m = number1.length();
      int n = number2.length();
      int product[] = new int[m + n];
	  int carry = 0;	
	  if (number1 == null || number2 == null || number1.length() == 0 || number2.length() == 0) {
	     return null;
	  }
	  if ((number1.length() == 1 && number1.charAt(0) - '0' == 0) || (number2.length() == 1 && number2.charAt(0) - '0' == 0)) {
	     return "0";
	  }
	  if (number1.length() == 1 && number1.charAt(0) - '0' == 1) {
	     return number2;
	  }
	  if (number2.length() == 1 && number2.charAt(0) - '0' == 1) {
	     return number1;
	  }
      for(int i = m-1; i>=0; i--) {
       for(int j = n-1; j>=0; j--) {  
    	 product[i + j + 1] += (number1.charAt(i) - '0') * (number2.charAt(j) - '0');
	   }
      }
	  StringBuilder sb = new StringBuilder();	
	  for (int i = product.length - 1; i >= 1; i--) {
		product[i] += carry;
	    carry = product[i] / 10;
	    product[i] = product[i] % 10;
	    sb.insert(0, product[i]);  
	  }
	  
	  if (carry != 0 || product[0] != 0) {
	    sb.insert(0, carry + product[0]);
	  }
	  
	  return sb.toString();     
	}	 
	 
	public static void main(String[] args) {
      String number1 = new String();	  
	  Scanner input1 = new Scanner(System.in);
	  System.out.print("Enter the first string: ");
	  number1 = input1.next();  
		  
	  System.out.println();	
	  String number2 = new String();	  
	  Scanner input2 = new Scanner(System.in);
	  System.out.print("Enter the second string: ");
	  number2 = input2.next();
		  
	  String result = multiplyStrings(number1, number2);
	  System.out.println();
	  System.out.println("The product of the two numbers is: " + result);

	}
 }
