import java.util.*;
import java.io.*;

  public class SubtractTheProductAndSumOfDigitsOfAnInteger {
	  
    public static int subtractProductAndSum(int number) {
      int result = 0;
      int product = getProduct(number);
      int sum = getSum(number);
	  
      result = product - sum;
		
      return result;      
    }	
	
    private static int getSum(int number) {     
      int sum = 0; 
	          
      while (number != 0) { 
	sum = sum + number % 10; 
	number = number/10; 
      } 
	      
      return sum; 
    } 	
	
    private static int getProduct(int number) {     
      int product = 1; 
		          
      while (number != 0) { 
        product = product * (number % 10); 
	number = number/10; 
      } 
		      
      return product; 
    } 		

    public static void main(String[] args) {      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();
		  
      int result = subtractProductAndSum(number);
      System.out.println();
      System.out.println("The difference between product of it's digits and the sum of it's digits is: " + result);
      input.close();
    }
  }
