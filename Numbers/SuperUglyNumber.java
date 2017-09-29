import java.util.*;
import java.io.*;

  public class SuperUglyNumber {
	  
	public static int nthSuperUglyNumber(int number, int[] primes) {
	   int[] ugly = new int[number];
	   int[] index = new int[primes.length];	
	   if (number == 1 || primes == null || primes.length == 0) {
	      return 1;
	   }
	   
	   ugly[0] = 1;
	   
	   for (int i = 1; i < number; i++) {
		 //find next
	     int min = Integer.MAX_VALUE;  
	     for (int j = 0; j < primes.length; j++) {
	       min = Math.min(min, primes[j] * ugly[index[j]]);
	     }
	     //slip duplicate
	     for(int j = 0; j < primes.length; j++){
	       if(min == primes[j] * ugly[index[j]]){
	         index[j]++;
	       }
	     }  
	   }
	   
	   return ugly[number-1];    
	}	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();   
	  System.out.println();
	  System.out.print("Enter number of elements in the array containing all the prime factors: ");
	  int numberOfElements = input.nextInt();  
	  int array[] = new int[numberOfElements];
	  
	  System.out.println();	
	  System.out.print("Please enter all the prime factors: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
	  }
	  int isTheNumberSuperUgly = nthSuperUglyNumber(number, array);
	  System.out.println();
	  System.out.println(number + "th super ugly number is " + isTheNumberSuperUgly);  
	}
  }
