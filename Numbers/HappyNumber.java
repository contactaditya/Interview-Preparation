import java.util.*;
import java.io.*;

 public class HappyNumber {
	 
	public static boolean isHappy(int number) {
	  if(number <= 0) {
		return false;	
	  }
	  while(number >= 10) {
	    int sum = 0;
	    while (number != 0) {
	      sum += (number%10)*(number%10);
	      number /= 10;
	    }
	    number = sum;  
		  
	  }
	  return number == 1 || number == 7;      
	}	 

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
		 		
	  boolean result = isHappy(number);

	  System.out.println();	
	  if(result) {
		System.out.print(number + " is a happy number.");
	  }
	  else {
		System.out.print(number + " is not a happy number.");  
	  }
	}
 }
