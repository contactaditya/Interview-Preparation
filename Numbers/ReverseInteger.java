import java.util.*;
import java.io.*;

  public class ReverseInteger {
	  
   public static int reverse(int number) {
     long reverse = 0;
     while (number != 0) {
	reverse = reverse*10 + number%10;
	number = number/10; 
     }  	
	        
     if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
	return 0;    
     }     
		         
     return (int) reverse; 
   }	  

   public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();
		  
      int result = reverse(number);
      System.out.println();
      System.out.println("The reverse of " + number + " is: " + result);
    
   }
 }
