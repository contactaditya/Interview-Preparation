import java.util.*;
import java.io.*;

 public class IsPower {
	 
    public static boolean isPower(int number) {
       double x = 2;
		
       if (number <= 1) {
	  return true;	
       }
	  
       for(double i=2; (i < 33) && (x<=(double)(Math.pow(2, 16))); i++) {
	 if(Math.pow(x,i)==(double)number) {
	   return true;
	 }
	 if(Math.pow(x,i) >= (Math.pow(2,32))) {
	    i=1;
	    x++;
	 }
       }

      return false;     
    } 
	
    public static boolean isPower1(int number) {
       double p;
        
       if (number <= 1) {
 	 return true;	
       }
 	   
       for(int x=2; x<=Math.sqrt(number); x++) {
 	       
          p = Math.log(number) / Math.log(x);
          if(p - (int)p < 0.000000001) {
            return true;
          }
       }
 	
      return false;     
    }

    public static void main(String[] args) {   
       Scanner input = new Scanner(System.in);
       System.out.print("Enter a positive integer: ");
       int number = input.nextInt();  
	 		
       boolean result = isPower(number);

       System.out.println();	
       if(result) {
	 System.out.print("Yes the given number can be expressed as a power of two numbers.");
       }
       else {
	 System.out.print("No the given number cannot be expressed as a power of two numbers.");  
       }

    }
 }
