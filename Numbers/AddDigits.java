import java.util.*;
import java.io.*;

  public class AddDigits { 	
	  
	public static int addDigits(int number) {
	  return (number - 1) % 9 + 1;
	}	
	  
	public static int addDigits1(int number) {
	  if(number < 10) {
		return number;
	  }
      else if(number%9 == 0) {
		return 9;
      }
	  else {
	    return number%9; 
	  }     
	}	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
	  System.out.println();	

	  int result = addDigits(number);
	  System.out.println();	
	  System.out.print("The number after repeatedly adding all its digits until the result has only one digit is: " + result);
	}

  }
