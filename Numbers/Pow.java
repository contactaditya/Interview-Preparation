import java.util.*;
import java.io.*;

  public class Pow {
	  
	public static double myPow(double number, int power) {
	   if(power == 0) {
         return 1;
	   }
	   double temp = myPow(number, power/2);      
	   if(power%2 == 0) {
		 return temp * temp;	
	   }
	   else {
		 if(power > 0) {
           return number*temp*temp;
		 }
         else {
           return (temp*temp)/number;
         }  
	   } 
	}  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  double number = input.nextDouble();  
	  System.out.println();	
	  System.out.print("Enter the power: ");
	  int power = input.nextInt();  
			
	  double result = myPow(number, power);

	  System.out.println();	
	  System.out.print(power + " power of " + number + " is: " + result);

	}
  }
