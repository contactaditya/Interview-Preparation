import java.util.*;
import java.io.*;

 public class UglyNumber {
	
   public static boolean isUgly(int number) {
     if (number <= 0) {
       return false;
     }
  
     if (number == 1) {
       return true;
     }	
		
     int[] divisors = {2, 3, 5};
     for(int d : divisors) {
       while (number % d == 0) {
         number /= d;
       }
     }
		
     return number == 1;
   }	 

   public static void main(String[] args) {  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the number: ");
     int number = input.nextInt();   
     boolean isTheNumberUgly = isUgly(number);
     System.out.println();
     if(isTheNumberUgly) {
       System.out.println(number + " is an ugly number");  
     }
     else {
       System.out.println(number + " is not an ugly number");  
     }
   }
 }
