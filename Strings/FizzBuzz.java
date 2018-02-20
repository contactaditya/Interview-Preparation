import java.util.*;
import java.io.*;

  public class FizzBuzz {
	  
	public static List<String> fizzBuzz(int number) {
	   List<String> result = new ArrayList<String>();
	   for(int i = 1; i <= number; i++) {  
		 if (i % 3 == 0 && i % 5 == 0) {
		   result.add("FizzBuzz");   
		 } else if(i % 3 == 0) {
		   result.add("Fizz"); 
		 } else if(i % 5 == 0) {
		   result.add("Buzz");		 
		 }
	     else {
		   result.add(String.valueOf(i));
	     }
	   }
		
	   return result;     
    }	  

	public static void main(String[] args) { 	  
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int number = input.nextInt();   
   
	   List<String> result = new ArrayList<String>();
	   result = fizzBuzz(number);
	   System.out.println();
	   System.out.print("The solution set is: " + result);
	}
  }
