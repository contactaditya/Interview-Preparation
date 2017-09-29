import java.util.*;
import java.io.*;

 public class CountPrimeNumbers {
	
     public static int countPrimes(int number) {
	int count = 0;
	boolean prime[] = new boolean[number+1];
	for(int i=0; i<number; i++) {
	   prime[i] = true;
	}
		  
	for(int p = 2; p*p <= number; p++) {
	  // If prime[p] is not changed, then it is a prime
	  if(prime[p] == true) {
	    // Update all multiples of p 
	    for(int i = p*2; i <= number; i += p) {
	       prime[i] = false;	 
	    } 
	  }
	}
			  
	 // Print all prime numbers
        for(int i = 2; i <= number; i++) {
	  if(prime[i] == true) {
	    count++;
	  }
	}
	      
	return count;   
     }	

     public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
	System.out.print("Enter the number: ");
	int number = input.nextInt();   
	int countPrimes = countPrimes(number);
	System.out.println();
	System.out.println("The number of prime numbers less than " + number + " are: " + countPrimes);
     }
 }
