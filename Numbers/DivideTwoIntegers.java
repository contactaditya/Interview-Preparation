import java.util.*;
import java.io.*;

  public class DivideTwoIntegers {
	
    public static int divide(int dividend, int divisor) {
      long count = 0;
      int sign = 1;
      int result = 0;
        
      long lx = Math.abs((long)dividend);
      long ly = Math.abs((long)divisor);
      
      if (ly == 0) {
    	return Integer.MAX_VALUE;
      }
	    
      if ((lx == 0) || (lx < ly)) {
    	return 0;    
      }
      
      count = divideLong(lx, ly);
      
      if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
        sign = -1;
      }
      
       if(count > Integer.MAX_VALUE) {
         result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
       } else {
         result = (int)(sign * count); 
       }
        
       return result;	
    }
	
    private static long divideLong(long dividend, long divisor) {	   
       // Return if nothing to divide
       if (dividend < divisor) {
	  return 0;
       }
	   
       long sum = divisor;
       long multiple = 1;
       while ((sum+sum) <= dividend) {
	  sum += sum;
	  multiple += multiple;
       }
		
       return multiple + divideLong((dividend-sum), divisor);
    }

    public static void main(String[] args) { 	
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the dividend: ");
       int dividend = input.nextInt();  
       System.out.println();	
       System.out.print("Enter the divisor: ");
       int divisor = input.nextInt();  
	  
       int result = divide(dividend, divisor);
       System.out.println();	
       System.out.print("The result of the division of the two integers is: " + result);
    }
  }
