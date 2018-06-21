import java.util.*;
import java.io.*;

 public class RepeatedSubstringPattern {
	 
   public static boolean repeatedSubstringPattern(String string) {
     int length = string.length();
     for(int i = length/2 ; i >= 1 ; i--) {
       if(length % i == 0) {
         int m = length/i;
   	 String subString = string.substring(0, i);
   	 int j;
   	 for(j = 1;j < m; j++) {
   	   if(!subString.equals(string.substring(j * i, i + j * i))) {
   	     break;
   	   }
   	 }
   	 if(j == m) {
   	   return true;
    	 }
       }
     }
     return false;      
   }	 

   public static void main(String[] args) { 	  
     String string = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string: ");
     string = input.nextLine(); 
     boolean isRepeatedSubstringPattern = repeatedSubstringPattern(string);
     System.out.println();
     if(isRepeatedSubstringPattern) {
       System.out.println("The string " + string + " can be constructed by taking a substring of it and appending multiple copies of the substring together.");  
     }
     else {
       System.out.println("The string " + string + " cannot be constructed by taking a substring of it and appending multiple copies of the substring together.");  
     }
   }
 }
