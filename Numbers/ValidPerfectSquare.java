import java.util.*;
import java.io.*;

 public class ValidPerfectSquare {
	 
    public static boolean isPerfectSquare(int number) {
      int low = 1, high = number;
      while (low <= high) {
	long mid = low + (high-low)/2;
	if (mid * mid == number) {
	  return true;
	} else if (mid * mid < number) {
	  low = (int) mid + 1;
	} else {
	  high = (int) mid - 1;
	}
      }	
	        
      return false;     
    }	 
	
    public boolean isPerfectSquare1(int number) {
      long x = number;
      while (x * x > number) {
        x = (x + number / x)/2;
      }
      return x * x == number;
    }

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the number: ");
       int number = input.nextInt();   
		    	   
       boolean isPerfectSqaure = isPerfectSquare(number); 
		   
       System.out.println();
       if(isPerfectSqaure) {
	 System.out.println(number + " is a perfect square.");  
       }
       else {
	 System.out.println(number + " is not a perfect square.");    
       }
    }
 }
