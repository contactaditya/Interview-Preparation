import java.util.*;
import java.io.*;

  public class PerfectNumber {
	  
    public static boolean checkPerfectNumber(int number) {
       if (number <= 0) {
	 return false;
       }
       int sum = 0;	
       for (int i = 1; i * i <= number; i++) {
         if (number % i == 0) {
           sum += i;
           if (i * i != number) {
             sum += number / i;
           }
         }
       }	
       return sum - number == number;
    }	  
	
    public boolean checkPerfectNumber1(int number) {
       if(number <= 0) { 
    	 return false;
       }
       int sum = 0, low = 1, high = number;
       while (low < high) {
	 int mid = low + (high-low)/2;
	 if(number % mid == 0) {
	   sum += mid;
	   high = mid;
	 } else {
	   return false;
	 }
       }
       return sum == number;
    }
	
    public int pn(int p) {
       return (1 << (p - 1)) * ((1 << p) - 1);
    }
	   
    public boolean checkPerfectNumber2(int number) {
       int[] primes=new int[]{2,3,5,7,13,17,19,31};
       for (int prime: primes) {
	 if (pn(prime) == number) {
	   return true;
	 }
       }
       return false; 
    }

    public static void main(String[] args) {    
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of elements in the array: ");
       int numberOfElements = input.nextInt();  
		    
       boolean result = checkPerfectNumber(numberOfElements);
       System.out.println();
       if(result) {
	 System.out.println("The given number is a perfect number.");  
       }
       else {
	 System.out.println("The given number is not a perfect number.");  
       }
    }
  }
