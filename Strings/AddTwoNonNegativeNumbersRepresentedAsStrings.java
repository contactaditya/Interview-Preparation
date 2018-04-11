import java.util.*;
import java.io.*;

 public class AddTwoNonNegativeNumbersRepresentedAsStrings {
	 
   public static String addStrings(String number1, String number2) {
     StringBuilder sb = new StringBuilder();
     int carry = 0;	
     for(int i = number1.length() - 1, j = number2.length() - 1; i >= 0 || j >= 0; i--, j--) {
       int x = i < 0 ? 0 : number1.charAt(i) - '0';
       int y = j < 0 ? 0 : number2.charAt(j) - '0'; 
       sb.append((x + y + carry) % 10);
       carry = (x + y + carry) / 10;
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
	  
     String result = addStrings(number1, number2);
     System.out.println();
     System.out.println("The sum of the two numbers is: " + result);
   }
 }
