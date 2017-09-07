import java.util.*;
import java.io.*;

 public class AddTwoBinaryStrings { 	
	 
   public static String addBinary(String number1, String number2) {
	  StringBuilder sb = new StringBuilder();
      int carry = 0;	
      int i = number1.length() - 1, j = number2.length() -1;
      while(i >= 0 || j >= 0) {
    	int sum = carry;  
    	if (j >= 0) {
    	  sum += number2.charAt(j--) - '0';	
    	}
    	if (i >= 0) {
      	  sum += number1.charAt(i--) - '0';	
      	}
        sb.append(sum % 2);
        carry = sum/2;
      }
      
      if(carry != 0) {
        sb.append(carry);
      }
	
	  return sb.reverse().toString();     
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
		  
	  String result = addBinary(number1, number2);
	  System.out.println();
	  System.out.println("The sum of the two numbers is: " + result);

	}
  }
