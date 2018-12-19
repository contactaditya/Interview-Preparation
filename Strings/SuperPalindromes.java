import java.util.*;
import java.io.*;

 public class SuperPalindromes {
	  
   public static int superpalindromesInRange(String sL, String sR) {
     long L = Long.valueOf(sL);
     long R = Long.valueOf(sR);
     int MAGIC = 100000;
     int answer = 0;
     
     // count odd length
     for (int k = 1; k < MAGIC; k++) {
       StringBuilder sb = new StringBuilder(Integer.toString(k));
       for (int i = sb.length() - 2; i >= 0; i--) {
         sb.append(sb.charAt(i));
       }
       long v = Long.valueOf(sb.toString());
       v *= v;
       if (v > R) {
    	 break;
       }
       if (v >= L && isPalindrome(v)) {
    	 answer++;
       }
     }
     
     // count even length
     for (int k = 1; k < MAGIC; k++) {
       StringBuilder sb = new StringBuilder(Integer.toString(k));
       for (int i = sb.length() - 1; i >= 0; i--) {
         sb.append(sb.charAt(i));
       }
       long v = Long.valueOf(sb.toString());
       v *= v;
       if (v > R) {
    	 break;
       }
       if (v >= L && isPalindrome(v)) {
    	 answer++;
       }
     }    
		
     return answer;       
   } 
   
   public static boolean isPalindrome(long x) {
     String string = Long.toString(x);
     int n = string.length();
     for(int i = 0; i < n/2 + n % 2; i++) {
       if (string.charAt(i) != string.charAt(n-i-1)) {
	 return false;
       }
     }
	    
     return true; 
   }
	  
   public static void main(String[] args) { 	 
     String L = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the first integer: ");  
     L = input.nextLine();
	  
     System.out.println();	
     String R = new String();	  
     System.out.print("Enter the second string: "); 
     R = input.nextLine();
	  
     int numberOfSuperPalindromes = superpalindromesInRange(L, R);
     System.out.println();	
     System.out.println("The number of super palindromes between the two given positive integers are: " + numberOfSuperPalindromes);	
     input.close();
   }
 }
