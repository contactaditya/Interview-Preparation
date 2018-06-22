import java.util.*;
import java.io.*;

 public class FindIfAGivenNumberIsAPowerOf2OrNot {
	
   public static int power(String A) {
     String dividend = A;
     StringBuilder string;
		    
     if (A == null || A.length() == 0) {
       return 0;
     }
		    
     if (A.length() == 1 && A.charAt(0) == '0') {
       return 0;
     }
		    
     while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
       string = new StringBuilder();
       int carry = 0;
       int n = dividend.length();
		        
       if (n > 0) {
 	 int number = dividend.charAt(n - 1) - '0';
	    	        
	 if (number % 2 == 1) {
	   return 0;
	 }
       }
		        
       for (int i = 0; i < n; i++) {          
         char c = (char) (dividend.charAt(i) - '0');
	 int result = c + 10 * carry;
		            
	 c = (char) (result / 2 + '0');
	 carry = result % 2;
		            
	 string.append(c);
       }
		        
       if (string.charAt(0) == '0') {
         string.deleteCharAt(0);
       }
		            
       dividend = string.toString(); 
     }
		    
     return 1;  
   }
	
   public static void main(String[] args) { 	
     String string = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the number: ");
     string = input.next();  
	  
     int result = power(string); 
     System.out.println();
     if(result == 1) {
       System.out.println("The given number can be expressed as a power of 2.");  
     }
     else {
       System.out.println("The given number cannot be expressed as a power of 2.");  
     }
   }
 }
