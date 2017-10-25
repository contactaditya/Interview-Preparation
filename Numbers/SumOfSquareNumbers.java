import java.util.*;
import java.io.*;

 public class SumOfSquareNumbers {
	
    public static boolean judgeSquareSum(int c) {
       for (long a = 0; a * a <= c; a++) {
         double b = Math.sqrt(c - a * a);
         if (b == (int) b) {
           return true;
         }
       } 	
       
       return false;      
    }	 

    public static void main(String[] args) {    
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the number: ");
       int c = input.nextInt();   
	    	   
       boolean sumOfSquareNumbers = judgeSquareSum(c); 
	   
       System.out.println();
       if(sumOfSquareNumbers) {
	 System.out.println("The are two integers a and b such that: a^2 + b^2 = " + c);  
       }
       else {
	 System.out.println("The are no two integers a and b such that: a^2 + b^2 = " + c);    
       }
    }
 }
